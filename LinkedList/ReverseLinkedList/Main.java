package ReverseLinkedList;

// Aqui está a definição de ListNode, que representa um nó em uma lista encadeada.
class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }
}

// A classe SolutionIterative, que implementa a versão iterativa da solução.
class SolutionIterative {
  public ListNode reverseList(ListNode head) {
      ListNode prev = null;
      ListNode curr = head;
      while (curr != null) {
          ListNode nextTemp = curr.next;
          curr.next = prev;
          prev = curr;
          curr = nextTemp;
      }
      return prev;
  }
}

// A classe SolutionRecursive, que implementa a versão recursiva da solução.
class SolutionRecursive {
  public ListNode reverseList(ListNode head) {
      if (head == null || head.next == null) return head;
      ListNode p = reverseList(head.next);
      head.next.next = head;
      head.next = null;
      return p;
  }
}

// A classe Main, que executa os testes.
public class Main {
  public static void printList(ListNode head) {
      while (head != null) {
          System.out.print(head.val + " ");
          head = head.next;
      }
      System.out.println();
  }

  public static void main(String[] args) {
      ListNode test1 = new ListNode(1);
      test1.next = new ListNode(2);
      test1.next.next = new ListNode(3);
      test1.next.next.next = new ListNode(4);
      test1.next.next.next.next = new ListNode(5);

      SolutionIterative solutionIterative = new SolutionIterative();
      ListNode result1 = solutionIterative.reverseList(test1);
      printList(result1);

      SolutionRecursive solutionRecursive = new SolutionRecursive();
      ListNode test2 = new ListNode(1);
      test2.next = new ListNode(2);
      test2.next.next = new ListNode(3);
      test2.next.next.next = new ListNode(4);
      test2.next.next.next.next = new ListNode(5);
      ListNode result2 = solutionRecursive.reverseList(test2);
      printList(result2);
  }
}
