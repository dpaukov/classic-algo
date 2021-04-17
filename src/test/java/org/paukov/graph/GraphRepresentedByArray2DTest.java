package org.paukov.graph;

import static org.fest.assertions.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public final class GraphRepresentedByArray2DTest {

  @Test
  public void bfs_start_from_0_0() {
    int[][] graph = new int[][]{
        {10, 11, 12, 13, 14, 15},
        {20, 21, 22, 23, 24, 25},
        {30, 31, 32, 33, 34, 35},
        {40, 41, 42, 43, 44, 45},
        {50, 51, 52, 53, 54, 55}
    };
    List<Integer> expectedOutput = new ArrayList<>();

    Integer[][][] parent = GraphRepresentedByArray2D.bfs(graph, 0, 0, expectedOutput);

    assertThat(expectedOutput)
        .containsSequence(10, 20, 11, 30, 21, 12, 40, 31, 22, 13, 50, 41, 32, 23, 14, 51, 42, 33,
            24, 15, 52, 43, 34, 25, 53, 44, 35, 54, 45, 55);
    assertThat(parent[0]).isEqualTo(
        new Integer[][]{
            {null, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 1},
            {1, 2, 2, 2, 2, 2},
            {2, 3, 3, 3, 3, 3},
            {3, 4, 4, 4, 4, 4}});
    assertThat(parent[1]).isEqualTo(
        new Integer[][]{
            {null, 0, 1, 2, 3, 4},
            {0, 0, 1, 2, 3, 4},
            {0, 0, 1, 2, 3, 4},
            {0, 0, 1, 2, 3, 4},
            {0, 0, 1, 2, 3, 4}});
  }

  @Test
  public void bfs_start_from_2_2() {
    int[][] graph = new int[][]{
        {10, 11, 12, 13, 14, 15},
        {20, 21, 22, 23, 24, 25},
        {30, 31, 32, 33, 34, 35},
        {40, 41, 42, 43, 44, 45},
        {50, 51, 52, 53, 54, 55}
    };
    List<Integer> expectedOutput = new ArrayList<>();

    Integer[][][] parent = GraphRepresentedByArray2D.bfs(graph, 2, 2, expectedOutput);

    assertThat(expectedOutput)
        .containsSequence(32, 42, 22, 33, 31, 52, 43, 41, 12, 23, 21, 34, 30, 53, 51, 44, 40, 13,
            11, 24, 20, 35, 54, 50, 45, 14, 10, 25, 55, 15);
    assertThat(parent[0]).isEqualTo(
        new Integer[][]{
            {0, 0, 1, 0, 0, 0},
            {1, 1, 2, 1, 1, 1},
            {2, 2, null, 2, 2, 2},
            {3, 3, 2, 3, 3, 3},
            {4, 4, 3, 4, 4, 4}});
    assertThat(parent[1]).isEqualTo(
        new Integer[][]{
            {1, 2, 2, 2, 3, 4},
            {1, 2, 2, 2, 3, 4},
            {1, 2, null, 2, 3, 4},
            {1, 2, 2, 2, 3, 4},
            {1, 2, 2, 2, 3, 4}});
  }

  @Test
  public void bfs_with_walls() {
    int[][] graph = new int[][]{
        {10, -1, 12, -1, 14, 15},
        {20, -1, 22, 23, 24, 25},
        {30, -1, -1, -1, -1, 35},
        {40, 41, 42, 43, -1, 45},
        {50, 51, -1, 53, 54, 55}
    };
    List<Integer> expectedOutput = new ArrayList<>();

    Integer[][][] parent = GraphRepresentedByArray2D.bfs(graph, 0, 2, expectedOutput);

    assertThat(expectedOutput)
        .containsSequence(12, 22, 23, 24, 14, 25, 15, 35, 45, 55, 54, 53, 43, 42, 41, 51, 40, 50,
            30, 20, 10);
    assertThat(parent[0]).isEqualTo(
        new Integer[][]{
            {1, null, null, null, 1, 0},
            {2, null, 0, 1, 1, 1},
            {3, null, null, null, null, 1},
            {3, 3, 3, 4, null, 2},
            {4, 3, null, 4, 4, 3}});
    assertThat(parent[1]).isEqualTo(
        new Integer[][]{
            {0, null, null, null, 4, 4},
            {0, null, 2, 2, 3, 4},
            {0, null, null, null, null, 5},
            {1, 2, 3, 3, null, 5},
            {1, 1, null, 4, 5, 5}});
  }

  @Test
  public void getPathToRoot_0_0_to_root_5_5() {
    // -1 represents wall.
    int[][] graph = new int[][]{
        {10, 11, 12, 13, 14, 15},
        {-1, -1, -1, -1, 24, 25},
        {30, 31, 32, 33, 34, 35},
        {40, -1, -1, 43, -1, -1},
        {50, 51, 52, -1, 54, 55},
        {60, 61, 62, 63, 64, 65}
    };
    List<Integer> output = new ArrayList<>();
    Integer[][][] parent = GraphRepresentedByArray2D.bfs(graph, 5, 5, output);

    List<int[]> path = GraphRepresentedByArray2D.getPathToRoot(parent, 0, 0, 5, 5);
    List<Integer> nodes = GraphRepresentedByArray2D.toNodeValues(graph, path);

    assertThat(nodes)
        .containsSequence(65, 64, 63, 62, 52, 51, 50, 40, 30, 31, 32, 33, 34, 24, 14, 13, 12, 11,
            10);
  }

  @Test
  public void getPathToRoot_root_to_root() {
    // -1 represents wall.
    int[][] graph = new int[][]{
        {10, 11, 12, 13, 14, 15},
        {-1, -1, -1, -1, 24, 25},
        {30, 31, 32, 33, 34, 35},
        {40, -1, -1, 43, -1, -1},
        {50, 51, 52, -1, 54, 55},
        {60, 61, 62, 63, 64, 65}
    };
    List<Integer> output = new ArrayList<>();
    Integer[][][] parent = GraphRepresentedByArray2D.bfs(graph, 5, 5, output);

    List<int[]> path = GraphRepresentedByArray2D.getPathToRoot(parent, 5, 5, 5, 5);
    List<Integer> nodes = GraphRepresentedByArray2D.toNodeValues(graph, path);

    assertThat(nodes).containsExactly(65);
  }

  @Test
  public void getPathToRoot_noPath() {
    // -1 represents wall.
    int[][] graph = new int[][]{
        {10, 11, 12, 13, 14, 15},
        {-1, -1, -1, -1, 24, 25},
        {30, 31, 32, -1, 34, 35},
        {40, -1, -1, -1, -1, -1},
        {50, 51, 52, 53, 54, 55},
        {60, 61, 62, 63, 64, 65}
    };
    List<Integer> output = new ArrayList<>();
    Integer[][][] parent = GraphRepresentedByArray2D.bfs(graph, 5, 5, output);

    List<int[]> path = GraphRepresentedByArray2D.getPathToRoot(parent, 0, 0, 5, 5);
    List<Integer> nodes = GraphRepresentedByArray2D.toNodeValues(graph, path);

    assertThat(nodes).isEmpty();
  }

  @Test
  public void getShortestPath_0_0_to_root_5_5() {
    // -1 represents wall.
    int[][] graph = new int[][]{
        {10, 11, 12, 13, 14, 15},
        {-1, -1, -1, -1, 24, 25},
        {30, 31, 32, 33, 34, 35},
        {40, -1, -1, 43, 44, -1},
        {50, 51, 52, -1, 54, 55},
        {60, 61, 62, 63, 64, 65}
    };

    List<Integer> nodes = GraphRepresentedByArray2D.getShortestPath(graph, 0, 0, 5, 5);

    assertThat(nodes)
        .containsSequence(65, 55, 54, 44, 34, 24, 14, 13, 12, 11, 10);
  }

  @Test
  public void getComponents_allGraph() {
    int[][] graph = new int[][]{
        {10, 11, 12, 13, 14, 15},
        {20, 21, 22, 23, 24, 25},
        {30, 31, 32, 33, 34, 35},
        {40, 41, 42, 43, 44, 45},
        {50, 51, 52, 53, 54, 55}
    };

    List<List<int[]>> components = GraphRepresentedByArray2D.getComponents(graph);

    List<List<Integer>> values = components.stream().map(
        indexes -> GraphRepresentedByArray2D.toNodeValues(graph, indexes))
        .collect(Collectors.toList());

    assertThat(values).hasSize(1);
    assertThat(values.get(0)).containsExactly(
        10, 20, 11, 30, 21, 12, 40, 31, 22, 13, 50, 41, 32, 23, 14, 51, 42, 33,
        24, 15, 52, 43, 34, 25, 53, 44, 35, 54, 45, 55);
  }

  @Test
  public void getComponents_2_parts() {
    int[][] graph = new int[][]{
        {10, 11, 12, 13, 14, 15},
        {20, 21, 22, 23, 24, 25},
        {-1, -1, -1, 33, 34, 35},
        {40, 41, 42, -1, 44, 45},
        {50, 51, 52, -1, 54, 55}
    };

    List<List<int[]>> components = GraphRepresentedByArray2D.getComponents(graph);

    List<List<Integer>> values = components.stream().map(
        indexes -> GraphRepresentedByArray2D.toNodeValues(graph, indexes))
        .collect(Collectors.toList());

    assertThat(values).containsExactly(
        Arrays.asList(10, 20, 11, 21, 12, 22, 13, 23, 14, 33, 24, 15, 34, 25, 44, 35, 54, 45, 55),
        Arrays.asList(40, 50, 41, 51, 42, 52));
  }

  @Test
  public void getComponents_2_parts_zero_walls() {
    int[][] graph = new int[][]{
        {10, 11, 12, 13, 14, 15},
        {20, 21, 22, 23, 24, 25},
        {0, 0, 0, 33, 34, 35},
        {40, 41, 42, 0, 44, 45},
        {50, 51, 52, 0, 54, 55}
    };

    List<List<int[]>> components = GraphRepresentedByArray2D.getComponents(graph);

    List<List<Integer>> values = components.stream().map(
        indexes -> GraphRepresentedByArray2D.toNodeValues(graph, indexes))
        .collect(Collectors.toList());

    assertThat(values).containsExactly(
        Arrays.asList(10, 20, 11, 21, 12, 22, 13, 23, 14, 33, 24, 15, 34, 25, 44, 35, 54, 45, 55),
        Arrays.asList(40, 50, 41, 51, 42, 52));
  }

  @Test
  public void getComponents_5_parts() {
    int[][] graph = new int[][]{
        {10, 11, -1, 13, 14, 15},
        {20, 21, -1, 23, 24, 25},
        {-1, -1, -1, -1, -1, -1},
        {40, -1, 42, -1, 44, 45},
        {50, 51, -1, -1, 54, 55}
    };

    List<List<int[]>> components = GraphRepresentedByArray2D.getComponents(graph);

    List<List<Integer>> values = components.stream().map(
        indexes -> GraphRepresentedByArray2D.toNodeValues(graph, indexes))
        .collect(Collectors.toList());

    assertThat(values).containsExactly(
        Arrays.asList(10, 20, 11, 21),
        Arrays.asList(13, 23, 14, 24, 15, 25),
        Arrays.asList(40, 50, 51),
        Collections.singletonList(42),
        Arrays.asList(44, 54, 45, 55));
  }

  @Test
  public void getComponents_noComponents() {
    int[][] graph = new int[][]{
        {-1, -1, -1},
        {-1, -1, -1}
    };
    List<List<int[]>> components = GraphRepresentedByArray2D.getComponents(graph);
    assertThat(components).isEmpty();
  }

  @Test
  void dfs_simple() {
    int[][] graph = new int[][]{
        {10, 11, 12},
        {20, 21, 22},
        {30, 31, 32}
    };
    List<Integer> expectedDiscoveryList = new ArrayList<>();
    List<int[]> expectedTreeEdgeList = new ArrayList<>();
    List<int[]> expectedBackEdgeList = new ArrayList<>();

    Integer[][][] parent = GraphRepresentedByArray2D
        .dfs(graph, 0, 0, expectedDiscoveryList, expectedTreeEdgeList, expectedBackEdgeList);

    assertThat(expectedDiscoveryList).containsSequence(10, 20, 30, 31, 21, 11, 12, 22, 32);

    assertThat(expectedTreeEdgeList).hasSize(8);
    assertThat(expectedTreeEdgeList.get(0)).isEqualTo(new int[]{10, 20});
    assertThat(expectedTreeEdgeList.get(1)).isEqualTo(new int[]{20, 30});
    assertThat(expectedTreeEdgeList.get(2)).isEqualTo(new int[]{30, 31});
    assertThat(expectedTreeEdgeList.get(3)).isEqualTo(new int[]{31, 21});
    assertThat(expectedTreeEdgeList.get(4)).isEqualTo(new int[]{21, 11});
    assertThat(expectedTreeEdgeList.get(5)).isEqualTo(new int[]{11, 12});
    assertThat(expectedTreeEdgeList.get(6)).isEqualTo(new int[]{12, 22});
    assertThat(expectedTreeEdgeList.get(7)).isEqualTo(new int[]{22, 32});

    assertThat(expectedBackEdgeList).hasSize(4);
    assertThat(expectedBackEdgeList.get(0)).isEqualTo(new int[]{32, 31});
    assertThat(expectedBackEdgeList.get(1)).isEqualTo(new int[]{22, 21});
    assertThat(expectedBackEdgeList.get(2)).isEqualTo(new int[]{11, 10});
    assertThat(expectedBackEdgeList.get(3)).isEqualTo(new int[]{21, 20});

    assertThat(parent[0]).isEqualTo(
        new Integer[][]{
            {null, 1, 0},
            {0, 2, 0},
            {1, 2, 1}});
    assertThat(parent[1]).isEqualTo(
        new Integer[][]{
            {null, 1, 1},
            {0, 1, 2},
            {0, 0, 2}});
    assertThat(parent[2]).isEqualTo(
        new Integer[][]{
            {0, 5, 6},
            {1, 4, 7},
            {2, 3, 8}});
    assertThat(parent[3]).isEqualTo(
        new Integer[][]{
            {17, 12, 11},
            {16, 13, 10},
            {15, 14, 9}});
  }

  @Test
  void dfs_tree() {
    int[][] graph = new int[][]{
        {10, 11, 12},
        {20, -1, -1},
        {30, 31, 32}
    };
    List<Integer> expectedDiscoveryList = new ArrayList<>();
    List<int[]> expectedTreeEdgeList = new ArrayList<>();
    List<int[]> expectedBackEdgeList = new ArrayList<>();

    Integer[][][] parent = GraphRepresentedByArray2D
        .dfs(graph, 0, 0, expectedDiscoveryList, expectedTreeEdgeList, expectedBackEdgeList);

    assertThat(expectedDiscoveryList).containsSequence(10, 20, 30, 31, 32, 11, 12);

    assertThat(expectedTreeEdgeList).hasSize(6);
    assertThat(expectedTreeEdgeList.get(0)).isEqualTo(new int[]{10, 20});
    assertThat(expectedTreeEdgeList.get(1)).isEqualTo(new int[]{20, 30});
    assertThat(expectedTreeEdgeList.get(2)).isEqualTo(new int[]{30, 31});
    assertThat(expectedTreeEdgeList.get(3)).isEqualTo(new int[]{31, 32});
    assertThat(expectedTreeEdgeList.get(4)).isEqualTo(new int[]{10, 11});
    assertThat(expectedTreeEdgeList.get(5)).isEqualTo(new int[]{11, 12});

    assertThat(expectedBackEdgeList).isEmpty();

    assertThat(parent[0]).isEqualTo(
        new Integer[][]{
            {null, 0, 0},
            {0, null, null},
            {1, 2, 2}});
    assertThat(parent[1]).isEqualTo(
        new Integer[][]{
            {null, 0, 1},
            {0, null, null},
            {0, 0, 1}});
    assertThat(parent[2]).isEqualTo(
        new Integer[][]{
            {0, 9, 10},
            {1, null, null},
            {2, 3, 4}});
    assertThat(parent[3]).isEqualTo(
        new Integer[][]{
            {13, 12, 11},
            {8, null, null},
            {7, 6, 5}});
  }
}
