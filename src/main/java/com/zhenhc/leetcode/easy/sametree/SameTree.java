package com.zhenhc.leetcode.easy.sametree;

import java.time.temporal.Temporal;
import java.util.LinkedList;
import java.util.Queue;

public class SameTree {

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1,new TreeNode(2),new TreeNode(3));
        TreeNode q = new TreeNode(1,new TreeNode(2),new TreeNode(3));
        System.out.println(isSameTree2(p,q));

        p = new TreeNode(1,new TreeNode(2),null);
        q = new TreeNode(1,null,new TreeNode(2));
        System.out.println(isSameTree2(p,q));

        p = new TreeNode(1,new TreeNode(2),new TreeNode(1));
        q = new TreeNode(1,new TreeNode(1),new TreeNode(2));
        System.out.println(isSameTree2(p,q));
    }

    /**
     * 方法一：深度优先搜索
     * @param p
     * @param q
     * @return
     */
    public static boolean isSameTree(TreeNode p,TreeNode q){
        if (p == null && q == null){
            return true;
        }else if (p == null || q == null){
            return false;
        }else if (p.val != q.val){
            return false;
        }else {
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
    }

    /**
     * 方法二：广度优先搜索
     */
    public static boolean isSameTree2(TreeNode p, TreeNode q){
        if(p == null && q ==null){
            return true;
        }else if (p == null || q == null){
            return false;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(p);
        queue2.offer(q);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if (node1.val != node2.val) {
                return false;
            }
            TreeNode left1 = node1.left, right1 = node1.right, left2 = node2.left, right2 = node2.right;
            if (left1 == null ^ left2 == null) {
                return false;
            }
            if (right1 == null ^ right2 == null) {
                return false;
            }
            if (left1 != null) {
                queue1.offer(left1);
            }
            if (right1 != null) {
                queue1.offer(right1);
            }
            if (left2 != null) {
                queue2.offer(left2);
            }
            if (right2 != null) {
                queue2.offer(right2);
            }
        }
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
