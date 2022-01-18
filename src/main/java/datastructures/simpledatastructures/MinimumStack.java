package datastructures.simpledatastructures;

import java.util.List;
import javax.naming.OperationNotSupportedException;

/**
 * A stack which allows us to find the smallest element of the stack in O(1) <br>
 * Further information: https://cp-algorithms.com/data_structures/stack_queue_modification.html
 */
public class MinimumStack<T extends Comparable<T>> extends Stack<List<T>> {

    /**
     * Create a new <Code>MinimumStack</Code> <br>
     * The stack contains pairs [element, currentMinimum]
     */
    public MinimumStack() {
        super();
    }

    /**
     * Push a new element onto the stack and compare the current minimum with this new element.
     *
     * @param element the element to push onto the stack
     */
    public void push(final T element) {
        if (super.isEmpty()) {
            super.push(List.of(element, element));
        } else {
            final T currentMin = super.peek().get(1);
            super.push(List.of(element, getMin(element, currentMin)));
        }
    }

    /**
     * Find the minimum of the stack in O(1). This does NOT remove the element from the stack!
     *
     * @return the minimum element of the stack
     */
    public T getMinimumAndKeep() {
        return super.peek().get(1);
    }

    /**
     * Find the minimum of the stack in O(1). This DOES remove the element from the stack!
     *
     * @return the minimum element of the stack
     */
    public T getMinimumAndRemove() throws OperationNotSupportedException {
        return super.top().get(1);
    }

    /**
     * @param a the first element
     * @param b the second element
     * @return the smallest element
     */
    private T getMin(final T a, final T b) {
        if (a.compareTo(b) < 0) {
            return a;   // a < b
        } else {
            return b;   // a >= b
        }
    }
}
