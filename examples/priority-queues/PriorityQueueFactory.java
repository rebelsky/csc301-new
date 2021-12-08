import java.util.Comparator;

/**
 * Factories for priority queues.
 */
public interface PriorityQueueFactory<T>
{
  /**
   * Construct a new priority queue that uses a particular comparator
   * to order elements.
   */
  PriorityQueue<T> construct(Comparator<T> compare);
} // interface PriorityQueueFactory<T>
