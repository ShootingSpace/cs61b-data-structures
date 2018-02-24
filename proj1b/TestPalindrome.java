import org.junit.Test;
import static org.junit.Assert.*;

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
    public void testisPalindrome(){
        String t0 = "";
        String t1 = "a";
        String t2 = "racecar";
        String t3 = "noon";

        String f0 = "Aa";
        String f1 = "rancor";
        String f2 = "aaaaab";
        String f3 = "horse";

        assertTrue(palindrome.isPalindrome(t0));
        assertTrue(palindrome.isPalindrome(t1));
        assertTrue(palindrome.isPalindrome(t2));
        assertTrue(palindrome.isPalindrome(t3));

        assertFalse(palindrome.isPalindrome(f0));
        assertFalse(palindrome.isPalindrome(f1));
        assertFalse(palindrome.isPalindrome(f2));
        assertFalse(palindrome.isPalindrome(f3));

    }
}
