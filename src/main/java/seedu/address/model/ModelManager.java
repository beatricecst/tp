package seedu.address.model;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.nio.file.Path;
import java.util.function.Predicate;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.item.Item;
import seedu.address.model.item.review.ItemReview;
import seedu.address.model.stall.Stall;

/**
 * Represents the in-memory model of the address book data.
 */
public class ModelManager implements Model {
    private static final Logger logger = LogsCenter.getLogger(ModelManager.class);

    private final AddressBook addressBook;
    private final UserPrefs userPrefs;
    private final FilteredList<Stall> filteredStalls;
    private final FilteredList<Stall> tempFilteredStalls;
    private Item filteredItem;

    /**
     * Initializes a ModelManager with the given addressBook and userPrefs.
     */
    public ModelManager(ReadOnlyAddressBook addressBook, ReadOnlyUserPrefs userPrefs) {
        requireAllNonNull(addressBook, userPrefs);

        logger.fine("Initializing with address book: " + addressBook + " and user prefs " + userPrefs);

        this.addressBook = new AddressBook(addressBook);
        this.userPrefs = new UserPrefs(userPrefs);
        filteredStalls = new FilteredList<>(this.addressBook.getStallList());
        tempFilteredStalls = new FilteredList<>(this.addressBook.getStallList());
    }

    public ModelManager() {
        this(new AddressBook(), new UserPrefs());
    }

    //=========== UserPrefs ==================================================================================

    @Override
    public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
        requireNonNull(userPrefs);
        this.userPrefs.resetData(userPrefs);
    }

    @Override
    public ReadOnlyUserPrefs getUserPrefs() {
        return userPrefs;
    }

    @Override
    public GuiSettings getGuiSettings() {
        return userPrefs.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        requireNonNull(guiSettings);
        userPrefs.setGuiSettings(guiSettings);
    }

    @Override
    public Path getAddressBookFilePath() {
        return userPrefs.getAddressBookFilePath();
    }

    @Override
    public void setAddressBookFilePath(Path addressBookFilePath) {
        requireNonNull(addressBookFilePath);
        userPrefs.setAddressBookFilePath(addressBookFilePath);
    }

    //=========== AddressBook ================================================================================

    @Override
    public void setAddressBook(ReadOnlyAddressBook addressBook) {
        this.addressBook.resetData(addressBook);
    }

    @Override
    public ReadOnlyAddressBook getAddressBook() {
        return addressBook;
    }

    @Override
    public boolean hasStall(Stall stall) {
        requireNonNull(stall);
        return addressBook.hasStall(stall);
    }

    @Override
    public void showStall(Stall stall) {
        requireNonNull(stall);
        Predicate<Stall> predicate = stallll -> stallll.equals(stall);
        tempFilteredStalls.setPredicate(predicate);
    }

    @Override
    public void deleteStall(Stall target) {
        addressBook.removeStall(target);
    }

    @Override
    public void addStall(Stall stall) {
        addressBook.addStall(stall);
        updateFilteredStallList(PREDICATE_SHOW_ALL_STALLS);
    }

    @Override
    public void setStall(Stall target, Stall editedStall) {
        requireAllNonNull(target, editedStall);

        addressBook.setStall(target, editedStall);
    }

    //=========== Filtered Stall List Accessors =============================================================

    /**
     * Returns an unmodifiable view of the list of {@code Stall} backed by the internal list of
     * {@code versionedAddressBook}
     */
    @Override
    public ObservableList<Stall> getFilteredStallList() {
        return filteredStalls;
    }

    @Override
    public ObservableList<Stall> getTempFilteredStallList() {
        return tempFilteredStalls;
    }

    @Override
    public void updateFilteredStallList(Predicate<Stall> predicate) {
        requireNonNull(predicate);
        filteredStalls.setPredicate(predicate);
    }

    //=========== Filtered Item List Accessors =============================================================
    @Override
    public boolean hasItem(Stall stall, Item item) {
        requireNonNull(stall);
        requireNonNull(item);
        return stall.hasItem(item);
    }

    @Override
    public boolean hasItemReview(Item item) {
        requireNonNull(item);
        return item.hasItemReview();
    }

    @Override
    public void addItem(Stall stall, Item item) {
        requireNonNull(stall);
        requireNonNull(item);
        stall.addItem(item);
    }

    @Override
    public void deleteItem(Stall stall, Item item) {
        requireNonNull(stall);
        requireNonNull(item);
        stall.deleteItem(item);
    }

    @Override
    public void addItemReview(Item item, ItemReview itemReview) {
        requireNonNull(item);
        requireNonNull(itemReview);

        item.addItemReview(itemReview);
    }

    @Override
    public void deleteItemReview(Item item) {
        requireNonNull(item);
        item.deleteItemReview();
    }

    @Override
    public Item getFilteredItem() {
        return filteredItem;
    }

    @Override
    public void setFilteredItem(Item item) {
        requireNonNull(item);
        this.filteredItem = item;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof ModelManager)) {
            return false;
        }

        ModelManager otherModelManager = (ModelManager) other;
        return addressBook.equals(otherModelManager.addressBook)
                && userPrefs.equals(otherModelManager.userPrefs)
                && filteredStalls.equals(otherModelManager.filteredStalls);
    }

}
