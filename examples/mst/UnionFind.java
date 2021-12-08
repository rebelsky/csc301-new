package mst;

/**
 * A simple union-find struture.
 */
public class UnionFind {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * Links to the parent node in the union find.  parents[i] is
   * set to i if i is a representative element.
   */
  int[] parents;

  /**
   * The size of the set with representative element i.
   */
  int[] size;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new union find structure with N nodes, each of which
   * is in its own set.
   */
  public UnionFind(int n) {
    parents = new int[n];
    size = new int[n];
    for (int i = 0; i < n; i++) {
      parents[i] = i;
      size[i] = 1;
    } // for
  } // UnionFind

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Given a node, find the representative node.
   */
  public int find(int node) {
    while (parents[node] != node) {
      node = parents[node];
    } // while
    return node;
  } // find

  /**
   * Given two nodes, union their sets
   */
  public void union(int rep1, int rep2) {
    // Find the representative nodes
    rep1 = find(rep1);
    rep2 = find(rep2);

    // Determine the size of the rep1 set and the rep2 set
    int smaller;
    int larger;
    if (size[rep1] > size[rep2]) {
      smaller = rep2;
      larger = rep1;
    } else {
      smaller = rep1;
      larger = rep2;
    }

    // Make the larger one the parent of the smaller one
    parents[smaller] = larger;
    size[larger] += size[smaller];
  } // union

} // class UnionFind
