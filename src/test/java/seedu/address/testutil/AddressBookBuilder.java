package seedu.address.testutil;

import seedu.address.model.AddressBook;
import seedu.address.model.stall.Stall;

/**
 * A utility class to help with building Addressbook objects.
 * Example usage: <br>
 *     {@code AddressBook ab = new AddressBookBuilder().withStall("Japanese Stall", "Korean Stall").build();}
 */
public class AddressBookBuilder {

    private AddressBook addressBook;

    public AddressBookBuilder() {
        addressBook = new AddressBook();
    }

    public AddressBookBuilder(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    /**
     * Adds a new {@code Stall} to the {@code AddressBook} that we are building.
     */
    public AddressBookBuilder withStall(Stall stall) {
        addressBook.addStall(stall);
        return this;
    }

    public AddressBook build() {
        return addressBook;
    }
}
