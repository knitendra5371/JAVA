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

	Node root;
	static int maxLevel;

	BinarySearchTree() {
		//this.root = null;
	}

	void insert(Node current, int data) {
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

	void inOrder(Node root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}
	}

	void preOrder(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	void postOrder(Node root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data + " ");
		}
	}

	void levelOrderTraversalUtil(Node root,int currLevel){
		if(root==null) return;
		if(currLevel == maxLevel){
			System.out.print(root.data+" ");
		}
		levelOrderTraversalUtil(root.left,currLevel+1);
		levelOrderTraversalUtil(root.right,currLevel+1);
		maxLevel++;

	}
	void levelOrderTraversal(Node root){
		int level=0;
		maxLevel=1;
		levelOrderTraversalUtil(root,level);
	}

	int height(Node root) {
		if (root == null) return 0;

		return 1 + Math.max(height(root.left), height(root.right));
	}

	void deleteNode(Node root, int data) {
		Node deletePointer = root;

		while (deletePointer != null) {

			if (deletePointer.data == data) {
				break;
			} else if (data < deletePointer.data) {
				deletePointer = deletePointer.left;
			} else {
				deletePointer = deletePointer.right;
			}

		}
		if (deletePointer == null) {
			System.out.println("key not found in BinarySearch Tree");
			return;
		} else {

		}

	}

	public static void main(String[] args) {

		BinarySearchTree bst = new BinarySearchTree();

		bst.insert(bst.root, 15);
		bst.insert(bst.root, 12);
		bst.insert(bst.root, 18);
		bst.insert(bst.root, 11);
		bst.insert(bst.root, 14);
		bst.insert(bst.root, 13);
		bst.insert(bst.root, 16);
		bst.insert(bst.root, 17);
		bst.insert(bst.root, 20);
		bst.insert(bst.root, 23);
		bst.insert(bst.root, 22);

		bst.inOrder(bst.root); // inorder traversal
		System.out.println();
		bst.preOrder(bst.root); // preorder traversal
		System.out.println();
		bst.postOrder(bst.root); // postorder traversal
		int height= bst.height(bst.root); // compute height of BST
		System.out.println("\nHright of BST = " + height);

		bst.levelOrderTraversal(bst.root);

		//Scanner scan = new Scanner(System.in);
		//System.out.println("Enter delete node");
		//int val = scan.nextInt();

//		bst.deleteNode(bst.root,val);

		bst.inOrder(bst.root);
		//scan.close();

	}

}
