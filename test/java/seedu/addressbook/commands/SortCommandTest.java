package seedu.addressbook.commands;

import org.junit.Before;
import org.junit.Test;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.*;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.util.TestUtil;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class SortCommandTest {
    private AddressBook addressBook;

    private List<ReadOnlyPerson> listWithEveryone;

    @Test
    public void execute() throws Exception {
        Person johnDoe = new Person(new Name("John Doe"), new Phone("61234567", false),
                new Email("john@doe.com", false), new Address("395C Ben Road", false), new UniqueTagList());
        Person janeDoe = new Person(new Name("Jane Doe"), new Phone("91234567", false),
                new Email("jane@doe.com", false), new Address("33G Ohm Road", false), new UniqueTagList());
        Person samDoe = new Person(new Name("Sam Doe"), new Phone("63345566", false),
                new Email("sam@doe.com", false), new Address("55G Abc Road", false), new UniqueTagList());
        Person davidGrant = new Person(new Name("David Grant"), new Phone("61121122", false),
                new Email("david@grant.com", false), new Address("44H Define Road", false),
                new UniqueTagList());

        addressBook = TestUtil.createAddressBook(johnDoe, janeDoe, davidGrant, samDoe);
        listWithEveryone = TestUtil.createList(johnDoe, janeDoe, davidGrant, samDoe);
        List<ReadOnlyPerson> sortedList = TestUtil.createList(davidGrant, janeDoe, johnDoe, samDoe);

        assertSortCommandBehavior(sortedList);
    }

    /**
     * Executes the sort command and verifies the result matches
     * the persons in the expectedPersonList exactly.
     */
    private void assertSortCommandBehavior(List<ReadOnlyPerson> expectedPersonList) {
        SortCommand command = new SortCommand();
        command.setData(addressBook, listWithEveryone);
        command.execute();


        assertEquals(expectedPersonList, addressBook.getAllPersons().immutableListView());
    }

}
