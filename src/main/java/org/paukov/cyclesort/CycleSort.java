package org.paukov.cyclesort;

import java.util.ArrayList;
import java.util.List;

// https://corte.si/posts/code/cyclesort/index.html
public class CycleSort {

  // Sorts the 0-based array with unique sequence numbers 0..n-1 in O(n).
  public static void sort(int[] arr){
    int index = 0;
    while(index < arr.length){
      if (arr[index]==index){
        index++;
        continue;
      }
      swap(arr, index, arr[index]);
    }
  }

  // Returns the cycles in the 0-based arrays.
  public static List<List<Integer>> findCycles(int[] arr){
    int index = 0;

    List<List<Integer>> cycles = new ArrayList<>();
    cycles.add(new ArrayList<>());

    boolean[] visited = new boolean[arr.length];

    while(index < arr.length){
      if (arr[index]==index){
        if (!visited[index]){
          cycles.get(cycles.size()-1).add(index);
          cycles.add(new ArrayList<>()); // start of the new cycle
        }
        visited[index]=true;
        index++;
        continue;
      }
      visited[arr[index]]=true;
      cycles.get(cycles.size()-1).add(arr[index]);
      swap(arr, index, arr[index]);
    }

    return cycles;
  }

  private static void swap(int[] arr, int left, int right){
    int tmp = arr[left];
    arr[left] = arr[right];
    arr[right] = tmp;
  }
}
