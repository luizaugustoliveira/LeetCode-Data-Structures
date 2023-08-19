/*
 * Search a 2D Matrix
 * 
 * ou are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.

 

Example 1:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true


Example 2:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
 */

//Versão Iterativa 
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] numeros = new int[matrix.length * matrix[0].length];
        int index = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++){
                numeros[index] = matrix[i][j];
                index++;
            }
        }
      int left = 0;
      int right = numeros.length - 1;

      while (left <= right) {
        int mid = (left + right) / 2;

        if (numeros[mid] == target){
          return true;
        }
        else if (target < numeros[mid]){
          right = mid - 1;
        }
        else {
          left = mid + 1;
        }
      }
      return false;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solucao = new Solution();
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 13;
        int target2 = 3;
        boolean search = solucao.searchMatrix(matrix, target);
        boolean search2 = solucao.searchMatrix(matrix, target2);
        System.out.println(search);
        System.out.println(search2);
    }
}

// Versão Recursiva


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] numeros = new int[matrix.length * matrix[0].length];
        int index = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++){
                numeros[index] = matrix[i][j];
                index++;
            }
        }
        return binarySearch(numeros, target, 0, numeros.length - 1);
    }
    
    private boolean binarySearch(int[] nums, int target, int left, int right) {
        if (left > right) {
            return false;
        }
        
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return true;
        } else if (target < nums[mid]) {
            return binarySearch(nums, target, left, mid - 1);
        } else {
            return binarySearch(nums, target, mid + 1, right);
        }
    }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        return search(matrix, target, 0, m * n - 1, n);
    }
    
    private boolean search(int[][] matrix, int target, int left, int right, int n) {
        if (left > right) {
            return false;
        }
        
        int mid = left + (right - left) / 2;
        int midElement = matrix[mid / n][mid % n];
        
        if (midElement == target) {
            return true;
        } else if (midElement < target) {
            return search(matrix, target, mid + 1, right, n);
        } else {
            return search(matrix, target, left, mid - 1, n);
        }
    }
}

class Main {
    public static void main(String[] args) {
        Solution solucao = new Solution();
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 13;
        int target2 = 3;
        boolean search = solucao.searchMatrix(matrix, target);
        boolean search2 = solucao.searchMatrix(matrix, target2);
        System.out.println(search);
        System.out.println(search2);
    }
}

// Versão Comparable