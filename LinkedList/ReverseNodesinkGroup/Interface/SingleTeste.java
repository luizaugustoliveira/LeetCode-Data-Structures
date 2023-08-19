package ReverseNodesinkGroup.Interface;

Aqui está uma possível interface que utiliza os métodos da classe SingleLinkedListNode<T> para resolver a questão "Reverse Nodes in k-Group" do LeetCode:

java
Copy code
public interface LinkedListReverser<T> {
    /**
     * Reverses the nodes of a linked list in groups of size k.
     *
     * @param head The head node of the linked list.
     * @param k    The size of each group.
     * @return The head node of the reversed linked list.
     */
    SingleLinkedListNode<T> reverseKGroup(SingleLinkedListNode<T> head, int k);
}
Nessa interface, temos um método reverseKGroup que recebe o nó cabeça (head) da lista encadeada e o tamanho do grupo (k). O método retorna o nó cabeça da lista encadeada após a reversão dos nós em grupos de tamanho k.

A interface utiliza os métodos da classe SingleLinkedListNode<T> para manipular e acessar os nós da lista encadeada. Os métodos getNext() e setNext() são usados para acessar e atualizar a referência para o próximo nó. O método setData() é usado para atualizar o valor do nó. O método isNIL() verifica se o nó é um nó vazio (NIL).

Essa interface fornece uma estrutura genérica para implementar a lógica de reversão dos nós em grupos de tamanho k, utilizando os métodos da classe SingleLinkedListNode<T>.

Claro! Aqui está a implementação da interface LinkedListReverser<T> de forma iterativa e recursiva, utilizando os métodos da classe SingleLinkedListNode<T>:

Implementação Iterativa:

java
Copy code
public class IterativeLinkedListReverser<T> implements LinkedListReverser<T> {

    public SingleLinkedListNode<T> reverseKGroup(SingleLinkedListNode<T> head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        SingleLinkedListNode<T> dummy = new SingleLinkedListNode<>();
        dummy.setNext(head);
        SingleLinkedListNode<T> prev = dummy;

        int count = 0;
        while (head != null) {
            count++;
            if (count % k == 0) {
                prev = reverseGroup(prev, head.getNext());
                head = prev.getNext();
            } else {
                head = head.getNext();
            }
        }

        return dummy.getNext();
    }

    private SingleLinkedListNode<T> reverseGroup(SingleLinkedListNode<T> prev, SingleLinkedListNode<T> next) {
        SingleLinkedListNode<T> last = prev.getNext();
        SingleLinkedListNode<T> curr = last.getNext();

        while (curr != next) {
            last.setNext(curr.getNext());
            curr.setNext(prev.getNext());
            prev.setNext(curr);
            curr = last.getNext();
        }

        return last;
    }
}
Implementação Recursiva:

java
Copy code
public class RecursiveLinkedListReverser<T> implements LinkedListReverser<T> {

    public SingleLinkedListNode<T> reverseKGroup(SingleLinkedListNode<T> head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        int count = 0;
        SingleLinkedListNode<T> curr = head;
        while (curr != null && count < k) {
            curr = curr.getNext();
            count++;
        }

        if (count == k) {
            curr = reverseKGroup(curr, k);
            head = reverseGroup(head, curr);
        }

        return head;
    }

    private SingleLinkedListNode<T> reverseGroup(SingleLinkedListNode<T> head, SingleLinkedListNode<T> tail) {
        SingleLinkedListNode<T> prev = tail;

        while (head != tail) {
            SingleLinkedListNode<T> next = head.getNext();
            head.setNext(prev);
            prev = head;
            head = next;
        }

        return prev;
    }
}
Na implementação iterativa, o método reverseKGroup percorre a lista encadeada em grupos de tamanho k. Em cada iteração, verifica se a contagem atingiu o valor k. Se sim, chama o método reverseGroup para inverter o grupo atual. O método reverseGroup realiza a inversão dos nós do grupo.

Na implementação recursiva, o método reverseKGroup também percorre a lista em grupos de tamanho k. No entanto, em vez de usar um loop, utiliza chamadas recursivas para avançar na lista. Quando a contagem atinge k, chama o método reverseGroup para inverter o grupo atual.

O método reverseGroup é comum a ambas as implementações. Ele recebe a cabeça do grupo e o próximo nó após o grupo. Em seguida, realiza a inversão dos nós dentro do grupo.

Essas implementações utilizam os métodos da classe SingleLinkedListNode<T> para manipular os nós da lista encadeada e retornam o nó cabeça da lista após a reversão dos grupos de tamanho k.

Lembrando que, além dessas implementações, você também precisa ter a classe SingleLinkedListNode<T> em seu código para executar essas implementações corretamente.

Aqui está a classe Main com alguns casos de teste e o print dos resultados para as implementações IterativeLinkedListReverser e RecursiveLinkedListReverser:

java
Copy code
public class Main {
    // Função para imprimir a lista encadeada
    public static <T> void printLinkedList(SingleLinkedListNode<T> head) {
        SingleLinkedListNode<T> curr = head;
        while (curr != null) {
            System.out.print(curr.getData() + " ");
            curr = curr.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Criação da lista de nós de teste: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8
        SingleLinkedListNode<Integer> head = new SingleLinkedListNode<>(1, null);
        head.setNext(new SingleLinkedListNode<>(2, null));
        head.getNext().setNext(new SingleLinkedListNode<>(3, null));
        head.getNext().getNext().setNext(new SingleLinkedListNode<>(4, null));
        head.getNext().getNext().getNext().setNext(new SingleLinkedListNode<>(5, null));
        head.getNext().getNext().getNext().getNext().setNext(new SingleLinkedListNode<>(6, null));
        head.getNext().getNext().getNext().getNext().getNext().setNext(new SingleLinkedListNode<>(7, null));
        head.getNext().getNext().getNext().getNext().getNext().getNext().setNext(new SingleLinkedListNode<>(8, null));

        LinkedListReverser<Integer> iterativeReverser = new IterativeLinkedListReverser<>();
        LinkedListReverser<Integer> recursiveReverser = new RecursiveLinkedListReverser<>();

        System.out.println("Iterative LinkedList Reversal:");
        System.out.print("Original: ");
        printLinkedList(head);
        SingleLinkedListNode<Integer> iterativeResult = iterativeReverser.reverseKGroup(head, 3);
        System.out.print("Reversed: ");
        printLinkedList(iterativeResult);
        System.out.println();

        System.out.println("Recursive LinkedList Reversal:");
        System.out.print("Original: ");
        printLinkedList(head);
        SingleLinkedListNode<Integer> recursiveResult = recursiveReverser.reverseKGroup(head, 4);
        System.out.print("Reversed: ");
        printLinkedList(recursiveResult);
    }
}
Nesse exemplo, a classe Main cria uma lista encadeada de nós de teste (1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8). Em seguida, são instanciadas as implementações IterativeLinkedListReverser e RecursiveLinkedListReverser.

Os casos de teste são executados chamando o método reverseKGroup para reverter a lista em grupos de tamanhos diferentes. Os resultados são impressos utilizando a função printLinkedList.

Ao executar a classe Main, você verá o resultado da reversão dos nós da lista encadeada para cada implementação, tanto a iterativa quanto a recursiva.
