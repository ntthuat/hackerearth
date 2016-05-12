/*Golu wants to find out the sum of Lucky numbers.
 * Lucky numbers are those numbers which contain exactly two set bits.
 * This task is very diffcult for him.
 * So Help Golu to find sum of those numbers which exactly contain two set
bits upto a given number N.

3 5 10 are lucky numbers where 7 14 are not.

INPUT

First line contain number of test cases T.Each test case contains a single
number N.
OUTPUT

Print sum of all Lucky Numbers upto N.Output may be large so take modulo
with 1000000007.
*/
package com.hackerearth.bitmanipulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LuckyNumbers {

	public static ArrayList<Long> bubbleSortAscendingList(ArrayList<Long> arrayListInput) {
		ArrayList<Long> arrayList = new ArrayList<>();
		for (int i = 0; i < arrayListInput.size(); i++) {
			arrayList.add(arrayListInput.get(i));
		}
		int counter, index;
		Long temp;
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int T = Integer.parseInt(line);
        
        int length = 60;
        ArrayList<Long> arrayList = new ArrayList<>();
        StringBuilder binary = new StringBuilder();
        binary.setLength(length);
        for (int k = 0; k < length; k++) {
            binary.setCharAt(k, '0');
        }
        for (int k = length-1; k > 0; k--) {
            for (int j = k-1; j >= 0; j--) {
                binary.setCharAt(k, '1');
                binary.setCharAt(j, '1');
                String binaryStr = binary.toString();
                long binaryLg = Long.parseLong(binaryStr, 2);
                arrayList.add(binaryLg);
                binary.setCharAt(k, '0');
                binary.setCharAt(j, '0');
            }
        }
        arrayList = bubbleSortAscendingList(arrayList);
        for (int i = 0; i < T; i++) {
        	line = br.readLine();
            long N = Long.parseLong(line);
        	long sum = 0;
        	int j = 0;
        	while (arrayList.get(j)<=N) {
				sum+=arrayList.get(j);
				sum=sum%1000000007;
				j++;
			}
            System.out.println(sum);
        }
    }
}