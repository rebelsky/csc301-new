package csc301;

import java.util.HashMap;

/**
 * A simple implementation of tries.
 */
public class Trie301<V> implements Dict301<String,V> {
  // +-------+-------------------------------------------------------
  // | Nodes |
  // +-------+

  class TrieNode { 
    String key; // Optional, used for when we reach the end of a string
    V value;    // Only if we have a key.
    HashMap<Character,TrieNode> children;
                // Links to children; uses less space than an array.

    TrieNode (String key, V value) {
      this.key = key;
      this.value = value;
      this.children = new HashMap<Character,TrieNode>();
    } // TrieNode(String, V)

    TrieNode () {
      this(null, null);
    } // TrieNode()
  };

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  TrieNode root = null;

  // +----------------+----------------------------------------------
  // | Helper Methods |
  // +----------------+

  /**
   * Get the value from following the given key, assuming we've
   * already traversed depth edges..
   */
  V get(TrieNode node, String key, int depth) {
    return null; // STUB
  } // get(TrieNode, String, int)

  /**
   * Return the subtree created by setting key to value, assuming
   * we've already traversed the first depth edges.
   */
  TrieNode set(TrieNode node, String key, int depth, V value) {
    return node; // STUB
  } // set(TrieNode, String, int, V)

  // +------------------+--------------------------------------------
  // | Exported Methods |
  // +------------------+

  public void set(String key, V value) {
    this.root = set(this.root, key, 0, value);
  } // set

  public V get(String key) {
    return get(this.root, key, 0);
  } // get(String)
} // class Trie301
