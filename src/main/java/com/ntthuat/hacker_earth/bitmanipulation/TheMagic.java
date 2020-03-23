package com.ntthuat.hacker_earth.bitmanipulation;

/*Navi got a task at school to collect N stones. 
 * Each day he can collect only one stone. 
 * As N can be a very large number so it could take many days to complete
the task, 
 * but then he remembers that his mother gave him a magic that can double
anything (i.e if he has 2 stones, 
 * the magic will make them to 4 stones). 
 * Navi can use this magic any number of time on the collected stone on a
particular day 
 * and add this to the previously collected stones. Remember that he wants
exactly N stones and he can't throw any stone. 
 * If he gets more than N stones then he gets 0 marks, of course he doesn't
want 0 marks. 
 * Help him to collect exactly N stones in minimum number of days.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheMagic {

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
            int coutOne = count_one(N);
            System.out.println(coutOne);
        }
    }
}

