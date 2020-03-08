package com.vis.test.leetcode;
/*
Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.

To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].

To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].

Example 1:

Input: [[1,1,0],[1,0,1],[0,0,0]]
Output: [[1,0,0],[0,1,0],[1,1,1]]
Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
 */
public class FlipAnImage {

  public static void main(String[] args) {
    int[][] input = {{1,1,0},{1,0,1},{0,0,0}};
    int[][] output = flipAndInvertImage(input);
    for(int[] rows:output){
      System.out.println("");
      for (int element: rows){
        System.out.print(element+", ");
      }
    }

  }

  public static int[][] flipAndInvertImage(int[][] A) {
    int[][] result = new int[A.length][A[0].length];
    for(int row =0; row < A.length; row++){
      int left =0, right =A.length -1;
      while(left < right){
        int r = getInverse(A[row][left]);
        int l = getInverse(A[row][right]);
        System.out.println("Row :"+row+ " r:"+r+", l:"+l);
        result[row][right] = r;
        result[row][left] = l;
        left++;
        right--;
      }
      if(left == right){
        int r = getInverse(A[row][left]);
        result[row][right] = r;
      }
    }
    return result;

  }

  static int getInverse(int val){
    return val==1?0:1;
  }
}
