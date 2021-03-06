package main.java.leetcode.trees;

public class TreeNode {
  /** Class variables */
  public int val;

  TreeNode left;
  TreeNode right;

  /**
   * Constructor
   *
   * @param val
   */
  TreeNode(int val) {
    this.val = val;
  }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
}
