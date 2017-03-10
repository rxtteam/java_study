package com.cmy.binaryTree;

import java.util.ArrayList;

public class BinaryTreeTool {
    public static ArrayList<BinaryTree> listOnDepth = new ArrayList<BinaryTree>();
    public static int searchDepth = 6;

    public static void preOrder(BinaryTree root) { // 先根遍历
        if (root != null) {
            System.out.print(root.data + "-");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void inOrder(BinaryTree root) { // 中根遍历

        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + "--");
            inOrder(root.right);
        }
    }

    public static void inOrderfOnDepth(BinaryTree node, int depth) {
        if (node != null) {
            inOrderfOnDepth(node.left, depth + 1);
            System.out.print(node.data + "--");
            if (depth == searchDepth) {
                listOnDepth.add(node);
            }
            inOrderfOnDepth(node.right, depth + 1);
        }
    }

    public static void postOrder(BinaryTree root) { // 后根遍历

        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + "---");
        }
    }

    public static void main(String[] str) {
        int[] array = { 1, 2, 3, 4, 12, 76, 35, 22, 16, 48, 90, 46, 9, 40 };
        BinaryTree root = new BinaryTree(array[0]); // 创建二叉树
        for (int i = 1; i < array.length; i++) {
            root.insert(root, array[i]); // 向二叉树中插入数据
        }
        // System.out.println("先根遍历：");
        // preOrder(root);
        // System.out.println();
        // System.out.println("中根遍历：");
        // inOrder(root);
        // System.out.println();
        // System.out.println("后根遍历：");
        // postOrder(root);
        inOrder(root);
        System.out.println();
        inOrderfOnDepth(root, 0);
        System.out.println();
        for (BinaryTree node : listOnDepth) {
            System.out.print(node.data + "--");
        }
    }
}
