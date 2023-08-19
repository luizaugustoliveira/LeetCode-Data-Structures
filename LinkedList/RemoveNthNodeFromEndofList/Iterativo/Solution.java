package RemoveNthNodeFromEndofList.Iterativo;

// A classe ListNode que representa um nó em uma lista encadeada.
class ListNode {
  int val;        // valor do nó
  ListNode next;  // próximo nó na lista
  ListNode(int x) { val = x; }
}

class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
      // Cria um nó fictício para lidar com a borda caso a cabeça seja removida.
      ListNode dummy = new ListNode(0);
      dummy.next = head;  // configura o próximo nó como a cabeça da lista
      
      // Define dois ponteiros para o nó fictício.
      ListNode first = dummy;
      ListNode second = dummy;

      // Move o primeiro ponteiro n + 1 nós à frente.
      for (int i = 1; i <= n + 1; i++) {
          first = first.next;
      }

      // Move ambos os ponteiros até que o primeiro alcance o final.
      while (first != null) {
          first = first.next;
          second = second.next;
      }

      // Remove o nó desejado conectando o nó anterior diretamente ao nó seguinte.
      second.next = second.next.next;
      
      // Retorna a lista modificada.
      return dummy.next;
  }
}

