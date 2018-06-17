package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);
        for (int i=0; i<arb.capacity(); i++){
            arb.enqueue(i);
        }
        assertEquals(0, arb.dequeue());
        assertEquals(1, arb.peek());

    }

    @Test(expected = RuntimeException.class)
    public void underFlowTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(1);
        arb.dequeue();
    }

    @Test(expected = RuntimeException.class)
    public void overFlowTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(1);
        for (int i=0; i<=arb.capacity(); i++){
            arb.enqueue(i);
        }
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
