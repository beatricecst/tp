package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ITEM;
import static seedu.address.logic.parser.CliSyntax.PREFIX_RATING;
import static seedu.address.logic.parser.CliSyntax.PREFIX_STALL;

import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.item.Item;
import seedu.address.model.item.review.ItemReview;
import seedu.address.model.stall.Stall;

/**
 * Adds a review to an item of a stall.
 */
public class AddItemReviewCommand extends Command {
    public static final String COMMAND_WORD = "review-item";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a review to an item of a stall."
            + "Parameters: "
            + PREFIX_STALL + "STALL NUMBER "
            + PREFIX_ITEM + "ITEM NUMBER "
            + PREFIX_RATING + "RATING "
            + PREFIX_DESCRIPTION + "DESCRIPTION \n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_STALL + "1 "
            + PREFIX_ITEM + "1 "
            + PREFIX_RATING + "5 "
            + PREFIX_DESCRIPTION + "Tasty chicken rice with a good amount of meat and rice. "
            + "The chilli is also very good.";

    public static final String MESSAGE_SUCCESS = "Yay! You have added a review for the %1$s at %2$s.";
    public static final String MESSAGE_DUPLICATE_ITEM_REVIEW = "This item already has a review.";

    private final ItemReview toAdd;
    private final Index stallIndex;
    private final Index itemIndex;

    /**
     * Creates an AddItemReviewCommand to add the specified {@code ItemReview}
     */
    public AddItemReviewCommand(Index stallIndex, Index itemIndex, ItemReview itemReview) {
        requireNonNull(itemReview);
        this.toAdd = itemReview;
        this.stallIndex = stallIndex;
        this.itemIndex = itemIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        List<Stall> lastShownList = model.getFilteredStallList();

        if (stallIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_STALL_DISPLAYED_INDEX);
        }

        Stall stallToUpdate = lastShownList.get(stallIndex.getZeroBased());
        List<Item> itemList = stallToUpdate.getMenu().getItemList();


        if (itemIndex.getZeroBased() >= itemList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_ITEM_DISPLAYED_INDEX);
        }

        Item itemToUpdate = itemList.get(itemIndex.getZeroBased());

        if (model.hasItemReview(itemToUpdate)) {
            throw new CommandException(MESSAGE_DUPLICATE_ITEM_REVIEW);
        }

        model.addItemReview(itemToUpdate, toAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, itemToUpdate.getName(), stallToUpdate.getName()));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof AddItemReviewCommand)) {
            return false;
        }

        // state check
        AddItemReviewCommand e = (AddItemReviewCommand) other;
        return toAdd.equals(e.toAdd)
                && stallIndex.equals(e.stallIndex)
                && itemIndex.equals(e.itemIndex);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("toAdd", toAdd)
                .toString();
    }
}
