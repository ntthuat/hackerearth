package com.ntthuat.hacker_earth.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ASCIIValue {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Read int n from STDIN
		String line = br.readLine();
		char c = line.charAt(0);
		System.out.println(Character.hashCode(c));
	}
}
