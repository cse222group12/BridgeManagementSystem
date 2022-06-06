package data_structures;


import java.util.LinkedList;

/** Hash table implementation using chaining. */
public class HashtableChain<K, V> implements KWHashMap<K, V> {
    // Insert inner class Entry<K, V> here.
    /** The table */
    //array of linked lists
    private LinkedList<Entry<K, V>>[] table;//A table of references to linked lists of Entry<K, V> objects
    /** The number of keys */
    private int numKeys;
    /** The capacity */
    private static final int CAPACITY = 101;
    /** The maximum load factor */
    private static final double LOAD_THRESHOLD = 3.0;
    // Constructor
    public HashtableChain() {
        table = new LinkedList[CAPACITY];
    }

    /** Method get for class HashtableChain.
     @param key The key being sought
     @return The value associated with this key if found;
     otherwise, null
     */
    @Override
    public V get(Object key) {
        int index = key.hashCode() % table.length;
        if (index < 0)
            index += table.length;
        if (table[index] == null)
            return null; // key is not in the table.
        // Search the list at table[index] to find the key.
        for (Entry<K, V> nextItem : table[index]) {
            if (nextItem.getKey().equals(key))
                return nextItem.getValue();
        }
        // assert: key is not in the table.
        return null;
    }

    private void rehash(){
        LinkedList<Entry<K, V>>[] oldTable = table;

        table = new LinkedList[2 * oldTable.length + 1];
        numKeys = 0;

        for (int i = 0; i < oldTable.length; i++) {
            if (oldTable[i]!=null){
                for (Entry<K,V> nextItem:
                        table[i]) {
                    put(nextItem.key, nextItem.value);
                }
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return numKeys==0;
    }

    /** Method put for class HashtableChain.
     @post This key‐value pair is inserted in the
     table and numKeys is incremented. If the key is already
     in the table, its value is changed to the argument
     value and numKeys is not changed.
     @param key The key of item being inserted
     @param value The value for this key
     @return The old value associated with this key if
     found; otherwise, null
     */
    @Override
    public V put(K key, V value) {
        int index = key.hashCode() % table.length;
        if (index < 0)
            index += table.length;
        if (table[index] == null) {
            // Create a new linked list at table[index].
            table[index] = new LinkedList<>();
        }

        // Search the list at table[index] to find the key.
        for (Entry<K, V> nextItem : table[index]) {
            // If the search is successful, replace the old value.
            if (nextItem.getKey().equals(key)) {
                // Replace value for this key.
                V oldVal = nextItem.getValue();
                nextItem.setValue(value);
                return oldVal;
            }
        }
        // assert: key is not in the table, add new item.
        table[index].addFirst(new Entry<>(key, value));
        numKeys++;
        if (numKeys > (LOAD_THRESHOLD * table.length))
            rehash();
        return null;
    }

    @Override
    public V remove(Object key) {
        int index = key.hashCode()% table.length;
        if (index<0)
            index += table.length;

        if (table[index] == null)//key is not in the table
            return null;

        for (Entry<K, V> nextItem : table[index]) {
            // If the search is successful, replace the old value.
            if (nextItem.getKey().equals(key)) {
                V returnV = nextItem.getValue();
                table[index].remove(nextItem);
                numKeys--;
                if (table[index].isEmpty())
                    table[index] = null;
                return returnV;
            }
        }
        return null;
    }
    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null){
                strBuilder.append(i+ "-\t");
                for (Entry<K, V> nextItem : table[i]) {
                    strBuilder.append(table[i].toString()+"\n\n");
                }
            }
            else{
                strBuilder.append(i + "- NotUsed \n");
            }
        }
        return strBuilder.toString();
    }
    @Override
    public int size() {
        return 0;
    }

    /** Contains key‐value pairs for a hash table. */
    private static class Entry<K, V> {
        /**
         * The key
         */
        private final K key;
        /**
         * The value
         */
        private V value;

        /**
         * Creates a new key‐value pair.
         *
         * @param key   The key
         * @param value The value
         */
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /**
         * Retrieves the key.
         *
         * @return The key
         */
        public K getKey() {
            return key;
        }

        /**
         * Retrieves the value.
         *
         * @return The value
         */
        public V getValue() {
            return value;
        }

        /**
         * Sets the value.
         *
         * @param val The new value
         * @return The old value
         */
        public V setValue(V val) {
            V oldVal = value;
            value = val;
            return oldVal;
        }

        @Override
        public String toString() {
            return  "K: " + key + "\t\t"+
                    "V:\t" + value;
        }
    }
}