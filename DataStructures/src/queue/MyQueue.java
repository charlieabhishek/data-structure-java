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

//FIRST IN FIRST OUT Data Structure..
public class MyQueue {
	int qArray[];
	int capacity;
	int front = -1; // remove or deque from front....
	int rear = -1;  // insert or enque from rear end...

	public MyQueue(int size) {
		this.capacity = size;
		this.qArray = new int[size];
	}

	void enque(int data) {	
		if(rear == capacity-1) {
			return; // Queue is Full
		}
		if(front == rear && front == -1) {
			front++;
			rear++;
		}else {
			rear++;
		}
		qArray[rear]=data;
	}

	int deque() {
		if(isQEmpty()) {
			return -1; // queue is empty...
		}else {
			int element = qArray[front];
			front++;
			if(front>rear) {
				//This mean all elements are deleted...so, reset front and rear (inital case)...
				front = -1;
				rear = -1;
			}
			return element;
		}
	}

	boolean isQEmpty() {
		if(front == -1 || front > rear) {
			return true;
		}
		return false;
	}
	
	void displayQ() {
		for (int i = front; i <= rear; i++) {
			System.out.print(qArray[i]+" ");
		}
	}

	public static void main(String[] args) {
		MyQueue myQueue = new MyQueue(10);
		myQueue.enque(10);
		myQueue.enque(20);
		myQueue.enque(30);
		myQueue.enque(40);
		myQueue.enque(50);
		myQueue.displayQ();
		myQueue.deque();
		System.out.println();
		myQueue.displayQ();
		myQueue.deque();
		System.out.println();
		myQueue.displayQ();

	}
}
