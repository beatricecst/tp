package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ITEM;
import static seedu.address.logic.parser.CliSyntax.PREFIX_STALL;

import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.item.Item;
import seedu.address.model.stall.Stall;


/**
 * Deletes a review from an item from a stall.
 */
public class DeleteItemReviewCommand extends Command {
    public static final String COMMAND_WORD = "delete-item-review";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Deletes a review from an item from a stall."
            + "Parameters: "
            + PREFIX_STALL + "STALL NUMBER "
            + PREFIX_ITEM + "ITEM NUMBER \n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_STALL + "1 "
            + PREFIX_ITEM + "1 ";

    private static final String MESSAGE_SUCCESS = "You have deleted a review for the %1$s at %2$s.";
    private static final String MESSAGE_ITEM_REVIEW_NOT_FOUND = "This item does not have a review.";

    private final Index stallIndex;
    private final Index itemIndex;

    /**
     * Creates an DeleteItemReviewCommand to delete the specified {@code ItemReview}
     */
    public DeleteItemReviewCommand(Index stallIndex, Index itemIndex) {
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
        if (!model.hasItemReview(itemToUpdate)) {
            throw new CommandException(MESSAGE_ITEM_REVIEW_NOT_FOUND);
        }

        model.deleteItemReview(itemToUpdate);
        return new CommandResult(String.format(MESSAGE_SUCCESS, Messages.format(itemToUpdate), Messages
                .format(stallToUpdate)));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DeleteItemReviewCommand // instanceof handles nulls
                && stallIndex.equals(((DeleteItemReviewCommand) other).stallIndex)
                && itemIndex.equals(((DeleteItemReviewCommand) other).itemIndex));
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("stallIndex", stallIndex)
                .add("itemIndex", itemIndex)
                .toString();
    }
}
