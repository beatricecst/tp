package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalStalls.AUNTIES_COOKING;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.item.Item;
import seedu.address.model.item.review.ItemReview;
import seedu.address.model.stall.Stall;
import seedu.address.testutil.StallBuilder;

public class AddStallCommandTest {

    @Test
    public void constructor_nullStall_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new AddStallCommand(null));
    }

    @Test
    public void execute_stallAcceptedByModel_addSuccessful() throws Exception {
        ModelStubAcceptingStallAdded modelStub = new ModelStubAcceptingStallAdded();
        Stall validStall = new StallBuilder().build();

        CommandResult commandResult = new AddStallCommand(validStall).execute(modelStub);

        assertEquals(String.format(AddStallCommand.MESSAGE_SUCCESS, Messages.format(validStall)),
                commandResult.getFeedbackToUser());
        assertEquals(Arrays.asList(validStall), modelStub.stallsAdded);
    }

    @Test
    public void execute_duplicateStall_throwsCommandException() {
        Stall validStall = new StallBuilder().build();
        AddStallCommand addStallCommand = new AddStallCommand(validStall);
        ModelStub modelStub = new ModelStubWithStall(validStall);

        assertThrows(CommandException.class, AddStallCommand.MESSAGE_DUPLICATE_STALL, () -> addStallCommand
                .execute(modelStub));
    }

    @Test
    public void equals() {
        Stall alice = new StallBuilder().withName("Alice").build();
        Stall bob = new StallBuilder().withName("Bob").build();
        AddStallCommand addAliceCommand = new AddStallCommand(alice);
        AddStallCommand addBobCommand = new AddStallCommand(bob);

        // same object -> returns true
        assertTrue(addAliceCommand.equals(addAliceCommand));

        // same values -> returns true
        AddStallCommand addAliceCommandCopy = new AddStallCommand(alice);
        assertTrue(addAliceCommand.equals(addAliceCommandCopy));

        // different types -> returns false
        assertFalse(addAliceCommand.equals(1));

        // null -> returns false
        assertFalse(addAliceCommand.equals(null));

        // different stall -> returns false
        assertFalse(addAliceCommand.equals(addBobCommand));
    }

    @Test
    public void toStringMethod() {
        AddStallCommand addCommand = new AddStallCommand(AUNTIES_COOKING);
        String expected = AddStallCommand.class.getCanonicalName() + "{toAdd=" + AUNTIES_COOKING + "}";
        assertEquals(expected, addCommand.toString());
    }

    /**
     * A default model stub that have all of the methods failing.
     */
    private class ModelStub implements Model {
        @Override
        public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyUserPrefs getUserPrefs() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public GuiSettings getGuiSettings() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setGuiSettings(GuiSettings guiSettings) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Path getAddressBookFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setAddressBookFilePath(Path addressBookFilePath) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addStall(Stall stall) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setAddressBook(ReadOnlyAddressBook newData) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyAddressBook getAddressBook() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasStall(Stall stall) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteStall(Stall target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void showStall(Stall stall) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setStall(Stall target, Stall editedStall) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Stall> getFilteredStallList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Stall> getTempFilteredStallList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredStallList(Predicate<Stall> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addItem(Stall stall, Item item) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteItem(Stall stall, Item item) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasItem(Stall stall, Item item) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addItemReview(Item item, ItemReview itemReview) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteItemReview(Item item) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasItemReview(Item item) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setFilteredItem(Item item) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Item getFilteredItem() {
            throw new AssertionError("This method should not be called.");
        }
    }

    /**
     * A Model stub that contains a single stall.
     */
    private class ModelStubWithStall extends ModelStub {
        private final Stall stall;

        ModelStubWithStall(Stall stall) {
            requireNonNull(stall);
            this.stall = stall;
        }

        @Override
        public boolean hasStall(Stall stall) {
            requireNonNull(stall);
            return this.stall.isSameStall(stall);
        }

        @Override
        public void showStall(Stall stall) {
            requireNonNull(stall);

        }
    }

    /**
     * A Model stub that always accept the stall being added.
     */
    private class ModelStubAcceptingStallAdded extends ModelStub {
        final ArrayList<Stall> stallsAdded = new ArrayList<>();

        @Override
        public boolean hasStall(Stall stall) {
            requireNonNull(stall);
            return stallsAdded.stream().anyMatch(stall::isSameStall);
        }

        @Override
        public void showStall(Stall stall) {
            requireNonNull(stall);
        }

        @Override
        public void addStall(Stall stall) {
            requireNonNull(stall);
            stallsAdded.add(stall);
        }

        @Override
        public ReadOnlyAddressBook getAddressBook() {
            return new AddressBook();
        }
    }

}
