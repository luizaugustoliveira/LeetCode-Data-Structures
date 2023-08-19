package AddTwoNumbers.Interface;

public class SingleTeste {
  
}

/*Se eu entendi corretamente, você gostaria de criar uma interface que imita o comportamento da classe SingleLinkedListNode<T> com métodos adicionais relevantes para o problema do LeetCode. Vou assumir que estamos nos referindo ao mesmo problema do LeetCode - "Add Two Numbers".

Podemos criar uma interface chamada IAddTwoNumbers com um método addTwoNumbers: */

public interface IAddTwoNumbers<T> {

  // Métodos herdados de SingleLinkedListNode<T>
  T getData();
  IAddTwoNumbers<T> getNext();
  boolean isNIL();
  void setData(T data);
  void setNext(IAddTwoNumbers<T> next);

  // Método adicional para o problema do LeetCode
  IAddTwoNumbers<T> addTwoNumbers(IAddTwoNumbers<T> l1, IAddTwoNumbers<T> l2);
}

public class AddTwoNumbersNode extends SingleLinkedListNode<Integer> implements IAddTwoNumbers<Integer> {

  public AddTwoNumbersNode() {
      super();
  }

  public AddTwoNumbersNode(Integer data, SingleLinkedListNode<Integer> next) {
      super(data, next);
  }

  // Implementação iterativa do método addTwoNumbers
  public IAddTwoNumbers<Integer> addTwoNumbersIterative(IAddTwoNumbers<Integer> l1, IAddTwoNumbers<Integer> l2) {
      AddTwoNumbersNode dummyHead = new AddTwoNumbersNode();
      IAddTwoNumbers<Integer> p = l1, q = l2, current = dummyHead;
      int carry = 0;
      while (p != null || q != null) {
          int x = 0;
          if (p != null) {
              x = p.getData();
              p = p.getNext();
          }
          int y = 0;
          if (q != null) {
              y = q.getData();
              q = q.getNext();
          }
          int sum = carry + x + y;
          carry = sum / 10;
          current.setNext(new AddTwoNumbersNode(sum % 10, null));
          current = current.getNext();
      }
      if (carry > 0) {
          current.setNext(new AddTwoNumbersNode(carry, null));
      }
      return dummyHead.getNext();
  }

  // Implementação recursiva do método addTwoNumbers
  public IAddTwoNumbers<Integer> addTwoNumbersRecursive(IAddTwoNumbers<Integer> l1, IAddTwoNumbers<Integer> l2) {
      return addTwoNumbersRecursive(l1, l2, 0);
  }

  private IAddTwoNumbers<Integer> addTwoNumbersRecursive(IAddTwoNumbers<Integer> l1, IAddTwoNumbers<Integer> l2, int carry) {
      if (l1 == null && l2 == null && carry == 0) {
          return null;
      }
      
      int sum = carry;
      if (l1 != null) {
          sum += l1.getData();
          l1 = l1.getNext();
      }
      if (l2 != null) {
          sum += l2.getData();
          l2 = l2.getNext();
      }
      
      AddTwoNumbersNode result = new AddTwoNumbersNode(sum % 10, null);
      result.setNext(addTwoNumbersRecursive(l1, l2, sum / 10));
      return result;
  }
}

public class Main {
    
  public static void main(String[] args) {
      AddTwoNumbersNode node1 = new AddTwoNumbersNode(2, new AddTwoNumbersNode(4, new AddTwoNumbersNode(3, null)));
      AddTwoNumbersNode node2 = new AddTwoNumbersNode(5, new AddTwoNumbersNode(6, new AddTwoNumbersNode(4, null)));
      AddTwoNumbersNode resultIterative = (AddTwoNumbersNode) node1.addTwoNumbersIterative(node1, node2);
      AddTwoNumbersNode resultRecursive = (AddTwoNumbersNode) node1.addTwoNumbersRecursive(node1, node2);
      
      System.out.println("Resultado iterativo: " + printList(resultIterative));  // Deveria imprimir: 7 -> 0 -> 8
      System.out.println("Resultado recursivo: " + printList(resultRecursive));  // Deveria imprimir: 7 -> 0 -> 8

      // Teste com números de tamanho diferente
      node1 = new AddTwoNumbersNode(1, new AddTwoNumbersNode(8, null));
      node2 = new AddTwoNumbersNode(0, null);
      resultIterative = (AddTwoNumbersNode) node1.addTwoNumbersIterative(node1, node2);
      resultRecursive = (AddTwoNumbersNode) node1.addTwoNumbersRecursive(node1, node2);

      System.out.println("Resultado iterativo: " + printList(resultIterative));  // Deveria imprimir: 1 -> 8
      System.out.println("Resultado recursivo: " + printList(resultRecursive));  // Deveria imprimir: 1 -> 8
  }

  // Método auxiliar para imprimir a lista
  public static String printList(AddTwoNumbersNode node) {
      StringBuilder sb = new StringBuilder();
      while (node != null && !node.isNIL()) {
          sb.append(node.getData());
          node = (AddTwoNumbersNode) node.getNext();
          if (node != null && !node.isNIL()) {
              sb.append(" -> ");
          }
      }
      return sb.toString();
  }
}

