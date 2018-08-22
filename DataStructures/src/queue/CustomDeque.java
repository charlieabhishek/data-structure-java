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

package queue;

//Double Ended queue in which insertion and deletion is possible from both ends...
public class CustomDeque {

	static DLLNode head;
	static DLLNode tail;

	static class DLLNode{
		DLLNode next;
		DLLNode prev; //Since deletion at end need access to tail.prev node to make it's next as null...
		int data;

		public DLLNode(int v){
			this.data = v;
		}
	}

	void addAtFirst(int data) {
		DLLNode node = new DLLNode(data);
		if(head == null) {
			head = node;
			tail = head;
		}else {
			head.prev = node;
			node.next = head;
			head = node;
		}
	}
	
	DLLNode removeFromFirst() {
		DLLNode node = head;
		if(node.next == null) {
			head = null;
			tail = null;
		}else {
			head = head.next;
			node.next.prev = null;
		}
		return node;
	}
	
	void addLast(int data) {
		DLLNode node = new DLLNode(data);
		if(head == null) {
			head = node;
			tail = node;
		}else {
			tail.next = node;
			node.prev = tail;
			tail = node;
		}
	}
	
	DLLNode removeFromLast() {
		DLLNode removedNode = tail;
		if(tail == null) {
			return null;
		}else {
			tail.prev.next = null;
			tail.prev = null;
			tail = null;
		}
		return removedNode;
	}
	
	void displayDeque(){
		DLLNode tempNode = head;
		while(tempNode != null) {
			System.out.print(tempNode.data+" ");
			tempNode = tempNode.next;
		}
	}

	public static void main(String[] args) {
		CustomDeque customDeque = new CustomDeque();
		customDeque.addAtFirst(5);
		customDeque.addAtFirst(15);
		customDeque.addAtFirst(25);
		customDeque.addAtFirst(35);
		
		customDeque.addLast(100);
		
		customDeque.removeFromFirst();
		customDeque.removeFromLast();
		
		customDeque.displayDeque();
	}

}
