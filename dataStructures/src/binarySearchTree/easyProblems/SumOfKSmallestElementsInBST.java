package binarySearchTree.easyProblems;


// Java program to find Sum Of All Elements smaller
// than or equal to Kth Smallest Element In BST
/*
* Time complexity: O(k)
Auxiliary Space: O(h), where h is the height of the tree
* */
import java.util.*;
class SumOfKSmallestElementsInBST
{

    /* Binary tree Node */
    static class Node
    {
        int data;
        Node left, right;
    };

    // utility function new Node of BST
    static Node createNode(int data)
    {
        Node new_Node = new Node();
        new_Node.left = null;
        new_Node.right = null;
        new_Node.data = data;
        return new_Node;
    }

    // A utility function to insert a new Node
// with given key in BST and also maintain lcount ,Sum
    static Node insert(Node root, int key)
    {

        // If the tree is empty, return a new Node
        if (root == null)
            return createNode(key);

        // Otherwise, recur down the tree
        if (root.data > key)
            root.left = insert(root.left, key);
        else if (root.data < key)
            root.right = insert(root.right, key);

        // return the (unchanged) Node pointer
        return root;
    }


    static int count = 0;

    // function return sum of all element smaller than
// and equal to Kth smallest element
    static int ksmallestElementSumRec(Node root, int k)
    {

        // Base cases
        if (root == null)
            return 0;
        if (count > k)
            return 0;

        // Compute sum of elements in left subtree
        int res = ksmallestElementSumRec(root.left, k);
        if (count >= k)
            return res;

        // Add root's data
        res += root.data;

        // Add current Node
        count++;
        if (count >= k)
            return res;

        // If count is less than k, return right subtree Nodes
        return res + ksmallestElementSumRec(root.right, k);
    }

    // Wrapper over ksmallestElementSumRec()
    static int ksmallestElementSum(Node root, int k)
    {

        int res = ksmallestElementSumRec(root, k);
        return res;
    }

    /* Driver program to test above functions */
    public static void main(String[] args)
    {

	/* 20
		/ \
	8	 22
	/ \
	4	 12
		/ \
		10 14
		*/
        Node root = null;
        root = insert(root, 20);
        root = insert(root, 8);
        root = insert(root, 4);
        root = insert(root, 12);
        root = insert(root, 10);
        root = insert(root, 14);
        root = insert(root, 22);

        int k = 3;
        int count = ksmallestElementSum(root, k);
        System.out.println(count);
    }
}

