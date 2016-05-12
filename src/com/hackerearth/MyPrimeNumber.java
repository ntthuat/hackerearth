package com.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MyPrimeNumber {

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

	public static ArrayList<Integer> bubbleSortAscendingList(ArrayList<Integer> arrayListInput) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		for (int i = 0; i < arrayListInput.size(); i++) {
			arrayList.add(arrayListInput.get(i));
		}
		int counter, index;
		Integer temp;
		int length = arrayList.size();

		for (counter = 0; counter < length - 1; counter++) {
			for (index = 0; index < length - 1 - counter; index++) {
				if (arrayList.get(index) > arrayList.get(index + 1)) {
					temp = arrayList.get(index);
					arrayList.set(index, arrayList.get(index + 1));
					arrayList.set(index + 1, temp);
				}
			}
		}
		
		return arrayList;
	}

	public static ArrayList<Integer> bubbleSortDecreasingList(ArrayList<Integer> arrayListInput) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		for (int i = 0; i < arrayListInput.size(); i++) {
			arrayList.add(arrayListInput.get(i));
		}
		int counter, index;
		Integer temp;
		int length = arrayList.size();

		for (counter = 0; counter < length - 1; counter++) {
			for (index = 0; index < length - 1 - counter; index++) {
				if (arrayList.get(index) < arrayList.get(index + 1)) {
					temp = arrayList.get(index);
					arrayList.set(index, arrayList.get(index + 1));
					arrayList.set(index + 1, temp);
				}
			}
		}

		return arrayList;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line);
		line = br.readLine();
		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList = stringToIntegerList(line);
		ArrayList<Integer> arrayListGraph = bubbleSortAscendingList(arrayList);
		ArrayList<Integer> arrayListFinal = new ArrayList<>();
		int i = 0;
		while (arrayListGraph.size() > 1) {
			for (i = 1; i < arrayListGraph.size(); i++) {
				if (arrayListGraph.get(i) % arrayListGraph.get(0) == 0) {
					arrayListGraph.remove(i);
					i--;
				}
			}
			arrayListFinal.add(arrayListGraph.get(0));
			arrayListGraph.remove(0);
		}
		if (arrayListGraph.size() > 0) {
			arrayListFinal.add(arrayListGraph.get(0));
		}		
		int j = 0;
		while (j < arrayList.size()) {
			for (j = 0; j < arrayList.size(); j++) {
				for (i = 0; i < arrayListFinal.size(); i++) {
					if (arrayList.get(j) == arrayListFinal.get(i)) {
						System.out.print(arrayList.get(j) + " ");
					}
				}
			}
		}
		System.out.println("Hello World");
	}
}