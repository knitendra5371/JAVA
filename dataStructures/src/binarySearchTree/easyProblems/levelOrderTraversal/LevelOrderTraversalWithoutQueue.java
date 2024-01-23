package binarySearchTree.easyProblems.levelOrderTraversal;


  /*      Time Complexity: O(N2), where N is the number of nodes in the skewed tree.
        Auxiliary Space: O(1) If the recursion stack is considered the space used is O(N).*/

// Recursive Java program for level
// order traversal of Binary Tree

// Class containing left and right child of current
// node and key value
class Node {
    int data;
    Node left, right;
    public Node(int item)
    {
        data = item;
        left = right = null;
    }
}

class LevelOrderTraversalWithoutQueue {

    // Root of the Binary Tree
    Node root;
    public LevelOrderTraversalWithoutQueue() { root = null; }

    // Function to print level order traversal of tree
    void printLevelOrder()
    {
        int h = height(root);

        for (int i = 1; i <= h; i++)
            printCurrentLevel(root, i);
    }

    // Compute the "height" of a tree -- the number of
    // nodes along the longest path from the root node
    // down to the farthest leaf node.
    int height(Node root)
    {
        if (root == null)
            return 0;
        return 1 + Math.max(height(root.left),height(root.right));
    }

    // Print nodes at the current level
    void printCurrentLevel(Node root, int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1) {
            printCurrentLevel(root.left, level - 1);
            printCurrentLevel(root.right, level - 1);
        }
    }

    // Driver program to test above functions
    public static void main(String args[])
    {
        LevelOrderTraversalWithoutQueue tree = new LevelOrderTraversalWithoutQueue();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Level order traversal of " + "binary tree is => ");
        tree.printLevelOrder();
    }
}

