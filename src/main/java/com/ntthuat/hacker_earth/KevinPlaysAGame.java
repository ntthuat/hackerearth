package com.ntthuat.hacker_earth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class KevinPlaysAGame {
	
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
		int T = Integer.parseInt(line);
		for (int i = 0; i < T; i++) {
			line = br.readLine();
			int N = Integer.parseInt(line);
			int x = N / 2;
			System.out.println(N + " " + x);
			for (int j = 0; j < N; j++) {
				if (j % 2 == 0) {
					System.out.print("+");
				} else {
					System.out.print("-");
				}
				if (j == N - 1) {
					System.out.println();
				}
			}
		}
		System.out.println("Hello world");
	}
}
