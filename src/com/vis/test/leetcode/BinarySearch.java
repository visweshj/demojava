package com.vis.test.leetcode;

import java.util.Arrays;

public class BinarySearch {

  private static int findIndex(int[] nums, int num){
    Arrays.sort(nums);

    int right = nums.length -1;
    int left =0;
    int midPoint;
    while (true){
      if(right < 0 || left >= nums.length || left > right){
        break;
      }
      midPoint = (left + right)/2;
      if(num == nums[midPoint])
        return midPoint;
      else if(num > nums[midPoint]){
        left = midPoint;
      }else {
        right = midPoint;
      }

    }

    return -1;
  }

}
