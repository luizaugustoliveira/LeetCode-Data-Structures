package MiddleoftheLinkedList.Interface;

public class SingleTeste {
  
}

/*Para criar uma interface que implementa a funcionalidade de "Middle of the Linked List" usando a classe SingleLinkedListNode<T>, você pode proceder da seguinte maneira:

Primeiro, defina a interface: */

public interface MiddleOfLinkedList<T> {
  SingleLinkedListNode<T> middleNode(SingleLinkedListNode<T> head);
}

//Iterativa
public class SolutionIterative<T> implements MiddleOfLinkedList<T> {
  public SingleLinkedListNode<T> middleNode(SingleLinkedListNode<T> head) {
      SingleLinkedListNode<T> slow = head;
      SingleLinkedListNode<T> fast = head;
      while (fast != null && fast.getNext() != null) {
          slow = slow.getNext();
          fast = fast.getNext().getNext();
      }
      return slow;
  }
}

//Recursiva
public class SolutionRecursive<T> implements MiddleOfLinkedList<T> {
  class NodeCount {
      SingleLinkedListNode<T> node;
      int count;
      NodeCount(SingleLinkedListNode<T> node, int count) {
          this.node = node;
          this.count = count;
      }
  }

  public SingleLinkedListNode<T> middleNode(SingleLinkedListNode<T> head) {
      return middleNodeHelper(head, 0).node;
  }

  private NodeCount middleNodeHelper(SingleLinkedListNode<T> head, int count) {
      if(head == null) {
          return new NodeCount(null, count);
      }
      NodeCount nc = middleNodeHelper(head.getNext(), count + 1);
      if(nc.count / 2 == count) {
          nc.node = head;
      }
      return nc;
  }
}

public class Main {
    public static void main(String[] args) {
        // Crie instâncias das duas soluções
        MiddleOfLinkedList<Integer> solutionIterative = new SolutionIterative<>();
        MiddleOfLinkedList<Integer> solutionRecursive = new SolutionRecursive<>();

        // Crie duas listas de teste
        SingleLinkedListNode<Integer> test1 = new SingleLinkedListNode<>(1, new SingleLinkedListNode<>(2, new SingleLinkedListNode<>(3, new SingleLinkedListNode<>(4, new SingleLinkedListNode<>(5, new SingleLinkedListNode<>())))));
        SingleLinkedListNode<Integer> test2 = new SingleLinkedListNode<>(1, new SingleLinkedListNode<>(2, new SingleLinkedListNode<>(3, new SingleLinkedListNode<>(4, new SingleLinkedListNode<>(5, new SingleLinkedListNode<>(6, new SingleLinkedListNode<>()))))));

        System.out.println("Iterative Solution:");
        // Use a solução iterativa para encontrar o meio das listas de teste e imprimir os valores
        System.out.println("Test1: " + solutionIterative.middleNode(test1).getData());
        System.out.println("Test2: " + solutionIterative.middleNode(test2).getData());

        System.out.println("Recursive Solution:");
        // Use a solução recursiva para encontrar o meio das listas de teste e imprimir os valores
        System.out.println("Test1: " + solutionRecursive.middleNode(test1).getData());
        System.out.println("Test2: " + solutionRecursive.middleNode(test2).getData());
    }
}
