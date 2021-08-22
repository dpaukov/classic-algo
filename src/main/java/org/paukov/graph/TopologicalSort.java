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
}
