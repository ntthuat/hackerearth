package com.ntthuat.hacker_earth.bitmanipulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Bit Comparison

&: AND
|: OR
^: OR loai tru
~: Dao bit
<<: Dich trai
: Dich phai
: Dich phai va them 0 vao cho trong

-----Example-----
public class Test {

  public static void main(String args[]) {
     int a = 60;      60 = 0011 1100 
     int b = 13;      13 = 0000 1101 
     int c = 0;

     c = a & b;       12 = 0000 1100
     System.out.println("a & b = " + c );

     c = a | b;       61 = 0011 1101
     System.out.println("a | b = " + c );

     c = a ^ b;        49 = 0011 0001 
     System.out.println("a ^ b = " + c );

     c = ~a;          -61 = 1100 0011
     System.out.println("~a = " + c );

     c = a << 2;     240 = 1111 0000
     System.out.println("a << 2 = " + c );

     c = a >> 2;     15 = 1111
     System.out.println("a >> 2  = " + c );

     c = a >>> 2;     15 = 0000 1111
     System.out.println("a >>> 2 = " + c );
  }
} 
*/

public class BitManipulationBasic {

    // function return bit 1 for int number
    public static int count_one (int n){
        int count = 0;
        while(n!=0)
        {
            n = n & (n-1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new
InputStreamReader(System.in));
        String line = br.readLine();
        int T = Integer.parseInt(line);
        for (int i = 0; i < T; i++) {
            line = br.readLine();
            int N = Integer.parseInt(line);
            System.out.println(count_one(N));
        }
    }
}
