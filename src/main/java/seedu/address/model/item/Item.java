package seedu.address.model.item;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.item.review.ItemReview;
import seedu.address.model.item.review.exceptions.DuplicateItemReviewException;
import seedu.address.model.item.review.exceptions.ItemReviewNotFoundException;

/**
 * Represents an Item in the address book.
 * Guarantees: details are present and not null, field values are validated.
 */
public class Item {

    // Identity fields
    private final ItemName itemName;

    private ItemReview itemReview;

    /**
     * Every field must be present and not null.
     */
    public Item(ItemName itemName) {
        requireAllNonNull(itemName);
        this.itemName = itemName;
    }

    /**
     * Constructor with review
     */
    public Item(ItemName itemName, ItemReview itemReview) {
        requireAllNonNull(itemName, itemReview);
        this.itemName = itemName;
        this.itemReview = itemReview;
    }

    public ItemName getName() {
        return itemName;
    }

    public String getNameString() {
        return itemName.toString();
    }

    public ItemReview getItemReview() {
        return itemReview;
    }

    public String getItemRatingString() {
        if (itemReview == null) {
            return "N/A";
        } else {
            return itemReview.getRatingString();
        }
    }

    public String getItemDescriptionString() {
        if (itemReview == null) {
            return "N/A";
        } else {
            return itemReview.getDescriptionString();
        }
    }

    /**
     * Adds an item review to the item.
     *
     * @param itemReview the item review to be added.
     */
    public void setItemReview(ItemReview itemReview) {
        requireAllNonNull(itemReview);
        if (hasItemReview()) {
            throw new DuplicateItemReviewException();
        }
        this.itemReview = itemReview;
    }

    /**
     * Deletes the item review from the item.
     */
    public void deleteItemReview() {
        if (!hasItemReview()) {
            throw new ItemReviewNotFoundException();
        }
        this.itemReview = null;
    }

    /**
     * Returns true if the item has an item review.
     */
    public boolean hasItemReview() {
        return this.itemReview != null;
    }


    /**
     * Returns true if both items have the same itemName.
     * This defines a weaker notion of equality between two stalls.
     */
    public boolean isSameItem(Item otherItem) {
        if (otherItem == this) {
            return true;
        }

        return otherItem != null
                && otherItem.getName().equals(getName());
    }

    /**
     * Returns true if both items have the same identity and data fields.
     * This defines a stronger notion of equality between two items.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Item)) {
            return false;
        }

        Item otherItem = (Item) other;
        return itemName.equals(otherItem.itemName);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(itemName);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("itemName", itemName)
                .toString();
    }

}
