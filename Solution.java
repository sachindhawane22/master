package com.sachin.algos.day4;
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
import org.junit.platform.commons.util.StringUtils;

import java.util.List;
import java.util.ArrayList;
import java.util.*;

// CLASS BEGINS, THIS CLASS IS REQUIRED
class Solution
{


    public static void main(String[] args){
        Solution s = new Solution();
        List<String> toys = new ArrayList<>();
        toys.add("toy1");
        toys.add("toy2");
        toys.add("toy3");
        toys.add("toy4");toys.add("toy6");
        toys.add("toy5");

        List<String> quotes = new ArrayList<>();
        quotes.add("Toy1 as as sa de Toy1");
        quotes.add("Toy2 as as sa de Toy1");
        quotes.add("Toy3 as as sa de Toy2");
        quotes.add("Toy4 as as sa de Toy2");
        quotes.add("Toy5 as as sa de Toy1");
        quotes.add("Toy6 as as sa de Toy1");

List<String>al=
        s.popularNToys(6,2,toys,6,quotes);

for(String st : al){
    System.out.print(st);
}


    }
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
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
            for(int i=0;i<qa.length;i++){
                if(toyList.contains(qa[i]) ){
                    if(m.get(qa[i])!= null){
                        int val = m.get(qa[i])+1;
                        m.put(qa[i],val);
                    }else{
                        m.put(qa[i],1);
                    }


                }
            }

        }
        List<Map.Entry<String,Integer>> list =
                new LinkedList<Map.Entry<String,Integer>>(m.entrySet());

        Collections.sort(list,(e1,e2)-> e2.getValue().compareTo(e1.getValue()));
        ArrayList<String> rl = new ArrayList();

        for(int k=0 ; k<topToys ; k++){
            rl.add(list.get(k).getKey());
        }

        return rl;

        // WRITE YOUR CODE HERE
    }


    // METHOD SIGNATURE ENDS


    public String caps(String str){
        return str.substring(0,1).toUpperCase()+str.substring(1);
    }

}