package seedu.address.model.stall;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.item.Item;
import seedu.address.model.stall.review.StallReview;

/**
 * Represents a Stall in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Stall {

    // Identity fields
    private final Name name;
    private final Location location;
    private final Menu menu;
    private StallReview stallReview;

    /**
     * Every field must be present and not null.
     */
    public Stall(Name name, Location location) {
        requireAllNonNull(name, location);
        this.name = name;
        this.location = location;
        this.menu = new Menu();
    }

    /**
     * Constructor with menu
     */
    public Stall(Name name, Location location, Menu menu) {
        requireAllNonNull(name, location, menu);
        this.name = name;
        this.location = location;
        this.menu = menu;
    }

    public Name getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public Menu getMenu() {
        return menu;
    }

    public StallReview getStallReview() {
        return stallReview;
    }

    public void setStallReview(StallReview stallReview) {
        this.stallReview = stallReview;
    }

    /**
     * Returns true if both stalls have the same name and location.
     * This defines a weaker notion of equality between two stalls.
     */
    public boolean isSameStall(Stall otherStall) {
        if (otherStall == this) {
            return true;
        }

        return otherStall != null
                && otherStall.getName().equals(getName())
                && otherStall.getLocation().equals(getLocation());
    }

    /**
     * Returns true if both stalls have the same identity and data fields.
     * This defines a stronger notion of equality between two stalls.
     */
    public boolean hasItem(Item item) {
        return menu.hasItem(item);
    }

    /**
     * Adds an item to the menu.
     * The item must not already exist in the menu.
     */
    public void addItem(Item item) {
        menu.addItem(item);
    }

    /**
     * Deletes an item from the menu.
     * The item must already exist in the menu.
     */

    public void deleteItem(Index itemIndex) {
        menu.removeItem(itemIndex);

    }

    public void deleteReview() {
        this.stallReview = null;
    }

    public String getStallReviewString() {
        if (this.stallReview != null) {
            return stallReview.toString();
        } else {
            return "No review added.";
        }
    }


    /**
     * Returns true if both stalls have the same identity and data fields.
     * This defines a stronger notion of equality between two stalls.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Stall)) {
            return false;
        }

        Stall otherStall = (Stall) other;
        return name.equals(otherStall.name)
                && location.equals(otherStall.location)
                && menu.equals(otherStall.menu);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, location);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("name", name)
                .add("location", location)
                .toString();
    }
}
