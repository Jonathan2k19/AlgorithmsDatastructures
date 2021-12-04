package datastructures.simpledatastructures;

import javax.naming.OperationNotSupportedException;

/**
 * <b>Implementation of an array using two stacks with the following operations.</b>
 * <p>- <Code>add()</Code></p>
 * <p>- <Code>add(int position)</Code></p>
 * <p>- <Code>set()</Code></p>
 * <p>- <Code>removeLast()</Code></p>
 * <p>- <Code>remove(int position)</Code></p>
 * <p>- <Code>getLast()</Code></p>
 * <p>- <Code>get(int position)</Code></p>
 * <p>- <Code>print()</Code></p>
 *
 * @param <T> the type parameter
 */
public class ArrayUsingStacks<T> {
    private final Stack<T> stack1;
    private final Stack<T> stack2;

    /**
     * Instantiates a new Array using stacks.
     */
    public ArrayUsingStacks() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    /**
     * Add element to the back.
     *
     * @param element the element to add
     */
    public void add(final T element) {
        this.stack1.push(element);
    }

    /**
     * Add element to a specified position.
     *
     * @param element  the element to add
     * @param position the index at which the element should be added
     * @throws OperationNotSupportedException if stack is empty
     */
    public void add(final T element, final int position) throws OperationNotSupportedException {
        final int positionFromTop = this.stack1.getSize() - position;
        shiftElementsToSecondStack(positionFromTop);
        this.stack1.push(element);  // push new element at specified position
        shiftElementsToMainStack();
    }

    /**
     * Remove old element at given index and set new element.
     *
     * @param element  the new element
     * @param position the index
     * @throws OperationNotSupportedException if stack is empty
     */
    public void set(final T element, final int position) throws OperationNotSupportedException {
        final int positionFromTop = this.stack1.getSize() - position;
        shiftElementsToSecondStack(positionFromTop);
        this.stack2.pop();          // remove old element at specified position
        this.stack1.push(element);  // push new element at specified position
        shiftElementsToMainStack();
    }

    /**
     * Remove the last element of the array.
     *
     * @throws OperationNotSupportedException if stack is empty
     */
    public void removeLast() throws OperationNotSupportedException {
        this.stack1.pop();
    }

    /**
     * Remove an element at a specified position in the array.
     *
     * @param position the specified index
     * @throws OperationNotSupportedException if stack is empty
     */
    public void remove(final int position) throws OperationNotSupportedException {
        final int positionFromTop = this.stack1.getSize() - position;
        shiftElementsToSecondStack(positionFromTop);
        this.stack2.pop();          // remove old element at specified position
        shiftElementsToMainStack();
    }

    /**
     * Gets last.
     *
     * @return the last element of the array
     * @throws OperationNotSupportedException if stack is empty
     */
    public T getLast() throws OperationNotSupportedException {
        final T top = this.stack1.top();
        this.stack1.push(top);
        return top;
    }

    /**
     * Get t.
     *
     * @param position the specified index
     * @return <Code>array[position]</Code>
     * @throws OperationNotSupportedException if stack is empty
     */
    public T get(final int position) throws OperationNotSupportedException {
        final int positionFromTop = this.stack1.getSize() - position;
        shiftElementsToSecondStack(positionFromTop);
        return this.stack2.top();          // return element at specified position
    }

    /**
     * Print the array to the screen.
     */
    public void print() {
        this.stack1.printBottomToTop();
    }

    /**
     * Shift a specified number of elements from the main stack to the second stack.
     *
     * @param howMany the number of elements to shift
     * @throws OperationNotSupportedException if stack is empty
     */
    private void shiftElementsToSecondStack(final int howMany)
            throws OperationNotSupportedException {
        for (int i = 0; i < howMany; i++) {
            this.stack2.push(this.stack1.top());
        }
    }

    /**
     * Shift all elements from the second stack to the main stack.
     *
     * @throws OperationNotSupportedException if stack is empty
     */
    private void shiftElementsToMainStack() throws OperationNotSupportedException {
        final int size = this.stack2.getSize();
        for (int i = 0; i < size; i++) {
            this.stack1.push(this.stack2.top());
        }
    }
}