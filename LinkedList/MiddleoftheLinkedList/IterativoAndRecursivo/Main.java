package MiddleoftheLinkedList.IterativoAndRecursivo;

public class Main {
  public static void main(String[] args) {
      // criamos instâncias das duas soluções
      SolutionIterative solutionIterative = new SolutionIterative();
      SolutionRecursive solutionRecursive = new SolutionRecursive();

      // criamos duas listas de teste
      ListNode test1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
      ListNode test2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));

      System.out.println("Iterative Solution:");
      // usamos a solução iterativa para encontrar o meio das listas de teste e imprimir os valores
      System.out.println("Test1: " + solutionIterative.middleNode(test1).val);
      System.out.println("Test2: " + solutionIterative.middleNode(test2).val);

      System.out.println("Recursive Solution:");
      // usamos a solução recursiva para encontrar o meio das listas de teste e imprimir os valores
      System.out.println("Test1: " + solutionRecursive.middleNode(test1).val);
      System.out.println("Test2: " + solutionRecursive.middleNode(test2).val);
  }
}

