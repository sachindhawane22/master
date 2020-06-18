/*
package com.sachin.algos.day4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Day4Class {
    public static void main(String[] args){
        Day4Class d4 = new Day4Class();
        d4.minimizeString();
    }

    public void minimizeString(){
        String str = "cabbaaabdd"; //cadd
        int k=2;
        Stack<Character> charStack = new Stack<>();
        Stack<Integer> charCountStack = new Stack<>();

        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);

            if (!charStack.isEmpty() && charStack.peek() == c) {
                charCountStack.push(charCountStack.peek() + 1);
            } else {
                charCountStack.push(1);
            }

            charStack.push(c);

            if (charCountStack.peek() == k) {
                for (int j = 0; j < k; j++) { // pop k adjacent equal chars
                    charStack.pop();
                    charCountStack.pop();
                }
            }

        }

        // Convert stack to string
        StringBuilder sb = new StringBuilder();
        while (!charStack.empty()) {
            sb.append(charStack.pop());
        }
        System.out.print(sb.reverse().toString());


    }

    public ArrayList<String> popularNToys(int numToys,
                                          int topToys,
                                          List<String> toys,
                                          int numQuotes,
                                          List<String> quotes)
    {
        List<String>toyList = new ArrayList();
        for(String toy:toys){
            String str = caps(toy);
            toyList.add(str);
        }

        String[] quotesArray = new String[quotes.size()];
        quotes.toArray(quotesArray);
        Map<String,Integer> m = new HashMap();

        for(String quote:quotes){
            String[] qa = quote.split(" ");
            for(int i=0;i<qa.length;i++{
                if(toyList.contains(qa[i]) ){
                    if(m.get(qa[i] != null){
                        int val = m.get(qa[i])+1;
                        m.put(qa[1],val);
                    }else{
                        m.put(qa[1],1);
                    }


                }
            }

        }



        // WRITE YOUR CODE HERE
    }


    // METHOD SIGNATURE ENDS


    public String caps(String str){
        return StringUtils.capitalize(str);
    }

}
*/
