/*
 * 85. Maximal Rectangle

 Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.
Example 2:

Input: matrix = [["0"]]
Output: 0
Example 3:

Input: matrix = [["1"]]
Output: 1
 */

 public class Solution {
  public int maximalRectangle(char[][] matrix) {
      if (matrix.length == 0) return 0;
      int m = matrix.length;
      int n = matrix[0].length;
      int[] left = new int[n]; 
      int[] right = new int[n]; 
      int[] height = new int[n];
      Arrays.fill(right, n); 
      int maxArea = 0;
      
      for (int i = 0; i < m; i++) {
          int currentLeft = 0, currentRight = n; 
          for (int j = 0; j < n; j++) { 
              if (matrix[i][j] == '1') height[j]++; 
              else height[j] = 0;
          }
          for (int j = 0; j < n; j++) { 
              if (matrix[i][j] == '1') left[j] = Math.max(left[j], currentLeft);
              else {left[j] = 0; currentLeft = j + 1;}
          }
          for (int j = n - 1; j >= 0; j--) {
              if (matrix[i][j] == '1') right[j] = Math.min(right[j], currentRight);
              else {right[j] = n; currentRight = j;}    
          }
          for (int j = 0; j < n; j++) {
              maxArea = Math.max(maxArea, (right[j] - left[j]) * height[j]);
          }    
      }
      return maxArea;
  }
}
