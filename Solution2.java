package com.sachin.algos.day4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution2
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<String> reorderLines(int logFileSize, List<String> logLines)
    {
        if(logLines == null || logLines.size() == 0 ){
            return logLines;
        }
        List<String> rl = new ArrayList<>();
        List<String> letterList = new ArrayList();
        List<String> digitList = new ArrayList();
        for(String log : logLines){
            if(log.split(" ")[1].charAt(0) < 'a'){
                digitList.add(log);
            }else{
                letterList.add(log);
            }
        }

        Collections.sort(letterList,(o1, o2)->{
            String[] s1 = o1.split(" ");
            String[] s2 = o2.split(" ");
            int len1 = s1.length;
            int len2 = s2.length;
            for(int i=0;i<Math.min(len1,len2);i++){
                if(!s1[i].equals(s2[i])){
                    return s1[i].compareTo(s1[i]);
                }

            }
            return s1[0].compareTo(s1[0]);
        }  );

        int count = 0;

        while(count < letterList.size()){
            rl.add(letterList.get(count));
            count++;
        }

        int i=0;

        while(i< digitList.size()){
            rl.add(digitList.get(i));
            i++;
        }
        return rl;
    }
    // METHOD SIGNATURE ENDS
}