package org.paukov.graph;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * This class demonstrates general BFS and DFS algorithms for graphs presented by 2D arrays.
 *
 * Each node (graph[i][j] > 0) is considered valid. Each valid node should have its own unique value.
 * The edges are only presented between valid adjacent nodes. Zero or negative values of any node
 * represents walls (edge absences between the node and the other adjacent nodes).
 *
 * This representation of the graphs is good for maps and/or mazes.
 */
public class GraphRepresentedByArray2D {

  /**
   * Performs BFS on the 2d array. Returns a parent array for finding paths from any node to the
   * starting point (root). Output list contains the visited nodes.
   */
  static public Integer[][][] bfs(int[][] graph, int root_i, int root_j, List<Integer> output) {
    int n = graph.length;
    int m = graph[0].length;

    boolean[][] discovered = new boolean[n][m];
    boolean[][] processed = new boolean[n][m];

    // parents are store in 2 separate arrays for each dimension.
    Integer[][] parent_i = new Integer[n][m];
    Integer[][] parent_j = new Integer[n][m];

    discovered[root_i][root_j] = true;

    Queue<Integer> queue_i = new LinkedList<>();
    Queue<Integer> queue_j = new LinkedList<>();

    queue_i.add(root_i);
    queue_j.add(root_j);

    while (!queue_i.isEmpty()) {
      int i = queue_i.poll();
      int j = queue_j.poll();

      // Event: process the node (i,j) as desired.
      // call other method here.
      // processNodeBefore(graph, i, j);
      output.add(graph[i][j]);

      processed[i][j] = true;

      for (int[] adj : adjacentNodes(graph, i, j)) {
        int adj_i = adj[0];
        int adj_j = adj[1];

        // Event: process the edge (i,j)->(adj_i, adj_j) as desired if the new node was
        // not processed yet. Call other method here.
        //if (!processed[adj_i][adj_j]) {
        //   precessEdge(graph, i, j, adj_i, adj_j);
        //}

        if (!discovered[adj_i][adj_j]) {

          discovered[adj_i][adj_j] = true;

          // Setting the parent for the discovered node.
          parent_i[adj_i][adj_j] = i;
          parent_j[adj_i][adj_j] = j;

          // Enqueue the node
          queue_i.add(adj_i);
          queue_j.add(adj_j);
        }
      }

      // Event: process the node (i,j) when all edges are done.
      // call other function.
      // processNodeAfter(graph, i, j);
    }

    return new Integer[][][]{parent_i, parent_j};
  }

  /**
   * Returns a list of the valid adjacent nodes coordinates (x, y) for a given graph and
   * node (i, j).
   */
  static List<int[]> adjacentNodes(int[][] graph, int i, int j) {
    List<int[]> result = new ArrayList<>();

    // Adding 4 direction of the cell (i,j) if possible.
    if (isValidNode(graph, i + 1, j)) {
      result.add(new int[]{i + 1, j});
    }
    if (isValidNode(graph, i - 1, j)) {
      result.add(new int[]{i - 1, j});
    }
    if (isValidNode(graph, i, j + 1)) {
      result.add(new int[]{i, j + 1});
    }
    if (isValidNode(graph, i, j - 1)) {
      result.add(new int[]{i, j - 1});
    }
    return result;
  }

  /**
   * Returns true if the given node (i, j) is a valid node in the given graph.
   */
  static boolean isValidNode(int[][] graph, int i, int j) {
    int n = graph.length;
    int m = graph[0].length;
    return (i >= 0 && i < n && j >= 0 && j < m && graph[i][j] > 0);
  }

  /**
   * Returns a list of the indexes for the shortest path between a given node (i, j) and the root
   * node that was used for calculating parent BFS matrix. It returns indexes in the order starting
   * from the root.
   */
  public static List<int[]> getPathToRoot(Integer[][][] parentBfs,
      Integer i,
      Integer j,
      int root_i,
      int root_j) {
    if (i == null || j == null) {
      return new ArrayList<>();
    }
    Integer parent_i = parentBfs[0][i][j];
    Integer parent_j = parentBfs[1][i][j];
    List<int[]> path = getPathToRoot(parentBfs, parent_i, parent_j, root_i, root_j);

    // If a path is requested for a node that belongs to another component and
    // doesn't have path, we will return an empty list.
    if (path.isEmpty() && i != root_i && j != root_j) {
      return path;
    }
    path.add(new int[]{i, j});
    return path;
  }

  public static List<Integer> getShortestPath(int[][] graph,
      Integer i,
      Integer j,
      int root_i,
      int root_j) {
    Integer[][][] parentBfs = bfs(graph, root_i, root_j, new ArrayList<>());
    List<int[]> path = getPathToRoot(parentBfs, i, j, root_i, root_j);
    return toNodeValues(graph, path);
  }

  public static List<Integer> toNodeValues(int[][] graph, List<int[]> path) {
    return path.stream().map(node -> {
      int i = node[0];
      int j = node[1];
      return graph[i][j];
    }).collect(toList());
  }

  public static List<List<int[]>> getComponents(int[][] graph) {
    int n = graph.length;
    int m = graph[0].length;
    boolean[][] discovered = new boolean[n][m];

    List<List<int[]>> result = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {

        // we should skip the wall cells
        if (graph[i][j] <= 0) {
          continue;
        }

        if (!discovered[i][j]) {
          // Do BFS starting from this point and collect the nodes into a list
          List<int[]> component = new ArrayList<>();
          discovered[i][j] = true;
          Queue<int[]> queue = new LinkedList<>();
          queue.add(new int[]{i, j});
          while (!queue.isEmpty()) {
            int[] node = queue.poll();
            component.add(node);
            int node_i = node[0];
            int node_j = node[1];
            for (int[] adj : adjacentNodes(graph, node_i, node_j)) {
              int adj_i = adj[0];
              int adj_j = adj[1];
              if (!discovered[adj_i][adj_j]) {
                discovered[adj_i][adj_j] = true;
                queue.add(adj);
              }
            }
          }
          result.add(component);
        }
      }
    }
    return result;
  }


  /**
   * Performs DFS on the 2d array. Returns a parent array for finding paths from any node to the
   * starting point (root), and entry and exit times for each node, discoveryList contains the
   * visited nodes, tree and back edges are returned separately.
   */
  public static Integer[][][] dfs(int[][] graph, int root_i, int root_j,
      // Additional output arguments.
      List<Integer> discoveryList, List<int[]> treeEdges, List<int[]> backEdges) {
    int n = graph.length;
    int m = graph[0].length;
    boolean[][] discovered = new boolean[n][m];
    boolean[][] processed = new boolean[n][m];

    Integer[][] parent_i = new Integer[n][m];
    Integer[][] parent_j = new Integer[n][m];
    Integer[][] entry_time = new Integer[n][m];
    Integer[][] exit_time = new Integer[n][m];

    dfsRecursive(graph, root_i, root_j, discovered, processed, parent_i, parent_j, entry_time,
        exit_time, new Clock(), discoveryList, treeEdges, backEdges);

    return new Integer[][][]{parent_i, parent_j, entry_time, exit_time};
  }

  static void dfsRecursive(int[][] graph, int i, int j,
      boolean[][] discovered,
      boolean[][] processed,
      Integer[][] parent_i,
      Integer[][] parent_j,
      Integer[][] entry_time,
      Integer[][] exit_time,
      Clock clock,
      List<Integer> discoveryList,
      List<int[]> treeEdges,
      List<int[]> backEdges) {
    discovered[i][j] = true;
    entry_time[i][j] = clock.incTime();

    // Event: Process the node (i,j) here as desired.
    // call other method if needed.
    // processNodeBefore(graph, i,j)
    discoveryList.add(graph[i][j]);

    for (int[] adj : adjacentNodes(graph, i, j)) {
      int adj_i = adj[0];
      int adj_j = adj[1];
      if (!discovered[adj_i][adj_j]) {
        parent_i[adj_i][adj_j] = i;
        parent_j[adj_i][adj_j] = j;

        // Event: Process the edge (i, j)->(adj_i, adj_j) here as desired.
        // call other method if needed.
        // processEdge(graph, i,j, adj_i, adj_j)
        treeEdges.add(new int[]{graph[i][j], graph[adj_i][adj_j]});

        dfsRecursive(graph, adj_i, adj_j, discovered, processed, parent_i, parent_j, entry_time,
            exit_time, clock, discoveryList, treeEdges, backEdges);

        // this check for back edges.
      } else if (!processed[adj_i][adj_j] /* || directed graph */) {
        // Event: Process the edge (i, j)->(adj_i, adj_j) here as desired.
        // call other method if needed.
        // processEdge(graph, i,j, adj_i, adj_j)
        Integer pi = parent_i[i][j];
        Integer pj = parent_j[i][j];
        if (pi != adj_i && pj != adj_j) {
          backEdges.add(new int[]{graph[i][j], graph[adj_i][adj_j]});
        }
      }
    }

    // Event: process the node (i,j) when all edges are done.
    // call other function.
    // processNodeAfter(graph, i, j);

    exit_time[i][j] = clock.incTime();
    processed[i][j] = true;
  }

  static class Clock {

    int time = 0;

    int incTime() {
      return time++;
    }
  }
}
