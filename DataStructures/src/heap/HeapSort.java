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

// Time Complexity - O(nlogn)
public class HeapSort {

	void swap(int arr[], int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
	
	void heapify(int arr[], int n, int i) {
		int l = 2*i+1;
		int r = 2*i+2;
		int largest = i;
	
		if(l<n && arr[largest]<arr[l]) {
			largest = l;
		}
		if(r<n && arr[largest]<arr[r]) {
			largest = r;
		}
	    if(largest != i) {
	        swap(arr, i, largest);
	        heapify(arr, n, largest);
	    }
	}
	
	void sort(int arr[]) {
		int n = arr.length;

		//Build heap...From Bottom to top call heapify to make heap.
		for (int i = n/2-1; i >= 0; i--) {
			heapify(arr, n, i);
		}

		for (int i = n-1; i >=0; i--) {
			//Move root to end as root is largest element.
			swap(arr, i, 0); 
			heapify(arr, i, 0); 
		}
	}
	
	void printArray(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {2,10,11,333,90,0,21,900};
		int n = arr.length;
		
		HeapSort hs = new HeapSort();
		hs.sort(arr);
		hs.printArray(arr);
	}
	
}
