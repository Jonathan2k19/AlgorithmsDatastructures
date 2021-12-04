package datastructures.trees;

/**
 * A special node which contains at max. 2 child nodes.
 *
 * @param <T> the type of values this node contains
 */
public class BinaryTreeNode<T> extends Node<T> {
    private T value;
    private BinaryTreeNode<T> leftChild;
    private BinaryTreeNode<T> rightChild;

    public BinaryTreeNode(final T value) {
        super(value);
    }

    public BinaryTreeNode<T> getLeftChild() {
        return this.leftChild;
    }

    public void setLeftChild(final BinaryTreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTreeNode<T> getRightChild() {
        return this.rightChild;
    }

    public void setRightChild(final BinaryTreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }
}