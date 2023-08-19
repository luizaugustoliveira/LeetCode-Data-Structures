package IntersectionofTwoLinkedLists.IterativoAndRecursivo;

public class Main {
  public static void main(String[] args) {
      ListNode intersection = new ListNode(8);
      intersection.next = new ListNode(10);
      intersection.next.next = new ListNode(12);

      ListNode headA = new ListNode(3);
      headA.next = new ListNode(5);
      headA.next.next = intersection;

      ListNode headB = new ListNode(4);
      headB.next = intersection;

      SolutionIterativa solutionIterativa = new SolutionIterativa();
      ListNode resultIterativo = solutionIterativa.getIntersectionNode(headA, headB);
      System.out.println(resultIterativo == null ? "No intersection" : "Intersection value: " + resultIterativo.val);

      SolutionRecursiva solutionRecursiva = new SolutionRecursiva();
      ListNode resultRecursivo = solutionRecursiva.getIntersectionNode(headA, headB);
      System.out.println(resultRecursivo == null ? "No intersection" : "Intersection value: " + resultRecursivo.val);
  }
}

/*
 * Para a abordagem iterativa, usamos dois ponteiros para percorrer as listas. Inicialmente, cada ponteiro está no início de cada lista. A cada iteração, avançamos um nó em cada lista. Se um ponteiro chega ao fim de sua lista, o movemos para o início da outra lista. Como as listas podem ser de comprimentos diferentes, essa troca garante que, eventualmente, ambos os ponteiros percorrerão a mesma distância. Se houver uma intersecção, os ponteiros irão encontrar-se nesse ponto de intersecção. Se não houver intersecção, ambos os ponteiros chegarão ao fim das listas ao mesmo tempo, e a função retornará null.

A abordagem recursiva é um pouco mais complexa. Primeiro, percorremos ambas as listas para determinar seus comprimentos. Se uma lista for mais longa que a outra, avançamos o ponteiro dessa lista até que ambas as listas tenham o mesmo comprimento restante. Então, avançamos simultaneamente em ambas as listas até encontrarmos um ponto de intersecção (ou seja, um nó em que ambos os ponteiros são iguais). Se não encontrarmos tal ponto, retornamos null.

Em ambas as abordagens, a ideia central é igualar a distância percorrida pelos ponteiros. Na abordagem iterativa, fazemos isso alternando os ponteiros entre as listas. Na abordagem recursiva, fazemos isso avançando o ponteiro na lista mais longa para que o restante das duas listas seja do mesmo comprimento.
 */
