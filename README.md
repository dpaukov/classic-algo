[![Build Status](https://secure.travis-ci.org/dpaukov/classic-algo.svg)](http://travis-ci.org/dpaukov/classic-algo)
[![Coverage Status](https://coveralls.io/repos/github/dpaukov/classic-algo/badge.svg?branch=master)](https://coveralls.io/github/dpaukov/classic-algo?branch=master)

# classic-algo
A collection of the classic algorithms and data structures implemented on java

- [Binary Search Algorithm](https://github.com/dpaukov/classic-algo/blob/master/src/main/java/org/paukov/search/BinarySearch.java#L13)
and [tests](https://github.com/dpaukov/classic-algo/blob/master/src/test/java/org/paukov/search/BinarySearchTest.java).  
- [Binary Search Tree (BST)](https://github.com/dpaukov/classic-algo/blob/master/src/main/java/org/paukov/tree/BinarySearchTree.java#L6).
- Binary tree traversals: 
  - Recursive
    - [inorder](https://github.com/dpaukov/classic-algo/blob/master/src/main/java/org/paukov/tree/BinaryTreeTraversal.java#L12)
    - [preorder](https://github.com/dpaukov/classic-algo/blob/master/src/main/java/org/paukov/tree/BinaryTreeTraversal.java#L21)
    - [postorder](https://github.com/dpaukov/classic-algo/blob/master/src/main/java/org/paukov/tree/BinaryTreeTraversal.java#L30)
  - Iterative
    - [inorder](https://github.com/dpaukov/classic-algo/blob/master/src/main/java/org/paukov/tree/BinaryTreeTraversal.java#L60)
    - [preorder](https://github.com/dpaukov/classic-algo/blob/master/src/main/java/org/paukov/tree/BinaryTreeTraversal.java#L75)
    - postorder
      - [2 stacks](https://github.com/dpaukov/classic-algo/blob/master/src/main/java/org/paukov/tree/BinaryTreeTraversal.java#L93)
      - [1 stack](https://github.com/dpaukov/classic-algo/blob/master/src/main/java/org/paukov/tree/BinaryTreeTraversal.java#L116)
    - [bfs using queue](https://github.com/dpaukov/classic-algo/blob/master/src/main/java/org/paukov/tree/BinaryTreeTraversal.java#L41)
             
- [Binary Indexed Tree (BIT, Fenwick Tree)](https://github.com/dpaukov/classic-algo/blob/master/src/main/java/org/paukov/tree/BinaryIndexedTreeFenwick.java#L16) for calculating prefix/range cumulative operations in 
  O(logn) time complexity.

- Graph represented by a 2d array: BFS & DFS.

- Max-Heap. 

- Segment Tree (updating and querying the data in log(n) time).

- Trie (Prefix Tree) with the insert, search, and startsWith methods.

- Backtracking (for generating subsets, permutations, solving sudoku, etc.).
