package RemoveLinkedListElements.Interface;

public class SingleTeste {
  
}

/*Vou criar uma interface que resolve a questão 203 "Remove Linked List Elements" do LeetCode, considerando a classe SingleLinkedListNode<T> que você forneceu. O objetivo será criar uma interface que define o método removeElements que aceita um SingleLinkedListNode<T> e um valor T para remover da lista. */

public interface RemoveLinkedListElements<T> {
  SingleLinkedListNode<T> removeElements(SingleLinkedListNode<T> head, T val);
}

// Iterativo
public class IterativeSolution<T> implements RemoveLinkedListElements<T> {
  @Override
  public SingleLinkedListNode<T> removeElements(SingleLinkedListNode<T> head, T val) {
      if (head == null || head.isNIL()) return null;

      SingleLinkedListNode<T> dummy = new SingleLinkedListNode<>();
      dummy.setNext(head);

      SingleLinkedListNode<T> current = dummy;

      while (current.getNext() != null && !current.getNext().isNIL()) {
          if (current.getNext().getData().equals(val)) {
              current.setNext(current.getNext().getNext());
          } else {
              current = current.getNext();
          }
      }

      return dummy.getNext();
  }
}

// Recursivo
public class RecursiveSolution<T> implements RemoveLinkedListElements<T> {
  @Override
  public SingleLinkedListNode<T> removeElements(SingleLinkedListNode<T> head, T val) {
      if (head == null || head.isNIL()) return null;

      head.setNext(removeElements(head.getNext(), val));

      return head.getData().equals(val) ? head.getNext() : head;
  }
}

/*Em ambos os casos, estamos implementando o método removeElements da interface RemoveLinkedListElements<T>. A diferença entre as duas soluções está em como percorremos a lista ligada e removemos os nós correspondentes: a solução iterativa usa um loop while, enquanto a solução recursiva chama a si mesma recursivamente. Ambas as implementações efetivamente "saltam" os nós cujos dados correspondem ao valor a ser removido, fazendo com que o próximo nó seja o nó após o nó a ser removido. */

public class Main {
  public static void main(String[] args) {
      // Cria uma instância das soluções.
      IterativeSolution<Integer> iterativeSolution = new IterativeSolution<>();
      RecursiveSolution<Integer> recursiveSolution = new RecursiveSolution<>();

      // Cria a lista ligada.
      SingleLinkedListNode<Integer> head = new SingleLinkedListNode<>(1, new SingleLinkedListNode<>(2, new SingleLinkedListNode<>(6, new SingleLinkedListNode<>(3, new SingleLinkedListNode<>(4, new SingleLinkedListNode<>(5, new SingleLinkedListNode<>(6, new SingleLinkedListNode<>())))))));

      // O valor a ser removido.
      Integer val = 6;

      // Chama o método removeElements e obtém o resultado para a solução iterativa.
      SingleLinkedListNode<Integer> iterativeResult = iterativeSolution.removeElements(head, val);
      // Imprime o resultado.
      printList(iterativeResult);

      // Chama o método removeElements e obtém o resultado para a solução recursiva.
      SingleLinkedListNode<Integer> recursiveResult = recursiveSolution.removeElements(head, val);
      // Imprime o resultado.
      printList(recursiveResult);
  }

  // Método para imprimir uma lista ligada.
  private static <T> void printList(SingleLinkedListNode<T> head) {
      SingleLinkedListNode<T> current = head;
      while (current != null && !current.isNIL()) {
          System.out.print(current.getData() + " ");
          current = current.getNext();
      }
      System.out.println();
  }
}

/*Este código cria duas soluções - uma iterativa e outra recursiva. Em seguida, cria uma lista ligada usando SingleLinkedListNode e chama o método removeElements em ambas as soluções. Por fim, imprime o resultado de cada chamada para verificar se os elementos corretos foram removidos.

Lembre-se que a estrutura de dados SingleLinkedListNode usa null para representar um nó vazio (NIL), então precisamos verificar isNIL antes de acessar os dados ou o próximo nó. Além disso, como este código usa a mesma lista ligada para ambas as soluções, os resultados podem ser diferentes se o método removeElements modificar a lista ligada. Se quiser garantir que ambas as soluções recebam a mesma lista ligada, você pode fazer uma cópia da lista ligada antes de chamar removeElements. */