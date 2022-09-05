package Learning;

import java.util.*;

class GraphTraversals {
  public static void main(String args[]) {
    GraphTraversals program = new GraphTraversals();
    Graph graphA = new Graph('a');
    Graph graphB = new Graph('b');
    Graph graphC = new Graph('c');
    Graph graphD = new Graph('d');
    Graph graphE = new Graph('e');
    Graph graphF = new Graph('f');
    graphA.Add(graphB);
    graphA.Add(graphC);
    graphB.Add(graphD);
    graphC.Add(graphE);
    graphD.Add(graphF);

    System.out.println("Breadth First traversal: ");
    program.breadthFirstTraversal(graphA);

    System.out.println("\nDepth First recursive traversal: ");
    program.depthFirstRecursiveTraversal(graphA);

    System.out.println("\nDepth First iteration traversal: ");
    program.depthFirstIterationTraversal(graphA);
  }

  public void depthFirstRecursiveTraversal(Graph graph) {
    System.out.print(graph.value + ", ");

    for (Graph neighbor : graph.graphs) {
      depthFirstRecursiveTraversal(neighbor);
    }
  }

  public void depthFirstIterationTraversal(Graph graph) {
    Stack<Graph> queue = new Stack<>();
    queue.add(graph);

    while (!queue.isEmpty()) {
      Graph currentGraph = queue.pop();
      char value = currentGraph.value;
      System.out.print(value + ", ");

      for (Graph neighbor : currentGraph.graphs) {
        queue.add(neighbor);
      }
    }
  }

  public void breadthFirstTraversal(Graph graph) {
    Queue<Graph> queue = new LinkedList<Graph>();
    queue.add(graph);

    while (!queue.isEmpty()) {
      Graph currentGraph = queue.poll();
      char value = currentGraph.value;
      System.out.print(value + ", ");

      for (Graph neighbor : currentGraph.graphs) {
        queue.add(neighbor);
      }
    }
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
