package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ITEM;
import static seedu.address.logic.parser.CliSyntax.PREFIX_LOCATION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_RATING;
import static seedu.address.logic.parser.CliSyntax.PREFIX_STALL;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.CollectionUtil;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.item.Item;
import seedu.address.model.item.ItemName;
import seedu.address.model.item.Price;
import seedu.address.model.item.review.ItemReview;
import seedu.address.model.review.Description;
import seedu.address.model.review.Rating;
import seedu.address.model.stall.Stall;





/**
 * Edits the details of an existing item in FoodNotes.
 */
public class EditItemCommand extends Command {

    public static final String COMMAND_WORD = "edit-item";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Edits the details of the item identified "
            + "by the index number used in the displayed item list. "
            + "Existing values will be overwritten by the input values.\n"
            + "Item must have a review before rating and description can be edited.\n"
            + "Parameters: "
            + PREFIX_STALL + "STALL_INDEX (must be a positive integer)\n"
            + PREFIX_ITEM + "ITEM_INDEX (must be a positive integer)\n"
            + "[" + PREFIX_NAME + "NAME] "
            + "[" + PREFIX_LOCATION + "LOCATION] "
            + "[" + PREFIX_RATING + "RATING] "
            + "[" + PREFIX_DESCRIPTION + "DESCRIPTION] ";


    public static final String MESSAGE_EDIT_ITEM_SUCCESS = "Edited Item: %1$s";
    public static final String MESSAGE_NOT_EDITED = "At least one field to edit must be provided.";
    public static final String MESSAGE_DUPLICATE_ITEM = "This item already exists in the menu.";
    public static final String MESSAGE_NO_REVIEW_FOUND = "This item has no review to edit.";

    private final Index stallIndex;
    private final Index itemIndex;
    private final EditItemDescriptor editItemDescriptor;

    /**
     * @param stallIndex         of the item in the filtered item list to edit
     * @param itemIndex
     * @param editItemDescriptor details to edit the item with
     */
    public EditItemCommand(Index stallIndex, Index itemIndex, EditItemDescriptor editItemDescriptor) {
        requireNonNull(stallIndex);
        requireNonNull(itemIndex);
        requireNonNull(editItemDescriptor);

        this.stallIndex = stallIndex;
        this.itemIndex = itemIndex;
        this.editItemDescriptor = new EditItemDescriptor(editItemDescriptor);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Stall> lastShownList = model.getFilteredStallList();

        if (stallIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_STALL_DISPLAYED_INDEX);
        }

        Stall stallToEdit = lastShownList.get(stallIndex.getZeroBased());

        List<Item> itemList = stallToEdit.getMenu().getItemList();

        if (itemIndex.getZeroBased() >= itemList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_ITEM_DISPLAYED_INDEX);
        }

        Item itemToEdit = model.getFilteredItem(stallIndex, itemIndex);

        if (!itemToEdit.hasItemReview() && editItemDescriptor.isReviewEdited()) {
            throw new CommandException(MESSAGE_NO_REVIEW_FOUND);
        }

        Item editedItem = createEditedItem(itemToEdit, editItemDescriptor);

        if (!itemToEdit.isSameItem(editedItem) && model.hasItem(stallToEdit, editedItem)) {
            throw new CommandException(MESSAGE_DUPLICATE_ITEM);
        }

        model.setItem(stallIndex, itemIndex, editedItem);
        return new CommandResult(String.format(MESSAGE_EDIT_ITEM_SUCCESS, Messages.format(editedItem)));
    }

    /**
     * Creates and returns a {@code Item} with the details of {@code itemToEdit}
     * edited with {@code editItemDescriptor}.
     */
    private static Item createEditedItem(Item itemToEdit, EditItemDescriptor editItemDescriptor) {
        assert itemToEdit != null;

        ItemName updatedItemName = editItemDescriptor.getItemName().orElse(itemToEdit.getName());
        Price updatedPrice = editItemDescriptor.getPrice().orElse(itemToEdit.getPrice());
        try {
            Rating updatedRating = editItemDescriptor.getRating().orElse(itemToEdit.getItemReview().getRating());
            Description updatedDescription = editItemDescriptor.getDescription()
                    .orElse(itemToEdit.getItemReview().getDescription());
            ItemReview updatedItemReview = new ItemReview(updatedRating, updatedDescription);
            Item editedItem = new Item(updatedItemName, updatedPrice, updatedItemReview);
            return editedItem;
        } catch (NullPointerException e) {
            Item editedItem = new Item(updatedItemName, updatedPrice);
            return editedItem;
        }
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof EditItemCommand)) {
            return false;
        }

        EditItemCommand otherEditItemCommand = (EditItemCommand) other;
        return stallIndex.equals(otherEditItemCommand.stallIndex)
                && itemIndex.equals(otherEditItemCommand.itemIndex)
                && editItemDescriptor.equals(otherEditItemCommand.editItemDescriptor);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("stallIndex", stallIndex)
                .add("itemIndex", itemIndex)
                .add("editItemDescriptor", editItemDescriptor)
                .toString();
    }

    /**
     * Stores the details to edit the item with. Each non-empty field value will replace the
     * corresponding field value of the item.
     */
    public static class EditItemDescriptor {
        private ItemName name;
        private Price price;
        private Rating rating;
        private Description description;
        public EditItemDescriptor() {}

        /**
         * Copy constructor.
         * A defensive copy of {@code tags} is used internally.
         */
        public EditItemDescriptor(EditItemDescriptor toCopy) {
            setItemName(toCopy.name);
            setPrice(toCopy.price);
            setRating(toCopy.rating);
            setDescription(toCopy.description);
        }

        /**
         * Returns true if at least one field is edited.
         */
        public boolean isAnyFieldEdited() {
            return CollectionUtil.isAnyNonNull(name, price, rating, description);
        }

        public boolean isReviewEdited() {
            return CollectionUtil.isAnyNonNull(rating, description);
        }

        public void setItemName(ItemName name) {
            this.name = name;
        }

        public Optional<ItemName> getItemName() {
            return Optional.ofNullable(name);
        }

        public void setPrice(Price price) {
            this.price = price;
        }

        public Optional<Price> getPrice() {
            return Optional.ofNullable(price);
        }

        public void setRating(Rating rating) {
            this.rating = rating;
        }

        public Optional<Rating> getRating() {
            return Optional.ofNullable(rating);
        }

        public void setDescription(Description description) {
            this.description = description;
        }

        public Optional<Description> getDescription() {
            return Optional.ofNullable(description);
        }

        @Override
        public boolean equals(Object other) {
            if (other == this) {
                return true;
            }

            // instanceof handles nulls
            if (!(other instanceof EditItemDescriptor)) {
                return false;
            }

            EditItemDescriptor otherEditItemDescriptor = (EditItemDescriptor) other;
            return Objects.equals(name, otherEditItemDescriptor.name)
                    && Objects.equals(price, otherEditItemDescriptor.price)
                    && Objects.equals(rating, otherEditItemDescriptor.rating)
                    && Objects.equals(description, otherEditItemDescriptor.description);
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this)
                    .add("name", name)
                    .add("price", price)
                    .add("rating", rating)
                    .add("description", description)
                    .toString();
        }
    }
}
