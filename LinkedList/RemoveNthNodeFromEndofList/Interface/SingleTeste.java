package RemoveNthNodeFromEndofList.Interface;

public class SingleTeste {
  
}

/*Podemos criar uma interface para resolver essa questão, usando o tipo genérico T. Vamos chamá-la de RemoveNthNodeFromEndInterface, e dentro dela, definiremos o método removeNthFromEnd. O método removeNthFromEnd recebe como parâmetros o nó inicial da lista e o índice n do nó a ser removido a partir do fim.

Aqui está a interface: */

public interface RemoveNthNodeFromEndInterface<T> {
  SingleLinkedListNode<T> removeNthFromEnd(SingleLinkedListNode<T> head, int n);
}


//Interativa
public class IterativeRemoval<T> implements RemoveNthNodeFromEndInterface<T> {

  @Override
  public SingleLinkedListNode<T> removeNthFromEnd(SingleLinkedListNode<T> head, int n) {
      // Criando um nó fictício e conectando-o à cabeça da lista
      SingleLinkedListNode<T> dummy = new SingleLinkedListNode<>();
      dummy.setNext(head);
      
      SingleLinkedListNode<T> first = dummy;
      SingleLinkedListNode<T> second = dummy;
      
      // Move o primeiro ponteiro n + 1 nós à frente
      for (int i = 1; i <= n + 1; i++) {
          first = first.getNext();
      }
      
      // Move ambos os ponteiros até que o primeiro alcance o final
      while (first != null) {
          first = first.getNext();
          second = second.getNext();
      }
      
      // Remove o nó desejado
      second.setNext(second.getNext().getNext());
      
      return dummy.getNext();
  }
}

//Recursiva
public class RecursiveRemoval<T> implements RemoveNthNodeFromEndInterface<T> {

  private int n;  // guarda o valor de n

  @Override
  public SingleLinkedListNode<T> removeNthFromEnd(SingleLinkedListNode<T> head, int n) {
      this.n = n;  // configura o valor de n
      return removeNthFromEndHelper(head);  // chama o método auxiliar
  }

  private SingleLinkedListNode<T> removeNthFromEndHelper(SingleLinkedListNode<T> node) {
      // Caso base da recursão: se o nó for null, retorne null
      if (node.isNIL()) {
          return null;
      }

      // Faz uma chamada recursiva para o próximo nó
      node.setNext(removeNthFromEndHelper(node.getNext()));

      // Decrementa o valor de n
      n--;

      // Se n for 0, então o próximo nó é o nó que queremos remover
      if (n == 0) {
          return node.getNext();
      }

      // Retorna o nó atual
      return node;
  }
}

//Main
public class Main {
  public static void main(String[] args) {
      // Cria uma lista encadeada 1 -> 2 -> 3 -> 4 -> 5
      SingleLinkedListNode<Integer> head = new SingleLinkedListNode<>(1, null);
      head.setNext(new SingleLinkedListNode<>(2, null));
      head.getNext().setNext(new SingleLinkedListNode<>(3, null));
      head.getNext().getNext().setNext(new SingleLinkedListNode<>(4, null));
      head.getNext().getNext().getNext().setNext(new SingleLinkedListNode<>(5, null));
      
      // Cria instâncias das classes IterativeRemoval e RecursiveRemoval
      IterativeRemoval<Integer> iterativeRemoval = new IterativeRemoval<>();
      RecursiveRemoval<Integer> recursiveRemoval = new RecursiveRemoval<>();
      
      // Remove o 2º nó a partir do final usando o método iterativo
      SingleLinkedListNode<Integer> resultIterative = iterativeRemoval.removeNthFromEnd(head, 2);
      System.out.println("Resultado do método iterativo: ");
      printList(resultIterative);
      
      // Remove o 2º nó a partir do final usando o método recursivo
      SingleLinkedListNode<Integer> resultRecursive = recursiveRemoval.removeNthFromEnd(head, 2);
      System.out.println("Resultado do método recursivo: ");
      printList(resultRecursive);
  }
  
  // Método auxiliar para imprimir a lista encadeada
  public static <T> void printList(SingleLinkedListNode<T> node) {
      while (node != null && !node.isNIL()) {
          System.out.println(node.getData());
          node = node.getNext();
      }
  }
}

/*
 * Este código cria uma lista encadeada de inteiros de 1 a 5, e em seguida remove o segundo nó a partir do final tanto com a abordagem iterativa quanto com a recursiva. O método printList é um método auxiliar para imprimir a lista encadeada. Por favor, note que as operações de remoção modificam a lista original, então o resultado da operação recursiva pode não ser o esperado, já que a lista já foi modificada pela operação iterativa. Se você quiser verificar os dois métodos de forma independente, faça uma cópia da lista original antes de aplicar cada operação.
 */