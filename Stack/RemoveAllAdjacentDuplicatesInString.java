/*Remove All Adjacent Duplicates In String
: Remover todos os caracteres duplicados adjacentes de uma string.
You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.

We repeatedly make duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.

 

Example 1:

Input: s = "abbaca"
Output: "ca"
Explanation: 
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
Example 2:

Input: s = "azxxzy"
Output: "ay" */

// Primeira versão
class Solution {
  public String removeDuplicates(String S) {
      Stack<Character> stack = new Stack<>();
      
      for (char c : S.toCharArray()) {
          if (!stack.isEmpty() && stack.peek() == c) {
              // Encontrou um caractere duplicado adjacente, então remova
              stack.pop();
          } else {
              stack.push(c);
          }
      }
      
      // Construa a string resultante
      StringBuilder sb = new StringBuilder();
      for (char c : stack) {
          sb.append(c);
      }
      
      return sb.toString();
  }
}

// Segunda versão
class Solution {
  public String removeDuplicates(String S) {
      Stack<Character> stack = new Stack<>();
      
      for (char c : S.toCharArray()) {
          if (!stack.isEmpty() && stack.peek() == c) {
              stack.pop();
          } else {
              stack.push(c);
          }
      }
      
      // Construa a string resultante
      StringBuilder sb = new StringBuilder();
      while (!stack.isEmpty()) {
          sb.append(stack.pop());
      }
      
      return sb.reverse().toString();
  }
}
