import java.util.Comparator;
import java.util.ArrayList;

/**
 * An implementation of Priority Queues using unsorted arrays.
 */
public class APQ<T>
  implements PriorityQueue<T>
{
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The comparator used for the ordering.
   */
  Comparator<T> compare;

  /**
   * The array that stores the valules.
   */
  ArrayList<T> values;

  /**
   * The number of values stored.
   */
  int size;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  public APQ(Comparator<T> compare) {
    this.compare = compare;
    this.values = new ArrayList<T>();
  } // APQ(Comparator<T>)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Add an element to the priority queue.
   */
  public void add(T val) 
    throws CollectionFullException
  {
    for (int i = 0; i < this.size; i++) {
      System.err.println("Comparing " + val + " to " + this.values.get(i) + ": " +
                         this.compare.compare(val, this.values.get(i)));
    }
    values.add(val);
    ++size;
  } // add(T)

  /**
   * Remove and return the highest priority element from the priority queue.
   */
  public T remove() 
    throws CollectionEmptyException
  {
    return null; // STUB
  } // remove()

  /**
   * Get the highest priority element from the priority queue without
   * removing the element.
   */
  public T peek() 
    throws CollectionEmptyException
  {
    return null; // STUB
  } // peek()

  /**
   * Determine if the collection is empty.
   */
  public boolean isEmpty()
  {
    return this.size == 0;
  } // isEmpty()

} // class APQ<T>
