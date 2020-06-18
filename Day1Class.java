package com.sachin.algos.day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day1Class {
    public static void  main(String[] args){
        Day1Class obj = new Day1Class();
        //obj.findDulicateInArrayOfNInteger();
        obj.sort012();
        obj.sort01();
        obj.missingNumberInArray();
        obj.mergeTwoSortedArray();
        obj.maxSubArray();
        obj.merge();
    }
    /*
        1. Find the duplicate in an array of N integers.
     */
    public int findDulicateInArrayOfNInteger(int[] nums){
        //int[] nums = {1,2,3,4,5,3};
        for(int i=0;i<nums.length;i++){
            if(nums[Math.abs(nums[i])] >= 0){
                nums[Math.abs(nums[i])] = -nums[Math.abs(nums[i])];
                //System.out.println("i-->"+i);
                for(int j=0;j<nums.length;j++){
                    //System.out.print(nums[j]+"\t");
                }

            }else{
                //System.out.println("Duplicate element:"+ Math.abs(nums[i]));
                return Math.abs(nums[i]);
            }
        }
        return -1;
    }

    /*
    2. Sort an array of 0’s 1’s 2’s without using extra space or sorting algo
    */

    public void sort012(){
        int[] input = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        int low=0; int mid=0; int high=input.length-1;
        int swapHelper=0;
        int i=0;
        while(mid<=high){
            if(input[mid]==0){
                swapHelper = input[mid];
                input[mid]=input[low];
                input[low]=input[mid];
                mid++;
                low++;
            }else if(input[mid]==1){
                mid++;

            }else if(input[mid]==2){
                swapHelper = input[mid];
                input[mid]=input[high];
                input[high]=swapHelper;
                high--;

            }else{

            }
        }
        for(Integer j:input){
            System.out.print(j+"\t");
        }
    }

    public void sort01() {
        int[] input = {0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1,0,0,0,0,1,1,0,0,0,0,0,0,0};
        int startIndex=0; int endIndex=input.length-1;
        while(startIndex<endIndex){
            if(input[startIndex]==0 ){
                startIndex++;
            }
            if(input[endIndex]==1){
                endIndex--;
            }
            if(startIndex<endIndex) {
                int temp = input[startIndex];
                input[startIndex] = input[endIndex];
                input[endIndex] = temp;
            }

        }
        for(Integer j:input){
            System.out.print(j+"\t");
        }
    }
    /*
     3. Repeat and Missing Number
    */

    public void missingNumberInArray() {
        int[] nums={9,6,4,2,3,5,7,0,1};
        int n = nums.length;
        int actualSum = n*(n+1)/2;
        int calculatedSum=0;
        for(int j=0;j<n;j++){
            calculatedSum=calculatedSum+nums[j];
        }
        System.out.println(actualSum-calculatedSum);

    }

    /*
     4. Merge two sorted Arrays without extra space
    */

    public void mergeTwoSortedArray(){
        int[]nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        //-------------CODE-----------
        int end1 = m-1;
        int end2 = n-1;
        int endIndex = m+n-1;

        while(end1 >=0 && end2>=0){
            if(nums1[end1]>nums2[end2]){
                nums1[endIndex]=nums1[end1];
                endIndex--;
                end1--;
            }else{
                nums1[endIndex]=nums2[end2];
                endIndex--;
                end2--;
            }
        }

        while(end2>=0){
            nums1[endIndex]=nums2[end2];
            endIndex--;
            end2--;
        }
        for(int i=0;i<nums1.length;i++){
            System.out.print(nums1[i]);
        }

    }
    /*
    5. Kadane’s Algorithm
    */
    public void maxSubArray() {
        int nums[]={-2,1,-3,4,-1,2,1,-5,4};
        int maxAtIndex = 0;
        int maxTillNow = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){

            maxAtIndex = maxAtIndex+nums[i];
            if(maxTillNow<maxAtIndex){
                maxTillNow=maxAtIndex;
            }
            if(maxAtIndex<0){
                maxAtIndex=0;
            }
        }
        System.out.print(maxTillNow);

    }
    /*
    6. Merge Overlapping Subintervals
    */

    public void merge() {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        if (intervals == null || intervals.length == 0)
            //return new int[0][0];

        Arrays.sort(intervals, ((x, y) -> x[0] - y[0]));
        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (current[1] >= intervals[i][0])
                current[1] = Math.max(current[1], intervals[i][1]);
            else {
                merged.add(current);
                current = intervals[i];
            }
        }
        merged.add(current);

        for(int[] ele : merged){
            System.out.println(ele[0]+","+ele[1]);

        }
        //return merged.toArray(new int[0][0]);
    }
}
