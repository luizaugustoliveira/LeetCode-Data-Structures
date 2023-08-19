package PartitionList.Interface;

public class SingleTeste {
}

/*
Se você quiser implementar uma interface para a questão de "Partition List" do LeetCode com base na classe SingleLinkedListNode<T>, você pode fazê-lo da seguinte maneira:
*/

public interface PartitionListInterface<T extends Comparable<T>> {
  SingleLinkedListNode<T> partition(SingleLinkedListNode<T> head, T x);
}

Aqui estão as implementações da interface PartitionListInterface<T> tanto de forma iterativa quanto de forma recursiva, usando a classe SingleLinkedListNode<T>:

Implementação Iterativa:
public class PartitionListIterative<T extends Comparable<T>> implements PartitionListInterface<T> {
    @Override
    public SingleLinkedListNode<T> partition(SingleLinkedListNode<T> head, T x) {
        SingleLinkedListNode<T> beforeHead = new SingleLinkedListNode<>();
        SingleLinkedListNode<T> before = beforeHead;
        SingleLinkedListNode<T> afterHead = new SingleLinkedListNode<>();
        SingleLinkedListNode<T> after = afterHead;
        
        while (head != null && !head.isNIL()) {
            if (head.getData().compareTo(x) < 0) {
                before.setNext(head);
                before = before.getNext();
            } else {
                after.setNext(head);
                after = after.getNext();
            }
            head = head.getNext();
        }
        
        after.setNext(null);
        before.setNext(afterHead.getNext());
        
        return beforeHead.getNext();
    }
}
Implementação Recursiva:


public class PartitionListRecursive<T extends Comparable<T>> implements PartitionListInterface<T> {
    @Override
    public SingleLinkedListNode<T> partition(SingleLinkedListNode<T> head, T x) {
        if (head == null || head.isNIL() || head.getNext() == null || head.getNext().isNIL()) {
            return head;
        }
        
        SingleLinkedListNode<T> smallerHead = new SingleLinkedListNode<>();
        SingleLinkedListNode<T> smallerTail = smallerHead;
        SingleLinkedListNode<T> greaterHead = new SingleLinkedListNode<>();
        SingleLinkedListNode<T> greaterTail = greaterHead;
        
        SingleLinkedListNode<T> current = head;
        while (current != null && !current.isNIL()) {
            if (current.getData().compareTo(x) < 0) {
                smallerTail.setNext(current);
                smallerTail = smallerTail.getNext();
            } else {
                greaterTail.setNext(current);
                greaterTail = greaterTail.getNext();
            }
            current = current.getNext();
        }
        
        smallerTail.setNext(greaterHead.getNext());
        greaterTail.setNext(null);
        
        return smallerHead.getNext();
    }
}
Essas implementações oferecem uma solução iterativa e recursiva para o problema de "Partition List" usando a classe SingleLinkedListNode<T>. Agora você pode usar as implementações conforme necessário para resolver o problema.


Claro! Aqui está a classe Main com exemplos de casos de teste e impressão dos resultados para as classes PartitionListIterative e PartitionListRecursive:

java
Copy code
public class Main {
    public static void main(String[] args) {
        // Exemplo de caso de teste
        SingleLinkedListNode<Integer> node1 = new SingleLinkedListNode<>(1);
        SingleLinkedListNode<Integer> node2 = new SingleLinkedListNode<>(4);
        SingleLinkedListNode<Integer> node3 = new SingleLinkedListNode<>(3);
        SingleLinkedListNode<Integer> node4 = new SingleLinkedListNode<>(2);
        SingleLinkedListNode<Integer> node5 = new SingleLinkedListNode<>(5);
        SingleLinkedListNode<Integer> node6 = new SingleLinkedListNode<>(2);
        
        // Montando a lista: 1 -> 4 -> 3 -> 2 -> 5 -> 2
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        
        // Instanciando a classe PartitionListIterative e realizando a partição
        PartitionListIterative<Integer> partitionListIterative = new PartitionListIterative<>();
        SingleLinkedListNode<Integer> resultIterative = partitionListIterative.partition(node1, 3);
        
        // Imprimindo o resultado da partição iterativa
        System.out.println("Resultado da partição iterativa:");
        printLinkedList(resultIterative);
        
        System.out.println();
        
        // Instanciando a classe PartitionListRecursive e realizando a partição
        PartitionListRecursive<Integer> partitionListRecursive = new PartitionListRecursive<>();
        SingleLinkedListNode<Integer> resultRecursive = partitionListRecursive.partition(node1, 3);
        
        // Imprimindo o resultado da partição recursiva
        System.out.println("Resultado da partição recursiva:");
        printLinkedList(resultRecursive);
    }
    
    public static <T> void printLinkedList(SingleLinkedListNode<T> head) {
        while (head != null && !head.isNIL()) {
            System.out.print(head.getData() + " -> ");
            head = head.getNext();
        }
        System.out.println("NIL");
    }
}
Neste exemplo, criamos uma lista ligada com os nós contendo valores inteiros. Em seguida, instanciamos as classes PartitionListIterative e PartitionListRecursive e chamamos o método partition para realizar a partição da lista. Por fim, imprimimos o resultado da partição para ambos os casos, iterativo e recursivo.

Espero que isso ajude a entender como usar as classes que implementam a interface PartitionListInterface e imprimir os resultados dos casos de teste!