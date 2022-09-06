package Learning;

import java.util.*;

class GraphShortestPath {

  public static void main(String args[]) {
    Character[][] edges = { { 'w', 'x' },
        { 'x', 'y' },
        { 'z', 'y' },
        { 'z', 'v' },
        { 'w', 'v' } };

    Graph graph = new Graph(edges);

    // Traverse
    graph.print();

    System.out.println("\n\nShortest path: " + graph.shortestPath('w', 'z')); // 2
  }

  static class Graph {
    HashMap<Character, List<Character>> graph = new HashMap<>();

    public Graph(Character[][] edges) {

      for (Character[] edge : edges) {
        Character a = edge[0];
        Character b = edge[1];

        if (!graph.containsKey(a))
          graph.put(a, new ArrayList<Character>());
        graph.get(a).add(b);

        if (!graph.containsKey(b))
          graph.put(b, new ArrayList<Character>());
        graph.get(b).add(a);
      }
    }

    public int shortestPath(Character nodeA, Character nodeB) {
      Queue<DistanceInfo> queue = new LinkedList<>();
      queue.add(new DistanceInfo(nodeA, 0));

      Set<Character> visited = new HashSet<Character>();
      visited.add(nodeA);

      while (!queue.isEmpty()) {
        DistanceInfo current = queue.poll();

        if (current.value == nodeB)
          return current.distance;

        for (Character character : graph.get(current.value)) {
          if (!visited.contains(character)) {
            visited.add(character);
            queue.add(new DistanceInfo(character, current.distance + 1));
          }
        }
      }

      return -1;
    }

    public void print() {
      for (Character key : graph.keySet()) {
        List<Character> list = graph.get(key);
        System.out.print("\nNode: " + key);
        for (Character value : list) {
          System.out.print(", " + value);
        }
      }
    }

    class DistanceInfo {
      Character value;
      Integer distance;

      DistanceInfo(Character value, Integer distance) {
        this.value = value;
        this.distance = distance;
      }
    }
  }
}
