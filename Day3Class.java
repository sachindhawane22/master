package com.sachin.algos.day3;

import com.sachin.algos.day2.Day2Class;

public class Day3Class {

    public static void main(String[] args){
        Day3Class d3 = new Day3Class();
        int d = d3.trailingZeroes(5);
        System.out.print("count 0 "+d);
    }
    public int trailingZeroes(int n) {
        int[] fact = new int[n+1];
        fact[0]=1;
        for(int i=1;i<=n;i++){
            fact[i]=i*fact[i-1];
        }
        System.out.println(fact[n]+","+fact[n]);
        int count=0;
        if(fact[n]>=10){
            System.out.println("fact >10");
            for(int i=5;n/i>=1;i=i*5){
                System.out.print("in if");
                count=count+n/i;
                System.out.println(count);
            }
        }

        return count;

}
}


