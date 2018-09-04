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

package AlgosMaths;

public class GCD {
	
	static int[] numbers = { 48, 24, 2, 8, 16};
	
	public static void main(String[] args) {
		System.out.println(findGCD());
	}

	private static int findGCD() {
		int result = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			result = gcd(result, numbers[i]);
		}
		return result;
	}

	private static int gcd(int a, int b) {
		if(b==0) {
			return a;
		}
		return gcd(b,a%b);
	}
	
}
