package com.ntthuat.hacker_earth.bitmanipulation;

/*You are given an array A1,A2...AN. You have to tell how many pairs (i, j)
exist such that 1 <= i < j <= N and Ai XOR Aj is odd.

Input and Output 
First line T, the number of testcases. Each testcase: first line N, followed
by N integers in next line. For each testcase, print the required answer in
one line.

Constraints 
1 <= T <= 10 
1 <= N <= 105 
0 <= Ai <= 109*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SherlockAndXOR {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int T = Integer.parseInt(line);
		
		/*Scanner inFile = new Scanner(new FileReader("D:\\test.txt"));
		String line;
		line = inFile.nextLine();
		int T = Integer.parseInt(line);*/
		
		for (int i = 0; i < T; i++) {
			line = br.readLine();
			int N = Integer.parseInt(line);
			/*line = inFile.nextLine();
			int N = Integer.parseInt(line);*/
			line = br.readLine();
			/*line = inFile.nextLine();*/
			int integerM;
			long count = 0;
			int even = 0;
			String subLine;
			for (int j = 0; j < line.length(); j++) {
				subLine = line.substring(j, j + 1);
				if (subLine.equals(" ")) {
					subLine = line.substring(j - 1, j);
					integerM = Integer.parseInt(subLine);
					if (integerM % 2 == 0) {
						even++;
					}
				}
			}

			subLine = line.substring(line.length() - 1, line.length());
			integerM = Integer.parseInt(subLine);
			if (integerM % 2 == 0) {
				even++;
			}
			count = (long)even * (N - even);
			/*System.out.println(N);
			System.out.println(even);
			System.out.println(N-even);*/
			System.out.println(count);
		}
	}

}
