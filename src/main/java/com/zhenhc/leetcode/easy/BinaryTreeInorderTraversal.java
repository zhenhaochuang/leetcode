package com.zhenhc.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历
 * root = [1,null,2,3]
 * root = [1,null,2]
 */
public class BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        BinaryTreeInorderTraversal inorderTraversal = new BinaryTreeInorderTraversal();
        TreeNode root = new TreeNode(1,null,new TreeNode(2,new TreeNode(3),null));
        System.out.println(inorderTraversal.inorderTraversal(root));
        TreeNode root2 = new TreeNode(1,null,new TreeNode(2));
        System.out.println(inorderTraversal.inorderTraversal(root2));
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

}

/**
 * 构造一个二叉树节点
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}