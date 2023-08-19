/*
 * Decode String

 Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 105.

Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
 */

 //Primeira Versão
 import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
            } else if (ch == '[') {
                // Push the number k and currentString to their respective stacks
                countStack.push(k);
                stringStack.push(currentString);
                // Reset k and currentString
                k = 0;
                currentString = new StringBuilder();
            } else if (ch == ']') {
                StringBuilder decodedString = stringStack.pop();
                for (int currentK = countStack.pop(); currentK > 0; currentK--) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                currentString.append(ch);
            }
        }

        return currentString.toString();
    }
}

//Segunda versão
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String decodeString(String s) {
        Deque<Integer> countDeque = new ArrayDeque<>();
        Deque<StringBuilder> stringDeque = new ArrayDeque<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0'; // building the count
            } else if (ch == '[') {
                // Push the count k and currentString to their respective stacks
                countDeque.push(k);
                stringDeque.push(currentString);
                // Reset k and currentString
                k = 0;
                currentString = new StringBuilder();
            } else if (ch == ']') {
                // Build the string by appending currentString k times
                StringBuilder decodedString = stringDeque.pop();
                for (int currentK = countDeque.pop(); currentK > 0; currentK--) {
                    decodedString.append(currentString);
                }
                // Update the currentString to be the decodedString
                currentString = decodedString;
            } else {
                // If ch is a letter, append it to currentString
                currentString.append(ch);
            }
        }

        // At the end, currentString contains the decoded string
        return currentString.toString();
    }
}
