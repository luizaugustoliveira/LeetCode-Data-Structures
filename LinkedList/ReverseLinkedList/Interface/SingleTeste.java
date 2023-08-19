package ReverseLinkedList.Interface;

public class SingleTeste {
}

public interface ReverseLinkedList<T> {
  SingleLinkedListNode<T> reverseList(SingleLinkedListNode<T> head);
}

public class SolutionIterative<T> implements ReverseLinkedList<T> {
  @Override
  public SingleLinkedListNode<T> reverseList(SingleLinkedListNode<T> head) {
      // Criamos um nó de referência para o elemento anterior, inicialmente definido como null
      SingleLinkedListNode<T> prev = new SingleLinkedListNode<>();

      // Nó de referência para o elemento atual, inicialmente definido como a cabeça da lista
      SingleLinkedListNode<T> curr = head;

      // Enquanto o elemento atual não for null (ou NIL), continuamos o loop
      while (curr != null && !curr.isNIL()) {
          // Guardamos o próximo elemento antes de alterar o ponteiro do elemento atual
          SingleLinkedListNode<T> nextTemp = curr.getNext();

          // Alteramos o ponteiro do próximo elemento do atual para o elemento anterior
          curr.setNext(prev);

          // Atualizamos o elemento anterior para o elemento atual
          prev = curr;

          // Atualizamos o elemento atual para o próximo elemento guardado anteriormente
          curr = nextTemp;
      }

      // Retornamos o elemento anterior, que agora é a nova cabeça da lista invertida
      return prev;
  }
}

public class SolutionRecursive<T> implements ReverseLinkedList<T> {
  @Override
  public SingleLinkedListNode<T> reverseList(SingleLinkedListNode<T> head) {
      // Caso base da recursão: se o nó atual é null (ou NIL) ou é o último nó (next é null ou NIL), retorne o nó atual
      if (head == null || head.isNIL() || head.getNext().isNIL()) {
          return head;
      }

      // Chamada recursiva: passamos o próximo nó
      SingleLinkedListNode<T> p = reverseList(head.getNext());

      // Invertemos o ponteiro do próximo nó para o nó atual
      head.getNext().setNext(head);

      // Anulamos o ponteiro do nó atual para o próximo nó
      head.setNext(new SingleLinkedListNode<>());  // Equivalent to 'head.next = null;' in ListNode

      // Retornamos o novo nó cabeça obtido da chamada recursiva
      return p;
  }
}

public class Main {
  public static void printList(SingleLinkedListNode<Integer> head) {
      // Imprimimos os valores de todos os nós enquanto iteramos através da lista
      while (head != null && !head.isNIL()) {
          System.out.print(head.getData() + " ");
          head = head.getNext();
      }
      System.out.println();
  }

  public static void main(String[] args) {
      // Preparando os test cases
      SingleLinkedListNode<Integer> test1 = new SingleLinkedListNode<>(1, 
          new SingleLinkedListNode<>(2, 
              new SingleLinkedListNode<>(3, 
                  new SingleLinkedListNode<>(4, 
                      new SingleLinkedListNode<>(5, new SingleLinkedListNode<>())))));

      // Testando a solução iterativa
      SolutionIterative<Integer> solutionIterative = new SolutionIterative<>();
      // Aplicamos a solução iterativa no primeiro caso de teste e imprimimos o resultado
      SingleLinkedListNode<Integer> result1 = solutionIterative.reverseList(test1);
      printList(result1); // Deve imprimir: 5 4 3 2 1

      // Testando a solução recursiva
      SolutionRecursive<Integer> solutionRecursive = new SolutionRecursive<>();
      // Preparamos outro teste similar ao anterior, pois o anterior foi modificado pelo método reverseList
      SingleLinkedListNode<Integer> test2 = new SingleLinkedListNode<>(1, 
          new SingleLinkedListNode<>(2, 
              new SingleLinkedListNode<>(3, 
                  new SingleLinkedListNode<>(4, 
                      new SingleLinkedListNode<>(5, new SingleLinkedListNode<>())))));
      // Aplicamos a solução recursiva no segundo caso de teste e imprimimos o resultado
      SingleLinkedListNode<Integer> result2 = solutionRecursive.reverseList(test2);
      printList(result2); // Deve imprimir: 5 4 3 2 1
  }
}
