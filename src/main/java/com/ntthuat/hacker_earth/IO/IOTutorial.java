package com.ntthuat.hacker_earth.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOTutorial {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Read int n from STDIN
		String line = br.readLine();
		int N = Integer.parseInt(line);
	    // Write your code here
		line = br.readLine();
	    String S = line;
	    System.out.println(N*2);
	    System.out.println(S);
	}
}
