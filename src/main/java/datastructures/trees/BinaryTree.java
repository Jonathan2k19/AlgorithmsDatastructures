package datastructures.trees;

/**
 * A tree with at max. two children per node.
 *
 * @param <T> the type of node value
 */
public abstract class BinaryTree<T> {
    private BinaryTreeNode<T> root;

    /*
    TODO:
        - addNode()
        - removeNode()
        - traverseTreePreOrder()
        - traverseTreePostOrder()
        - invertTree()
        - printTree()
     */

    /**
     * Invert a binary tree. By default, invert the complete tree.
     *
     * @param top the top node of the binary (sub-) tree to invert
     */
    public void invertBinaryTree(final BinaryTreeNode<T> top) {
        BinaryTreeNode<T> parent = this.root;   // default
        if (top != null) {
            parent = top;
        }
        final BinaryTreeNode<T> leftChild = parent.getLeftChild();
        final BinaryTreeNode<T> rightChild = parent.getRightChild();
        parent.setLeftChild(rightChild);
        parent.setRightChild(leftChild);
        invertBinaryTree(parent.getLeftChild());
        invertBinaryTree(parent.getRightChild());
    }
}