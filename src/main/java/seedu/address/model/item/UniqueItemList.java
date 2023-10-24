package seedu.address.model.item;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Iterator;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.item.exceptions.DuplicateItemException;
import seedu.address.model.item.exceptions.ItemNotFoundException;

/**
 * A list of persons that enforces uniqueness between its elements and does not allow nulls.
 * An item is considered unique by comparing using {@code item#isSamePerson(item)}. As such, adding and updating of
 * persons uses item#isSamePerson(item) for equality to ensure that the item being added or updated is
 * unique in terms of identity in the UniqueitemList. However, the removal of an item uses item#equals(Object)
 * to ensure that the item with exactly the same fields will be removed.
 *
 * Supports a minimal set of list operations.
 *
 * @see Item#isSameItem(Item)
 */
public class UniqueItemList implements Iterable<Item> {

    private final ObservableList<Item> internalList = FXCollections.observableArrayList();
    private final ObservableList<Item> internalUnmodifiableList =
            FXCollections.unmodifiableObservableList(internalList);

    /**
     * Returns size of list
     *
     * @return size of list
     */
    public int getSize() {
        return internalList.size();
    }

    /**
     * Returns Item at index
     * @param index index of item
     * @return item at index
     */
    public Item getItem(int index) {
        return internalList.get(index);
    }

    public Item getItem(Item item) {
        requireNonNull(item);
        return internalList.stream().filter(item::isSameItem).findFirst().get();
    }

    /**
     * Returns true if the list contains an equivalent item as the given argument.
     */
    public boolean contains(Item toCheck) {
        requireNonNull(toCheck);
        return internalList.stream().anyMatch(toCheck::isSameItem);
    }

    /**
     * Adds an item to the list.
     * The item must not already exist in the list.
     */
    public void add(Item toAdd) {
        requireNonNull(toAdd);
        if (contains(toAdd)) {
            throw new DuplicateItemException();
        }
        internalList.add(toAdd);
    }

    /**
     * Replaces the item {@code target} in the list with {@code editeditem}.
     * {@code target} must exist in the list.
     * The item identity of {@code editeditem} must not be the same as another existing item in the list.
     */
    public void setItem(Item target, Item editeditem) {
        requireAllNonNull(target, editeditem);

        int index = internalList.indexOf(target);
        if (index == -1) {
            throw new ItemNotFoundException();
        }

        if (!target.isSameItem(editeditem) && contains(editeditem)) {
            throw new DuplicateItemException();
        }

        internalList.set(index, editeditem);
    }

    /**
     * Removes the equivalent item from the list.
     * The item must exist in the list.
     */
    public void remove(Item toRemove) {
        requireNonNull(toRemove);
        if (!internalList.remove(toRemove)) {
            throw new ItemNotFoundException();
        }
    }

    public void setItems(UniqueItemList replacement) {
        requireNonNull(replacement);
        internalList.setAll(replacement.internalList);
    }

    /**
     * Replaces the contents of this list with {@code items}.
     * {@code items} must not contain duplicate items.
     */
    public void setItems(List<Item> items) {
        requireAllNonNull(items);
        if (!itemsAreUnique(items)) {
            throw new DuplicateItemException();
        }

        internalList.setAll(items);
    }

    /**
     * Returns the backing list as an unmodifiable {@code ObservableList}.
     */
    public ObservableList<Item> asUnmodifiableObservableList() {
        return internalUnmodifiableList;
    }

    @Override
    public Iterator<Item> iterator() {
        return internalList.iterator();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof UniqueItemList)) {
            return false;
        }

        UniqueItemList otherUniqueitemList = (UniqueItemList) other;
        return internalList.equals(otherUniqueitemList.internalList);
    }

    @Override
    public int hashCode() {
        return internalList.hashCode();
    }

    @Override
    public String toString() {
        return internalList.toString();
    }

    /**
     * Returns true if {@code items} contains only unique items.
     */
    private boolean itemsAreUnique(List<Item> items) {
        for (int i = 0; i < items.size() - 1; i++) {
            for (int j = i + 1; j < items.size(); j++) {
                if (items.get(i).isSameItem(items.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }
}
