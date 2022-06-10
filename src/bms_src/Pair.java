package bms_src;

import java.util.Collection;

public class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public static<K, V> Pair<K, V>[] of(K[] keys, V[] values) {
        if (keys.length != values.length) {
            throw new RuntimeException("The number of keys and values must be equal.");
        }

        Pair<K, V>[] pairs = new Pair[keys.length];

        for (int i = 0; i < keys.length; i++) {
            pairs[i] = new Pair<>(keys[i], values[i]);
        }

        return pairs;
    }
}
