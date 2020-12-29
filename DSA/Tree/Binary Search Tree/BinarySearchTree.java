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

	BinarySearchTree() {
		this.root = null;
	}

	void insert(Node root, int d) {

		if (root == null) {
			this.root = new Node(d);
		} else if (d < root.data) {
			if (root.left == null) {
				root.left = new Node(d);
			} else {
				insert(root.left, d);
			}
		} else if (d > root.data) {
			if (root.right == null) {
				root.right = new Node(d);
			} else {
				insert(root.right, d);
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

	int height(Node root) {
		if (root == null) {
			return 0;
		}
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

		bst.inOrder(bst.root);
		System.out.println();
		bst.preOrder(bst.root);
		System.out.println();
		bst.postOrder(bst.root);
		System.out.println("\nHright of BST = " + bst.height(bst.root));

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter delete node");
		int val = scan.nextInt();

//		bst.deleteNode(bst.root,val);

		bst.inOrder(bst.root);
		scan.close();

	}

}
