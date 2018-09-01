/** Array based Double Ended Queue.
 *  @author Cong Chen
 *  @param <T>
 *  1. Treat array as circular: if front pointer is at position zero,
 *      addFirst: the front pointer should loop back around to the end of the array,
 *      so the new front item in the deque will be the last item in the underlying array.
 *  2. Need only worry about initializing empty ArrayDeques.
 *  3. The starting size of your array should be 8.
 *  4. For arrays of length 16 or more, your usage factor should always be at least 25%.
 */

public class ArrayDeque<T> {
    private static final int RFACTOR = 2; // 扩容 factor
    private static final double USAGE = 0.25; // usage factor
    private static final int MINI_CHECK_CAPACITY = 16;
    private static final int INIT_CAPACITY = 8;
    private T[] items;
    private int head; // mark the head index of array
    private int tail; // mark the tail index of array
    private int size;

    /** 构造一个初始容量 8 的数组，初始有效数据成员为0,
     * when head == tail, the array is empty */
    public ArrayDeque() {
        items = (T[]) new Object[INIT_CAPACITY];
        size = 0;
        head = 0;
        tail = 0;
    }

    /** 改变列表容量, capacity为改变后的容量.
     * For case where head index is larger than tail:
     * 1. First Copy the [head - conatainer bottom] part: the headToBottom chunk,
     *      and position it at the beginning of the new container
     * 2. Copy the rest [real head - nominated tail] part, following the above part.
     * 3. Modify the head and tail.
     * */
    private void resize(int capacity) {
        T[] newContainer = (T[]) new Object[capacity];
        if (head > tail) {
            int headToBottom = items.length - head;
            System.arraycopy(items, head, newContainer, 0, headToBottom);
            System.arraycopy(items, 0, newContainer, headToBottom, size - headToBottom);
        } else {
            System.arraycopy(items, head, newContainer, 0, size);
        }

        items = newContainer;
        head = 0;
        tail = size - 1;
    }

    /** Check if usage rate is low. */
    private boolean isLowUsage() {
        double rate = (double) size / items.length;
        return items.length >= MINI_CHECK_CAPACITY && rate < USAGE;
    }

    /** Adds an item to the front of the Deque. */
    public void addFirst(T x) {
        if (size == items.length) {
            resize(size * RFACTOR);
        }

        if (isEmpty()) {
            /** for empty array, just dial the head and tail back to the initial position */
            head = 0;
            items[head] = x;
            tail = 0;
        } else {
            int insert = (head - 1 + items.length) % items.length;
            items[insert] = x;
            head = insert;
        }

        size += 1;
    }

    /** Adds an item to the back of the Deque. */
    public void addLast(T x) {
        if (size == items.length) {
            resize(size * RFACTOR);
        }

        if (isEmpty()) {
            /** for empty array, just dial the head and tail back to the initial position */
            head = 0;
            items[head] = x;
            tail = 0;
        } else {
            int insert = (tail + 1) % items.length;
            items[insert] = x;
            tail = insert;
        }

        size += 1;
    }

    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Prints the items in the Deque from first to last, separated by a space */
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(items[ (i + head) % items.length]);
            System.out.print(" ");
        }
    }

    /** Removes and returns the item at the front of the Deque.
     * If no such item exists, returns null.O(c). */
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        T save = items[head];
        items[head] = null;
        head = (head + 1) % items.length;
        size -= 1;

        if (isLowUsage()) {
            resize(items.length / RFACTOR);
        }

        return save;
    }

    /** Removes and returns the item at the back of the Deque.
     * If no such item exists, returns null. O(1) */
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        T save = items[tail];
        items[tail] = null;
        tail = (tail - 1 + items.length) % items.length;
        size -= 1;

        if (isLowUsage()) {
            resize(items.length / RFACTOR);
        }

        return save;
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque!
     * Use iteration.  */
    public T get(int index) {
        if (index > size - 1) {
            return null;
        }

        return items[(index + head) % items.length];
    }

}
