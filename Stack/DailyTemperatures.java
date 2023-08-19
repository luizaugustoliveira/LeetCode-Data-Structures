/*Daily Temperatures
Questão 739: Encontre o número de dias que você terá que esperar até que a temperatura aumente para cada dia
 
Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
Example 1:

Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
Example 2:

Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
Example 3:

Input: temperatures = [30,60,90]
Output: [1,1,0]
 */

 // Primeira Versão
 class Solution {
  public int[] dailyTemperatures(int[] T) {
      int[] result = new int[T.length];
      Stack<Integer> stack = new Stack<>();

      for (int i = 0; i < T.length; i++) {
          while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
              int index = stack.pop();
              result[index] = i - index;
          }
          stack.push(i);
      }

      return result;
  }
}

//Segunda Versão
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] waitDays = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int previousIndex = stack.pop();
                waitDays[previousIndex] = i - previousIndex;
            }
            // Empilhe o índice do dia atual
            stack.push(i);
        }

        // Dias restantes na pilha não têm um dia mais quente no futuro
        return waitDays;
    }
}
