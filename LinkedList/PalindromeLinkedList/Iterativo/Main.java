package PalindromeLinkedList.Iterativo;

public class Main {
  public static void main(String[] args) {
      Solution solution = new Solution();

      // Caso de teste 1: 1->2->2->1 é um palíndrome
      ListNode node1 = new ListNode(1);
      ListNode node2 = new ListNode(2);
      ListNode node3 = new ListNode(2);
      ListNode node4 = new ListNode(1);
      node1.next = node2;
      node2.next = node3;
      node3.next = node4;
      System.out.println(solution.isPalindrome(node1));  // true

      // Caso de teste 2: 1->2 não é um palíndrome
      ListNode node5 = new ListNode(1);
      ListNode node6 = new ListNode(2);
      node5.next = node6;
      System.out.println(solution.isPalindrome(node5));  // false
  }
}

