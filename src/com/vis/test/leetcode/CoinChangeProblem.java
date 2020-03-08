package com.vis.test.leetcode;

public class CoinChangeProblem {
  public static void main(String[] args) {
    int[] input = {1, 5, 10, 25};
    System.out.println(noOfCoin(input, 53, 3));
  }

  private static int noOfCoin(int[] coins, int change, int index){
    if(index < 0 || change ==0)
      return 0;
    if(change < coins[index])
      return noOfCoin(coins, change, index-1);
    else {
      int noOfCoins = change/coins[index];
      int balance = change%coins[index];
      return noOfCoins+ (balance == 0?0:noOfCoin(coins, balance, index-1));
    }

  }

}
