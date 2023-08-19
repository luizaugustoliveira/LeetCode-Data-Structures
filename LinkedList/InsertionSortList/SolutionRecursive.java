package InsertionSortList;

class ListNode {
  int val;
  ListNode next;

  ListNode(int val) {
      this.val = val;
  }
}

public class SolutionRecursive {
  public ListNode insertionSortList(ListNode head) {
      if (head == null || head.next == null)
          return head;

      ListNode sortedTail = head;
      ListNode unsortedHead = head.next;
      head.next = null;

      ListNode sortedHead = recursiveSort(head, unsortedHead);

      return sortedHead;
  }

  private ListNode recursiveSort(ListNode sortedHead, ListNode unsortedHead) {
      if (unsortedHead == null)
          return sortedHead;

      ListNode curr = sortedHead;
      ListNode prev = null;

      while (curr != null && curr.val < unsortedHead.val) {
          prev = curr;
          curr = curr.next;
      }

      if (prev == null) {
          unsortedHead.next = sortedHead;
          sortedHead = unsortedHead;
      } else {
          prev.next = unsortedHead;
          unsortedHead.next = curr;
      }

      return recursiveSort(sortedHead, unsortedHead.next);
  }

  public static void main(String[] args) {
      Solution solution = new Solution();

      // Teste 1: 4->2->1->3
      ListNode head1 = new ListNode(4);
      head1.next = new ListNode(2);
      head1.next.next = new ListNode(1);
      head1.next.next.next = new ListNode(3);
      ListNode sortedList1 = solution.insertionSortList(head1);
      printList(sortedList1);

      // Teste 2: -1->5->3->4->0
      ListNode head2 = new ListNode(-1);
      head2.next = new ListNode(5);
      head2.next.next = new ListNode(3);
      head2.next.next.next = new ListNode(4);
      head2.next.next.next.next = new ListNode(0);
      ListNode sortedList2 = solution.insertionSortList(head2);
      printList(sortedList2);
  }

  private static void printList(ListNode head) {
      ListNode curr = head;
      while (curr != null) {
          System.out.print(curr.val + " ");
          curr = curr.next;
      }
      System.out.println();
  }
}

