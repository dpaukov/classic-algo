package org.paukov.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Topological Sort of directed graph (a graph with unidirectional edges) is a linear ordering
 * of its vertices such that for every directed edge (U, V) from vertex U to vertex V, U
 * comes before V in the ordering.
 *
 * For example:
 * Input: Vertices=5, Edges=[4, 2], [4, 3], [2, 0], [2, 1], [3, 1]
 * Output: Following are all valid topological sorts for the given graph:
 * 1) 4, 2, 3, 0, 1
 * 2) 4, 3, 2, 0, 1
 * 3) 4, 3, 2, 1, 0
 * 4) 4, 2, 3, 1, 0
 * 5) 4, 2, 0, 3, 1
 */
public class TopologicalSort {

  public static List<Integer> sort(int vertices, int[][] edges) {
    List<Integer> result = new ArrayList<>();
    if (vertices<=0){
      return result;
    }

    Map<Integer, List<Integer>> graph = new HashMap<>();
    int[] inDegree = new int[vertices]; // count of the incoming edges to nodes

    // Initialize the graph
    for (int i=0; i<vertices; i++){
      graph.put(i, new ArrayList<>());
    }

    // Build the graph and inDegree
    for (int[] edge : edges){
      graph.get(edge[0]).add(edge[1]);
      inDegree[edge[1]]++;
    }

    // Perform the BFS from all sources (nodes) that has inDegree == 0
    // Init the queue and offer the initial sources
    Queue<Integer> queue = new LinkedList<>();
    for (int i=0; i<vertices; i++){
      if (inDegree[i]==0){
        queue.offer(i);
      }
    }

    while(!queue.isEmpty()){
      Integer node = queue.poll();
      result.add(node);
      for (Integer child : graph.get(node)) {
        inDegree[child]--;
        if (inDegree[child]==0){
          queue.offer(child);
        }
      }
    }

    if (result.size() != vertices){
      return new ArrayList<>(); // graph has a cycle
    }

    return result;
  }

  // returns all possible topological sort ordering
  // Time: O(V!*E) if no edges, all possible permutations V!.
  public static List<List<Integer>> allSort(int vertices, int[][] edges) {
    List<List<Integer>> result = new ArrayList<>();
    if (vertices<=0){
      return result;
    }

    Map<Integer, List<Integer>> graph = new HashMap<>();
    int[] inDegree = new int[vertices];

    for (int i=0; i<vertices; i++){
      graph.put(i, new ArrayList<>());
    }
    for (int[] edge : edges){
      graph.get(edge[0]).add(edge[1]);
      inDegree[edge[1]]++;
    }

    backtracking(new int[vertices+1], 0, inDegree, graph, result);

    return result;
  }

  static List<Integer> getCandidates(int[] vector, int k, int[] inDegree){
    List<Integer> candidates = new ArrayList<>();
      for (int i = 0; i < inDegree.length; i++) {
        if (inDegree[i] == 0) {
          // check that the candidate is not in the vector already
          boolean find = false;
          for (int j=1; j<=k; j++){
            if (vector[j]==i){
              find = true;
              break;
            }
          }
          if (!find) {
            candidates.add(i);
          }
        }
      }
    return candidates;
  }

  static void backtracking(int[] vector, int k, int[] inDegree, Map<Integer, List<Integer>> graph,
      List<List<Integer>> result){
    if (k == inDegree.length){
      // Solution found: process it.
      ArrayList<Integer> order = new ArrayList<>();
      for (int i=1; i<=k; i++){
        order.add(vector[i]);
      }
      result.add(order);
    } else {
      if (k>0) {
        for (int child : graph.get(vector[k])) {
          inDegree[child]--;
        }
      }
      for (int candidate : getCandidates(vector, k, inDegree)) {
        vector[k + 1] = candidate;
        backtracking(vector, k + 1, inDegree, graph, result);
      }
      if (k>0) {
        for (int child : graph.get(vector[k])) {
          inDegree[child]++;
        }
      }
    }
  }
}
