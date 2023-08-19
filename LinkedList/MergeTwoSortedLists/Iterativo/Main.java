public class Main {
  public static void main(String[] args) {
      // Cria a primeira lista ligada: 1 -> 2 -> 4
      ListNode l1 = new ListNode(1);
      l1.next = new ListNode(2);
      l1.next.next = new ListNode(4);

      // Cria a segunda lista ligada: 1 -> 3 -> 4
      ListNode l2 = new ListNode(1);
      l2.next = new ListNode(3);
      l2.next.next = new ListNode(4);

      // Cria um objeto da classe Solution e mescla as duas listas
      Solution solution = new Solution();
      ListNode mergedList = solution.mergeTwoLists(l1, l2);

      // Imprime a lista mesclada
      while (mergedList != null) {
          System.out.print(mergedList.val + " ");
          mergedList = mergedList.next;
      }
  }
}

class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      ListNode head = new ListNode(0);
      ListNode p = head;
      while (l1 != null && l2 != null){
          if(l1.val <= l2.val) {
              p.next = l1;
              l1 = l1.next;
          } else {
              p.next = l2;
              l2 = l2.next;
          }
          p = p.next;
      }
      if (l1 != null){
          p.next = l1;
      }
      if (l2 != null){
          p.next = l2;
      }
      return head.next;
  }
}

