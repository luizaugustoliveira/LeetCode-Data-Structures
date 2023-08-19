package PalindromeLinkedList.Recursivo;

// Definição da estrutura de dados da lista encadeada
class ListNode {
  int val; // valor que o nó armazena
  ListNode next; // referência ao próximo nó na lista
  ListNode(int x) { val = x; } // construtor do nó
}

public class Solution {
  private ListNode frontPointer; // ponteiro para o início da lista

  private boolean recursivelyCheck(ListNode currentNode) {
      if(currentNode != null) { // se ainda não chegamos ao fim da lista
          if(!recursivelyCheck(currentNode.next)) return false; // chamada recursiva para o próximo nó
          if(currentNode.val != frontPointer.val) return false; // se o valor no nó atual for diferente do valor no 'frontPointer'
          frontPointer = frontPointer.next; // move o 'frontPointer' para o próximo nó
      }
      return true; // se todos os nós passaram na verificação, então a lista é um palíndrome
  }

  public boolean isPalindrome(ListNode head) {
      frontPointer = head; // inicializando o 'frontPointer'
      return recursivelyCheck(head); // iniciando a chamada recursiva
  }
}

/*
 * Na solução recursiva, temos um ponteiro 'frontPointer' que começa no início da lista. A função recursiva 'recursivelyCheck' percorre a lista até o final, e depois começa a verificar cada nó à medida que a pilha de chamadas recursivas começa a desenrolar.

A cada passo, verificamos se o valor no 'frontPointer' é igual ao valor no nó atual. Se eles forem iguais, movemos o 'frontPointer' para o próximo nó e retornamos verdadeiro. Se eles não forem iguais em qualquer ponto, retornamos falso.

Essa solução funciona porque, à medida que a função recursiva se desenrola, ela está essencialmente verificando a lista de trás para frente, enquanto o 'frontPointer' verifica a lista da frente para trás.
 */
