package data_structures;

import java.util.*;

/** The KWPriorityQueue implements the Queue interface
 by building a heap in an ArrayList. The heap is structured
 so that the “smallest” item is at the top.
 */
public class KWPriorityQueue<E> extends AbstractQueue<E>
        implements Queue<E> {
    // Data Fields
    /** The ArrayList to hold the data. */
    private ArrayList<E> theData;
    /** An optional reference to a Comparator object. */
    Comparator<E> comparator = null;
    // Methods
    // Constructor
    public KWPriorityQueue() {
        theData = new ArrayList<>();
    }

    @Override
    public Iterator<E> iterator() {
        return theData.iterator();
    }

    /** Insert an item into the priority queue.
     pre: The ArrayList theData is in heap order.
     post: The item is in the priority queue and
     theData is in heap order.
     @param item The item to be inserted
     @throws NullPointerException if the item to be inserted is null.
     */
    @Override
    public boolean offer(E item) {
        // Add the item to the heap.
        theData.add(item);
        // child is newly inserted item.
        int child = theData.size() - 1;
        int parent = (child - 1) / 2; // Find child's parent.
        // Reheap
        while (parent >= 0 && compare(theData.get(parent),
                theData.get(child)) > 0) {
            swap(parent, child);
            child = parent;
            parent = (child - 1) / 2;
        }
        return true;
    }
    /** Remove an item from the priority queue
     pre: The ArrayList theData is in heap order.
     post: Removed smallest item, theData is in heap order.
     @return The item with the smallest priority value or null if empty.
     */
    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        // Save the top of the heap.
        E result = theData.get(0);
        // If only one item then remove it.
        if (theData.size() == 1) {
            theData.remove(0);
            return result;
        }
 /* Remove the last item from the ArrayList and place it into
 the first position. */
        theData.set(0, theData.remove(theData.size() - 1));
        // The parent starts at the top.
        int parent = 0;
        while (true) {
            int leftChild = 2 * parent + 1;
            if (leftChild >= theData.size()) {
                break; // Out of heap.
            }
            int rightChild = leftChild + 1;
            int minChild = leftChild; // Assume leftChild is smaller.
            // See whether rightChild is smaller.
            if (rightChild < theData.size()
                    && compare(theData.get(leftChild),
                    theData.get(rightChild)) > 0) {
                minChild = rightChild;
            }
            // assert: minChild is the index of the smaller child.
            // Move smaller child up heap if necessary.
            if (compare(theData.get(parent),
                    theData.get(minChild)) > 0) {
                swap(parent, minChild);
                parent = minChild;
            } else { // Heap property is restored.
                break;
            }
        }
        return result;
    }





    /** Creates a heap‐based priority queue with the specified initial
     capacity that orders its elements according to the specified
     comparator.
     @param cap The initial capacity for this priority queue
     @param comp The comparator used to order this priority queue
     @throws IllegalArgumentException if cap is less than 1
     */
    public KWPriorityQueue(int cap, Comparator<E> comp) {
        if (cap < 1)
            throw new IllegalArgumentException();
        theData = new ArrayList<>();
        comparator = comp;
    }

    /** Compare two items using either a Comparator object's compare method
     or their natural ordering using method compareTo.
     @pre: If comparator is null, left and right implement Comparable<E>.
     @param left One item
     @param right The other item
     @return Negative int if left less than right,
     0 if left equals right,
     positive int if left > right
     @throws ClassCastException if items are not Comparable
     */
    @SuppressWarnings("unchecked")
    private int compare(E left, E right) {
        if (comparator != null) { // A Comparator is defined.
            return comparator.compare(left, right);
        } else { // Use left's compareTo method.
            return ((Comparable<E>) left).compareTo(right);
        }
    }

    /**
     * A method that swap values
     * @param index1 and
     * @param index2 is wanted to swapped values
     */
    private void swap(int index1, int index2){
        E temp = theData.get(index1);
        theData.set(index1,theData.get(index2));
        theData.set(index2,temp);
    }

    /**
     * A method that return smallest entry without removing if priority queue
     * is empty then returns null
     * @return
     */
    public E peek(){
        if (theData.size()==0)
            return null;
        return theData.get(0);
    }

    /**
     * A method that return true if the priorityqueue is empty
     * else return false
     * @return indicates is empty or not
     */
    public boolean isEmpty(){
        return theData.size() == 0;
    }

    /**
     * A method that returns smallest enty and returns it if the queue is not empty.
     * If queue is emty then throws exception
     * @return
     */
    public E remove(){
        if (isEmpty())
            throw new IllegalStateException("The priority queue is empty");
        return poll();
    }

    public int size(){
        return theData.size();
    }
}