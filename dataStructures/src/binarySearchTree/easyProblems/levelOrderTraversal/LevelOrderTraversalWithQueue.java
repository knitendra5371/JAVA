package binarySearchTree.easyProblems.levelOrderTraversal;

import java.util.*;


/*
Time Complexity: O(N) where N is the number of nodes in the binary tree.
Auxiliary Space: O(N) where N is the number of nodes in the binary tree.
* */

// Iterative Queue based Java program
// to do level order traversal
// of Binary Tree

// Class to print Level Order Traversal
class LevelOrderTraversalWithQueue {
    static class Node {
        int data;
        Node left, right;

        public Node(int item)
        {
            data = item;
            left = null;
            right = null;
        }
    }

    static Node root;

    // Given a binary tree. Print
    // its nodes in level order
    // using array for implementing queue
    static void printLevelOrder()
    {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {

            // poll() removes the present head.
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            // Enqueue left child
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            // Enqueue right child
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

    public static void main(String args[])
    {
        // Creating a binary tree and entering
        // the nodes
        LevelOrderTraversalWithQueue tree_level = new LevelOrderTraversalWithQueue();
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("Level order traversal of binary tree is - ");
        printLevelOrder();
    }
}

