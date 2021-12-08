package mst;

/**
 * A quick and dirty experiment with union find.
 * (Sam is too lazy to write JUnit tests.)
 */
public class UnionFindExperiment {
  static UnionFind uf;

  public static int find(int i) {
    int result = uf.find(i);
    System.out.println("find(" + i + ") = " + result);
    return result;
  }

  public static void union(int i, int j) {
    uf.union(i, j);
    System.out.println("union(" + i + ", " + j +")");
  }

  public static void main(String[] args) {
    uf = new UnionFind(6);
    find(0);
    union(0,1);
    find(0);
    union(0,2);
    find(0);
    find(1);
    find(2);
    find(3);
    union(3,4);
    find(3);
    find(4);
    union(0, 3);
    for (int i = 0; i < 5; i++) {
      find(i);
    }
  } // main(String[])
}
