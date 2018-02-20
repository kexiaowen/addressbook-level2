package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class UtilsTest {


    @Test
    public void elementsAreUnique() throws Exception {
        // empty list
        assertAreUnique();

        // only one object
        assertAreUnique((Object) null);
        assertAreUnique(1);
        assertAreUnique("");
        assertAreUnique("abc");

        // all objects unique
        assertAreUnique("abc", "ab", "a");
        assertAreUnique(1, 2);

        // some identical objects
        assertNotUnique("abc", "abc");
        assertNotUnique("abc", "", "abc", "ABC");
        assertNotUnique("", "abc", "a", "abc");
        assertNotUnique(1, new Integer(1));
        assertNotUnique(null, 1, new Integer(1));
        assertNotUnique(null, null);
        assertNotUnique(null, "a", "b", null);
    }

    @Test
    public void isAnyNull() {
        // empty list
        assertNotNull();

        // only one not null object
        assertNotNull(1);
        assertNotNull("");
        assertNotNull("abc");

        // all not null objects
        assertNotNull("abc", "ab", "a");
        assertNotNull(1, 2);
        assertNotNull("a", "ab", "abc", "abcd");

        // only one null object
        assertHasNull((Object)null);

        // some null objects and some not null objects
        assertHasNull(null, "a", "b", null);
        assertHasNull(null, 1, null, "b");
        assertHasNull(1, null, "b");
        assertHasNull(1, null, null, 2);

        // all null objects
        assertHasNull(null, null);
        assertHasNull(null, null, null);
        assertHasNull(null, null, null, null);
    }

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotNull(Object... objects) {
        assertFalse(Utils.isAnyNull(objects));
    }

    private void assertHasNull(Object... objects) {
        assertTrue(Utils.isAnyNull(objects));
    }
}
