package testing;


// Java program to demonstrate searching operation
// in binary search tree without recursion
import java.util.*;

class Test2 {

    static class Node {
        int data;
        Node left, right;
    };

    // Function to check the given key exist or not
    static boolean iterativeSearch(Node root, int key)
    {
        // Traverse until root reaches to dead end
        while (root != null) {
            // pass right subtree as new tree
            if (key > root.data)
                root = root.right;

                // pass left subtree as new tree
            else if (key < root.data)
                root = root.left;
            else
                return true; // if the key is found return 1
        }
        return false;
    }

    // A utility function to create a new BST Node
    static Node newNode(int item)
    {
        Node temp = new Node();
        temp.data = item;
        temp.left = temp.right = null;
        return temp;
    }

    /* A utility function to insert a new Node with
given key in BST */
    static Node insert(Node node, int data)
    {
        /* If the tree is empty, return a new Node */
        if (node == null)
            return newNode(data);

        /* Otherwise, recur down the tree */
        if (data < node.data)
            node.left=insert(node.left, data);
        else if (data > node.data)
            node.right=insert(node.right, data);

        /* return the (unchanged) Node pointer */
        System.out.println(" => "+node.data);
        return node;
    }
    static void inorder(Node node){
        if(node!=null){
            inorder(node.left);
            System.out.print(node.data+" ");
            inorder(node.right);
        }
    }
    // Driver code
//    static Node root;
    public static void main(String args[])
    {
		/* Let us create following BST
			50
			/ \
		30 70
		/ \ / \
	20 40 60 80 */
        Node root = null;
        root= insert(root, 50);
        insert(root, 30);
        insert(root, 20);
        insert(root, 40);
        insert(root, 70);
        insert(root, 60);
        insert(root, 80);

        inorder(root);
        System.out.println();

        if (iterativeSearch(root, 15))
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}


