import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

/** Implementation of Project 1b of cs61b
 * @author Cong Chen
 */
public class TestOffByOne {
    /*
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.**/
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.

    @Test
    public void testequalChars() {
        assertTrue(offByOne.equalChars('a', 'b'));
        assertTrue(offByOne.equalChars('r', 'q'));
        assertTrue(offByOne.equalChars('&', '%'));
        System.out.println('&' - '%');
        System.out.println('2' - '1');

        assertFalse(offByOne.equalChars('a', 'B'));
        assertFalse(offByOne.equalChars('a', 'e'));
        assertFalse(offByOne.equalChars('A', 'a'));
        assertFalse(offByOne.equalChars('a', 'a'));
    }
}
