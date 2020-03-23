package com.ntthuat.hacker_earth.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LifeUniverseEverything {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Read int n from STDIN
		int N = 0;
		while (N!=42) {
			String line = br.readLine();
			N = Integer.parseInt(line);
			if (N==42) {
				break;
			}
			System.out.println(N);	
		}
;
	}
}
