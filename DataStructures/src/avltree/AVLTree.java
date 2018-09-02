/*
 * Copyright 2018 Abhishek Kumar 
 * 
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at
   http://www.apache.org/licenses/LICENSE-2.0
   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License
 */

package avltree;

public class AVLTree {

	Node root;
	
	static class Node{
		Node left;
		Node right;
		int key;
		int height;
		public Node(int data) {
			this.key = data;
		}
	}
	
	int height(Node node) {
		if(node == null) {
			return 0;
		}
		return node.height;
	}
	
	int balancedFactor(Node node) {
		if(root == null) {
			return 0;
		}
		return height(node.left) - height(node.right);
	}
	
	int max(int x, int y) {
	  return x>y ? x:y;
	}
	
	Node rotateRight(Node y){
		Node x = y.left;
		Node T2 = x.right;
		y.left = T2;
		x.right = y;
		
		x.height = 1 + max(height(x.left), height(x.right));
		y.height = 1 + max(height(y.left), height(y.right));
		
		return x;
	}
	
	Node rotateLeft(Node y) {
		Node x = y.right;
		Node T2 = x.left;
		y.right = T2;
		x.left = y;
		
		x.height = 1 + max(height(x.left), height(x.right));
		y.height = 1 + max(height(y.left), height(y.right));
		return x;
	}
	
	Node insert(Node node, Node root) {
		//Normal BST insertion....
		if(root == null) {
			return node;
		}
		if(node.key < root.key) {
			root.left = insert(node, root.left);
		}else if(node.key > root.key) {
			root.right = insert(node, root.right);
		}else {
			return root;
		}
		//Update height of root node..(root here is the parent of new node)
		root.height = 1 + max(height(root.left), height(root.right));
		//check balance factor...
		int balance = balancedFactor(root);
		
		//Left-Left case
		if(balance > 1 && node.key < root.left.key) {
			return rotateRight(root);
		}
		//Left-Right case
		if(balance > 1 && node.key > root.right.key) {
			root.left = rotateLeft(root.left);
			return rotateRight(root);
		}
		//Right-Right case
		if(balance < -1 && node.key > root.right.key) {
			return rotateRight(root);
		}
		//Right-Left case
		if(balance < -1 && node.key < root.right.key) {
			root.right = rotateRight(root.right);
			return rotateLeft(root);
		}
		return root;
	}
	
	void inorderTraversal(Node root) {
		if(root != null) {
			inorderTraversal(root.left);
			System.out.print(root.key+" ");
			inorderTraversal(root.right);
		}
	}
	
	Node delete(int key, Node root) {
		//Delete normal BST
		if(root == null) {
			return root;
		}
		if(key < root.key) {
			root.left = delete(key, root.left);
		}else if(key > root.key) {
			root.right = delete(key, root.right);
		}else {
			//Case 1 and Case 2 - root is leaf or root has 1 child...
			if(root.left == null) {
				return root.right;
			}
			if(root.right == null) {
				root = root.left;
			}
			//Case 3 - 2 child case 
			//Get inorder successor in right subtree...
			int minValue = getMinValue(root.right);
			root.key = minValue;
			root.right = delete(minValue, root.right);
		}
		//Update height
		root.height = 1 + max(height(root.left), height(root.right));
		int balance = balancedFactor(root);
		// Left-Left case
		if(balance > 1 && balancedFactor(root.left) >= 0) {
			return rotateRight(root);
		}
		// Left-Right case
		if(balance > 1 && balancedFactor(root.left) < 0) {
			root.left = rotateLeft(root.left);
			return rotateRight(root);
		}
		// Right-Right case
		if(balance < -1 && balancedFactor(root.right) <= 0) {
			return rotateLeft(root);
		}
		//Right-Left case
		if(balance < -1 && balancedFactor(root.right) > 0) {
			root.right = rotateLeft(root.right);
			return rotateLeft(root);
		}
		return root;
	}
	
	private int getMinValue(Node right) {
		Node temp = right;
		while(temp.left != null) {
			temp = temp.left;
		}
		return temp.key;
	}

	public static void main(String[] args) {
		AVLTree avlTree = new AVLTree();
		avlTree.root = avlTree.insert(new Node(10), avlTree.root);
		avlTree.root = avlTree.insert(new Node(12), avlTree.root);
		avlTree.root = avlTree.insert(new Node(1), avlTree.root);
		avlTree.root = avlTree.insert(new Node(2), avlTree.root);
		avlTree.root = avlTree.insert(new Node(100), avlTree.root);
		avlTree.root = avlTree.insert(new Node(120), avlTree.root);
		avlTree.root = avlTree.insert(new Node(50), avlTree.root);
		avlTree.root = avlTree.insert(new Node(62), avlTree.root);	
		
		
		avlTree.inorderTraversal(avlTree.root);
		avlTree.root = avlTree.delete(100, avlTree.root);
		System.out.println();
		avlTree.inorderTraversal(avlTree.root);
		avlTree.root = avlTree.delete(1, avlTree.root);
		System.out.println();
		avlTree.inorderTraversal(avlTree.root);
		avlTree.root = avlTree.delete(50, avlTree.root);
		System.out.println();
		avlTree.inorderTraversal(avlTree.root);
		
	}
}
