package mst;

import java.util.List;

/**
 * Algorithms over MSTs.
 */
public interface MSTAlgorithm {
  /**
   * Find the mst for the graph given by edges.
   */
  List<Edge> mst(List<Edge> edges);
} // interface MST
