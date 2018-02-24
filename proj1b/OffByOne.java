/** Implementation of Project 1b of cs61b
 * @author Cong Chen
 */
import java.lang.Math;
public class OffByOne implements CharacterComparator {
    /** Returns true for characters that are different by exactly one
     * @param x
     * @param y
     * @return
     */
    @Override
    public boolean equalChars(char x, char y) {
        return ( Math.abs(x-y) == 1);
    }
}
