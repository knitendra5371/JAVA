package binarySearchTree.easyProblems.BTtoBSTconversion;


import java.util.ArrayList;
import java.util.Collections;
/*
* Time Complexity: O(nlogn).
Auxiliary Space: O(n).
* */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class BTtoBSTExample1 {
    public static void main(String[] args) {
        // Example binary tree
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(30);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(5);

        // Convert binary tree to binary search tree
        TreeNode bst = convertToBST(root);

        System.out.println("Following is Inorder Traversal of the converted BST:");
        printInorder(bst);
    }

    // Inorder traversal to store the nodes in an ArrayList
    public static void inorder(TreeNode root, ArrayList<TreeNode> nodes) {
        if (root == null) {
            return;
        }
        inorder(root.left, nodes);
        nodes.add(root);
        inorder(root.right, nodes);
    }

    // Function to construct a binary search tree from a sorted ArrayList
    public static TreeNode constructBST(ArrayList<TreeNode> nodes, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = nodes.get(mid);
        root.left = constructBST(nodes, start, mid - 1);
        root.right = constructBST(nodes, mid + 1, end);
        return root;
    }

    // Function to convert a binary tree to a binary search tree
    public static TreeNode convertToBST(TreeNode root) {
        ArrayList<TreeNode> nodes = new ArrayList<>();
        inorder(root, nodes);
        Collections.sort(nodes, (a, b) -> a.val - b.val);
        return constructBST(nodes, 0, nodes.size() - 1);
    }

    // Function to print the inorder traversal of a binary tree
    public static void printInorder(TreeNode root) {
        if (root == null) {
            return;
        }
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }
}

