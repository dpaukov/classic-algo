package org.paukov.heap;

import java.util.ArrayList;

public class SimpleMaxHeap {

  final ArrayList<Integer> array = new ArrayList<>();

  public Integer getParentNodeIndex(Integer nodeIndex) {
    if (nodeIndex > 0) {
      return (nodeIndex - 1) / 2;
    } else {
      return null;
    }
  }

  public Integer getLastElementIndex() {
    if (array.size() > 0) {
      return array.size() - 1;
    } else {
      return 0;
    }
  }

  public Integer getNodeValue(Integer elementIndex) {
    if (elementIndex >= 0 && elementIndex <= getLastElementIndex()) {
      return array.get(elementIndex);
    } else {
      return null;
    }
  }

  public void setNodeValue(Integer elementIndex, Integer value) {
    if (elementIndex >= 0 && elementIndex <= getLastElementIndex()) {
      array.set(elementIndex, value);
    }
  }


  public void add(Integer value) {
    array.add(value);
    Integer currentNodeIndex = getLastElementIndex();
    Integer parentNodeIndex = getParentNodeIndex(currentNodeIndex);
    Integer parentValue = null;
    if (parentNodeIndex != null) {
      parentValue = getNodeValue(parentNodeIndex);
    }
    while (parentNodeIndex != null && parentValue < getNodeValue(currentNodeIndex)) {
      swap(parentNodeIndex, currentNodeIndex);
      currentNodeIndex = parentNodeIndex;
      parentNodeIndex = getParentNodeIndex(currentNodeIndex);
      if (parentNodeIndex != null) {
        parentValue = getNodeValue(parentNodeIndex);
      }
    }

  }

  void swap(Integer index1, Integer index2) {
    Integer value1 = getNodeValue(index1);
    Integer value2 = getNodeValue(index2);

    setNodeValue(index1, value2);
    setNodeValue(index2, value1);
  }
}
