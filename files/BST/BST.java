/**
 * A simple implementation of BSTs.
 *
 * @author Samuel A. Rebelsky.
 */
package csc301;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * BSTs that hold Key/Value pairs.
 */
public class BST<K,V> {

  // +-------+-------------------------------------------------------
  // | Notes |
  // +-------+

  /* NODES
     We use an inner class for the nodes in the tree.  Because of that,
     we are comfortable accessing the fields directly, rather than
     through getters and setters.
   */

  /* LEAVES/FRINGE
     We use a special empty node at the fringe of the tree.  Doing
     so makes it easier to, say, grab the height or size of anything.
     We use our <pre>newNode</pre> function, rather than the
     <pre>Node</pre> constructor to ensure that each new node has
     the fringe node below it.
   */

   /* SPECIAL PACKAGE METHODS
      Since we may want to do analysis of the tree, we include 
      <pre>height</pre> and <pre>size</pre> methods that other
      classes in the package can use.
    */

  // +----------------+----------------------------------------------
  // | Inner Classses |
  // +----------------+

  /**
   * Nodes in BSTs.
   */
  class Node {
    /**
     * The key/value pair.  Keys are used to order nodes and to find values.
     */
    KVPair<K,V> kv;

    /**
     * The height of the tree rooted at this node.
     */
    int height;

    /**
     * The size of the tree rooted at this node.
     */
    int size;

    /**
     * The left child.
     */
    Node left;

    /**
     * The right child.
     */
    Node right;

    /**
     * Construct a new node.
     */
    Node(KVPair<K,V> kv, int height, int size) {
      this.kv = kv;
      this.height = height;
      this.size = size;
      this.left = null;
      this.right = null;
    } // Node(KVPair, height, size)
  }  // class Node

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The comparator used to determine ordering of keys.
   */
  Comparator<? super K> comparator;
  
  /**
   * The root of the tree.
   */
  Node root;

  /**
   * The node used to mark the fringe of the tree.
   */
  Node FRINGE = new Node(null, 0, 0);

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new BST that compares keys using c
   */
  public BST(Comparator<? super K> c) {
    this.comparator = c;
    this.root = FRINGE;
  } // BST(Comparator<? super K>)

  // +---------------+-----------------------------------------------
  // | Local Helpers |
  // +---------------+

  /** 
   * Build a new node of the appropriate form (with fringe set).
   */
  Node newNode(KVPair<K,V> kv, int height, int size) {
    Node node = new Node(kv, height, size);
    node.left = FRINGE;
    node.right = FRINGE;
    return node;
  } // newNode

  // +-------------------------+-------------------------------------
  // | Special Package Methods |
  // +-------------------------+

  /**
   * Get the height of the tree.
   */
  int height() {
    return this.root.height;
  } // height()

  /**
   * Get the size of the tree.
   */
  int size() {
    return this.root.size;
  } // size()

  // +--------------------+------------------------------------------
  // | Exported Functions |
  // +--------------------+

  /**
   * Get the value with the specified key.
   *
   * @exception NoSuchElementException
   *   If the key is not found.
   */
  public V get(K key) throws NoSuchElementException {
    throw new 
      NoSuchElementException("There is no element with key " + key.toString());
    // STUB
  } // get(K)

  /**
   * Insert or replace the element with the specified key.
   */
  public void set(K key, V value) {
    // STUB
  } // set(K, V)

  /**
   * Find the kth key in the tree.
   *
   * @exception NoSuchElementException
   *   if the key is invalid.
   */
  public K kthKey(int k) throws NoSuchElementException {
    return kthPair(k).key();
  } // kthKey(int)

  /**
   * Find the kth value in the tree.
   *
   * @exception NoSuchElementException
   *   if the key is invalid.
   */
  public V kthValue(int k) throws NoSuchElementException {
    return kthPair(k).value();
  } // kthValue(int)

  /**
   * Find the kth key/value pair in the tree.
   *
   * @exception NoSuchElementException
   *   if the key is invalid.
   */
  public KVPair<K,V> kthPair(int k) throws NoSuchElementException {
    throw new NoSuchElementException("Invalid index: " + k); // STUB
  } // kthPair

  /**
   * Iterate the keys of the tree in preorder.
   */
  public Iterable<K> keys() {
    return () -> keysIterator();
  } // keys()

  /**
   * Iterate the keys of the tree in preorder.
   */
  public Iterable<V> values() {
    return () -> valuesIterator();
  } // values();

  /**
   * Iterate the pairs of the tree in preorder.
   */
  public Iterable<KVPair<K,V>> pairs() {
    return () -> pairsIterator();
  } // pairs()

  /**
   * Iterate the keys of the tree in preoder.
   */
  public Iterator<K> keysIterator() {
    return new Iterator<K>() {
      Iterator<KVPair<K,V>> pairIterator = pairsIterator();
      public boolean hasNext() { return pairIterator.hasNext(); }
      public K next() throws NoSuchElementException { 
        return pairIterator.next().key(); 
      } // next()
      public void remove() throws UnsupportedOperationException,IllegalStateException {
        pairIterator.remove();
      } // remove()
    };
  } // keys()

  /**
   * Iterate the values of the tree in preorder.
   */
  public Iterator<V> valuesIterator() {
    return new Iterator<V>() {
      Iterator<KVPair<K,V>> pairIterator = pairsIterator();
      public boolean hasNext() { return pairIterator.hasNext(); }
      public V next() throws NoSuchElementException { 
        return pairIterator.next().value(); 
      } // next()
      public void remove() throws UnsupportedOperationException,IllegalStateException {
        pairIterator.remove();
      } // remove()
    };
  } // values()

  /**
   * Iterate the key/value pairs in the tree in preorder.
   */
  public Iterator<KVPair<K,V>> pairsIterator() {
    return null; // STUB
  } // pairs()
} // class BST<K,V>

