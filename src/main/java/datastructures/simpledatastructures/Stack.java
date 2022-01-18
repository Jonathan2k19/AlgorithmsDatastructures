package datastructures.simpledatastructures;

import java.util.LinkedList;
import javax.naming.OperationNotSupportedException;

/**
 * A simple stack implementation supporting the following operations.
 * <p>- <Code>push()</Code></p>
 * <p>- <Code>pop()</Code></p>
 * <p>- <Code>isEmpty()</Code></p>
 * <p>- <Code>top()</Code></p>
 * <p>- <Code>peek()</Code></p>
 * <p>- <Code>getSize()</Code></p>
 * <p>- <Code>printTopToBottom()</Code></p>
 * <p>- <Code>printBottomToTop()</Code></p>
 *
 * @param <T> the type parameter
 */
public class Stack<T> {
    private final LinkedList<T> stack;
    private int size;

    /**
     * Instantiates a new Stack.
     */
    public Stack() {
        this.stack = new LinkedList<>();
        this.size = 0;
    }


    /**
     * Push.
     *
     * @param element The element to push onto the stack
     */
    public void push(final T element) {
        this.stack.add(element);
        this.size++;
    }

    /**
     * Remove the upper-most element of the stack.
     *
     * @throws OperationNotSupportedException If the stack is empty
     */
    public void pop() throws OperationNotSupportedException {
        if (!this.stack.isEmpty()) {
            this.stack.removeLast();
            this.size--;
        } else {
            throw new OperationNotSupportedException("Cannot remove element from empty stack!");
        }
    }

    /**
     * Is empty boolean.
     *
     * @return <Code>true</Code> if stack is empty, <Code>false</Code> otherwise
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Removes the top-most element of the stack and returns it.
     *
     * @return The top-most element of the stack
     * @throws OperationNotSupportedException If the stack is empty
     */
    public T top() throws OperationNotSupportedException {
        final T top = this.stack.getLast();
        this.pop();
        return top;
    }

    /**
     * Returns the top-most element of the stack without removing it.
     */
    public T peek() {
        return this.stack.getLast();
    }

    /**
     * Gets size.
     *
     * @return the size of the stack
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Print the elements on the stack to the screen. Order is from top -> bottom.
     */
    public void printTopToBottom() {
        for (int i = this.size - 1; i >= 0; i--) {
            System.out.println(this.stack.get(i));
        }
    }

    /**
     * Print the elements on the stack to the screen. Order is from bottom -> top.
     */
    public void printBottomToTop() {
        for (int i = 0; i < this.size; i++) {
            System.out.println(this.stack.get(i));
        }
    }
}