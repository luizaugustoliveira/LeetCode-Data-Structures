package MiddleoftheLinkedList.IterativoAndRecursivo;

class ListNode {
  int val; // valor deste nó
  ListNode next; // referência ao próximo nó na lista
  
  // Construtores para criar novos nós
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public class SolutionIterative {
  public ListNode middleNode(ListNode head) {
      ListNode slow = head; // inicia um ponteiro 'slow' no início da lista
      ListNode fast = head; // inicia um ponteiro 'fast' no início da lista
      // o ponteiro 'fast' se moverá duas vezes mais rápido que o 'slow'
      
      while (fast != null && fast.next != null) { // enquanto 'fast' não chegar ao final da lista
          slow = slow.next; // move 'slow' para o próximo nó
          fast = fast.next.next; // move 'fast' para dois nós à frente
      }
      // quando 'fast' chega ao final da lista, 'slow' estará no meio da lista
      return slow;
  }
}

/*
 * A estratégia para a solução iterativa é conhecida como "dois ponteiros" ou "ponteiro rápido-lento". O truque é iniciar dois ponteiros na cabeça da lista vinculada e mover um deles duas vezes mais rápido que o outro. Desta forma, quando o ponteiro rápido chegar ao final da lista, o ponteiro lento terá chegado exatamente ao meio.

No código, slow e fast são iniciados na cabeça da lista. Em cada iteração do loop, slow avança um passo (slow = slow.next), enquanto fast avança dois passos (fast = fast.next.next). O loop continua até que fast atinja o final da lista. Quando isso ocorre, slow está no nó do meio e é retornado pela função.
 */
