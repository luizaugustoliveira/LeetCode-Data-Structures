package InsertionSortList.Interface;

Aqui está a interface da questão do LeetCode que utiliza os métodos da classe SingleLinkedListNode<T>:

java
Copy code
public interface LinkedListSort<T> {
    SingleLinkedListNode<T> insertionSortList(SingleLinkedListNode<T> head);
}
Essa interface define um contrato para a implementação da questão do LeetCode, onde o método insertionSortList recebe um nó da lista encadeada (SingleLinkedListNode<T>) como parâmetro e retorna o nó da lista ordenada. A implementação dessa interface deve usar os métodos da classe SingleLinkedListNode<T> para manipular a lista encadeada e realizar a ordenação.

Dessa forma, é possível criar diferentes implementações dessa interface que utilizam os métodos da classe SingleLinkedListNode<T> de maneiras específicas para realizar a ordenação da lista encadeada.

Claro! Aqui está a implementação da interface LinkedListSort<T> tanto de forma iterativa quanto de forma recursiva, utilizando os métodos da classe SingleLinkedListNode<T>:

Implementação iterativa:

java
Copy code
public class IterativeLinkedListSort<T extends Comparable<T>> implements LinkedListSort<T> {
    @Override
    public SingleLinkedListNode<T> insertionSortList(SingleLinkedListNode<T> head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        SingleLinkedListNode<T> dummy = new SingleLinkedListNode<>();
        dummy.setNext(head);

        SingleLinkedListNode<T> curr = head.getNext();
        SingleLinkedListNode<T> tail = head;
        while (curr != null) {
            SingleLinkedListNode<T> prev = dummy;
            while (prev.getNext() != curr && curr.getData().compareTo(prev.getNext().getData()) >= 0) {
                prev = prev.getNext();
            }

            if (prev.getNext() != curr) {
                tail.setNext(curr.getNext());
                curr.setNext(prev.getNext());
                prev.setNext(curr);
            } else {
                tail = curr;
            }

            curr = tail.getNext();
        }

        return dummy.getNext();
    }
}
Implementação recursiva:

java
Copy code
public class RecursiveLinkedListSort<T extends Comparable<T>> implements LinkedListSort<T> {
    @Override
    public SingleLinkedListNode<T> insertionSortList(SingleLinkedListNode<T> head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        SingleLinkedListNode<T> sortedHead = insertionSortList(head.getNext());
        head.setNext(insertIntoSortedList(sortedHead, head));

        return sortedHead;
    }

    private SingleLinkedListNode<T> insertIntoSortedList(SingleLinkedListNode<T> head, SingleLinkedListNode<T> node) {
        if (head == null || node.getData().compareTo(head.getData()) <= 0) {
            node.setNext(head);
            return node;
        }

        SingleLinkedListNode<T> curr = head;
        while (curr.getNext() != null && node.getData().compareTo(curr.getNext().getData()) > 0) {
            curr = curr.getNext();
        }

        node.setNext(curr.getNext());
        curr.setNext(node);

        return head;
    }
}
Ambas as implementações seguem a mesma lógica do algoritmo de Insertion Sort para listas encadeadas. A implementação iterativa usa um nó dummy para representar a cabeça da lista ordenada. A cada iteração, encontra a posição correta para inserir o nó atual na lista ordenada, ajustando os ponteiros adequadamente.

Já a implementação recursiva divide a lista em duas partes: a lista ordenada (recursivamente ordenada) e a lista não ordenada. Em cada passo recursivo, insere o nó atual na lista ordenada utilizando o método insertIntoSortedList, que encontra a posição correta e faz os ajustes necessários nos ponteiros.

Agora você pode utilizar as implementações iterativa e recursiva da interface LinkedListSort<T> para resolver a questão do LeetCode.

Aqui está a classe Main com exemplos de casos de teste para as implementações iterativa e recursiva da interface LinkedListSort<T>:

java
Copy code
public class Main {
    public static void main(String[] args) {
        // Criação da lista encadeada
        SingleLinkedListNode<Integer> head = new SingleLinkedListNode<>(4, null);
        head.setNext(new SingleLinkedListNode<>(2, null));
        head.getNext().setNext(new SingleLinkedListNode<>(1, null));
        head.getNext().getNext().setNext(new SingleLinkedListNode<>(3, null));

        // Teste da implementação iterativa
        LinkedListSort<Integer> iterativeSort = new IterativeLinkedListSort<>();
        SingleLinkedListNode<Integer> sortedListIterative = iterativeSort.insertionSortList(head);
        System.out.println("Lista Ordenada (Iterativa): " + printList(sortedListIterative));

        // Criação de outra lista encadeada
        SingleLinkedListNode<Integer> head2 = new SingleLinkedListNode<>(-1, null);
        head2.setNext(new SingleLinkedListNode<>(5, null));
        head2.getNext().setNext(new SingleLinkedListNode<>(3, null));
        head2.getNext().getNext().setNext(new SingleLinkedListNode<>(4, null));
        head2.getNext().getNext().getNext().setNext(new SingleLinkedListNode<>(0, null));

        // Teste da implementação recursiva
        LinkedListSort<Integer> recursiveSort = new RecursiveLinkedListSort<>();
        SingleLinkedListNode<Integer> sortedListRecursive = recursiveSort.insertionSortList(head2);
        System.out.println("Lista Ordenada (Recursiva): " + printList(sortedListRecursive));
    }

    private static String printList(SingleLinkedListNode<Integer> head) {
        StringBuilder sb = new StringBuilder();
        SingleLinkedListNode<Integer> curr = head;
        while (curr != null) {
            sb.append(curr.getData()).append(" ");
            curr = curr.getNext();
        }
        return sb.toString();
    }
}
Neste exemplo, criamos duas listas encadeadas de inteiros e aplicamos as implementações iterativa e recursiva da interface LinkedListSort<T> para ordenar as listas. Em seguida, imprimimos as listas ordenadas.

Certifique-se de que as classes IterativeLinkedListSort<T>, RecursiveLinkedListSort<T>, e SingleLinkedListNode<T> estejam devidamente importadas para o arquivo Main.

Ao executar a classe Main, você verá a saída com as listas ordenadas usando as implementações iterativa e recursiva.
