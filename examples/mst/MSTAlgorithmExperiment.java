package mst;

import java.util.List;
import java.util.ArrayList;

/**
 * A quick experiment with msts.
 */
public class MSTAlgorithmExperiment {
  public static void experiment(MSTAlgorithm algorithm) {
    // Create a graph, which we represent as a list of edge
    List<Edge> edges = new java.util.ArrayList<Edge>();
    edges.add(new Edge(0,1,2));
    edges.add(new Edge(0,2,3));
    edges.add(new Edge(1,2,0));
    // Run the algorithm on the graph
    List<Edge> mst = algorithm.mst(edges);
    // Print the result
    for (Edge e : mst) {
      System.out.println(e);
    } // for
  } // experiment
} // MSTAlgorithmExperiment
