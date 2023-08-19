package RemoveNthNodeFromEndofList.Recursivo;

class ListNode {
  int val;        // valor do nó
  ListNode next;  // próximo nó na lista
  ListNode(int x) { val = x; }
}

class SolutionRecursive {
  private int n;  // guarda o valor de n
  
  public ListNode removeNthFromEnd(ListNode head, int n) {
      this.n = n;  // configura o valor de n
      return removeNthFromEndHelper(head);  // chama o método auxiliar
  }

  private ListNode removeNthFromEndHelper(ListNode node) {
      // Caso base da recursão: se o nó for null, retorne null.
      if (node == null) {
          return null;
      }

      // Faz uma chamada recursiva para o próximo nó.
      node.next = removeNthFromEndHelper(node.next);

      // Decrementa o valor de n.
      n--;

      // Se n for 0, então o próximo nó é o nó que queremos remover.
      if (n == 0) {
          return node.next;
      }

      // Retorna o nó atual.
      return node;
  }
}

