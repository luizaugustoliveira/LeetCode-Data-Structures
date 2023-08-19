/*
There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.
*/
public class SearchinRotatedSortedArray {
    class Solution {
        public int search(int[] nums, int target) {
            int inicio = 0;
            int fim = nums.length -1;
            return buscaBinaria(nums,inicio,fim, target);
        }
    
        private int buscaBinaria(int[] nums, int inicio, int fim, int target){
    
            if(inicio > fim){
                return -1;
            }
           int meio = (inicio + fim)/2;
    
            if(target == nums[meio]) {
                return meio;
            }if(nums[inicio] <= nums[meio]) {
                if(target <= nums[meio] && nums[inicio] <= target ){
                    return buscaBinaria(nums, inicio, meio -1,target);
                }else{
                    return buscaBinaria(nums, meio +1, fim, target);
                }
            }else{
                if(nums[meio] <= target && target <= nums[fim]){
                    return buscaBinaria(nums,meio +1,fim, target);
                }else{
                    return buscaBinaria(nums,inicio, meio -1,target);
                }
            }
        }
    
    }   
}
