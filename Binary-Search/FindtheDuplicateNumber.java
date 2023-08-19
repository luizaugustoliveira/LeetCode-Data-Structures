/*
 * Find the Duplicate Number
 * 
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.

 

Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3

A ideia da busca binária neste problema é considerar a faixa de valores possíveis para a resposta, que é de 1 a n-1, onde n é o tamanho do array. Em cada iteração da busca binária, encontramos o valor do meio dessa faixa e contamos quantos elementos do array são menores ou iguais a esse valor. Se houver mais elementos do que o valor do meio, sabemos que o número duplicado deve estar na metade inferior da faixa de valores possíveis, então atualizamos o limite superior da faixa para o meio atual. Caso contrário, o número duplicado deve estar na metade superior da faixa, então atualizamos o limite inferior. No final, o limite inferior será a resposta.
 */


 //Versão Iterativa
 public class Solution {
    public int findDuplicate(int[] nums) {
        int left = 1, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}


 // Versão Recursiva

 public class Solution {
    public int findDuplicate(int[] nums) {
        return binarySearch(nums, 1, nums.length - 1);
    }
    
    private int binarySearch(int[] nums, int left, int right) {
        if (left == right) {
            return left;
        }
        int mid = left + (right - left) / 2;
        int count = 0;
        for (int num : nums) {
            if (num <= mid) {
                count++;
            }
        }
        if (count > mid) {
            return binarySearch(nums, left, mid);
        } else {
            return binarySearch(nums, mid + 1, right);
        }
    }
}


 // Versão Comparable

 public class Solution implements Comparable<Solution> {
    public int findDuplicate(int[] nums) {
        return binarySearch(nums, 1, nums.length - 1);
    }
    
    private int binarySearch(int[] nums, int left, int right) {
        if (left == right) {
            return left;
        }
        int mid = left + (right - left) / 2;
        int count = 0;
        for (int num : nums) {
            if (num <= mid) {
                count++;
            }
        }
        if (count > mid) {
            return binarySearch(nums, left, mid);
        } else {
            return binarySearch(nums, mid + 1, right);
        }
    }
    
    @Override
    public int compareTo(Solution other) {
        int[] nums = {1, 3, 4, 2, 2};
        int ans1 = this.findDuplicate(nums);
        int ans2 = other.findDuplicate(nums);
        return Integer.compare(ans1, ans2);
    }
}
