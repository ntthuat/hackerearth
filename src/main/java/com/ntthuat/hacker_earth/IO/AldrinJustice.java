package com.ntthuat.hacker_earth.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AldrinJustice {

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
			ArrayList<Integer> arrayList = new ArrayList<>();
			arrayList = stringToIntegerList(line);
			int bt1 = arrayList.get(0);
			int bt2 = arrayList.get(1);
			int mt1 = arrayList.get(2);
			int mt2 = arrayList.get(3);
			if (bt2 < bt1) {
				int mediate = bt1;
				bt1 = bt2;
				bt2 = mediate;
			}
			if (mt2 < mt1) {
				int mediate = mt1;
				mt1 = mt2;
				mt2 = mediate;
			}
			if (mt1 > bt2) {
				System.out.println("Line");
			} else if (mt2 < bt1) {
				System.out.println("Line");
			} else if (mt1 == bt2 || mt2 == bt1) {
				System.out.println("Point");
			} else if (mt1 < bt2 && (bt1 == bt2 || mt1 == mt2)) {
				System.out.println("Point");
			} else if (mt2 > bt1 && (bt1 == bt2 || mt1 == mt2)) {
				System.out.println("Point");
			} else {
				System.out.println("Nothing");
			}
		}
		System.out.println("Hello World");
	}
}
