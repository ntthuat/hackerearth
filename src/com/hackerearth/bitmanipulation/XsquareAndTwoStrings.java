/*Xsquare loves to play with strings a lot. Today, he has two strings S1 and S2 both consisting of lower case alphabets. Xsquare listed all subsequences of string S1 on a paper and all subsequences of string S2 on a separate paper. Xsquare wants to know whether there exists a string which is listed on both the papers.

Xsquare thinks that this task is pretty boring and handed it to you. Please accomplish this task on his behalf.

Input

First line of input contains a single integer T denoting the number of test cases. Each test case consists of two lines. First line of each test case contains a string denoting string S1. Next line of each test case contains a string denoting string S2.

Output

For each test case, Print Yes if both papers contain a common string otherwise Print No.

Constraints

1 <= T <= 105

1 <= |S1| <= 105

1 <= |S2| <= 105

Sum of |S1| over all test case does not exceed 5*105

Sum of |S2| over all test case does not exceed 5*105

Subtasks

Subtask1 : sum of |S1|,|S2| over all test cases does not exceed 103 (25 pts)
Subtask2 : sum of |S1|,|S2| over all test cases does not exceed 104 (25 pts)
Subtask3 : sum of |S1|,|S2| over all test cases does not exceed 5*105 (50 pts)*/

package com.hackerearth.bitmanipulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class XsquareAndTwoStrings {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int T = Integer.parseInt(line);
		for (int i = 0; i < T; i++) {
			String string1 = br.readLine();
			String string2 = br.readLine();
			boolean bool = false;
			
			ArrayList<String> arrayList1 = new ArrayList<>();
			while (string1.length()!=0) {
				String stringCk = string1.substring(0, 1);
				char charCk = stringCk.charAt(0);
				int checkChar = string2.indexOf(charCk);
				if (checkChar!=-1) {
					bool = true;
					break;
				}
				string1 = string1.replace(stringCk,"");
			}
			if (bool) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
		System.out.println("Hello World");
	}
}
