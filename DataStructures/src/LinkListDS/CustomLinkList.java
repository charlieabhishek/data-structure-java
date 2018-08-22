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

public class CustomLinkList {
	
	Node head;
	
	static class Node{
		int data;
		Node next;
		
		public Node(int val){
			this.data = val;
		}
	}
	
	/*
	 * Function to add Node in front of linkedList..
	 * Time Complexity:O(1).
	 */
	
	void addNode(Node node){
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
	Node searchNode(int val) {
		Node tempNode = head;
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
	
	boolean deleteNode(int val) {
		if(head==null) {
			return false;
		}else {
			Node tempNode = head;
			Node prevNode = head;
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
		Node tempNode = head;
		while(tempNode != null) {
			System.out.print(tempNode.data+"-->");
			tempNode = tempNode.next;
		}
	}
	
	public static void main(String[] args) {
		CustomLinkList customLL = new CustomLinkList();
		customLL.addNode(new Node(10));
		customLL.addNode(new Node(12));
		customLL.addNode(new Node(2));
		customLL.addNode(new Node(112));
		customLL.addNode(new Node(1222));
		customLL.printLinkList();
		customLL.deleteNode(2);
		System.out.println();
		customLL.printLinkList();
	}
}
