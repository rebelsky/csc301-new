package mst;

import java.util.List;
import java.util.ArrayList;

public class Kruskals implements MSTAlgorithm {
  public List<Edge> mst(List<Edge> edges) {
    // Sort the edges by weight from least to greatest
    edges.sort((e,f) -> Integer.compare(e.weight, f.weight));

    // Prepare a list of nodes for the MST
    List<Edge> mst = new ArrayList<Edge>();

    // Find the number of the largest node
    int n = 0;
    for (Edge e : edges) {
      if (e.source > n) { n = e.source; }
      if (e.target > n) { n = e.target; }
    }

    // Create an appropriate UnionFind
    UnionFind uf = new UnionFind(n+1);

    // Go through all the edges
    for (Edge e : edges) {
       // If the edge does not create a cycle
       if (uf.find(e.source) != uf.find(e.target)) {
         // Add it
         mst.add(e);
         uf.union(e.source, e.target);
       }
    } // for

    return mst;
  } // mst
} // class Kruskals

