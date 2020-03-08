package com.vis.test.leetcode;


/**
 Given a m x n grid. Each cell of the grid has a sign pointing to the next cell you should visit if you are currently in this cell. The sign of grid[i][j] can be:
 1 which means go to the cell to the right. (i.e go from grid[i][j] to grid[i][j + 1])
 2 which means go to the cell to the left. (i.e go from grid[i][j] to grid[i][j - 1])
 3 which means go to the lower cell. (i.e go from grid[i][j] to grid[i + 1][j])
 4 which means go to the upper cell. (i.e go from grid[i][j] to grid[i - 1][j])
 Notice that there could be some invalid signs on the cells of the grid which points outside the grid.

 You will initially start at the upper left cell (0,0). A valid path in the grid is a path which starts from the upper left cell (0,0) and ends at the bottom-right cell (m - 1, n - 1) following the signs on the grid. The valid path doesn't have to be the shortest.

 You can modify the sign on a cell with cost = 1. You can modify the sign on a cell one time only.

 Return the minimum cost to make the grid have at least one valid path.
*/
public class MinCosValidPath {
  public static void main(String[] args) {
    int[][] grid = {{1,1,3},{3,2,2},{1,1,4}};

    //minCost(grid);
    int[][] grid2 = {{2, 2, 2}, {2, 2, 2}};
    minCost(grid2);
  }
  public static int minCost(int[][] grid) {
    int cost = 0;
    System.out.println(minCost(grid, 0, 0));
    return cost;
  }

  static int minCost(int[][] grid, int row, int col){
    System.out.println(row+" "+col+" ");

    if(row < 0 || row > grid.length-1 || col < 0|| col > grid[row].length-1 || grid[row][col] == 0){
      return -1;
    }

    if(row == grid.length-1 && col == grid[row].length-1 )
      return 0;

    int nxtMove = grid[row][col];
    grid[row][col] = 0;
    int nxtRow = row;
    int nxtCol = col;
    if( nxtMove == 1){
      nxtCol+=1;
    }else if( nxtMove == 2){
      nxtCol-=1;
    }else if( nxtMove == 3){
      nxtRow+=1;
    }else {
      nxtRow-=1;
    }

    int cost = minCost(grid, nxtRow, nxtCol);
    if(cost == -1){
      int newCost = Integer.MAX_VALUE;
      if( nxtMove != 1){
        int branchCost = minCost(grid, row, col+1);
        newCost = branchCost!= -1?Math.min(newCost, branchCost):newCost;
      }
      if( nxtMove != 2){
        int branchCost = minCost(grid, row, col-1);
        newCost = branchCost!=-1?Math.min(newCost, branchCost):newCost;
      }
      if( nxtMove != 3){
        int branchCost = minCost(grid, row+1, col);
        newCost = branchCost!=-1?Math.min(newCost, branchCost):newCost;
      }
      if( nxtMove != 4) {
        int branchCost = minCost(grid, row-1, col);
        newCost = branchCost!=-1?Math.min(newCost, branchCost):newCost;
      }
      cost = newCost +1;
    }

    return cost;

  }

}
