package datastructures.simpledatastructures;

import java.util.LinkedList;
import java.util.List;

/**
 * A simple queue implementation supporting the following operations.
 * <p>- <Code>enqueue()</Code></p>
 * <p>- <Code>dequeue()</Code></p>
 * <p>- <Code>isEmpty()</Code></p>
 * <p>- <Code>front()</Code></p>
 * <p>- <Code>getSize()</Code></p>
 * <p>- <Code>print()</Code></p>
 *
 * @param <T> the type parameter
 */
public class Queue<T extends Comparable<T>> {
    private List<T> queue;

    public Queue() {
        this.queue = new LinkedList<>();
    }

    /**
     * Adds element to the end of the queue.
     *
     * @param element enqueues the element
     */
    public void enqueue(final T element) {
        this.queue.add(element);
    }

    /**
     * Removes and returns element from the front of the queue.
     *
     * @return the dequeued element or <Code>null</Code> if the queue is empty
     */
    public T dequeue() {
        if (this.isEmpty()) {
            return null;
        }
        return this.queue.remove(0);
    }

    /**
     * @return <Code>true</Code> if the queue is empty
     */
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    /**
     * Lookup the first element of the queue.
     *
     * @return the front element of the queue. If the queue is empty the method returns
     * <Code>null</Code>
     */
    public T front() {
        if (this.isEmpty()) {
            return null;
        }
        return this.queue.get(0);
    }

    /**
     * @return the size of the queue
     */
    public int getSize() {
        return this.queue.size();
    }

    /**
     * Prints the queue from front to back.
     */
    public void print() {
        System.out.print("[");
        for (int i = 0; i < this.getSize() - 1; i++) {
            System.out.print(this.queue.get(i) + ", ");
        }
        System.out.println(this.queue.get(this.getSize() - 1) + "]");
    }
}
