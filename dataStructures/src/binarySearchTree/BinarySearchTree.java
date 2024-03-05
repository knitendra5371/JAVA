package binarySearchTree;

import java.util.*;
import java.io.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BinarySearchTree {

    public static class Sum {
        int sum;

        Sum(int sum) {
            this.sum = sum;
        }
    }

    static Node root;
    static int maxLevel;

    static {
        root = null;
        maxLevel = 0;
    }

    BinarySearchTree() {
//		root = null;
    }

    static void insert(Node current, int data) {
        if (current == null) {
            root = new Node(data);
        } else if (data < current.data) {
            if (current.left == null) {
                current.left = new Node(data);
            } else {
                insert(current.left, data);
            }
        } else if (data > current.data) {
            if (current.right == null) {
                current.right = new Node(data);
            } else {
                insert(current.right, data);
            }
        }
    }

    static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    static void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    static void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    static void printLevelOrderUtil(Node root, int currLevel) {
        if (currLevel < 1 || root == null) return;

        if (currLevel == 1) System.out.print(" " + root.data);

        printLevelOrderUtil(root.left, currLevel - 1);
        printLevelOrderUtil(root.right, currLevel - 1);
    }

    // This is the naive way to print level order BST. It's more time compare to non-Recursive way
    // Time Complexity: O(N) , Auxiliary Space: O(1)
    static void printLevelOrder(Node root) {
        int height = height(root);
        for (int level = 1; level <= height; level++)
            printLevelOrderUtil(root, level);
    }

    // This is the best way to print level order BST. It's take less time compare to Recursive way
    // Time Complexity: O(N) , Auxiliary Space: O(N)
    static void levelOrderTraversal_nrec(Node root) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node curr = queue.remove();
            System.out.print(" " + curr.data);
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }

    }

    static void leftViewWithMapUtil(Node root, int currLevel, Map<Integer, Node> lnMap) {
        if (root == null) return;
        if (!lnMap.containsKey(currLevel)) lnMap.put(currLevel, root);
        leftViewWithMapUtil(root.left, currLevel + 1, lnMap);
        leftViewWithMapUtil(root.right, currLevel + 1, lnMap);
    }

    // Here we are using extra space like: Map , We can do this with constant space also.
    static void leftViewWithMap(Node root) {
        Map<Integer, Node> levelNodeMap = new TreeMap<>();
        int currLevel = 1;
        leftViewWithMapUtil(root, currLevel, levelNodeMap);
        levelNodeMap.forEach((key, node) -> System.out.print(" " + node.data));
    }

    static void leftView(Node root, int currLevel) {
        if (root == null) return;
        if (currLevel > maxLevel) {
            System.out.print(" " + root.data);
            maxLevel++;
        }

        leftView(root.left, currLevel + 1);
        leftView(root.right, currLevel + 1);
    }

    static void rightView(Node root, int currLevel) {
        if (root == null) return;
        if (currLevel > maxLevel) {
            System.out.print(" " + root.data);
            maxLevel++;
        }
        rightView(root.right, currLevel + 1);
        rightView(root.left, currLevel + 1);
    }

    static void topViewWithMapUtil(Node root, int hd, Map<Integer, Integer> map) {
        if (root == null) return;
        if (!map.containsKey(hd)) map.put(hd, root.data);

        topViewWithMapUtil(root.left, hd - 1, map);
        topViewWithMapUtil(root.right, hd + 1, map);

    }

    static void topViewWithMap(Node root) {
        int hd = 0;
        Map<Integer, Integer> map = new TreeMap<>();
        topViewWithMapUtil(root, hd, map);

        map.forEach((key, value) -> System.out.print(" " + value));
    }

    static void bottomViewWithMapUtil(Node root, int hd, Map<Integer, Integer> map) {
        if (root == null) return;
        map.put(hd, root.data);
        bottomViewWithMapUtil(root.left, hd - 1, map);
        bottomViewWithMapUtil(root.right, hd + 1, map);
    }

    static void bottomViewWithMap(Node root) {
        int hd = 0;
        Map<Integer, Integer> map = new TreeMap<>();
        bottomViewWithMapUtil(root, hd, map);
        map.forEach((key, value) -> System.out.print(" " + value));
    }

    static void leftNodes(Node root, List<Integer> ans) {
        if (root == null) return;

        if (root.left != null) {
            ans.add(root.data);
            leftNodes(root.left, ans);
        } else if (root.right != null) {
            ans.add(root.data);
            leftNodes(root.right, ans);
        }
    }

    static void leafNodes(Node root, List<Integer> ans) {

        if (root == null) return;

        if (root.left == null && root.right == null) ans.add(root.data);

        leafNodes(root.left, ans);
        leafNodes(root.right, ans);

    }

    static void rightNodes(Node root, List<Integer> ans) {
        if (root == null) return;

        if (root.right != null) {
            rightNodes(root.right, ans);
            ans.add(root.data);
        } else if (root.left != null) {
            rightNodes(root.left, ans);
            ans.add(root.data);
        }

    }

    static void boundaryNodes(Node root) {
        if (root == null) return;
        List<Integer> ans = new ArrayList<>();
        ans.add(root.data);

        leftNodes(root.left, ans);
        leafNodes(root, ans);
        rightNodes(root.right, ans);

        ans.forEach(node -> System.out.print(" " + node));
    }

    static void leftDiagonalTraversalUtil(Node root, int currDiagonal, Map<Integer, List<Integer>> map) {
        if (root == null) return;

        if (map.containsKey(currDiagonal)) {
            map.get(currDiagonal).add(root.data);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(root.data);
            map.put(currDiagonal, list);
        }
        leftDiagonalTraversalUtil(root.left, currDiagonal, map);
        leftDiagonalTraversalUtil(root.right, currDiagonal + 1, map);
    }

    static void leftDiagonalTraversal(Node root) {
        Map<Integer, List<Integer>> diagNodesMap = new TreeMap<>();
        leftDiagonalTraversalUtil(root, 0, diagNodesMap);

        diagNodesMap.forEach((key, value) -> {
            System.out.print("Diagonal : " + key + " => ");
            value.forEach(ele -> System.out.print(" " + ele));
            System.out.println();
        });
    }

    static void rightDiagonalTraversalUtil(Node root, int currDiagonal, Map<Integer, List<Integer>> map) {
        if (root == null) return;

        if (map.containsKey(currDiagonal)) {
            map.get(currDiagonal).add(root.data);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(root.data);
            map.put(currDiagonal, list);
        }
        rightDiagonalTraversalUtil(root.left, currDiagonal + 1, map);
        rightDiagonalTraversalUtil(root.right, currDiagonal, map);
    }


    static void rightDiagonalTraversal(Node root) {
        Map<Integer, List<Integer>> diagNodesMap = new TreeMap<>();
        rightDiagonalTraversalUtil(root, 0, diagNodesMap);

        diagNodesMap.forEach((key, value) -> {
            System.out.print("Diagonal : " + key + " => ");
            value.forEach(ele -> System.out.print(" " + ele));
            System.out.println();
        });
    }

    static void verticalTraversalUtil(Node root, int hd, Map<Integer, List<Integer>> map) {
        if (root == null) return;

        if (map.containsKey(hd)) {
            map.get(hd).add(root.data);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(root.data);
            map.put(hd, list);
        }
        verticalTraversalUtil(root.left, hd - 1, map);
        verticalTraversalUtil(root.right, hd + 1, map);

    }

    static void verticalTraversal(Node root) {
        if (root == null) return;
        Map<Integer, List<Integer>> hdNodesMap = new TreeMap<>();
        verticalTraversalUtil(root, 0, hdNodesMap);

        hdNodesMap.forEach((key, value) -> {
            System.out.print("HD : " + key + " => ");
            value.forEach(ele -> System.out.print(" " + ele));
            System.out.println();
        });
    }

    static void zigZagTraversal(Node root) {
        Stack<Node> oddLevelStack = new Stack<>();
        Stack<Node> evenLevelStack = new Stack<>();

        oddLevelStack.push(root);

        while (!oddLevelStack.isEmpty()) {

            while (!oddLevelStack.isEmpty()) {
                Node currNode = oddLevelStack.pop();
                System.out.print(" " + currNode.data);
                if (currNode.right != null) evenLevelStack.push(currNode.right);
                if (currNode.left != null) evenLevelStack.push(currNode.left);
            }

            while (!evenLevelStack.isEmpty()) {
                Node currNode = evenLevelStack.pop();
                System.out.print(" " + currNode.data);

                if (currNode.left != null) oddLevelStack.push(currNode.left);
                if (currNode.right != null) oddLevelStack.push(currNode.right);

            }
        }

    }

    static void minValue(Node root) {
        if (root == null) return;

        if (root.left == null) System.out.print(" " + root.data);
        minValue(root.left);
    }

    static void maxValue(Node root) {
        if (root == null) return;
        if (root.right == null) System.out.print(" " + root.data);

        maxValue(root.right);
    }

    static void addAllGreaterValuesToEveryNode(Node root, Sum sm) {
        if (root == null) return;
        addAllGreaterValuesToEveryNode(root.right, sm);
        sm.sum += root.data;
        root.data = sm.sum;
        addAllGreaterValuesToEveryNode(root.left, sm);

    }

    static void addAllSmallerValuesToEveryNode(Node root, Sum sm) {
        if (root == null) return;
        addAllSmallerValuesToEveryNode(root.left, sm);
        sm.sum += root.data;
        root.data = sm.sum;
        addAllSmallerValuesToEveryNode(root.right, sm);
    }

    static int height(Node root) {
        if (root == null) return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }

    static void deleteNode_nrec(Node root, int data) {
        Node delNode = root, parNode = null, succ, parSucc, child = null;

        while (delNode != null) {
            if (delNode.data == data) break;
            parNode = delNode;
            if (data < delNode.data) delNode = delNode.left;
            else delNode = delNode.right;
        }

        if (delNode == null) {
            System.out.println("key not found in BinarySearch Tree");
        } else {
            if (delNode.left != null && delNode.right != null) {
                parSucc = delNode;
                succ = delNode.right;
                while (succ.left != null) {
                    parSucc = succ;
                    succ = succ.left;
                }
                delNode.data = succ.data;
                delNode = succ;
                parNode = parSucc;
            }
            if (delNode.left != null) {
                child = delNode.left;
            } else if (delNode.right != null) {
                child = delNode.right;
            }

            if (parNode == null)
                root = child;
            else if (delNode == parNode.left) {
                parNode.left = child;
            } else {
                parNode.right = child;
            }
        }

    }

    static Node deleteNode(Node root, int dkey) {
        if (root == null) return null;

        Node delNode, succ;

        if (dkey < root.data) root.left = deleteNode(root.left, dkey);
        else if (dkey > root.data) root.right = deleteNode(root.right, dkey);
        else {
//            delNode = root;

            if (root.left != null && root.right != null) {
                succ = root.right;
                while (succ.left != null) succ = succ.left;

                root.data = succ.data;
                root.right = deleteNode(root.right, succ.data);
            }else{

                if(root.left!=null) root = root.left;
                else if(root.right!=null) root = root.right;
                else root =null;
            }
        }
        return root;
    }

    static void constructBST() {
        int[] data = new int[]{15, 12, 18, 11, 14, 13, 16, 17, 20, 23, 22};
        for (int key : data) {
            insert(root, key);
        }
    }

    public static void main(String[] args) {

        constructBST();

        System.out.print("Inorder Traversal => ");
        inOrder(root); // inorder traversal

        System.out.print("\nPreorder Traversal => ");
        preOrder(root); // preorder traversal

        System.out.print("\nPostorder Traversal => ");
        postOrder(root); // postorder traversal

        System.out.println("\nHeight of BST = " + height(root)); // compute height of BST

        System.out.print("\nLevel Order Traversal with Recursive way => ");
        printLevelOrder(root);

        System.out.print("\nLevel Order Traversal with non Recursive way => ");
        levelOrderTraversal_nrec(root);
        System.out.print("\nLeft view of BST with map or extra space => ");
        leftViewWithMap(root);

        System.out.print("\nLeft view of BST with constant space => ");
        maxLevel = 0;
        int currLevel = 1;
        leftView(root, currLevel);

        System.out.print("\nRight view of BST with constant space => ");
        maxLevel = 0;
        rightView(root, currLevel);

        System.out.print("\nTop view of BST with map=> ");
        topViewWithMap(root);

        System.out.print("\nBottom view of BST with map => ");
        bottomViewWithMap(root);

        System.out.print("\nboundary nodes of BT => ");
        boundaryNodes(root);

        System.out.print("\nLeft diagonal traversal of BT => ");
        leftDiagonalTraversal(root);

        System.out.print("\n\nRight diagonal traversal of BT => ");
        rightDiagonalTraversal(root);

        System.out.print("\n\nVertical traversal of BT => ");
        verticalTraversal(root);

        System.out.print("\n\nZigZag traversal of BT => ");
        zigZagTraversal(root);

        System.out.print("\nMin value of BT => ");
        minValue(root);

        System.out.print("\nMax value of BT => ");
        maxValue(root);

        System.out.print("\nAdd All Greater Values To EveryNode In BST => ");
        Sum sm = new Sum(0);
        addAllGreaterValuesToEveryNode(root, sm);
        inOrder(root);
        root = null;
        constructBST();

        System.out.print("\nAdd All Smaller Values To EveryNode In BST => ");
        sm.sum = 0;
        addAllSmallerValuesToEveryNode(root, sm);
        inOrder(root);
        root = null;
        constructBST();

        System.out.print("\nDeleted Given node from BST with non-recursive way => ");
        deleteNode_nrec(root, 16);
        inOrder(root);
        constructBST();

        System.out.print("\nDeleted Given node from BST with recursive way => ");
        deleteNode(root, 16);
        inOrder(root);
        constructBST();

    }

}
