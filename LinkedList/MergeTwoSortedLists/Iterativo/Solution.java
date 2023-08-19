/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

 class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      // Cria um nó temporário para agir como a cabeça da lista final
      ListNode head = new ListNode(0);

      // Nó de rastreamento temporário para anexar novos nós
      ListNode p = head;

      // Enquanto ambas as listas têm elementos restantes
      while (l1 != null && l2 != null){
          // Se o valor no l1 é menor ou igual ao valor no l2
          if(l1.val <= l2.val) {
              // Anexar o nó de l1 à lista final
              p.next = l1;
              // Move para o próximo nó em l1
              l1 = l1.next;
          } else {
              // Anexar o nó de l2 à lista final
              p.next = l2;
              // Move para o próximo nó em l2
              l2 = l2.next;
          }
          // Move o rastreador para o próximo nó na lista final
          p = p.next;
      }

      // Se l1 ainda tem elementos, anexá-los à lista final
      if (l1 != null){
          p.next = l1;
      }

      // Se l2 ainda tem elementos, anexá-los à lista final
      if (l2 != null){
          p.next = l2;
      }

      // Retorna a lista final, começando do primeiro nó após a cabeça
      // Porque a cabeça foi um nó temporário com valor 0
      return head.next;
  }
}

