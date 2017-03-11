package com.cmy.line.test;

import java.util.ArrayList;

public class BinaryTreeTool {
	public static ArrayList<BinaryTree> listOnDepth = new ArrayList<BinaryTree>(); // list to save nodes in one depth
	public static int searchDepth = 6; //search depth

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

	public static void main(String[] str) {
		int[] array = { 1, 2, 3, 4, 12, 76, 35, 22, 16, 48, 90, 46, 9, 40 };
		BinaryTree root = new BinaryTree(array[0]); // create tree
		for (int i = 1; i < array.length; i++) {
			root.insert(root, array[i]); // insert node
		}

		inOrderfOnDepth(root, 0);
		System.out.println();
		for (BinaryTree node : listOnDepth) {
			System.out.print(node.data + "--");
		}
	}
}
