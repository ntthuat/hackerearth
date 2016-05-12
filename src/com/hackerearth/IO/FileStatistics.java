package com.hackerearth.IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.nio.channels.Channel;
import java.util.Scanner;

public class FileStatistics {
	public static void main(String[] args) throws IOException {
		Scanner inFile = new Scanner(new FileReader("D:\\test.txt"));
		String line;
		int numLine = 0;
		int numChar = 0;
		int numWord = 0;
		boolean startWord = false;
		while (inFile.hasNextLine()) {
			numLine++;
			line = inFile.nextLine();
			for (int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);
				int asciiCode = (int)c; 
				if ((asciiCode>=65 && asciiCode<=90) ||
					(asciiCode>=97 && asciiCode<=122)) {
					if (!startWord) {
						startWord = true;
					} 
					numChar++;
				} else {
					if (startWord) {
						startWord = false;
						numWord++;
					}
				}
			}
		}
		inFile.close();
		/*for (int i = 0; i < 255; i++) {
			System.out.println(i + " = " +(char)i);
		}*/
		System.out.println(numLine);
		System.out.println(numWord);
		System.out.println(numChar);	
		/*String userName = System.getProperty("user.name");
		String command = "id -u "+userName;
    	Process child = Runtime.getRuntime().exec(command);*/
    	/*File f = new File("/home/test.txt");
    	BufferedReader br = new BufferedReader(new FileReader(f));
    	String lineTest = br.readLine();*/
		File file = new File("/home/sample.txt");
		LineNumberReader sc = new LineNumberReader(new FileReader(file));
		sc.close();
	}
}
