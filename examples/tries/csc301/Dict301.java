package csc301;

/**
 * Simple dictionaries.
 */
interface Dict301<K,V> {
  /**
   * Add a key/value pair.
   */
  void set(K key, V value);

  /**
   * Look up a value.
   */
  V get(K key);
} // interface Dict301<K,V>
