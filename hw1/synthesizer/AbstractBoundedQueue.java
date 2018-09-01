package synthesizer;

/** To provide a protected fillCount and capacity variable
 * so that all subclasses will inherit, as well as getter methods capacity() and fillCount().
 * This saves a tiny amount of work for future implementations.
 */
public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T> {
    protected int fillCount;
    protected int capacity;
    public int capacity() {
        return capacity;
    }
    public int fillCount() {
        return fillCount;
    }

}
