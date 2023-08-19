package SortList.Recursivo;

public class Main {
  public static void main(String[] args) {
      Solution solution = new Solution();
      
      // Caso de teste 1: [4,2,1,3]
      ListNode head1 = new ListNode(4);
      head1.next = new ListNode(2);
      head1.next.next = new ListNode(1);
      head1.next.next.next = new ListNode(3);
      ListNode sorted1 = solution.sortList(head1);
      printList(sorted1); // Resultado esperado: [1,2,3,4]
      
      // Caso de teste 2: [-1,5,3,4,0]
      ListNode head2 = new ListNode(-1);
      head2.next = new ListNode(5);
      head2.next.next = new ListNode(3);
      head2.next.next.next = new ListNode(4);
      head2.next.next.next.next = new ListNode(0);
      ListNode sorted2 = solution.sortList(head2);
      printList(sorted2); // Resultado esperado: [-1,0,3,4,5]
  }
  
  // Método auxiliar para imprimir a lista
  private static void printList(ListNode head) {
      ListNode curr = head;
      while (curr != null) {
          System.out.print(curr.val + " ");
          curr = curr.next;
      }
      System.out.println();
  }
}

