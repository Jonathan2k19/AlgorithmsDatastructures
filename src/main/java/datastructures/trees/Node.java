package datastructures.trees;

/**
 * A generic Node class. Every node contains a <Code>value</Code>.
 *
 * @param <T> the type of the node value
 */
public abstract class Node<T> {
    private T value;
    // TODO: maybe add an id

    public Node(final T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(final T value) {
        this.value = value;
    }

    public void printNode() {
        System.out.println(this.value);
    }
}