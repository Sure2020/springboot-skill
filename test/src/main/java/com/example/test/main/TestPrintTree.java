/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestPrintTree
 * Date Created : 2024-02-03
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-03       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.test.main;

/**
 * @program: com.example.test.main
 * @description: xxx
 * @author: w15021
 * @create: 2024-02-03
 **/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class TestPrintTree {
    public static void printTree(TreeNode root) {
        printTree(root, 0);
    }

    private static void printTree(TreeNode node, int level) {
        if (node == null)
            return;

        printTree(node.right, level + 1);
        if (level != 0) {
            for (int i = 0; i < level - 1; i++)
                System.out.print("|\t");
            System.out.println("|-------" + node.val);
        } else {
            System.out.println(node.val);
        }
        printTree(node.left, level + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        printTree(root);
    }
}
