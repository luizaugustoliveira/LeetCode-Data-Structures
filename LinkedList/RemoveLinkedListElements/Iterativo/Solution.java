package RemoveLinkedListElements.Iterativo;

// Classe para representar um nó na lista ligada.
class ListNode {
  int val; // Valor do nó
  ListNode next; // Referência ao próximo nó na lista ligada
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
  public ListNode removeElements(ListNode head, int val) {
      // Nó fictício que permite lidar facilmente com os nós na cabeça da lista.
      ListNode dummy = new ListNode(0);

      // O próximo do nó fictício é a cabeça da lista original.
      dummy.next = head;

      // Nó atual começa do nó fictício.
      ListNode current = dummy;
      
      // Enquanto o próximo do nó atual não é nulo
      while(current.next != null) {
          // Se o valor do próximo nó for igual ao valor fornecido
          if(current.next.val == val) {
              // Remova o próximo nó ao ignorá-lo
              current.next = current.next.next;
          } else {
              // Senão, avance para o próximo nó
              current = current.next;
          }
      }

      // Retorne o nó seguinte ao fictício, que é a nova cabeça da lista.
      return dummy.next;
  }
}

