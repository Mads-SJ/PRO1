package book_examples;

/**
 * This class models a tally counter.
 */
public class Counter {
    private int count;

    /**
     * Gets the current count of this counter.
     * @return the current count.
     */
    public int getCount() {
        return count;
    }

    /**
     * Increments the counter by one.
     */
    public void click() {
        count++;
    }

    /**
     * Resets the counter to zero.
     */
    public void reset() {
        count = 0;
    }
}
