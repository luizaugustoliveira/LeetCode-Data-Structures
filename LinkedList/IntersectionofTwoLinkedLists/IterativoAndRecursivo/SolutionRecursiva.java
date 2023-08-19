package IntersectionofTwoLinkedLists.IterativoAndRecursivo;
class ListNode {
  int val;
  ListNode next;
  ListNode(int x) {
      val = x;
      next = null;
  }
}
// Solução recursiva
public class SolutionRecursiva {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      // Obtendo o comprimento das listas
      int lengthA = getLength(headA);
      int lengthB = getLength(headB);

      // Igualando os comprimentos das listas
      while (lengthA > lengthB) {
          headA = headA.next;
          lengthA--;
      }

      while (lengthA < lengthB) {
          headB = headB.next;
          lengthB--;
      }

      // Encontrando o ponto de intersecção
      while (headA != headB) {
          headA = headA.next;
          headB = headB.next;
      }

      // Retorna o nó de intersecção ou null se não houver intersecção
      return headA;
  }

  // Método recursivo para calcular o comprimento de uma lista
  private int getLength(ListNode node) {
      // Se a lista está vazia, o comprimento é 0
      if (node == null) {
          return 0;
      } else { // Caso contrário, o comprimento é 1 mais o comprimento do restante da lista
          return 1 + getLength(node.next);
      }
  }
}