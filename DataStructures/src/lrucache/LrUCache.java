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


package lrucache;
import java.util.*;
/*
 * Problem statement: Find the number of page faults using least recently used (LRU) page 
 * replacement algorithm with 3 page frames.
 */
public class LrUCache {

	static final int CACHE_SIZE = 3; //MAX SIZe of CACHE...

	static Deque<Page> deque = new LinkedList<Page>();
	static HashMap<Integer, Page> hashMap = new HashMap<Integer, Page>();
	static int hitCount = 0;
	static int pageFaults = 0;

	static class Page{
		int pageNo;	
		public Page(int val) {
			this.pageNo = val;
		}
	}

	public static void main(String[] args) {
		//Input: 1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5
		int pages[] = {1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5};
		for (int i = 0; i < pages.length; i++) {
			storePage(pages[i]);
		}
		System.out.println("Hit Count = "+hitCount);
		System.out.println("Page Faults = "+pageFaults);
	}

	private static void storePage(Integer pNo) {
		//checking in HashMap if this pageNo is present or not. 
		if(hashMap.containsKey(pNo)) {
			//Hit case
			//Remove it and put it in front of deque.
			Page hitPage= (Page)hashMap.get(pNo);
			deque.remove(hitPage);
			deque.addFirst(hitPage);
			hitCount++;
		}else {
			Page page = new Page(pNo);

			if(deque.size() == CACHE_SIZE) {
				// Page Fault case...
				// Removing last element and insert new element to front of queue.
				Page removedPage = deque.removeLast();
				hashMap.remove(removedPage.pageNo);
				deque.addFirst(page);
			}else {
				deque.addFirst(page);
			}
			pageFaults++;
			hashMap.put(pNo, page);
		}
	}

}
