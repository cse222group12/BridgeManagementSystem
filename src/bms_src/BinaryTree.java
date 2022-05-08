package bms_src;

import java.io.Serializable;
import java.util.Scanner;
import java.util.function.BiConsumer;

/** Class for a binary tree that stores type E objects. */
public class BinaryTree<E> implements Serializable {
    // Insert inner class Node<E> here.
    // Data Field
    /**
     * The root of the binary tree
     */
    protected Node<E> root;

    /**
     * Class to encapsulate a tree node.
     */
    public BinaryTree() {
        root = null;
    }

    protected BinaryTree(Node<E> root) {
        this.root = root;
    }

    /** Constructs a new binary tree with data in its root leftTree
     as its left subtree and rightTree as its right subtree.
     */
    public BinaryTree(E data, BinaryTree<E> leftTree,
                      BinaryTree<E> rightTree) {
        root = new Node<>(data);
        if (leftTree != null) {
            root.left = leftTree.root;
        } else {
            root.left = null;
        }
        if (rightTree != null) {
            root.right = rightTree.root;
        } else {
            root.right = null;
        }
    }

    /**
     * Starter method for inOrder traversal
     * @param consumer an object that instantiates the BiConsumer interface. Its method
     *                 implements abstract method apply
     */
    public void inOrderTraverse(BiConsumer<E, Integer> consumer){
        inOrderTraverse(root, 1, consumer);
    }

    /**
     * Perfomrs recursive inOrder traversal of the tree
     * applying the action specified in the consumer object
     * @param node current node
     * @param depth current depth of tree
     * @param consumer whose accept method specifies the action
     *                 to be performed on each node
     */
    private void inOrderTraverse(Node<E> node, int depth, BiConsumer<E, Integer> consumer){
        if (node==null)
            consumer.accept(null, depth);
        else{
            inOrderTraverse(node.left,depth+1,consumer);
            consumer.accept( node.data, depth);
            inOrderTraverse(node.right,depth+1,consumer);
        }
    }

    /**
     * Starter method for postOrder traversal
     * @param consumer an object that instantiates the BiConsumer interface. Its method
     *                 implements abstract method apply
     */
    public void postOrderTraverse(BiConsumer<E, Integer> consumer){
        postOrderTraverse(root,1,consumer);
    }

    /**
     * Perfomrs recursive postOrderTraversal of the tree
     * applying the action specified in the consumer object
     * @param node current node
     * @param depth current depth of tree
     * @param consumer whose accept method specifies the action
     *                 to be performed on each node
     */
    private void postOrderTraverse(Node<E> node, int depth, BiConsumer<E, Integer> consumer){
        if (node==null)
            consumer.accept(null, depth);
        else{
            postOrderTraverse(node.left,depth+1, consumer);
            postOrderTraverse(node.right,depth+1, consumer);
            consumer.accept(node.data, depth);
        }
    }

    /** Starter method for preOrder traversal
     * @param consumer an object that instantiates the BiConsumer interface. Its method
     *                implements abstract method apply
     */
    public void preOrderTraverse(BiConsumer<E, Integer> consumer){
        preOrderTraverse(root, 1, consumer);
    }

    /**
     * Perfomrs recursive preOrderTraversal of the tree
     * applying the action specified in the consumer object
     * @param node current node
     * @param depth current depth of tree
     * @param consumer whose accept method specifies the action
     *                 to be performed on each node
     */
    private void preOrderTraverse(Node<E> node, int depth, BiConsumer<E, Integer> consumer){
        if (node == null)
            consumer.accept(null, depth);
        else{
            consumer.accept(node.data, depth);
            preOrderTraverse(node.left, depth+1, consumer);
            preOrderTraverse(node.right, depth+1, consumer);
        }
    }

    /** Return the left subtree.
     @return The left subtree or null if either the root or
     the left subtree is null
     */
    public BinaryTree<E> getLeftSubtree() {
        if (root != null && root.left != null) {
            return new BinaryTree<>(root.left);
        } else {
            return null;
        }
    }

    /** Determine whether this tree is a leaf.
     @return true if the root has no children
     */
    public boolean isLeaf() {
        return (root.left == null && root.right == null);
    }


    public String inOrder(){
        StringBuilder sb = new StringBuilder();
        inOrder(root, 1, sb);
        return sb.toString();
    }

    private void inOrder(Node<E> node, int depth, StringBuilder sb){
        sb.append(" ".repeat(Math.max(0,depth-1)));
        if (node == null)
            sb.append("null\n");
        else{
            inOrder(node.left, depth+1, sb);
            sb.append(node.toString());
            sb.append("\n");
            inOrder(node.right, depth+1, sb);
        }
    }

    public String postOrder(){
        StringBuilder sb = new StringBuilder();
        postOrder(root, 1, sb);
        return sb.toString();
    }

    private void postOrder(Node<E> node, int depth, StringBuilder sb){
        sb.append(" ".repeat(Math.max(0, depth - 1)));
        if (node == null)
            sb.append("null\n");
        else{
            postOrder(node.left, depth+1, sb);
            postOrder(node.right, depth+1, sb);
            sb.append(node.toString());
            sb.append("\n");
        }
    }

    public String preOrder(){
        StringBuilder sb = new StringBuilder();
        preOrder(root, 1, sb);
        return sb.toString();
    }

    private void preOrder(Node<E> node, int depth, StringBuilder sb){
        sb.append(" ".repeat(Math.max(0, depth)));
        if (node == null)
            sb.append("null\n");
        else{
            sb.append(node.toString());
            sb.append("\n");
            preOrder(node.left, depth+1, sb);
            preOrder(node.right, depth+1, sb);

        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(root, 1, sb);
        return sb.toString();
    }
    /** Converts a sub‐tree to a string.
     Performs a preorder traversal.
     @param node The local root
     @param depth The depth
     @param sb The StringBuilder to save the output
     */
    private void toString(Node<E> node, int depth,
                          StringBuilder sb) {
        sb.append(" ".repeat(Math.max(0, depth - 1)));
        if (node == null) {
            sb.append("null\n");
        } else {
            sb.append(node.toString());
            sb.append("\n");
            toString(node.left, depth + 1, sb);
            toString(node.right, depth + 1, sb);
        }
    }


    /** Method to read a binary tree.
     pre: The input consists of a preorder traversal
     of the binary tree. The line "null" indicates a null tree.
     @param scan the Scanner attached to the input file.
     @return The binary tree
     */
    public static BinaryTree<String> readBinaryTree(Scanner scan) {
        // Read a line and trim leading and trailing spaces.
        String data = scan.nextLine().trim();
        if (data.equals("null")) {
            return null;
        } else {
            BinaryTree<String> leftTree = readBinaryTree(scan);

            BinaryTree<String> rightTree = readBinaryTree(scan);
            return new BinaryTree<>(data, leftTree, rightTree);
        }
    }
    protected static class Node<E> implements Serializable {
        // Data Fields
        /**
         * The information stored in this node.
         */
        protected E data;
        /**
         * Reference to the left child.
         */
        protected Node<E> left;
        /**
         * Reference to the right child.
         */
        protected Node<E> right;
        // Constructors

        /**
         * Construct a node with given data and no children.
         *
         * @param data The data to store in this node
         */
        public Node(E data) {
            this.data = data;
            left = null;
            right = null;
        }
        // Methods

        /**
         * Return a string representation of the node.
         *
         * @return A string representation of the data fields
         */
        public String toString() {
            return data.toString();
        }
    }
    
}