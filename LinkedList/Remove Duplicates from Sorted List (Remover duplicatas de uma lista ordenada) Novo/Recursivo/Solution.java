class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }
}

public class Solution {
  public ListNode deleteDuplicates(ListNode head) {
      // Condição base: se a lista estiver vazia ou se o próximo nó for null
      if (head == null || head.next == null) {
          return head;
      }
      // Chama a função recursiva para o restante da lista
      head.next = deleteDuplicates(head.next);

      // Verifica se o valor do nó atual é igual ao valor do próximo nó
      if (head.val == head.next.val) {
          // Se for, retorna o próximo nó, efetivamente ignorando o nó atual (deletando-o)
          return head.next;
      } else {
          // Se não for, retorna o nó atual
          return head;
      }
  }
}
