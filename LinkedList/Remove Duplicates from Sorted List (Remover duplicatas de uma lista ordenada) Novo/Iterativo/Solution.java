/*
 * Definição para uma lista ligada.
 */
class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }
}

public class Solution {
  public ListNode deleteDuplicates(ListNode head) {
      // Cria uma referência ao nó atual, inicialmente apontando para a cabeça da lista
      ListNode current = head;

      // Percorre a lista enquanto existir um nó atual
      while (current != null && current.next != null) {
          // Verifica se o valor do nó atual é igual ao valor do próximo nó
          if (current.val == current.next.val) {
              // Se for, faz o nó atual "pular" o próximo nó, efetivamente deletando-o
              current.next = current.next.next;
          } else {
              // Se o valor do próximo nó for diferente, então move para o próximo nó
              current = current.next;
          }
      }

      // Retorna a cabeça da lista, que agora não tem duplicatas
      return head;
  }
}
