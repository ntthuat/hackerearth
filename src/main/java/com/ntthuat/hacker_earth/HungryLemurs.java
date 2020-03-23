/*
There are K lemurs on Madagascar and Kevin has N bananas. He has to give
away all his bananas to lemurs. Lemurs are happy if all of them get the same
number of bananas (even if they don't get any). In one minute Kevin can do
one of the following:

Find one banana.
Discard one banana (eat).
Increase a population of lemurs on Madagascar by one.
If there are at least two lemurs remove one of them from Madagascar (don't
ask how).
Help Kevin and find the minimum number of minutes Kevin needs to satisfy all
the lemurs.

Input format:

The only line of the input contains two space-separated integers N and K.

Output format:

Output the single integer -- the minimum number of minutes.

Constraints:

1 <= K,N <= 105
K, N <= 50 in test data worth 33% of all points
 */
package com.ntthuat.hacker_earth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class HungryLemurs {

	public static ArrayList<Integer> stringToIntegerList(String line) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		Integer integerM;

		while (line.length() != 0) {
			int indexString = line.indexOf(" ");
			if (indexString == -1) {
				arrayList.add(Integer.parseInt(line));
				break;
			}
			String elementArray = line.substring(0, indexString);
			integerM = Integer.parseInt(elementArray);
			arrayList.add(integerM);
			line = line.substring(indexString + 1, line.length());
		}

		return arrayList;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList = stringToIntegerList(line);
		int N = arrayList.get(0);
		int K = arrayList.get(1);
		int minutes = N + K;
		int N_extra = N, K_extra = K;
		if (N > K) {
			label1: for (int i = 0; i < N; i++) {
				N_extra = N - i;
				for (int j = 0; j <= i; j++) {
					K_extra = K + j;

					if (N_extra % K_extra == 0) {
						if (i + j < minutes) {
							minutes = i + j;
							break label1;
						}
					}
				}
			}
			label2: for (int i = 0; i < N; i++) {
				if (i > minutes) {
					break label2;
				}
				K_extra = K + i;
				for (int j = 0; j <= i; j++) {
					N_extra = N - j;
					if (i + j > minutes) {
						break;
					}
					if (N_extra % K_extra == 0) {
						if (i + j < minutes) {
							minutes = i + j;
							break;
						}
					}
				}
			}
			int step = 0;
			while (step <= minutes) {
				N_extra = N - step;
				for (int j = 0; j <= K; j++) {
					K_extra = K - j;
					if (step + j > minutes) {
						break;
					}
					if (N_extra % K_extra == 0) {
						if (step + j < minutes) {
							minutes = step + j;
						}
					}
				}
				step++;
			}
			step = 0;
			while (step <= minutes) {
				N_extra = N + step;
				for (int j = 0; j <= K; j++) {
					K_extra = K - j;
					if (step + j > minutes) {
						break;
					}
					if (N_extra % K_extra == 0) {
						if (step + j < minutes) {
							minutes = step + j;
						}
					}
				}
				step++;
			}
			step = 0;
			while (step <= minutes) {
				N_extra = N + step;
				for (int j = 0; j <= K; j++) {
					K_extra = K + j;
					if (step + j > minutes) {
						break;
					}
					if (N_extra % K_extra == 0) {
						if (step + j < minutes) {
							minutes = step + j;
						}
					}
				}
				step++;
			}
		}
		if (N <= K) {
			minutes = N;
			int minutes_extra = K - N;
			minutes = Math.min(minutes, minutes_extra);
		}
		System.out.println(minutes);
		System.out.println("Hello world");
	}
}