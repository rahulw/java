package main.java.leetcode.PriorityQueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KthGreatestElementsInAMaxHeap {

  private int getLeftChildIndex(int index) {
    return index * 2 + 1;
  }

  private int getRightChildIndex(int index) {
    return index * 2 + 2;
  }

  private class Node {
    public int index;
    public int num;

    Node(int index, int num) {
      this.index = index;
      this.num = num;
    }
  }

  private class NodeComparator implements Comparator<Node> {
    @Override
    public int compare(Node n1, Node n2) {
      return Integer.compare(n2.num, n1.num);
    }
  }

  public List<Integer> kLargestInImmutableHeap(int[] immutableHeap, int k) {
    if (k <= 0) {
      return new ArrayList<Integer>();
    }
    int initialCapacity = k + 1;
    List<Integer> kthLargest = new ArrayList<>();
    PriorityQueue<Node> queue = new PriorityQueue<>(initialCapacity, new NodeComparator());
    queue.add(new Node(0, immutableHeap[0]));
    for (int i = 0; i < k; i++) {
      Node currentNode = queue.poll();
      kthLargest.add(currentNode.num);
      int leftChildIndex = getLeftChildIndex(currentNode.index);
      if (leftChildIndex < immutableHeap.length) {
        queue.add(new Node(leftChildIndex, immutableHeap[leftChildIndex]));
      }
      int rightChildIndex = getRightChildIndex(currentNode.index);
      if (rightChildIndex < immutableHeap.length) {
        queue.add(new Node(rightChildIndex, immutableHeap[rightChildIndex]));
      }
    }
    return kthLargest;
  }
}
