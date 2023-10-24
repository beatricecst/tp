package seedu.address.testutil;

import seedu.address.model.item.Item;
import seedu.address.model.item.ItemName;
import seedu.address.model.stall.Location;
import seedu.address.model.stall.Menu;
import seedu.address.model.stall.Name;
import seedu.address.model.stall.Stall;

/**
 * A utility class to help with building Stall objects.
 */
public class StallBuilder {

    public static final String DEFAULT_NAME = "Chicken Rice";
    public static final String DEFAULT_LOCATION = "Deck";
    private static final Item VALID_ITEM_1 = new Item(new ItemName("Roasted Chicken Rice"));
    private static final Item VALID_ITEM_2 = new Item(new ItemName("Steamed Chicken Rice"));
    private static final Menu DEFAULT_MENU = new MenuBuilder().withItem(VALID_ITEM_1).withItem(VALID_ITEM_2).build();
    private Name name;
    private Location location;
    private Menu menu;


    /**
     * Creates a {@code StallBuilder} with the default details.
     */
    public StallBuilder() {
        name = new Name(DEFAULT_NAME);
        location = new Location(DEFAULT_LOCATION);
        menu = DEFAULT_MENU;
    }

    /**
     * Initializes the StallBuilder with the data of {@code stallToCopy}.
     */
    public StallBuilder(Stall stallToCopy) {
        name = stallToCopy.getName();
        location = stallToCopy.getLocation();
        menu = stallToCopy.getMenu();
    }

    /**
     * Sets the {@code Name} of the {@code Stall} that we are building.
     */
    public StallBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Sets the {@code Location} of the {@code Stall} that we are building.
     */
    public StallBuilder withLocation(String location) {
        this.location = new Location(location);
        return this;
    }

    /**
     * Sets the {@code Menu} of the {@code Stall} that we are building.
     */
    public StallBuilder withMenu(Menu menu) {
        this.menu = menu;
        return this;
    }

    public Stall build() {
        return new Stall(name, location);
    }

}
