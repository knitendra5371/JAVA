package binarySearchTree.easyProblems;


// Java implementation to check if given Binary tree
// is a BST or not

/* Class containing left and right child of current
node and key value*/

/*
* Time Complexity: O(N), Where N is the number of nodes in the tree
Auxiliary Space: O(1), if Function Call Stack size is not considered, otherwise O(H) where H is the height of the tree
* */


public class CheckBTisBSTorNot {

    static class Node {
        int data;
        Node left, right;

        public Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
    // Root of the Binary Tree
    Node root;

	/* Can give min and max value according to your code or
	can write a function to find min and max value of tree.
*/

    /* Returns true if given search tree is binary
    search tree (efficient version) */
    boolean isBST()
    {
        return isBSTUtil(root, Integer.MIN_VALUE,
                Integer.MAX_VALUE);
    }

    /* Returns true if the given tree is a BST and its
    values are >= min and <= max. */
    boolean isBSTUtil(Node node, int min, int max)
    {
        /* an empty tree is BST */
        if (node == null)
            return true;

        /* false if this node violates the min/max
         * constraints */
        if (node.data < min || node.data > max)
            return false;

		/* otherwise check the subtrees recursively
		tightening the min/max constraints */
        // Allow only distinct values
        return (
                isBSTUtil(node.left, min, node.data - 1)
                        && isBSTUtil(node.right, node.data + 1, max));
    }

    /* Driver code */
    public static void main(String args[])
    {
        CheckBTisBSTorNot tree = new CheckBTisBSTorNot();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);

        // Function call
        if (tree.isBST())
            System.out.println("Is BST");
        else
            System.out.println("Not a BST");
    }
}

