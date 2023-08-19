package SortList.Interface;

Com base na classe SingleLinkedListNode<T> fornecida, podemos criar uma interface para a questão do LeetCode que utilize os métodos da classe. Aqui está a interface SortList:

java
Copy code
public interface SortList<T> {
    SingleLinkedListNode<T> sortList(SingleLinkedListNode<T> head);
}
Essa interface define um método sortList que recebe um nó de lista encadeada head e retorna o nó da lista ordenada.

Aqui está a implementação da interface SortList tanto de forma iterativa quanto de forma recursiva, utilizando os métodos da classe SingleLinkedListNode<T>:

Implementação Iterativa:

java
Copy code
class Solution implements SortList<Integer> {
    public SingleLinkedListNode<Integer> sortList(SingleLinkedListNode<Integer> head) {
        if (head == null || head.getNext() == null)
            return head;

        // Obter o tamanho da lista
        int length = getLength(head);

        // Criar um nó fictício para ser o início da lista
        SingleLinkedListNode<Integer> dummy = new SingleLinkedListNode<>();
        dummy.setNext(head);

        // Dividir a lista em sub-listas e realizar a mesclagem iterativamente
        for (int step = 1; step < length; step *= 2) {
            SingleLinkedListNode<Integer> prev = dummy;
            SingleLinkedListNode<Integer> curr = dummy.getNext();

            while (curr != null) {
                SingleLinkedListNode<Integer> left = curr;
                SingleLinkedListNode<Integer> right = split(left, step);
                curr = split(right, step);
                prev = merge(left, right, prev);
            }
        }

        return dummy.getNext();
    }

    // Obter o tamanho da lista
    private int getLength(SingleLinkedListNode<Integer> head) {
        int length = 0;
        SingleLinkedListNode<Integer> curr = head;
        while (curr != null) {
            length++;
            curr = curr.getNext();
        }
        return length;
    }

    // Dividir a lista em duas sub-listas com o tamanho especificado
    private SingleLinkedListNode<Integer> split(SingleLinkedListNode<Integer> head, int size) {
        if (head == null)
            return null;

        SingleLinkedListNode<Integer> curr = head;
        for (int i = 1; i < size && curr.getNext() != null; i++) {
            curr = curr.getNext();
        }

        SingleLinkedListNode<Integer> right = curr.getNext();
        curr.setNext(null);
        return right;
    }

    // Mesclar duas sub-listas ordenadas e retornar o último nó mesclado
    private SingleLinkedListNode<Integer> merge(SingleLinkedListNode<Integer> left, SingleLinkedListNode<Integer> right, SingleLinkedListNode<Integer> prev) {
        SingleLinkedListNode<Integer> curr = prev;

        while (left != null && right != null) {
            if (left.getData() < right.getData()) {
                curr.setNext(left);
                left = left.getNext();
            } else {
                curr.setNext(right);
                right = right.getNext();
            }
            curr = curr.getNext();
        }

        curr.setNext((left != null) ? left : right);
        while (curr.getNext() != null) {
            curr = curr.getNext();
        }

        return curr;
    }
}
Implementação Recursiva:

java
Copy code
class Solution implements SortList<Integer> {
    public SingleLinkedListNode<Integer> sortList(SingleLinkedListNode<Integer> head) {
        if (head == null || head.getNext() == null)
            return head;

        // Dividir a lista em duas partes
        SingleLinkedListNode<Integer> mid = getMid(head);
        SingleLinkedListNode<Integer> left = head;
        SingleLinkedListNode<Integer> right = mid.getNext();
        mid.setNext(null);

        // Ordenar recursivamente as duas partes
        SingleLinkedListNode<Integer> sortedLeft = sortList(left);
        SingleLinkedListNode<Integer> sortedRight = sortList(right);

        // Mesclar as duas partes ordenadas
        return merge(sortedLeft, sortedRight);
    }

    // Encontrar o nó do meio da lista
    private SingleLinkedListNode<Integer> getMid(SingleLinkedListNode<Integer> head) {
        SingleLinkedListNode<Integer> slow = head;
        SingleLinkedListNode<Integer> fast = head;

        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        return slow;
    }

    // Mesclar duas listas ordenadas e retornar a cabeça da lista mesclada
    private SingleLinkedListNode<Integer> merge(SingleLinkedListNode<Integer> left, SingleLinkedListNode<Integer> right) {
        SingleLinkedListNode<Integer> dummy = new SingleLinkedListNode<>();
        SingleLinkedListNode<Integer> curr = dummy;

        while (left != null && right != null) {
            if (left.getData() < right.getData()) {
                curr.setNext(left);
                left = left.getNext();
            } else {
                curr.setNext(right);
                right = right.getNext();
            }
            curr = curr.getNext();
        }

        if (left != null)
            curr.setNext(left);
        if (right != null)
            curr.setNext(right);

        return dummy.getNext();
    }
}
Essas implementações utilizam os métodos da classe SingleLinkedListNode<T> para realizar as operações necessárias, como obter o tamanho da lista, dividir a lista em partes menores e mesclar as partes ordenadas. A implementação iterativa utiliza loops para realizar a divisão e mesclagem das sublistas, enquanto a implementação recursiva divide a lista de forma recursiva até que cada parte contenha apenas um elemento, e em seguida, realiza a mesclagem recursiva das partes ordenadas.

Note que a implementação assume que a classe SingleLinkedListNode<T> possui os métodos getData(), getNext(), setNext(SingleLinkedListNode<T> next), isNIL(), toString(), equals(Object obj), setData(T data), que são usados nos respectivos métodos implementados na classe Solution.

Aqui está a classe Main com o print de alguns casos de teste utilizando as classes que implementaram a interface SortList:

java
Copy code
public class Main {
    public static void main(String[] args) {
        // Caso de teste 1: [4,2,1,3]
        SingleLinkedListNode<Integer> head1 = new SingleLinkedListNode<>(4, null);
        head1.setNext(new SingleLinkedListNode<>(2, null));
        head1.getNext().setNext(new SingleLinkedListNode<>(1, null));
        head1.getNext().getNext().setNext(new SingleLinkedListNode<>(3, null));
        
        Solution solution1 = new Solution();
        SingleLinkedListNode<Integer> sorted1 = solution1.sortList(head1);
        printList(sorted1); // Resultado esperado: 1 -> 2 -> 3 -> 4

        // Caso de teste 2: [-1,5,3,4,0]
        SingleLinkedListNode<Integer> head2 = new SingleLinkedListNode<>(-1, null);
        head2.setNext(new SingleLinkedListNode<>(5, null));
        head2.getNext().setNext(new SingleLinkedListNode<>(3, null));
        head2.getNext().getNext().setNext(new SingleLinkedListNode<>(4, null));
        head2.getNext().getNext().getNext().setNext(new SingleLinkedListNode<>(0, null));
        
        Solution solution2 = new Solution();
        SingleLinkedListNode<Integer> sorted2 = solution2.sortList(head2);
        printList(sorted2); // Resultado esperado: -1 -> 0 -> 3 -> 4 -> 5
    }

    // Método auxiliar para imprimir a lista encadeada
    private static void printList(SingleLinkedListNode<Integer> head) {
        SingleLinkedListNode<Integer> curr = head;
        while (curr != null) {
            System.out.print(curr.getData() + " ");
            curr = curr.getNext();
        }
        System.out.println();
    }
}
Nesse exemplo, criamos dois casos de teste, cada um representando uma lista encadeada com números inteiros. Em seguida, instanciamos a classe Solution e chamamos o método sortList para ordenar as listas encadeadas. Por fim, utilizamos o método printList para imprimir os elementos das listas ordenadas.

Certifique-se de que as classes SingleLinkedListNode<T>, Solution e Main estejam corretamente definidas em seu código. Os casos de teste fornecidos são apenas exemplos simples, você pode adicionar mais casos de teste conforme necessário.