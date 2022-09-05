package Learning;

import java.util.*;

class GraphHasPath {
  public static void main(String args[]) {
    GraphHasPath program = new GraphHasPath();
    Graph graphF = new Graph('f');
    Graph graphG = new Graph('g');
    Graph graphH = new Graph('h');
    Graph graphI = new Graph('i');
    Graph graphJ = new Graph('j');
    Graph graphK = new Graph('k');
    graphF.Add(graphG);
    graphF.Add(graphI);
    graphG.Add(graphH);
    graphI.Add(graphG);
    graphI.Add(graphK);
    graphJ.Add(graphJ);

    System.out.println(program.HasPathRecursive(graphF, graphK));

    System.out.println(program.HasPathInteration(graphF, graphK));
  }

  // Time (O(e)) # e = edges
  // Space (O(n)) # n = nodes
  public boolean HasPathRecursive(Graph src, Graph dst) {
    if (src.value == dst.value)
      return true;

    for (Graph neighbor : src.graphs) {
      if (HasPathRecursive(neighbor, dst)) {
        return true;
      }
    }

    return false;
  }

  public boolean HasPathInteration(Graph src, Graph dst) {
    Queue<Graph> queue = new LinkedList<Graph>();
    queue.add(src);

    while (!queue.isEmpty()) {
      Graph current = queue.poll();

      if (current.value == dst.value)
        return true;

      for (Graph neighbor : current.graphs) {
        queue.add(neighbor);
      }
    }

    return false;
  }

  static class Graph {
    public List<Graph> graphs;
    public char value;

    public Graph(char value) {
      this.value = value;
      this.graphs = new ArrayList<Graph>() {
      };
    }

    public void Add(Graph graph) {
      this.graphs.add(graph);
    }
  }
}
