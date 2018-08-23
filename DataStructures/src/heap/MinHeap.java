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

package heap;

/*
 * Heap is data structure which stores data with below rules...
 * - For MinHeap, Parent will be smallest and For MaxHeap Parent will be largest.
 * - SubHeap of a node is also a heap.
 * - Left chld value can be larger than Right child value.
 */

public class MinHeap {
	
	int heapArr[];
	int capacity;
	int heap_size;
	
	public MinHeap(int size) {
		this.capacity = size;
		this.heapArr = new int[size];
	}
	
	int parent(int i) {
		return (i-1)/2;
	}
	
	int left(int i) {
		return (2*i+1);
	}
	
	int right(int i) {
		return (2*i + 2);
	}
	
	void swap(int x, int y) {
		int temp   = heapArr[x];
		heapArr[x] = heapArr[y];
		heapArr[y] = temp;
	}
	
	/*
	 * Time Complexity: O(log n) 
	 */
	void insert(int key) {
		if(heap_size == capacity-1) {
			return;
		}
		//add new data in heap.
		heap_size++;
		int i = heap_size-1;
		heapArr[i] = key;
		//From bottom up check if parent is smaaller or not
		//and swap until heap property is not staisfied...
		while(i!=0 && heapArr[parent(i)] > heapArr[i]) {
			swap(i, parent(i));
			i = parent(i);
		}
	}
	
	/*
	 * Time Complexity: O(log n) 
	 */
	void decreaseKey(int i, int newKey) {
		if(heapArr[i] <= newKey) {
			return;
		}
		heapArr[i] = newKey;
		while(i!=0 && heapArr[parent(i)]>heapArr[i]) {
			swap(parent(i), i);
			i = parent(i);
		}
	}
	
	/*
	 * From top to bottom recursively satisfying checking heap property.
	 */
	void heapify(int i) {
		int l = left(i);
		int r = right(i);
		int smallest = i;
		if(l<heap_size && heapArr[l] < heapArr[smallest]) {
			smallest = l;
		}
		if(r<heap_size && heapArr[r] < heapArr[smallest]) {
			smallest = r;
		}
		if(i != smallest) {
			swap(i, smallest);
			heapify(smallest);
		}
	}
	
	/*
	 * Delete minimum element in heap...
	 * Time Complexity: O(log n) 
	 */
	int extractMin() {
		int minKey = heapArr[0];
		heapArr[0] = heapArr[heap_size-1];
		heap_size--;
		heapify(0);
		return minKey;
	}
	
	void delete(int i) {
		decreaseKey(i, Integer.MIN_VALUE);
		extractMin();
	}
  
	public static void main(String[] args) {
		MinHeap minHeap = new MinHeap(8);
		minHeap.insert(100);
		minHeap.insert(65);
		minHeap.insert(40);
		minHeap.insert(50);
		minHeap.insert(10);
		minHeap.insert(20);
		minHeap.insert(80);
		minHeap.insert(110);
		
		System.out.println(minHeap.extractMin());
		System.out.println(minHeap.extractMin());
		System.out.println(minHeap.extractMin());
	}
}
