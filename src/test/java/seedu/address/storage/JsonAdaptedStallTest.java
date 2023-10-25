package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.storage.JsonAdaptedStall.MISSING_FIELD_MESSAGE_FORMAT;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalStalls.BEVERAGES;
import static seedu.address.testutil.TypicalStalls.CHICKEN_RICE;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.stall.Location;
import seedu.address.model.stall.Name;

public class JsonAdaptedStallTest {
    private static final String INVALID_NAME = " ";
    private static final String INVALID_LOCATION = " ";

    private static final String VALID_NAME = BEVERAGES.getName().toString();
    private static final String VALID_LOCATION = BEVERAGES.getLocation().toString();

    @Test
    public void toModelType_validStallDetails_returnsStall() throws Exception {
        JsonAdaptedStall stall = new JsonAdaptedStall(BEVERAGES);
        assertEquals(BEVERAGES, stall.toModelType());
    }

    @Test
    public void toModelType_validStallDetailsWithItems_returnsStall() throws Exception {
        JsonAdaptedStall stall = new JsonAdaptedStall(CHICKEN_RICE);
        assertEquals(CHICKEN_RICE, stall.toModelType());
    }

    @Test
    public void toModelType_invalidName_throwsIllegalValueException() {
        JsonAdaptedStall stall =
                new JsonAdaptedStall(INVALID_NAME, VALID_LOCATION, null, null);
        String expectedMessage = Name.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, stall::toModelType);
    }

    @Test
    public void toModelType_nullName_throwsIllegalValueException() {
        JsonAdaptedStall stall = new JsonAdaptedStall(null, VALID_LOCATION, null, null);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, stall::toModelType);
    }


    @Test
    public void toModelType_invalidLocation_throwsIllegalValueException() {
        JsonAdaptedStall stall =
                new JsonAdaptedStall(VALID_NAME, INVALID_LOCATION, null, null);
        String expectedMessage = Location.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, stall::toModelType);
    }

    @Test
    public void toModelType_nullLocation_throwsIllegalValueException() {
        JsonAdaptedStall stall = new JsonAdaptedStall(VALID_NAME, null, null, null);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Location.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, stall::toModelType);
    }
}
