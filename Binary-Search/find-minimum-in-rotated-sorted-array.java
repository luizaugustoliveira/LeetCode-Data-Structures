/*
 *
 * 153. Find Minimum in Rotated Sorted Array
 *  
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.

 

Example 1:

Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.
Example 2:

Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
Example 3:

Input: nums = [11,13,15,17]
Output: 11
Explanation: The original array was [11,13,15,17] and it was rotated 4 times. 
 */

//Versão Iterativa

class Solution {
    public int findMin(int[] nums) {
      int left = 0;
      int right = nums.length - 1;

      if (nums[left] < nums[right]) {
        return nums[left];
      }

      while (left < right) {
        int mid = (left + right) / 2;

        if (nums[mid] > nums[right]){
          left = mid + 1;
        }
        else {
          right = mid;
        }
      }
      return nums[left];
    }
}

class Main {
  public static void main(String[] args) {
    int[] nums = {5, 1, 2, 3, 4};
    int[] nums2 = {3,4,5,1,2};
    int[] nums3 = {4,5,6,7,0,1,2};

    Solution solution = new Solution();
    int result = solution.findMin(nums);
    int result2 = solution.findMin(nums2);
    int result3 = solution.findMin(nums3);

    System.out.println(result);
    System.out.println(result2);
    System.out.println(result3);
  }
}

// Versão Recursiva

class Solution {
    public int findMin(int[] nums) {
      return search(nums, 0, nums.length - 1);
    }

    private int search(int[] nums, int left, int right) {
      if (nums[left] <= nums[right]) {
        return nums[left];
      }
      
      int mid = (left + right) / 2;

      if (nums[mid] > nums[right]){
        return search(nums, mid + 1, right);
      }
      else {
        return search(nums, left, mid);
      }
    }
}


class Main {
  public static void main(String[] args) {
    int[] nums = {5, 1, 2, 3, 4};
    int[] nums2 = {3,4,5,1,2};
    int[] nums3 = {4,5,6,7,0,1,2};

    Solution solution = new Solution();
    int result = solution.findMin(nums);
    int result2 = solution.findMin(nums2);
    int result3 = solution.findMin(nums3);

    System.out.println(result);
    System.out.println(result2);
    System.out.println(result3);
  }
}