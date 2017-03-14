package com.java.binarytree;

import java.util.Stack;

//each node is processed after subtrees traversal.In simpler words,Visit left subtree,  right subtree and then node.
//Steps: Traverse the left subtree in PostOrder, Traverse the right s/t, visit the node.
public class PostOrderTraversal {
    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    // Recursive Solution
    public void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            // Visit the node by Printing the node data
            System.out.printf("%d ", root.data);
        }
    }

    // Iterative solution
    public void postOrderIter(TreeNode root) {
        if (root == null)
            return;

        Stack s = new Stack();
        TreeNode current = root;

        while (true) {

            if (current != null) {
                if (current.right != null)
                    s.push(current.right);
                s.push(current);
                current = current.left;
                continue;
            }

            if (s.isEmpty())
                return;
            current = (TreeNode) s.pop();

            if (current.right != null && !s.isEmpty() && current.right == s.peek()) {
                s.pop();
                s.push(current);
                current = current.right;
            } else {
                System.out.print(current.data + " ");
                current = null;
            }
        }
    }

    public static void main(String[] args) {
        PostOrderTraversal bi = new PostOrderTraversal();
        // Creating a binary tree
        TreeNode rootNode = createBinaryTree();
        System.out.println("Using Recursive solution:");

        bi.postOrder(rootNode);

        System.out.println();
        System.out.println("-------------------------");
        System.out.println("Using Iterative solution:");

        bi.postOrderIter(rootNode);
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
