package MergekSortedLists.Interface;

Com base na classe SingleLinkedListNode<T> fornecida, podemos criar uma interface que utilize os métodos dessa classe para representar a questão "Merge k Sorted Lists" do LeetCode. Aqui está uma possível implementação dessa interface em Java:

java
Copy code
public interface MergeKSortedLists<T extends Comparable<T>> {
    SingleLinkedListNode<T> mergeKLists(SingleLinkedListNode<T>[] lists);
}
Nesta interface, declaramos um único método mergeKLists, que recebe um array de SingleLinkedListNode<T> representando as listas a serem mescladas. O método retorna um SingleLinkedListNode<T> que representa a lista mesclada.

Com essa interface, você pode implementar as soluções iterativa e recursiva da questão "Merge k Sorted Lists" utilizando a classe SingleLinkedListNode<T> e seus métodos

Aqui está a implementação da interface MergeKSortedLists tanto de forma iterativa quanto de forma recursiva, utilizando a classe SingleLinkedListNode<T>:

java
Copy code
public interface MergeKSortedLists<T extends Comparable<T>> {
    SingleLinkedListNode<T> mergeKListsIterative(SingleLinkedListNode<T>[] lists);
    SingleLinkedListNode<T> mergeKListsRecursive(SingleLinkedListNode<T>[] lists);
}

public class MergeKSortedListsImpl<T extends Comparable<T>> implements MergeKSortedLists<T> {
    // Implementação iterativa
    @Override
    public SingleLinkedListNode<T> mergeKListsIterative(SingleLinkedListNode<T>[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<SingleLinkedListNode<T>> pq = new PriorityQueue<>((a, b) -> a.getData().compareTo(b.getData()));

        for (SingleLinkedListNode<T> list : lists) {
            if (list != null) {
                pq.offer(list);
            }
        }

        SingleLinkedListNode<T> dummy = new SingleLinkedListNode<>();
        SingleLinkedListNode<T> current = dummy;

        while (!pq.isEmpty()) {
            SingleLinkedListNode<T> minNode = pq.poll();
            current.setNext(minNode);
            current = current.getNext();

            if (minNode.getNext() != null) {
                pq.offer(minNode.getNext());
            }
        }

        return dummy.getNext();
    }

    // Implementação recursiva
    @Override
    public SingleLinkedListNode<T> mergeKListsRecursive(SingleLinkedListNode<T>[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        return mergeLists(lists, 0, lists.length - 1);
    }

    private SingleLinkedListNode<T> mergeLists(SingleLinkedListNode<T>[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }

        int mid = left + (right - left) / 2;
        SingleLinkedListNode<T> leftList = mergeLists(lists, left, mid);
        SingleLinkedListNode<T> rightList = mergeLists(lists, mid + 1, right);

        return mergeTwoLists(leftList, rightList);
    }

    private SingleLinkedListNode<T> mergeTwoLists(SingleLinkedListNode<T> l1, SingleLinkedListNode<T> l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.getData().compareTo(l2.getData()) < 0) {
            l1.setNext(mergeTwoLists(l1.getNext(), l2));
            return l1;
        } else {
            l2.setNext(mergeTwoLists(l1, l2.getNext()));
            return l2;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MergeKSortedLists<Integer> merger = new MergeKSortedListsImpl<>();

        SingleLinkedListNode<Integer> list1 = new SingleLinkedListNode<>(1, new SingleLinkedListNode<>(4, new SingleLinkedListNode<>(5, null)));
        SingleLinkedListNode<Integer> list2 = new SingleLinkedListNode<>(1, new SingleLinkedListNode<>(3, new SingleLinkedListNode<>(4, null)));
        SingleLinkedListNode<Integer> list3 = new SingleLinkedListNode<>(2, new SingleLinkedListNode<>(6, null));

        SingleLinkedListNode<Integer>[] lists = new SingleLinkedListNode[]{list1, list2, list3};

        SingleLinkedListNode<Integer> mergedListIterative = merger.mergeKListsIterative(lists);
        SingleLinkedListNode<Integer> mergedListRecursive = merger.mergeKListsRecursive(lists);

        System.out.println("Merged List (Iterative):");
        printList(mergedListIterative);

        System.out.println("Merged List (Recursive):");
        printList(mergedListRecursive);
    }

    private static void printList(SingleLinkedListNode<Integer> head) {
        while (head != null) {
            System.out.print(head.getData() + " ");
            head = head.getNext();
        }
        System.out.println();
    }
}
Neste exemplo, a classe MergeKSortedListsImpl implementa a interface MergeKSortedLists. A solução iterativa utiliza uma PriorityQueue para manter o menor elemento de cada lista e, em seguida, itera sobre a fila de prioridade para mesclar as listas de forma iterativa.

A solução recursiva utiliza a técnica de divisão e conquista, onde as listas são divididas em partes menores e, em seguida, mescladas recursivamente. Os métodos mergeLists e mergeTwoLists são responsáveis por realizar a mesclagem das listas.

A classe Main contém um exemplo de caso de teste onde três listas são criadas e mescladas tanto de forma iterativa quanto recursiva. Os resultados são impressos utilizando o método printList.

Claro! Aqui está a classe Main com a impressão de alguns casos de teste para as classes que implementaram a interface MergeKSortedLists:

java
Copy code
public class Main {
    public static void main(String[] args) {
        MergeKSortedLists<Integer> merger = new MergeKSortedListsImpl<>();

        // Caso de teste 1
        SingleLinkedListNode<Integer> list1 = new SingleLinkedListNode<>(1,
                new SingleLinkedListNode<>(4,
                        new SingleLinkedListNode<>(5, null)));
        SingleLinkedListNode<Integer> list2 = new SingleLinkedListNode<>(1,
                new SingleLinkedListNode<>(3,
                        new SingleLinkedListNode<>(4, null)));
        SingleLinkedListNode<Integer> list3 = new SingleLinkedListNode<>(2,
                new SingleLinkedListNode<>(6, null));

        SingleLinkedListNode<Integer>[] lists1 = new SingleLinkedListNode[]{list1, list2, list3};

        SingleLinkedListNode<Integer> mergedListIterative1 = merger.mergeKListsIterative(lists1);
        SingleLinkedListNode<Integer> mergedListRecursive1 = merger.mergeKListsRecursive(lists1);

        System.out.println("Merged List (Iterative) - Test Case 1:");
        printList(mergedListIterative1);

        System.out.println("Merged List (Recursive) - Test Case 1:");
        printList(mergedListRecursive1);

        // Caso de teste 2
        SingleLinkedListNode<Integer> list4 = new SingleLinkedListNode<>(1,
                new SingleLinkedListNode<>(2,
                        new SingleLinkedListNode<>(3, null)));
        SingleLinkedListNode<Integer> list5 = new SingleLinkedListNode<>(4,
                new SingleLinkedListNode<>(5,
                        new SingleLinkedListNode<>(6, null)));
        SingleLinkedListNode<Integer> list6 = new SingleLinkedListNode<>(7,
                new SingleLinkedListNode<>(8, null));

        SingleLinkedListNode<Integer>[] lists2 = new SingleLinkedListNode[]{list4, list5, list6};

        SingleLinkedListNode<Integer> mergedListIterative2 = merger.mergeKListsIterative(lists2);
        SingleLinkedListNode<Integer> mergedListRecursive2 = merger.mergeKListsRecursive(lists2);

        System.out.println("Merged List (Iterative) - Test Case 2:");
        printList(mergedListIterative2);

        System.out.println("Merged List (Recursive) - Test Case 2:");
        printList(mergedListRecursive2);
    }

    private static void printList(SingleLinkedListNode<Integer> head) {
        while (head != null) {
            System.out.print(head.getData() + " ");
            head = head.getNext();
        }
        System.out.println();
    }
}
Neste exemplo, a classe Main contém dois casos de teste. Cada caso de teste cria um conjunto de listas ligadas e chama os métodos mergeKListsIterative e mergeKListsRecursive para mesclar as listas. Em seguida, os resultados são impressos utilizando o método printList.

Certifique-se de ter importado corretamente as classes SingleLinkedListNode, MergeKSortedLists, MergeKSortedListsImpl e qualquer outra classe necessária para executar o código.
