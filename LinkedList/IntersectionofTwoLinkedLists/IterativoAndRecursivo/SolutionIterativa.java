package IntersectionofTwoLinkedLists.IterativoAndRecursivo;

// Definição da estrutura para um nó da lista ligada
class ListNode {
  int val; // valor do nó
  ListNode next; // referência ao próximo nó
  ListNode(int x) { // construtor do nó
      val = x;
      next = null;
  }
}

// Solução iterativa
public class SolutionIterativa {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      // Se uma das listas estiver vazia, não há intersecção
      if (headA == null || headB == null) {
          return null;
      }
      
      // Ponteiros para percorrer as listas
      ListNode pointerA = headA;
      ListNode pointerB = headB;
      
      // Enquanto os ponteiros não apontarem para o mesmo nó
      while (pointerA != pointerB) {
          // Se o ponteiro A chegou ao fim da lista, mova-o para o início da lista B
          if (pointerA == null) {
              pointerA = headB;
          } else { // Caso contrário, avance o ponteiro A
              pointerA = pointerA.next;
          }
          
          // Se o ponteiro B chegou ao fim da lista, mova-o para o início da lista A
          if (pointerB == null) {
              pointerB = headA;
          } else { // Caso contrário, avance o ponteiro B
              pointerB = pointerB.next;
          }
      }
      
      // Retorna o nó de intersecção ou null se não houver intersecção
      return pointerA;
  }
}