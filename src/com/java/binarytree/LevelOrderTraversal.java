package com.java.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.java.binarytree.InOrderTraversal.TreeNode;

/*
 * Create empty queue and pust root node to it.
    Do the following when queue is not empty
        Pop a node from queue and print it
        Push left child of popped node to queue if not null
        Push right child of popped node to queue if not null
 */
public class LevelOrderTraversal {

    // prints in level order
    public static void levelOrderTraversal(TreeNode startNode) {
        Queue queue = new LinkedList();
        queue.add(startNode);
        while (!queue.isEmpty()) {
            TreeNode tempNode = (TreeNode) queue.poll();
            System.out.printf("%d ", tempNode.data);
            if (tempNode.left != null)
                queue.add(tempNode.left);
            if (tempNode.right != null)
                queue.add(tempNode.right);
        }
    }

    /**
     * Steps:
     * Create empty queue and push root node to it.
        Do the following when queue is not empty
          Pop a node from queue and print it
          Push right child of popped node to queue if not null
          Push left child of popped node to queue if not null
          Push current node to stack
          Pop node from stack and print it
     * @param startNode
     */
    // prints in reverse level order
    public static void reverseLevelOrderTraversal(TreeNode startNode) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        queue.add(startNode);
        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            if (tempNode.right != null)
                queue.add(tempNode.right);
            if (tempNode.left != null)
                queue.add(tempNode.left);

            stack.push(tempNode);
        }

        while (!stack.empty())
            System.out.print(stack.pop().data + " ");
    }
}
