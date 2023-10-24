package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_LOCATION_ASIAN;
import static seedu.address.logic.commands.CommandTestUtil.VALID_LOCATION_BRITISH;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_ASIAN;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BRITISH;
import static seedu.address.testutil.TypicalMenus.VALID_MENU_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.stall.Stall;

/**
 * A utility class containing a list of {@code Stall} objects to be used in tests.
 */
public class TypicalStalls {

    public static final Stall CHICKEN_RICE = new StallBuilder().withName("Chicken Rice")
            .withLocation("Deck").withMenu(VALID_MENU_1).build();

    public static final Stall AUNTIES_COOKING = new StallBuilder().withName("Auntie's Cooking")
            .withLocation("Deck").build();
    public static final Stall BEVERAGES = new StallBuilder().withName("Beverages")
            .withLocation("Deck").build();
    public static final Stall CHINESE = new StallBuilder().withName("Chinese")
            .withLocation("wall street").build();
    public static final Stall DRINKS_STALL = new StallBuilder().withName("Drinks Stall")
            .withLocation("10th street").build();
    public static final Stall ECONOMIC_RICE = new StallBuilder().withName("Economic Rice")
            .withLocation("michegan ave").build();
    public static final Stall FRENCH = new StallBuilder().withName("French").withLocation("little tokyo").build();
    public static final Stall GOODFOOD = new StallBuilder().withName("GoodFood").withLocation("4th street").build();

    // Manually added
    public static final Stall HOON = new StallBuilder().withName("Hoon Meier").withLocation("little india").build();
    public static final Stall IDA = new StallBuilder().withName("Ida Mueller").withLocation("chicago ave").build();

    // Manually added - Stall's details found in {@code CommandTestUtil}
    public static final Stall ASIAN = new StallBuilder()
            .withName(VALID_NAME_ASIAN).withLocation(VALID_LOCATION_ASIAN).build();
    public static final Stall BRITISH = new StallBuilder()
            .withName(VALID_NAME_BRITISH).withLocation(VALID_LOCATION_BRITISH).build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalStalls() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical persons.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Stall stall : getTypicalStalls()) {
            ab.addStall(stall);
        }
        return ab;
    }

    public static List<Stall> getTypicalStalls() {
        return new ArrayList<>(Arrays
                .asList(AUNTIES_COOKING, BEVERAGES, CHINESE, DRINKS_STALL, ECONOMIC_RICE, FRENCH, GOODFOOD));
    }
}
