package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.item.Item;
import seedu.address.model.item.ItemName;

/**
 * Jackson-friendly version of {@link Item}.
 */
public class JsonAdaptedItem {
    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Item's %s field is missing!";

    private final String itemName;

    /**
     * Constructs a {@code JsonAdaptedItem} with the given item details.
     */
    @JsonCreator
    public JsonAdaptedItem(@JsonProperty("itemName") String itemName) {
        this.itemName = itemName;
    }

    /**
     * Converts a given {@code Item} into this class for Jackson use.
     */
    public JsonAdaptedItem(Item source) {
        itemName = source.getName().fullName;
    }

    /**
     * Converts this Jackson-friendly adapted item object into the model's {@code Item} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted item.
     */
    public Item toModelType() throws IllegalValueException {
        if (itemName == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    ItemName.class.getSimpleName()));
        }
        if (!ItemName.isValidItemName(itemName)) {
            throw new IllegalValueException(ItemName.MESSAGE_CONSTRAINTS);
        }
        final ItemName modelName = new ItemName(itemName);
        return new Item(modelName);
    }
}
