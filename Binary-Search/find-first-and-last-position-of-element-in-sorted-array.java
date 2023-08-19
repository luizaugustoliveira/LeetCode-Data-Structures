/*
 * Find First and Last Position of Element in Sorted Array
 * 
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 */

 // Versão Iterativa

 class Solution{
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums == null || nums.length == 0) {
            return  result;
        }
        int left = 0;
        int right = nums.length -1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }

        if (nums[left] != target) {
            return result;
        }

        result[0] =  left;

        right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2 + 1;
            if (target < nums[mid]) {
                right = mid - 1;
            }
            else {
                left = mid;
            }
        }
        result[1] = left;
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 3, 3, 5, 7, 8, 9, 9, 9, 15};
        int target = 9;

        Solution solution = new Solution();
        int[] result = solution.searchRange(nums, target);

        System.out.println("Primeira ocorrência do elemento: " + result[0]);
        System.out.println("Última ocorrência do elemento: " + result[1]);
    }
}

 // Versão Recursiva

 class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1}; // inicializa o array result com -1 em ambas as posições
        if (nums == null || nums.length == 0) { // verifica se a matriz nums é nula ou vazia
            return result; // retorna o array result
        }
        searchRange(nums, target, 0, nums.length - 1, result); // chama o método searchRange para buscar o elemento target
        return result; // retorna o array result com as posições do elemento target
    }
    
    private void searchRange(int[] nums, int target, int left, int right, int[] result) {
        if (left > right) { // verifica se a submatriz atual está vazia
            return; // encerra a busca
        }
        int mid = left + (right - left) / 2; // calcula o índice médio da submatriz atual
        if (nums[mid] == target) { // verifica se o valor do índice médio é igual ao elemento target
            if (result[0] == -1 || result[0] > mid) { // verifica se a primeira posição do elemento target foi encontrada ou se a posição atual é menor que a primeira posição atual
                result[0] = mid; // atualiza a primeira posição do elemento target
            }
            if (result[1] == -1 || result[1] < mid) { // verifica se a última posição do elemento target foi encontrada ou se a posição atual é maior que a última posição atual
                result[1] = mid; // atualiza a última posição do elemento target
            }
            searchRange(nums, target, left, mid - 1, result); // busca recursivamente na submatriz à esquerda do índice médio
            searchRange(nums, target, mid + 1, right, result); // busca recursivamente na submatriz à direita do índice médio
        } else if (nums[mid] > target) { // verifica se o valor do índice médio é maior que o elemento target
            searchRange(nums, target, left, mid - 1, result); // busca recursivamente na submatriz à esquerda do índice médio
        } else { // o valor do índice médio é menor que o elemento target
            searchRange(nums, target, mid + 1, right, result); // busca recursivamente na submatriz à direita do índice médio
        }
    }
}


public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 3, 3, 5, 7, 8, 9, 9, 9, 15};
        int target = 9;

        Solution solution = new Solution();
        int[] result = solution.searchRange(nums, target);

        System.out.println("Primeira ocorrência do elemento: " + result[0]);
        System.out.println("Última ocorrência do elemento: " + result[1]);
    }
}