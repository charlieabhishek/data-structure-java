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

package LinkListDS;

public class CustomLinkList<T> {
	
	Node<T> head;
	
	static class Node<T>{
		T data;
		Node<T> next;
		
		public Node(T val){
			this.data = val;
		}
	}
	
	/*
	 * Function to add Node in front of linkedList..
	 * Time Complexity:O(1).
	 */
	
	void addNode(Node<T> node){
		if(head==null) {
			head = node;
		}else {
			//add node in front...
			node.next = head;
			head = node;
		
			//Append nodes at last (T = O(n))
			/*Node tempNode = head;
			while(tempNode.next != null) {
  				 tempNode = tempNode.next;
			}
			tempNode.next = node;
			*/
		}
	}
	
	/*
	 * Function for searchig a node in Linked List
	 * Time Complexity : O(n) where n - size of Linked List.
	 */
	Node<T> searchNode(T val) {
		Node<T> tempNode = head;
		while(tempNode != null) {
			if(tempNode.data == val) {
				break;
			}
			tempNode = tempNode.next;
		}
		return tempNode;
	}
	
	/*
	 * Deleting node with value val from Linked List.
	 * Time Complexity : O(n) where n - size of Linked List.
	 * return true if node is delted.
	 */
	
	boolean deleteNode(T val) {
		if(head==null) {
			return false;
		}else {
			Node<T> tempNode = head;
			Node<T> prevNode = head;
			boolean isFound = false;
			while(tempNode != null) {
				if(tempNode.data == val) {
					isFound = true;
					break;
				}
				prevNode = tempNode;
				tempNode = tempNode.next;
			}
			if(isFound) {
				prevNode.next = tempNode.next;
				return true;
			}
		}
		return false;
	}
	
	void printLinkList() {
		Node<T> tempNode = head;
		while(tempNode != null) {
			System.out.print(tempNode.data+"-->");
			tempNode = tempNode.next;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("------Integer type Linked List--------");
		testIntegerLinkedList();
		
		System.out.println("------String type Linked List--------");
		CustomLinkList<String> sCustomLL = new CustomLinkList<String>();
		System.out.println();
		printStringLL(sCustomLL);
	}

	private static void printStringLL(CustomLinkList<String> sCustomLL) {
		sCustomLL.addNode(new Node<String>("Romeo"));
		sCustomLL.addNode(new Node<String>("Tommy"));
		sCustomLL.addNode(new Node<String>("Johnny"));
		sCustomLL.addNode(new Node<String>("Abhishek"));
		sCustomLL.addNode(new Node<String>("Kumar"));
		sCustomLL.addNode(new Node<String>("Danny"));
		sCustomLL.printLinkList();
		sCustomLL.deleteNode("Johnny");
		System.out.println();
		sCustomLL.printLinkList();
	}

	private static CustomLinkList<Integer> testIntegerLinkedList() {
		CustomLinkList<Integer> customLL = new CustomLinkList<Integer>();
		customLL.addNode(new Node<Integer>(10));
		customLL.addNode(new Node<Integer>(12));
		customLL.addNode(new Node<Integer>(2));
		customLL.addNode(new Node<Integer>(112));
		customLL.addNode(new Node<Integer>(1222));
		customLL.printLinkList();
		customLL.deleteNode(2);
		System.out.println();
		customLL.printLinkList();
		return customLL;
	}
}
