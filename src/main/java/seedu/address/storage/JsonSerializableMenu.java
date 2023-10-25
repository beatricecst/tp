package seedu.address.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.item.Item;
import seedu.address.model.stall.Menu;
import seedu.address.model.stall.ReadOnlyMenu;


/**
 * An immutable Menu that is serializable to JSON format.
 */
@JsonRootName(value = "menu")
public class JsonSerializableMenu {
    public static final String MESSAGE_DUPLICATE_ITEM = "Items list contains duplicate item(s).";

    private final List<JsonAdaptedItem> items = new ArrayList<>();

    /**
     * Constructs a {@code JsonSerializableMenu} with the given items.
     */
    @JsonCreator
    public JsonSerializableMenu(@JsonProperty("items") List<JsonAdaptedItem> items) {
        if (items != null) {
            this.items.addAll(items);
        }
    }

    /**
     * Converts a given {@code ReadOnlyMenu} into this class for Jackson use.
     *
     * @param source future changes to this will not affect the created {@code JsonSerializableMenu}.
     */
    public JsonSerializableMenu(ReadOnlyMenu source) {
        items.addAll(source.getItemList().stream().map(JsonAdaptedItem::new).collect(Collectors.toList()));
    }


    /**
     * Converts this menu into the model's {@code Menu} object.
     *
     * @throws IllegalValueException if there were any data constraints violated.
     */
    public ReadOnlyMenu toModelType() throws IllegalValueException {
        Menu menu = new Menu();
        for (JsonAdaptedItem jsonAdaptedItem : items) {
            Item item = jsonAdaptedItem.toModelType();
            if (menu.hasItem(item)) {
                throw new IllegalValueException(MESSAGE_DUPLICATE_ITEM);
            }
            menu.addItem(item);
        }
        return menu;
    }
}
