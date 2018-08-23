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

package stackDS;

public class CustomStack {

	int stackArr[];
	int capacity;
	int top = -1;

	CustomStack(int size){
		this.capacity = size;
		stackArr = new int[size];
	}

	void push(int data) {
		if(top == capacity-1) {
			return;
		}
		stackArr[++top] = data;
	}

	int pop() {
		if(top == -1) {
			return -1;
		}
		return stackArr[top--];
	}
	
	void printStack() {
		int index = top;
		while(index >=0 ) {
			System.out.println(stackArr[index]);
			index--;
		}
	}

	public static void main(String[] args) {
		CustomStack cStack = new CustomStack(10);
		cStack.push(100);
		cStack.push(200);
		cStack.push(300);
		cStack.push(400);
		cStack.push(500);
		cStack.push(600);
		cStack.push(700);
		cStack.push(800);
		cStack.push(900);
		cStack.push(1000);
		cStack.printStack();
		System.out.println("popped item = "+cStack.pop());
		System.out.println("popped item = "+cStack.pop());	
		cStack.printStack();
	}
}
