package mst;

/**
 * Simple edges.
 */
public class Edge {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  int source;

  int target;

  int weight;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  public Edge(int source, int target, int weight) {
    this.source = source;
    this.target = target;
    this.weight = weight;
  } // Edge(int, int, int)

  // +------------------+--------------------------------------------
  // | Standard Methods |
  // +------------------+

  public String toString() {
    return "<" + source + "," + target + ">:" + weight;
  } // toString()

} // class Edge
