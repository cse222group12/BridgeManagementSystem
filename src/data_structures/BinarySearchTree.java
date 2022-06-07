package data_structures;

public class BinarySearchTree<E extends Comparable<E>>
        extends BinaryTree<E> implements SearchTree<E> {
    // Data Fields
    /**
     * Return value from the public add method.
     */
    protected boolean addReturn;
    /**
     * Return value from the public delete method.
     */
    protected E deleteReturn;

    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * PROGRAMMING
     * 1. Write methods contains and remove for the BinarySearchTree class. Use methods find and
     * delete to do the work.
     */
    /**
     * A method to check whether bst contains target element or not
     * @param target an element to wanted to check whether bst is contain or not
     * @return true if the target element exist in the bst
     *          false if not in the bst
     */
    public boolean contains(E target){
        return find(target)!=null;
    }

    /**
     * A method to remove an element in the bst
     * @param target is wanted to remove element from bst
     * @return true if the removed succesfully "Find and remove"
     *          false if the removed element not in the bst
     */
    public boolean remove(E target){
        return delete(target)!=null;
    }


    /**
     *
     */



    /** Starter method find.
     pre: The target object must implement
     the Comparable interface.
     @param target The Comparable object being sought
     @return The object, if found, otherwise null
     */
    public E find(E target) {
        return find(root, target);
    }
    /** Recursive find method.
     @param localRoot The local subtree's root
     @param target The object being sought
     @return The object, if found, otherwise null
     */
    private E find(Node<E> localRoot, E target) {
        if (localRoot == null)
            return null;
        // Compare the target with the data field at the root.
        int compResult = target.compareTo(localRoot.data);
        if (compResult == 0)
            return localRoot.data;
        else if (compResult < 0)
            return find(localRoot.left, target);
        else
            return find(localRoot.right, target);
    }

    /** Starter method add.
     pre: The object to insert must implement the
     Comparable interface.
     @param item The object being inserted
     @return true if the object is inserted, false
     if the object already exists in the tree
     */
    public boolean add(E item) {
        root = add(root, item);
        return addReturn;
    }
    /** Recursive add method.
     post: The data field addReturn is set true if the item is added to
     the tree, false if the item is already in the tree.
     @param localRoot The local root of the subtree
     @param item The object to be inserted
     @return The new local root that now contains the
     inserted item
     */
    private Node<E> add(Node<E> localRoot, E item) {
        if (localRoot == null) {
            // item is not in the tree — insert it.
            addReturn = true;
            return new Node<>(item);
        } else if (item.compareTo(localRoot.data) == 0) {
            // item is equal to localRoot.data
            addReturn = false;
            return localRoot;
        } else if (item.compareTo(localRoot.data) < 0) {
            // item is less than localRoot.data
            localRoot.left = add(localRoot.left, item);
            return localRoot;
        } else {
            // item is greater than localRoot.data
            localRoot.right = add(localRoot.right, item);
            return localRoot;
        }
    }


/**
 *  * 2. Self‐Check Exercise 4 indicates that two items can be used to replace a data item in a
 *  * binary search tree. Rewrite method delete so that it retrieves the leftmost element in the
 *  * right subtree instead. You will also need to provide a method findSmallestChild.
 */
    /** Starter method delete2.
     post: The object is not in the tree.
     @param target The object to be deleted
     @return The object deleted from the tree
     or null if the object was not in the tree
     @throws ClassCastException if target does not implement
     Comparable
     */
    public E delete2(E target){
        root = delete2(root, target);
        return deleteReturn;
    }
    private Node<E> delete2(Node<E> localRoot, E item){
        if(localRoot == null){
            deleteReturn = null;
            return localRoot;
        }
        //search for item to delete
        int compResult = item.compareTo(localRoot.data);
        if (compResult<0){
            localRoot.left = delete2(localRoot.left, item);
            return localRoot;
        }
        else if (compResult>0){
            localRoot.right = delete2(localRoot.right,item);
            return localRoot;
        }
        else{//item is at local root
            deleteReturn = localRoot.data;
            if (localRoot.right== null){
                //if there is no right child, return left child
                //which can also be null.
                return localRoot.left;
            }
            else if (localRoot.left == null)//if there is no left child, return right child
                return localRoot.right;
            else{//Node being deleted has 2 children, replace the data
                //with inorder successor
                if (localRoot.right.left == null){
                    // The right child has nor left child
                    //replace the data with the data int the right child
                    localRoot.data = localRoot.right.data;
                    localRoot.right = localRoot.right.right;
                    return localRoot;
                }else{
                    // Search for the inorder successor (is) and
                    //replace deleted node's data with is.
                    localRoot.data = findSmallestChild(localRoot.right);
                    return localRoot;
                }

            }

        }
    }

    /** Starter method delete.
     post: The object is not in the tree.
     @param target The object to be deleted
     @return The object deleted from the tree
     or null if the object was not in the tree
     @throws ClassCastException if target does not implement
     Comparable
     */
    public E delete(E target) {
        root = delete(root, target);
        return deleteReturn;
    }
    /** Recursive delete method.
     post: The item is not in the tree;
     deleteReturn is equal to the deleted item
     as it was stored in the tree or null
     if the item was not found.
     @param localRoot The root of the current subtree
     @param item The item to be deleted
     @return The modified local root that does not contain
     the item
     */
    private Node<E> delete(Node<E> localRoot, E item) {
        if (localRoot == null) {
            // item is not in the tree.
            deleteReturn = null;
            return localRoot;
        }
        // Search for item to delete.
        int compResult = item.compareTo(localRoot.data);
        if (compResult < 0) {
            // item is smaller than localRoot.data.
            localRoot.left = delete(localRoot.left, item);
            return localRoot;
        } else if (compResult > 0) {
            // item is larger than localRoot.data.
            localRoot.right = delete(localRoot.right, item);
            return localRoot;
        } else {
            // item is at local root.
            deleteReturn = localRoot.data;
            if (localRoot.left == null) {
                // If there is no left child, return right child
                // which can also be null.
                return localRoot.right;
            } else if (localRoot.right == null) {
                // If there is no right child, return left child.
                return localRoot.left;
            } else {
                // Node being deleted has 2 children, replace the data
                // with inorder predecessor.
                if (localRoot.left.right == null) {
                    // The left child has no right child.
                    // Replace the data with the data in the
                    // left child.
                    localRoot.data = localRoot.left.data;
                    // Replace the left child with its left child.
                    localRoot.left = localRoot.left.left;
                    return localRoot;
                } else {
                    // Search for the inorder predecessor (ip) and
                    // replace deleted node's data with ip.
                    localRoot.data = findLargestChild(localRoot.left);
                    return localRoot;
                }
            }
        }
    }

    /** Find the node that is the
     inorder predecessor and replace it
     with its left child (if any).
     post: The inorder predecessor is removed from the tree.
     @param parent The parent of possible inorder
     predecessor (ip)
     @return The data in the ip
     */
    public E findLargestChild(Node<E> parent) {
        // If the right child has no right child, it is
        // the inorder predecessor.
        if (parent.right.right == null) {
            E returnValue = parent.right.data;
            parent.right = parent.right.left;
            return returnValue;
        } else {
            return findLargestChild(parent.right);
        }
    }


    /**
     * A method to get smallest nodes data end remove it from bst
     * post: The inorder predecessor is removed from the tree.
     * @param parent the parent of possible inorder successor (is)
     * @return the data in the inorder successor (is)
     */
    public E findSmallestChild(Node<E> parent){
        if(parent.left.left == null){
            E returnValue = parent.left.data;
            parent.left = parent.left.left;
            return returnValue;
        }else
            return findSmallestChild(parent.left);
    }
    public Node<E> getRoot(){return root;}
}
