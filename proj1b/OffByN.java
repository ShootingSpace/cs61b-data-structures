import java.util.Comparator;

public class OffByN implements CharacterComparator {
    private int N;
    public OffByN(int N) {
        this.N = N;
    }

    /** returns true for characters that are off by N.
     * For example
     * offBy5.equalChars('a', 'f'); true
     * offBy5.equalChars('f', 'a'); true
     * offBy5.equalChars('f', 'h'); false
     * @param x
     * @param y
     * @return
     */
    @Override
    public boolean equalChars(char x, char y) {
        return ( Math.abs(x-y) == this.N);
    }
}
