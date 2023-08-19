package RemoveLinkedListElements.Recursivo;

class ListNode {
  int val; // Valor do nó
  ListNode next; // Referência ao próximo nó na lista ligada
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
  public ListNode removeElements(ListNode head, int val) {
      // Se a cabeça é nula, retorne nula (base do caso de recursão).
      if (head == null) return null;

      // Chamada recursiva para o resto da lista.
      head.next = removeElements(head.next, val);

      // Se o valor da cabeça for igual ao valor fornecido, retorne o próximo nó. 
      // Caso contrário, retorne a própria cabeça.
      return head.val == val ? head.next : head;
  }
}

