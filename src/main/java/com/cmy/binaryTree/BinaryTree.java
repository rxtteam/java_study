package com.cmy.binaryTree;

public class BinaryTree {

    public int data; // root
    public BinaryTree left; // left
    public BinaryTree right; // right

    public BinaryTree(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public void insert(BinaryTree root, int data) {
        if (data > root.data) {
            if (root.right == null) {
                root.right = new BinaryTree(data);
            } else {
                this.insert(root.right, data);
            }
        } else {
            if (root.left == null) {
                root.left = new BinaryTree(data);
            } else {
                this.insert(root.left, data);
            }
        }
    }
}