/**
 * Key/value pairs.  
 *
 * @author Samuel A. Rebelsky.
 */
package csc301;

import java.util.Comparator;
import java.util.Iterator;

/**
 * The key/value pairs used in a variety of dictionaries.
 */
public class KVPair<K,V> {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The key.  Keys are used to retrieve values.
   */
  private K key;

  /**
   * The value.  Values are what are stored in dictionaries.
   */
  private V value;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new key/value pair.
   */
  public KVPair(K key, V value) {
    this.key = key;
    this.value= value;
  } // KVPair(K,V)

  // +--------------------+------------------------------------------
  // | Exported Functions |
  // +--------------------+

  /**
   * Get the key from a pair.
   */
  public K key() {
    return this.key;
  } // key()

  /**
   * Get the value from a pair.
   */
  public V value() {
    return this.value;
  } // value()

  /**
   * Set the value in a pair.
   *
   * @return The old value
   */
  public V setValue(V newValue) { 
    V oldValue = this.value;
    this.value = newValue;
    return oldValue;
  } // setValue(V)
} // KVPair<K,V>
