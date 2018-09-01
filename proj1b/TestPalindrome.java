import org.junit.Test;
import static org.junit.Assert.*;

/** Implementation of Project 1b of cs61b
 * @author Cong Chen
 */
public class TestPalindrome {
    /** You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.*/
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } // Uncomment this class once you've created your Palindrome class.

    @Test
    public void testisPalindrome() {
        String t0 = "";
        String t1 = "a";
        String t2 = "rr";
        String t3 = "no on";
        String t4 = "racecar";
        String t5 = "123321";

        String f0 = "Aa";
        String f1 = "rancor";
        String f2 = "aaaaab";
        String f3 = "horse";
        String f4 = "racecar ";

        assertTrue(palindrome.isPalindrome(t0));
        assertTrue(palindrome.isPalindrome(t1));
        assertTrue(palindrome.isPalindrome(t2));
        assertTrue(palindrome.isPalindrome(t3));
        assertTrue(palindrome.isPalindrome(t4));
        assertTrue(palindrome.isPalindrome(t5));

        assertFalse(palindrome.isPalindrome(f0));
        assertFalse(palindrome.isPalindrome(f1));
        assertFalse(palindrome.isPalindrome(f2));
        assertFalse(palindrome.isPalindrome(f3));
        assertFalse(palindrome.isPalindrome(f4));

    }

    @Test
    public void testisPalindromeOffByOne() {
        CharacterComparator offByOne = new OffByOne();

        String f2 = "rr";
        String f3 = "no on";
        String f4 = "racecar";
        String f5 = "123321";

        String t0 = "";
        String t1 = "a";
        String t2 = "flake";

        assertTrue(palindrome.isPalindrome(t0, offByOne));
        assertTrue(palindrome.isPalindrome(t1, offByOne));
        assertTrue(palindrome.isPalindrome(t2, offByOne));

        assertFalse(palindrome.isPalindrome(f2, offByOne));
        assertFalse(palindrome.isPalindrome(f3, offByOne));
        assertFalse(palindrome.isPalindrome(f4, offByOne));

    }
}
