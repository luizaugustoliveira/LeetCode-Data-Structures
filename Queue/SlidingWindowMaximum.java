/*
 * 239. Sliding Window Maximum
Hard
14.4K
468
Companies
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

 

Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:

Input: nums = [1], k = 1
Output: [1]
 */

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();

        // Processa os primeiros k elementos do array nums
        for (int i = 0; i < k; i++) {
            // Remove elementos menores do deque, pois eles não serão o máximo do intervalo atual
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        // Processa o restante dos elementos do array nums
        for (int i = k; i < n; i++) {
            // O primeiro elemento do deque é o máximo do intervalo anterior
            result[i - k] = nums[deque.peekFirst()];

            // Remove elementos que estão fora do intervalo atual
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Remove elementos menores do deque, pois eles não serão o máximo do intervalo atual
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.offerLast(i);
        }

        // Adiciona o máximo do último intervalo ao resultado
        result[n - k] = nums[deque.peekFirst()];

        return result;
    }
}

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        // Exemplo de uso da solução
        Solution solution = new Solution();

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = solution.maxSlidingWindow(nums, k);

        // Exibe o resultado
        for (int num : result) {
            System.out.print(num + " "); // Deve retornar 3 3 5 5 6 7
        }
    }
}
