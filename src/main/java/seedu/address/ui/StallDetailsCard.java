package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.stall.Stall;

/**
 * An UI component that displays information of a {@code Stall}.
 */
public class StallDetailsCard extends UiPart<Region> {

    private static final String FXML = "StallDetailsCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Stall stall;

    @FXML
    private HBox cardPane;
    @FXML
    private Label name;
    @FXML
    private Label locationName;

    @FXML
    private Label review;

    @FXML
    private Label menuItem;

    /**
     * Creates a {@code PersonCode} with the given {@code Stall} and index to display.
     */
    public StallDetailsCard(Stall stall, int displayedIndex) {
        super(FXML);
        this.stall = stall;
        name.setText(stall.getName().fullName);
        locationName.setText(stall.getLocation().locationName);
        if (stall.getMenu().numOfItem() == 0) {
            String str = "No menu item added to this stall yet";
            menuItem.setText(str);
            review.setText(stall.getStallReviewString());
        } else {
            menuItem.setText(stall.getMenuString());
            review.setText(stall.getStallReviewString());
        }

    }
}
