package seedu.address.storage;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.stall.Location;
import seedu.address.model.stall.Menu;
import seedu.address.model.stall.Name;
import seedu.address.model.stall.Stall;

/**
 * Jackson-friendly version of {@link Stall}.
 */
class JsonAdaptedStall {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Stall's %s field is missing!";

    private final String name;
    private final String location;
    private JsonSerializableMenu menu;

    /**
     * Constructs a {@code JsonAdaptedStall} with the given stall details.
     */
    @JsonCreator
    public JsonAdaptedStall(@JsonProperty("name") String name, @JsonProperty("location") String location,
                            @JsonProperty("items") List<JsonAdaptedItem> items) {
        this.name = name;
        this.location = location;
        if (items != null) {
            this.menu = new JsonSerializableMenu(items);
        }
    }

    /**
     * Converts a given {@code Stall} into this class for Json use.
     */
    public JsonAdaptedStall(Stall source) {
        name = source.getName().fullName;
        location = source.getLocation().locationName;
        menu = new JsonSerializableMenu(source.getMenu());
    }

    /**
     * Converts this Jackson-friendly adapted stall object into the model's {@code Stall} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted stall.
     */
    public Stall toModelType() throws IllegalValueException {
        if (name == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()));
        }
        if (!Name.isValidName(name)) {
            throw new IllegalValueException(Name.MESSAGE_CONSTRAINTS);
        }
        final Name modelName = new Name(name);

        if (location == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    Location.class.getSimpleName()));
        }
        if (!Location.isValidLocation(location)) {
            throw new IllegalValueException(Location.MESSAGE_CONSTRAINTS);
        }
        final Location modelLocation = new Location(location);

        if (menu != null) {
            return new Stall(modelName, modelLocation, new Menu(menu.toModelType()));
        }

        return new Stall(modelName, modelLocation);
    }

}
