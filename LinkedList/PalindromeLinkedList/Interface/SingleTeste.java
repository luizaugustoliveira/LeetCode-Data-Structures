package PalindromeLinkedList.Interface;

public class SingleTeste {
}

/*Obrigado por fornecer a classe SingleLinkedListNode<T>. Para criar uma interface específica para a questão "Palindrome Linked List" do LeetCode, você pode criar uma interface PalindromeLinkedList que declara o método isPalindrome. */

public interface PalindromeLinkedList<T> {
  // Método que verifica se uma lista ligada é um palíndromo.
  boolean isPalindrome(SingleLinkedListNode<T> head);
}

/*Para implementar a interface para a questão "Palindrome Linked List" do LeetCode, você pode criar duas classes IterativeSolution e RecursiveSolution que implementam a interface PalindromeLinkedList. */
//IterativeSolution (Modo Iterativo):
import java.util.Stack;

public class IterativeSolution<T extends Comparable<T>> implements PalindromeLinkedList<T> {
    @Override
    public boolean isPalindrome(SingleLinkedListNode<T> head) {
        Stack<T> stack = new Stack<>();
        SingleLinkedListNode<T> slow = head;
        SingleLinkedListNode<T> fast = head;

        while (fast != null && fast.getNext() != null) {
            stack.push(slow.getData());
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        if (fast != null) {
            slow = slow.getNext();
        }

        while (slow != null) {
            if (!slow.getData().equals(stack.pop())) {
                return false;
            }
            slow = slow.getNext();
        }

        return true;
    }
}

//RecursiveSolution (Modo Recursivo):
public class RecursiveSolution<T extends Comparable<T>> implements PalindromeLinkedList<T> {
  private SingleLinkedListNode<T> frontPointer;

  private boolean recursivelyCheck(SingleLinkedListNode<T> currentNode) {
      if(currentNode != null) {
          if(!recursivelyCheck(currentNode.getNext())) return false;
          if(!currentNode.getData().equals(frontPointer.getData())) return false;
          frontPointer = frontPointer.getNext();
      }
      return true;
  }

  @Override
  public boolean isPalindrome(SingleLinkedListNode<T> head) {
      frontPointer = head;
      return recursivelyCheck(head);
  }
}

public class Main {
    public static void main(String[] args) {
        // Criando alguns nós
        SingleLinkedListNode<Integer> node1 = new SingleLinkedListNode<>(1, null);
        SingleLinkedListNode<Integer> node2 = new SingleLinkedListNode<>(2, node1);
        SingleLinkedListNode<Integer> node3 = new SingleLinkedListNode<>(2, node2);
        SingleLinkedListNode<Integer> node4 = new SingleLinkedListNode<>(1, node3);

        // Caso de teste 1: 1 -> 2 -> 2 -> 1 (é um palíndromo)
        System.out.println("Iterative Solution, Test Case 1: " + new IterativeSolution<Integer>().isPalindrome(node4));
        System.out.println("Recursive Solution, Test Case 1: " + new RecursiveSolution<Integer>().isPalindrome(node4));

        // Criando mais alguns nós
        SingleLinkedListNode<Integer> node5 = new SingleLinkedListNode<>(1, null);
        SingleLinkedListNode<Integer> node6 = new SingleLinkedListNode<>(2, node5);
        SingleLinkedListNode<Integer> node7 = new SingleLinkedListNode<>(3, node6);
        SingleLinkedListNode<Integer> node8 = new SingleLinkedListNode<>(4, node7);

        // Caso de teste 2: 4 -> 3 -> 2 -> 1 (não é um palíndromo)
        System.out.println("Iterative Solution, Test Case 2: " + new IterativeSolution<Integer>().isPalindrome(node8));
        System.out.println("Recursive Solution, Test Case 2: " + new RecursiveSolution<Integer>().isPalindrome(node8));
    }
}

