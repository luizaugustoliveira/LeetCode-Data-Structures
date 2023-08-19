/*Valid Parentheses Questão 20: Verificar se a sequência de parênteses, colchetes e chaves é válida.


Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false

 */

 // Primeira versão 
 import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}

// Segunda versão
import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> mappings = new HashMap<>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // Se o caractere atual é um parêntese de fechamento
            if (mappings.containsKey(c)) {
                // Obter o elemento do topo da pilha. Se a pilha está vazia, defina um caractere de espaço reservado
                char topElement = stack.empty() ? '#' : stack.pop();

                // Se o mapeamento para este parêntese não corresponder ao elemento do topo da pilha, retorne false
                if (topElement != mappings.get(c)) {
                    return false;
                }
            } else {
                // Se for um parêntese de abertura, empurre na pilha
                stack.push(c);
            }
        }

        // Se a pilha ainda contém elementos, então é uma expressão inválida
        return stack.isEmpty();
    }
}

