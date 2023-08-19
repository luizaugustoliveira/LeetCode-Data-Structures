package ReverseLinkedList.IterativoAndRecursivo;

class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }
}


public class SolutionIterative {
  public ListNode reverseList(ListNode head) {
      // Criamos um nó de referência para o elemento anterior, inicialmente definido como null
      ListNode prev = null;

      // Nó de referência para o elemento atual, inicialmente definido como a cabeça da lista
      ListNode curr = head;

      // Enquanto o elemento atual não for null, continuamos o loop
      while (curr != null) {
          // Guardamos o próximo elemento antes de alterar o ponteiro do elemento atual
          ListNode nextTemp = curr.next;

          // Alteramos o ponteiro do próximo elemento do atual para o elemento anterior
          curr.next = prev;

          // Atualizamos o elemento anterior para o elemento atual
          prev = curr;

          // Atualizamos o elemento atual para o próximo elemento guardado anteriormente
          curr = nextTemp;
      }

      // Retornamos o elemento anterior, que agora é a nova cabeça da lista invertida
      return prev;
  }
}

