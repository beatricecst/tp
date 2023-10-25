package seedu.address.model.stall;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javafx.collections.ObservableList;
import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.item.Item;
import seedu.address.model.item.UniqueItemList;

/**
 * Wraps all data at the menu level
 * Duplicates are not allowed (by .isSameItem comparison)
 */
public class Menu implements ReadOnlyMenu {
    private final UniqueItemList items;

    /*
     * The 'unusual' code block below is a non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */
    {
        items = new UniqueItemList();
    }

    public Menu() {}

    /**
     * Creates a Menu using the items in the {@code toBeCopied}
     */
    public Menu(ReadOnlyMenu toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    //// list overwrite operations

    /**
     * Replaces the contents of the item list with {@code items}.
     * {@code items} must not contain duplicate items.
     */
    public void setItems(List<Item> items) {
        this.items.setItems(items);
    }

    /**
     * Resets the existing data of this {@code Menu} with {@code newData}.
     */
    public void resetData(ReadOnlyMenu newData) {
        requireNonNull(newData);

        setItems(newData.getItemList());
    }

    //// item-level operations

    /**
     * Returns true if a stall with the same identity as {@code item} exists in the menu.
     */
    public boolean hasItem(Item item) {
        requireNonNull(item);
        return items.contains(item);
    }

    public Item getItem(Index itemIndex) {
        return items.getItem(itemIndex.getZeroBased());
    }

    /**
     * Adds an item to the menu.
     * The item must not already exist in the menu.
     */
    public void addItem(Item p) {
        items.add(p);
    }

    /**
     * Replaces the given item {@code target} in the list with {@code editedItem}.
     * {@code target} must exist in the menu.
     * The stall identity of {@code editedStall} must not be the same as another existing stall in the address book.
     */
    public void setItem(Item target, Item editedItem) {
        requireNonNull(editedItem);

        items.setItem(target, editedItem);
    }

    /**
     * Removes {@code key} from this {@code Menu}.
     * {@code key} must exist in the menu.
     */
    public void removeItem(Index itemIndex) {
        items.remove(itemIndex);
    }

    //// util methods

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("items", items)
                .toString();
    }

    @Override
    public ObservableList<Item> getItemList() {
        return items.asUnmodifiableObservableList();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Menu)) {
            return false;
        }

        Menu otherMenu = (Menu) other;
        return items.equals(otherMenu.items);
    }

    @Override
    public int hashCode() {
        return items.hashCode();
    }
}
