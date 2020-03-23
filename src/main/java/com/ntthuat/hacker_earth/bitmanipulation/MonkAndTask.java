/*Monk A loves to complete all his tasks just before the deadlines for introducing unwanted thrill in his life. But, there is another Monk D who hates this habit of Monk A and thinks it's risky.

To test Monk A, Monk D provided him tasks for N days in the form of an array Array, where the elements of the array represent the number of tasks.

The number of tasks performed by Monk A on the ith day is the number of ones in the binary representation of Arrayi.

Monk A is fed up of Monk D, so to irritate him even more, he decides to print the tasks provided in non-decreasing order of the tasks performed by him on each day. Help him out!

Input:
The first line of input contains an integer T, where T is the number of test cases.
The first line of each test case contains N, where N is the number of days.
The second line of each test case contains Array array having N elements, where Arrayi represents the number of tasks provided by Monk D to Monk A on ith day.

Output:
Print all the tasks provided to Monk A in the non-decreasing order of number of tasks performed by him.

Constraints:
1  T  100
1  N  105
1  Arrayi  1018

Note:
If two numbers have the same number of ones (set bits), print the one which came first in the input first, and then the other one, as in the input.*/

package com.ntthuat.hacker_earth.bitmanipulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MonkAndTask {
	
	public static long count_one (long n){
        long count = 0;
        while(n!=0)
        {
            n = n & (n-1);
            count++;
        }
        return count;
    }
	
	public static ArrayList<Long> stringToIntegerList(String line) {
		ArrayList<Long> arrayList = new ArrayList<>();
		Long integerM;

		while (line.length() != 0) {
			int indexString = line.indexOf(" ");
			if (indexString == -1) {
				arrayList.add(Long.parseLong(line));
				break;
			}
			String elementArray = line.substring(0, indexString);
			integerM = Long.parseLong(elementArray);
			arrayList.add(integerM);
			line = line.substring(indexString + 1, line.length());
		}

		return arrayList;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int T = Integer.parseInt(line);
		for (int i = 0; i < T; i++) {
			line = br.readLine();
			int N = Integer.parseInt(line);
			line = br.readLine();
			ArrayList<Long> arrayList;
			arrayList = stringToIntegerList(line);
			
			int counter, index;
			Long temp;
			int length = arrayList.size();

			for (counter = 0; counter < length - 1; counter++) {
				for (index = 0; index < length - 1 - counter; index++) {
					if (count_one(arrayList.get(index)) > count_one(arrayList.get(index + 1))) {
						temp = arrayList.get(index);
						arrayList.set(index, arrayList.get(index + 1));
						arrayList.set(index + 1, temp);
					}
				}
			}
			for (int j = 0; j < arrayList.size(); j++) {
				System.out.print(arrayList.get(j)+" ");
			}
			System.out.println();
		}	
	}
}
