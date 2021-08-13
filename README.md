[![Build Status](https://secure.travis-ci.org/dpaukov/classic-algo.svg)](http://travis-ci.org/dpaukov/classic-algo)
[![Coverage Status](https://coveralls.io/repos/github/dpaukov/classic-algo/badge.svg?branch=master)](https://coveralls.io/github/dpaukov/classic-algo?branch=master)

# classic-algo
A collection of the classic algorithms and data structures implemented on java

- Binary Search Algorithm, [tests](https://github.com/dpaukov/classic-algo/blob/master/src/test/java/org/paukov/search/BinarySearchTest.java).
  - [exactIndex](https://github.com/dpaukov/classic-algo/blob/master/src/main/java/org/paukov/search/BinarySearch.java#L13), 
    the first occurrence of a target in an array, if it is present. If the target is not present, 
    it returns the position where the value can be inserted.
  - [indexRightMost](https://github.com/dpaukov/classic-algo/blob/master/src/main/java/org/paukov/search/BinarySearch.java#L29),
    the last occurrence of a target (right most index) in an array, if it is present. If the target 
    is not present, it returns the previous position where the value should be inserted.
  - [indexIfFound](https://github.com/dpaukov/classic-algo/blob/master/src/main/java/org/paukov/search/BinarySearch.java#L45),
    the first occurrence of the target (left most index) in the array, if it is present. 
    If the target is not present, it returns -1;
    
- [Binary Search Tree (BST)](https://github.com/dpaukov/classic-algo/blob/master/src/main/java/org/paukov/tree/BinarySearchTree.java#L6).

- Binary tree traversals: 
  - Recursive
    - [inorder](https://github.com/dpaukov/classic-algo/blob/master/src/main/java/org/paukov/tree/BinaryTreeTraversal.java#L12)
    - [preorder](https://github.com/dpaukov/classic-algo/blob/master/src/main/java/org/paukov/tree/BinaryTreeTraversal.java#L21)
    - [postorder](https://github.com/dpaukov/classic-algo/blob/master/src/main/java/org/paukov/tree/BinaryTreeTraversal.java#L30)
  - Iterative
    - [inorder](https://github.com/dpaukov/classic-algo/blob/master/src/main/java/org/paukov/tree/BinaryTreeTraversal.java#L85)
    - [preorder](https://github.com/dpaukov/classic-algo/blob/master/src/main/java/org/paukov/tree/BinaryTreeTraversal.java#L100)
    - postorder
      - [2 stacks](https://github.com/dpaukov/classic-algo/blob/master/src/main/java/org/paukov/tree/BinaryTreeTraversal.java#L118)
      - [1 stack](https://github.com/dpaukov/classic-algo/blob/master/src/main/java/org/paukov/tree/BinaryTreeTraversal.java#L141)
    - [bfs using queue](https://github.com/dpaukov/classic-algo/blob/master/src/main/java/org/paukov/tree/BinaryTreeTraversal.java#L41)
    - [bfs by levels using queue](https://github.com/dpaukov/classic-algo/blob/master/src/main/java/org/paukov/tree/BinaryTreeTraversal.java#L61)         
- [Binary Indexed Tree (BIT, Fenwick Tree)](https://github.com/dpaukov/classic-algo/blob/master/src/main/java/org/paukov/tree/BinaryIndexedTreeFenwick.java#L16) for calculating prefix/range cumulative operations in 
  O(logn) time complexity ([tests](https://github.com/dpaukov/classic-algo/blob/master/src/test/java/org/paukov/tree/BinaryIndexedTreeFenwickTest.java#L10)).

- Graph represented by a 2d array ([tests](https://github.com/dpaukov/classic-algo/blob/master/src/test/java/org/paukov/graph/GraphRepresentedByArray2DTest.java#L12)):
  - [Iterative BFS](https://github.com/dpaukov/classic-algo/blob/master/src/main/java/org/paukov/graph/GraphRepresentedByArray2D.java#L20) 
    that returns a parent array for finding paths from any node to the starting point (root).
  - [Getting path to a root](https://github.com/dpaukov/classic-algo/blob/master/src/main/java/org/paukov/graph/GraphRepresentedByArray2D.java#L112)
  - [Shortest path](https://github.com/dpaukov/classic-algo/blob/master/src/main/java/org/paukov/graph/GraphRepresentedByArray2D.java#L133)
  - [Connected components](https://github.com/dpaukov/classic-algo/blob/master/src/main/java/org/paukov/graph/GraphRepresentedByArray2D.java#L151)
  - [Recursive DFS](https://github.com/dpaukov/classic-algo/blob/master/src/main/java/org/paukov/graph/GraphRepresentedByArray2D.java#L199)

- [Max-Heap](https://github.com/dpaukov/classic-algo/blob/master/src/main/java/org/paukov/heap/SimpleMaxHeap.java#L5). 

- Partitioning:
  - [QuickSelect](https://github.com/dpaukov/classic-algo/blob/master/src/main/java/org/paukov/partition/QuickSelect.java#L13) 
    is a selection algorithm to find the kth smallest element in an unordered list. It is related to the quicksort sorting algorithm.
  - [QuickSort](https://github.com/dpaukov/classic-algo/blob/master/src/main/java/org/paukov/partition/QuickSort.java#L18)
  - [Three Way Partitioning](https://github.com/dpaukov/classic-algo/blob/master/src/main/java/org/paukov/partition/ThreeWayPartitioning.java#L9)
    (Dutch national flag problem).

- [Segment Tree](https://github.com/dpaukov/classic-algo/blob/master/src/main/java/org/paukov/tree/SegmentTree.java#L14) 
(updating and querying the data in log(n) time, [tests](https://github.com/dpaukov/classic-algo/blob/master/src/test/java/org/paukov/tree/SegmentTreeTest.java)):
  - [build](https://github.com/dpaukov/classic-algo/blob/master/src/main/java/org/paukov/tree/SegmentTree.java#L114)
  - [query](https://github.com/dpaukov/classic-algo/blob/master/src/main/java/org/paukov/tree/SegmentTree.java#L131)
  - [update](https://github.com/dpaukov/classic-algo/blob/master/src/main/java/org/paukov/tree/SegmentTree.java#L148)
  - [query range](https://github.com/dpaukov/classic-algo/blob/master/src/main/java/org/paukov/tree/SegmentTree.java#L110)

- [Trie (Prefix Tree)](https://github.com/dpaukov/classic-algo/blob/master/src/main/java/org/paukov/trie/Trie.java) 
  with the insert, search, and startsWith methods, [tests](https://github.com/dpaukov/classic-algo/blob/master/src/test/java/org/paukov/trie/TrieTest.java).

- [Backtracking](https://github.com/dpaukov/classic-algo/blob/master/src/main/java/org/paukov/backtracking/Backtracking.java#L24) 
  (for generating subsets, [permutations](https://github.com/dpaukov/classic-algo/blob/master/src/main/java/org/paukov/backtracking/AllPermutations.java), 
  [solving sudoku](https://github.com/dpaukov/classic-algo/blob/master/src/main/java/org/paukov/backtracking/Sudoku.java), etc.).

- [CycleSort](https://github.com/dpaukov/classic-algo/blob/master/src/main/java/org/paukov/cyclesort/CycleSort.java#L10) 
  and searching all cycles (groups) in a permutation [findCycles](https://github.com/dpaukov/classic-algo/blob/master/src/main/java/org/paukov/cyclesort/CycleSort.java#L22)
  and [tests](https://github.com/dpaukov/classic-algo/blob/master/src/test/java/org/paukov/cyclesort/CycleSortTest.java#L12)
