/*Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1
 */

 //Versão Iterativa

 class Solution {
    public int search(int[] nums, int target) {
      int left = 0;
      int right = nums.length - 1;

      while (left <= right) {
        int mid = (left + right) / 2;

        if (target == nums[mid]) {
          return mid;
        }
        else if (target < nums[mid]) {
          right = mid - 1;
        }
        else {
          left = mid + 1;
        }
      }
      return -1;
    }
}

class Main {
  public static void main(String[] args) {
    Solution solucao = new Solution();
    int[] nums = { 2, 5, 6, 8, 9, 10 };
    int target = 5;

    int index = solucao.search(nums, target);
    if (index != -1) {
            System.out.println("Element found at index " + index);
        }
        else {
            System.out.println("Element not found in the array");
        }
  }
}

 // Versão Recursiva

 class Solution {
    public int search(int[] nums, int target) {
      return binarySearch(nums, target, 0, nums.length - 1);
    }
    private int binarySearch(int[] nums, int target, int left, int right){
        
      if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;

        if (nums[mid] == target){
          return mid;
        }
        else if (target > nums[mid]) {
          return binarySearch(nums, target, mid + 1, right);
        }
        else {
          return binarySearch(nums, target, left, mid -1);
      }
    }
}

class Main {
  public static void main(String[] args) {
    Solution solucao = new Solution();
    int[] nums = { 2, 5, 6, 8, 9, 10 };
    int target = 5;

    int index = solucao.search(nums, target);
    if (index != -1) {
            System.out.println("Element found at index " + index);
        }
        else {
            System.out.println("Element not found in the array");
        }
  }
} 

 // Versão Comparable

 class Solution implements Comparable<Solution> {

    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int target, int left, int right){
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (nums[mid] == target){
            return mid;
        } else if (target > nums[mid]) {
            return binarySearch(nums, target, mid + 1, right);
        } else {
            return binarySearch(nums, target, left, mid -1);
        }
    }

    @Override
    public int compareTo(Solution other) {
        int result = this.search(new int[]{}, 0) - other.search(new int[]{}, 0);
        return result;
    }
}

// Classe main de teste

public class Main {
    public static void main(String[] args) {
        Solution solution1 = new Solution();
        int[] nums1 = {1, 2, 3, 4, 5};
        int target1 = 3;
        int result1 = solution1.search(nums1, target1);
        System.out.println("Result1: " + result1);

        Solution solution2 = new Solution();
        int[] nums2 = {2, 4, 6, 8, 10};
        int target2 = 5;
        int result2 = solution2.search(nums2, target2);
        System.out.println("Result2: " + result2);

        int compareToResult = solution1.compareTo(solution2);
        System.out.println("CompareToResult: " + compareToResult);
    }
}
