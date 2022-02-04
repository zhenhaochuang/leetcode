package com.zhenhc.leetcode.easy.sametree;

/**
 * Definition for a binary tree node.
 */
public class TreeNode {
    //定义三个树形，根节点，左节点，右节点
    int val;
    TreeNode left;
    TreeNode right;

    //定义三个构造函数，无参，一个参数，三个参数的构造函数
    TreeNode(){
    }
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val,TreeNode left,TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
