package PalindromeLinkedList.Iterativo;

import java.util.Stack;

// Definição da estrutura de dados da lista encadeada
class ListNode {
    int val; // valor que o nó armazena
    ListNode next; // referência ao próximo nó na lista
    ListNode(int x) { val = x; } // construtor do nó
}

public class Solution {
    public boolean isPalindrome(ListNode head) {
        // Criando um objeto Stack para armazenar os valores dos nós
        Stack<Integer> stack = new Stack<>();

        // Ponteiros 'slow' e 'fast' para percorrer a lista
        ListNode slow = head;
        ListNode fast = head;

        // Este loop preenche a stack com a primeira metade dos valores dos nós
        while(fast != null && fast.next != null) {
            stack.push(slow.val); // empilhando o valor do nó no objeto stack
            slow = slow.next; // move o ponteiro 'slow' para o próximo nó
            fast = fast.next.next; // move o ponteiro 'fast' para o nó depois do próximo nó
        }

        // Isso ajusta o ponteiro 'slow' se a lista tem um número ímpar de elementos
        if(fast != null) {
            slow = slow.next;
        }

        // Este loop verifica se a segunda metade dos valores dos nós é um palíndrome
        while(slow != null) {
            if(slow.val != stack.pop()) { // se o valor do nó for diferente do valor no topo da pilha
                return false; // então a lista não é um palíndrome
            }
            slow = slow.next; // move o ponteiro 'slow' para o próximo nó
        }

        // Se todas as verificações passaram, então a lista é um palíndrome
        return true;
    }
}


/*O truque aqui é usar dois ponteiros - 'slow' e 'fast'. No início, ambos os ponteiros apontam para a cabeça da lista. Enquanto o ponteiro 'fast' avança dois passos por vez, o ponteiro 'slow' avança um passo por vez. Ao mesmo tempo, os valores de 'slow' são empurrados para uma pilha. Quando o ponteiro 'fast' chega ao fim da lista, o ponteiro 'slow' está no meio.

Se a lista tem um número ímpar de nós, o ponteiro 'fast' não será nulo e o ponteiro 'slow' deve avançar mais uma posição para apontar para o início da segunda metade da lista.

Agora o ponteiro 'slow' começa a percorrer o restante da lista, enquanto comparamos o valor em cada nó com o topo da pilha. Se em qualquer ponto esses valores não forem iguais, sabemos que a lista não é um palíndromo. */
