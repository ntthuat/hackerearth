package com.ntthuat.hacker_earth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RoyAndWobblyNumber {

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
		ArrayList<Integer> arrayListResult = new ArrayList<>();
		for (int i = 1; i < 10; i++) {
			int a = i;
			for (int j = 0; j < 10; j++) {
				if (j != a) {
					int b = j;
					int ab = a*10 + b;
					arrayListResult.add(ab);
				}
			}
		}
		
		int T = Integer.parseInt(line);
		ArrayList<Integer> arrayList = new ArrayList<>();
		for (int i = 0; i < T; i++) {
			int wobblyNumber = -1;
			line = br.readLine();
			arrayList = stringToIntegerList(line);
			int N = arrayList.get(0);
			int K = arrayList.get(1);
			N = N - 2;
			boolean next = true;
			if (K > 81) {
				System.out.println(-1);
			} else {
				wobblyNumber = arrayListResult.get(K-1);
				int b = wobblyNumber % 10;
				int a = (wobblyNumber - b)/10;
				System.out.print(wobblyNumber);
				while (N>0) {
					if (next) {
						System.out.print(a);
						next = false;
					} else {
						System.out.print(b);
						next = true;
					}
					N--;
				}
				System.out.println();
			}
		}
		System.out.println("Hello world");
	}
}
