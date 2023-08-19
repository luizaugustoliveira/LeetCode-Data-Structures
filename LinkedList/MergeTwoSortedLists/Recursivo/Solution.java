package LinkedList.MergeTwoSortedLists.Recursivo;
class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      // Caso base: se qualquer uma das listas for null, retorne a outra lista
      if (l1 == null) {
          return l2;
      } else if (l2 == null) {
          return l1;
      }

      // Se o valor do nó na lista 1 é menor ou igual ao da lista 2,
      // então colocamos o nó da lista 1 na lista mesclada
      // e recursivamente mesclamos o restante da lista 1 e a lista 2 inteira
      else if (l1.val <= l2.val) {
          l1.next = mergeTwoLists(l1.next, l2);
          return l1;
      }
      
      // Se o valor do nó na lista 2 é menor que o da lista 1,
      // então colocamos o nó da lista 2 na lista mesclada
      // e recursivamente mesclamos a lista 1 inteira e o restante da lista 2
      else {
          l2.next = mergeTwoLists(l1, l2.next);
          return l2;
      }
  }
}

