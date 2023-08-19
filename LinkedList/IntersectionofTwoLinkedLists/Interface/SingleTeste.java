package IntersectionofTwoLinkedLists.Interface;

public class SingleTeste {
}

/*
 * Considerando a definição fornecida para SingleLinkedListNode<T>, poderíamos criar uma interface para a questão 160 do LeetCode da seguinte maneira:
 */

 public interface IntersectionFinder<T> {
  /**
   * Método que retorna o nó de intersecção de duas listas ligadas
   *
   * @param headA o primeiro nó da primeira lista ligada
   * @param headB o primeiro nó da segunda lista ligada
   * @return o nó de intersecção ou null se não houver intersecção
   */
  SingleLinkedListNode<T> getIntersectionNode(SingleLinkedListNode<T> headA, SingleLinkedListNode<T> headB);
}

/*Então, poderíamos implementar essa interface nas classes SolutionIterativa e SolutionRecursiva: */

public class SolutionIterativa<T> implements IntersectionFinder<T> {
  public SingleLinkedListNode<T> getIntersectionNode(SingleLinkedListNode<T> headA, SingleLinkedListNode<T> headB) {
      // A implementação permanece a mesma, substituindo apenas ListNode por SingleLinkedListNode<T>
  }
}

public class SolutionRecursiva<T> implements IntersectionFinder<T> {
  public SingleLinkedListNode<T> getIntersectionNode(SingleLinkedListNode<T> headA, SingleLinkedListNode<T> headB) {
      // A implementação permanece a mesma, substituindo apenas ListNode por SingleLinkedListNode<T>
  }

  // Método auxiliar privado para calcular o comprimento de uma lista
  private int getLength(SingleLinkedListNode<T> node) {
      // A implementação permanece a mesma, substituindo apenas ListNode por SingleLinkedListNode<T>
  }
}

/*Por favor, note que ao substituir ListNode por SingleLinkedListNode<T>, você também deve substituir as chamadas node.val por node.getData(), e node.next por node.getNext(), de acordo com os métodos disponíveis na nova classe de nó. */

// Implementação Iterativa
public class SolutionIterativa<T> implements IntersectionFinder<T> {
  public SingleLinkedListNode<T> getIntersectionNode(SingleLinkedListNode<T> headA, SingleLinkedListNode<T> headB) {
      if (headA.isNIL() || headB.isNIL()) {
          return new SingleLinkedListNode<T>();
      }
      
      SingleLinkedListNode<T> pointerA = headA;
      SingleLinkedListNode<T> pointerB = headB;
      
      while (pointerA != pointerB) {
          if (pointerA.getNext().isNIL()) {
              pointerA = headB;
          } else {
              pointerA = pointerA.getNext();
          }
          
          if (pointerB.getNext().isNIL()) {
              pointerB = headA;
          } else {
              pointerB = pointerB.getNext();
          }
      }
      
      return pointerA;
  }
}

// Implementação Recursiva
public class SolutionRecursiva<T> implements IntersectionFinder<T> {
  public SingleLinkedListNode<T> getIntersectionNode(SingleLinkedListNode<T> headA, SingleLinkedListNode<T> headB) {
      int lengthA = getLength(headA);
      int lengthB = getLength(headB);

      while (lengthA > lengthB) {
          headA = headA.getNext();
          lengthA--;
      }

      while (lengthA < lengthB) {
          headB = headB.getNext();
          lengthB--;
      }

      while (headA != headB) {
          headA = headA.getNext();
          headB = headB.getNext();
      }

      return headA;
  }

  private int getLength(SingleLinkedListNode<T> node) {
      if (node.isNIL()) {
          return 0;
      } else {
          return 1 + getLength(node.getNext());
      }
  }
}

/*Estas classes agora implementam a interface IntersectionFinder<T>, e utilizam a classe SingleLinkedListNode<T> em vez de ListNode para os nós das listas ligadas. Além disso, os métodos getData(), getNext() e isNIL() são usados em vez dos campos val e next e uma comparação de igualdade com null, respectivamente */

public class Main {
  public static void main(String[] args) {
      // Criando uma lista de intersecção
      SingleLinkedListNode<Integer> intersection = new SingleLinkedListNode<>(8, new SingleLinkedListNode<>());
      intersection.setNext(new SingleLinkedListNode<>(10, new SingleLinkedListNode<>()));
      intersection.getNext().setNext(new SingleLinkedListNode<>(12, new SingleLinkedListNode<>()));

      // Criando duas listas que intersectam na lista acima
      SingleLinkedListNode<Integer> headA = new SingleLinkedListNode<>(3, new SingleLinkedListNode<>());
      headA.setNext(new SingleLinkedListNode<>(5, new SingleLinkedListNode<>()));
      headA.getNext().setNext(intersection);

      SingleLinkedListNode<Integer> headB = new SingleLinkedListNode<>(4, new SingleLinkedListNode<>());
      headB.setNext(intersection);

      // Testando a solução iterativa
      SolutionIterativa<Integer> solutionIterativa = new SolutionIterativa<>();
      SingleLinkedListNode<Integer> resultIterativo = solutionIterativa.getIntersectionNode(headA, headB);
      // Imprimindo o resultado
      System.out.println(resultIterativo.isNIL() ? "No intersection" : "Intersection value: " + resultIterativo.getData());

      // Testando a solução recursiva
      SolutionRecursiva<Integer> solutionRecursiva = new SolutionRecursiva<>();
      SingleLinkedListNode<Integer> resultRecursivo = solutionRecursiva.getIntersectionNode(headA, headB);
      // Imprimindo o resultado
      System.out.println(resultRecursivo.isNIL() ? "No intersection" : "Intersection value: " + resultRecursivo.getData());
  }
}

/*Este código de teste cria duas listas ligadas que se intersectam, testa a função getIntersectionNode tanto com a implementação iterativa quanto com a recursiva e imprime o resultado. Ele cria dois nós que se intersectam no valor 8 e, em seguida, ambos seguem a mesma sequência (10, 12). Então, ele imprime o valor do nó de intersecção. Se tudo estiver funcionando corretamente, você deve ver "Intersection value: 8" impresso duas vezes. */