package seedu.address.model.stall;

import javafx.collections.ObservableList;
import seedu.address.model.item.Item;

/**
 * Unmodifiable view of a menu
 */
public interface ReadOnlyMenu {
    /**
     * Returns an unmodifiable view of the item list.
     * This list will not contain any duplicate items.
     */
    ObservableList<Item> getItemList();
}
