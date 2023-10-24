package seedu.address.testutil;

import seedu.address.model.item.Item;
import seedu.address.model.stall.Menu;

/**
 * A utility class to help with building Menu objects.
 * Example usage: <br>
 *    {@code Menu ab = new MenuBuilder().withItem("Chicken Rice", "Duck Rice").build();}
 */
public class MenuBuilder {
    private Menu menu;

    public MenuBuilder() {
        menu = new Menu();
    }

    public MenuBuilder(Menu menu) {
        this.menu = menu;
    }

    /**
     * Adds a new {@code Item} to the {@code Menu} that we are building.
     */
    public MenuBuilder withItem(Item item) {
        menu.addItem(item);
        return this;
    }

    public Menu build() {
        return menu;
    }
}
