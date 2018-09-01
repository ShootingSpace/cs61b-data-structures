/** Implementation of Project 1b of cs61b
 * Characters in Java include non-alphabetical characters.
 * For example ‘%’ and ‘&’ are off by one. This might seem strange
 * but char values in Java are really just integers.
 * For example ‘%’ is actually just another way of writing 37,
 * and ‘&’ is another way of writing 38.
 * @author Cong Chen
 */
public class OffByOne implements CharacterComparator {
    /** Returns true for characters that are different by exactly one
     * @param x
     * @param y
     * @return
     */
    @Override
    public boolean equalChars(char x, char y) {
        return (Math.abs(x - y) == 1) ? (true) : (false);
    }
}
