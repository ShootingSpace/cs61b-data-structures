import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

/** Test case for Project 1b of cs61b
 * @author Cong Chen
 */
public class TestOffByN {
    @Test
    public void testequalChars(){
        OffByN offBy5 = new OffByN(5);
        assertTrue(offBy5.equalChars('a', 'f'));  // true
        assertTrue(offBy5.equalChars('f', 'a'));  // true
        assertFalse(offBy5.equalChars('f', 'h'));  // false

        OffByN offBy1 = new OffByN(1);
        assertTrue(offBy1.equalChars('r', 'q'));
        assertFalse(offBy1.equalChars('a', 'e'));

        OffByN offBy0 = new OffByN(0);
        assertTrue(offBy0.equalChars('r', 'r'));
        assertFalse(offBy0.equalChars('a', 'e'));

    }
}
