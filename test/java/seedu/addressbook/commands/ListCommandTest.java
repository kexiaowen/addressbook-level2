package seedu.addressbook.commands;

import org.junit.Test;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.util.TypicalPersons;


import java.util.Arrays;
import java.util.List;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class ListCommandTest {

    private final AddressBook addressBook = new TypicalPersons().getTypicalAddressBook();
    private final TypicalPersons td = new TypicalPersons();

    @Test
    public void execute() {
        assertListCommandBehavior(Arrays.asList(td.amy, td.bill, td.candy, td.dan));
    }

    /**
     * Executes the list command and verifies the result matches
     * the persons in the expectedPersonList exactly.
     */
    private void assertListCommandBehavior(List<ReadOnlyPerson> expectedPersonList) {
        ListCommand command = createListCommand();
        CommandResult result = command.execute();

        assertEquals(Command.getMessageForPersonListShownSummary(expectedPersonList), result.feedbackToUser);
    }

    private ListCommand createListCommand() {
        ListCommand command = new ListCommand();
        command.setData(addressBook, Collections.emptyList());
        return command;
    }
}