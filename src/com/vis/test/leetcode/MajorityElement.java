package com.vis.test.leetcode;

import java.util.HashMap;
import java.util.stream.Collectors;

/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
 */
public class MajorityElement {
  public int majorityElement(int[] nums) {
    int result = -1;
    HashMap<Integer, Integer> countMap = new HashMap<>();

    int half = nums.length/2;
    int globalMax = Integer.MIN_VALUE;
    for(int num: nums){
      int count = 0;
      if(countMap.containsKey(num)){
        count = countMap.get(num);
        count++;

      }else {
        count =1;
      }
      globalMax = Math.max(count, globalMax);
      countMap.put(num, count);

      if(count > half)
        return count;

    }
    return result;
  }


}
