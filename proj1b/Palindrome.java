import java.util.Queue;

public class Palindrome {
    /** Input: a String,
     *  Return: a Deque, where the characters appear in the same order as in the String.
     *  For example, if the word is “persiflage”,
     *  then the returned Deque should have‘p’at the front,
     *  followed by ‘e’, and so forth.
     * @param word
     * @return
     */
    public Deque<Character> wordToDeque(String word){
        Deque<Character> ary = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            ary.addLast(word.charAt(i));
        }
        return ary;
    }

    /** return true if the given word is a palindrome, and false otherwise.
     * Any word of length 1 or 0 is a palindrome
     * Case sensitive
     * @param word
     * @return
     */
    public boolean isPalindrome(String word){
        Deque wordQ = wordToDeque(word);
        return isPalindromeHelper(wordQ);
    }

    public boolean isPalindromeHelper(Deque wordQ){
        if (wordQ.size() < 2){
            return true;
        } else {
            if (wordQ.removeFirst() == wordQ.removeLast()){
                return isPalindromeHelper(wordQ);
            }
            return false;
        }
    }

}
