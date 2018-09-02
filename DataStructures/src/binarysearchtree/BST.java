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


package binarysearchtree;

public class BST {
	
	Node root;
	
	class Node{
		Node left;
		Node right;
		int key;
		
		public Node(int data) {
			this.key = data;
		}
	}
	
	void insert(int key) {
		Node newNode = new Node(key);
		root = insertRecur(root, newNode);
	}

	private Node insertRecur(Node root, Node newNode) {
		if(root==null) {
			root = newNode;
			return root;
		}
		
		if(newNode.key < root.key) {
			root.left = insertRecur(root.left, newNode);
		}else {
			root.right = insertRecur(root.right, newNode);
		}
		return root;
	}
	
	void delete(int key) {
		root = deleteRecur(root,key);
	}
	
	private Node deleteRecur(Node root,int key) {
		if(root == null) {
			return root;
		}
		if(key < root.key) {
			root.left = deleteRecur(root.left, key);
		}else if(key > root.key) {
			root.right = deleteRecur(root.right, key);
		}else {
			//find the element...Now 3 cases can be there....
			/*1. node to be deleted is leaf node.
			 *2. node to be deleted has 1 child
			 *3. node to be deleted has 2 children.*/
			if(root.left == null) {
				return root.right;
			}
			if(root.right == null) {
				return root.left;
			}
			// 2 child case...
			root.key = minValueInRightSubtree(root.right);
			root.right = deleteRecur(root.right, root.key);
		}
		return root;
	}

	private int minValueInRightSubtree(Node node) {
		Node tempNode = node;
		while(tempNode.left != null) {
			tempNode = tempNode.left;
		}
		return tempNode.key;
	}

	void inorderTraversal(Node root) {
		if(root != null) {
			inorderTraversal(root.left);
			System.out.print(root.key+" ");
			inorderTraversal(root.right);
		}
	}
	void preOrderTraversal(Node root) {
		if(root != null) {
			System.out.print(root.key+" ");
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
		}
	}
	void postOrderTraversal(Node root) {
		if(root != null) {
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			System.out.print(root.key+" ");
		}
	}
	
	public static void main(String[] args) {
		BST bst = new BST();
        bst.insert(10);
		bst.insert(20);
		bst.insert(30);
		bst.insert(50);
		bst.insert(5);
		bst.insert(11);
		bst.insert(1);
		bst.insert(190);
		bst.inorderTraversal(bst.root);
		System.out.println();
		bst.delete(10);
		bst.inorderTraversal(bst.root);
		System.out.println();
		bst.delete(190);
		bst.inorderTraversal(bst.root);
	}

}
