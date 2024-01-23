package binarySearchTree.easyProblems;


// Java program to check if two BSTs
// contain same set of elements
import java.util.*;
/*
* Time Complexity: O( n ).
Auxiliary Space: O( n ).
* */
class CheckTwoBSTsContainSameSetOfElements {

    // BST Node
    static class Node {
        int data;
        Node left;
        Node right;
    };

    // Utility function to create new Node
    static Node newNode(int val)
    {
        Node temp = new Node();
        temp.data = val;
        temp.left = temp.right = null;
        return temp;
    }

    // function to insert elements
    // of the tree to map m
    static void storeInorder(Node root, Vector<Integer> v)
    {
        if (root == null)
            return;
        storeInorder(root.left, v);
        v.add(root.data);
        storeInorder(root.right, v);
    }

    // function to check if the two BSTs
    // contain same set of elements
    static boolean checkBSTs(Node root1, Node root2)
    {
        // Base cases
        if (root1 == null && root2 == null)
            return true;
        if ((root1 == null && root2 != null)
                || (root1 != null && root2 == null))
            return false;

        // Create two vectors and store
        // inorder traversals of both BSTs
        // in them.
        Vector<Integer> v1 = new Vector<Integer>();
        Vector<Integer> v2 = new Vector<Integer>();
        storeInorder(root1, v1);
        storeInorder(root2, v2);

        // Return true if both vectors are
        // identical
        return (v1.hashCode() == v2.hashCode());
    }

    // Driver Code
    public static void main(String[] args)
    {
        // First BST
        Node root1 = newNode(15);
        root1.left = newNode(10);
        root1.right = newNode(20);
        root1.left.left = newNode(5);
        root1.left.right = newNode(12);
        root1.right.right = newNode(25);

        // Second BST
        Node root2 = newNode(15);
        root2.left = newNode(12);
        root2.right = newNode(20);
        root2.left.left = newNode(5);
        root2.left.left.right = newNode(10);
        root2.right.right = newNode(25);

        // check if two BSTs have same set of elements
        if (checkBSTs(root1, root2))
            System.out.print("YES");
        else
            System.out.print("NO");
    }
}

