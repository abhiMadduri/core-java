package com.java.binarytree;

import java.util.Stack;

//each node is processed before either of its sub-trees.In simpler words,Visit each node before its children.
//Steps: Visit the node, Traverse the left subtree in PreOrder, Traverse the right subtree in PreOrder
//Implementation: Recursive and Iterative
public class PreOrderTraversal {

    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    // Recursive Solution
    public void preorder(TreeNode root) {
        if (root != null) {
            // Visit the node-Printing the node data
            System.out.printf("%d ", root.data);
            preorder(root.left);
            preorder(root.right);
        }
    }

    // Iterative solution
    public void preorderIter(TreeNode root) {

        if (root == null)
            return;

        Stack stack = new Stack();
        stack.push(root);

        while (!stack.empty()) {

            TreeNode n = (TreeNode) stack.pop();
            System.out.printf("%d ", n.data);

            if (n.right != null) {
                stack.push(n.right);
            }
            if (n.left != null) {
                stack.push(n.left);
            }

        }

    }

    public static void main(String[] args) {
        PreOrderTraversal bi = new PreOrderTraversal();
        // Creating a binary tree
        TreeNode rootNode = createBinaryTree();
        System.out.println("Using Recursive solution:");

        bi.preorder(rootNode);

        System.out.println();
        System.out.println("-------------------------");
        System.out.println("Using Iterative solution:");

        bi.preorderIter(rootNode);
    }

    public static TreeNode createBinaryTree() {

        TreeNode rootNode = new TreeNode(40);
        TreeNode node20 = new TreeNode(20);
        TreeNode node10 = new TreeNode(10);
        TreeNode node30 = new TreeNode(30);
        TreeNode node60 = new TreeNode(60);
        TreeNode node50 = new TreeNode(50);
        TreeNode node70 = new TreeNode(70);

        rootNode.left = node20;
        rootNode.right = node60;

        node20.left = node10;
        node20.right = node30;

        node60.left = node50;
        node60.right = node70;

        return rootNode;
    }

}
