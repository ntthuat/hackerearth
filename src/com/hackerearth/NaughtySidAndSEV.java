package com.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class NaughtySidAndSEV {

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
		int t = Integer.parseInt(line);
		ArrayList<Integer> arrayList = new ArrayList<>();
		int a, H, THETA_MAX;
		double K , resultDouble;
		for (int i = 0; i < t; i++) {
			line = br.readLine();			
			arrayList = stringToIntegerList(line);
			a = arrayList.get(0);
			H = arrayList.get(1);
			THETA_MAX = arrayList.get(2);
			K = H/Math.tan(Math.toRadians(THETA_MAX));
			if (K >= a) {
				resultDouble = H - 0.5 * a * Math.tan(Math.toRadians(THETA_MAX));
			} else {
				resultDouble = 0.5 * H * K;
				resultDouble = resultDouble / a;
			}
			System.out.println((int) Math.ceil(resultDouble));
			arrayList.clear();
		}
		System.out.println(Math.acos(-1));
	}
}