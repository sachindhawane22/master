package com.sachin.algos.day2;

public class Day2Class {

    public static void main(String[] args){
        Day2Class d2 = new Day2Class();
         int d = d2.hammingDistance(93,72);
         System.out.print("distance "+d);
    }


    public int hammingDistance(int x, int y) {
        String stringX = Integer.toBinaryString(x);
        String stringY = Integer.toBinaryString(y);
        int xLen =stringX.length();
        int yLen = stringY.length();
        StringBuilder xb=new StringBuilder();
        StringBuilder yb=new StringBuilder();
        int j=0;

        if(xLen!=yLen) {
            if (xLen < yLen) {
                int diff = yLen - xLen;
                while (diff-- != 0) {
                    xb.append("0");
                }
                xb.append(stringX);
                yb.append(stringY);
            } else {
                int diff = xLen - yLen;
                while (diff-- != 0) {
                    yb.append("0");
                }
                yb.append(stringY);
                xb.append(stringX);
            }

            System.out.println(xb + "," + yb);

            for (int i = 0; i < xb.length(); i++) {
                if (xb.charAt(i) != yb.charAt(i)) {
                    j++;
                }

            }
        }else{
            xb.append(stringX);
            yb.append(stringY);
            System.out.println(xb + "\n" + yb);
            for (int i = 0; i < xb.length(); i++) {
                if (xb.charAt(i) != yb.charAt(i)) {
                    j++;
                }

            }
        }
        return j;
    }
}
