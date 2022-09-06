package Learning;

import java.util.*;

class GraphUndirected {

  public static void main(String args[]) {
    Character[][] edges = { { 'i', 'j' }, { 'k', 'i' }, { 'm', 'k' }, { 'k', 'l' }, { 'o', 'n' } };

    Graph graph = new Graph(edges);
    // Traverse
    graph.print();

    // HasPath
    Character src = 'k';
    Character dst = 'l';
    boolean hasPath = graph.hasPath(src, dst, new HashSet<Character>());
    System.out.print("\n\nsrc: " + src + ", dst: " + dst + ". Found? = " + hasPath);

    // ConnectedComponentsCount
    System.out.print("\n\nCount of compoenents: " + graph.connectedComponentsCount());

    // Largest Component
    System.out.print("\n\nLargest compoenent: " + graph.largestComponent());
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

    public int largestComponent() {
      int largest = Integer.MIN_VALUE;

      for (Character key : graph.keySet()) {
        int currentSize = exploreLargest(key, new HashSet<Character>());
        largest = Math.max(largest, currentSize);
      }

      return largest;
    }

    private int exploreLargest(Character current, Set<Character> visited) {
      if (visited.contains(current))
        return 0;

      visited.add(current);

      int size = 1;

      for (Character character : graph.get(current)) {
        size += exploreLargest(character, visited);
      }

      return size;
    }

    public int connectedComponentsCount() {
      Set<Character> visited = new HashSet<>();
      int count = 0;

      for (Character key : graph.keySet()) {
        if (explore(key, visited))
          count++;
      }

      return count;
    }

    private boolean explore(Character current, Set<Character> visited) {
      if (visited.contains(current))
        return false;

      visited.add(current);

      for (Character character : graph.get(current)) {
        explore(character, visited);
      }

      return true;
    }

    public boolean hasPath(Character src, Character dst, Set<Character> visited) {
      if (src == dst)
        return true;
      if (visited.contains(src))
        return false;

      visited.add(src);

      for (Character neighbor : graph.get(src)) {
        if (hasPath(neighbor, dst, visited))
          return true;
      }

      return false;
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
  }
}
