/*Definition:
Roy's boolean function (RBF) is True, if number of the positive integers less than or equal to N that are relatively prime to N, is prime; else False.
In other words, let Z be the number of integers K in the range 1 <= K <= N for which the greatest common divisor gcd(N, K) = 1. If Z is prime then RBF is True else it is False.

Given an integer N, your task is to find if its RBF value.

Input:
First line contains T - number of test cases.
Each of next T lines contain an integer N.

Output:
Print RBF value of each N in a new line i.e. "TRUE" or "FALSE" (quotes are only for clarity)

Constraints:
1 <= T <= 10
1 <= N <= 100000

Note: In case you're wondering, 1 is NOT a prime number :)
*/
package com.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import javax.security.sasl.RealmCallback;

public class RoyBooleanFunction {

	private static int gcd(int a, int b) {
		int t;
		while (b != 0) {
			t = a;
			a = b;
			b = t % b;
		}
		return a;
	}

	private static boolean relativelyPrime(int a, int b) {
		return gcd(a, b) == 1;
	}

	public static boolean[] fillSieve(int length) {
		boolean[] primes = new boolean[length];
		Arrays.fill(primes, true); // assume all integers are prime.
		primes[0] = primes[1] = false; // we know 0 and 1 are not prime.
		for (int i = 2; i < primes.length; i++) {
			// if the number is prime,
			// then go through all its multiples and make their values false.
			if (primes[i]) {
				for (int j = 2; i * j < primes.length; j++) {
					primes[i * j] = false;
				}
			}
		}
		return primes;
	}

	public static boolean checkPrime(int a) {
		boolean bool = false;
		if (a < 2) {
			return bool;
		}
		bool = true;
		double aDouble = Math.sqrt(a);
		for (int i = 2; i <= aDouble; i++) {
			if (a % i == 0) {
				bool = false;
			}
		}
		return bool;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int T = Integer.parseInt(line);
		boolean[] primes = fillSieve(100000);
		for (int i = 0; i < T; i++) {
			line = br.readLine();
			int N = Integer.parseInt(line);
			int number = 1;
			if (N != 1) {
				for (int j = 2; j < N; j++) {
					if (relativelyPrime(j,N)) {
						number++;
					}
				}
				boolean bool = primes[number];
				if (bool) {
					System.out.println("TRUE");
				} else {
					System.out.println("FALSE");
				}
			} else {
				System.out.println("FALSE");
			}
		}
		System.out.println("Hello world");
	}
}
