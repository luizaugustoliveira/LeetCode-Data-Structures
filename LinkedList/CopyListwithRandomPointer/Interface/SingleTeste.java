package CopyListwithRandomPointer.Interface;

Aqui está a interface que utiliza os métodos da classe SingleLinkedListNode<T> para representar a questão "Copy List with Random Pointer" do LeetCode:

java
Copy code
public interface CopyListWithRandomPointer<T> {
    /**
     * Copy the given linked list with random pointer.
     *
     * @param head The head node of the linked list to be copied.
     * @return The head node of the copied linked list.
     */
    SingleLinkedListNode<T> copyRandomList(SingleLinkedListNode<T> head);
}
Explicação:

A interface CopyListWithRandomPointer<T> define um contrato para a cópia de uma lista ligada com ponteiro aleatório.

O método copyRandomList recebe o nó inicial da lista ligada e retorna o nó inicial da lista copiada.

A interface utiliza a classe SingleLinkedListNode<T> para representar os nós da lista ligada. Os métodos getData, getNext, setData e setNext são usados para acessar e modificar os dados e os ponteiros dos nós.

Dessa forma, essa interface pode ser implementada em uma classe concreta, como a CopyListWithRandomPointerImpl, onde os métodos da classe SingleLinkedListNode<T> serão utilizados para implementar a lógica de cópia da lista ligada com ponteiro aleatório.

Aqui está a implementação da interface CopyListWithRandomPointer<T> de forma iterativa e recursiva, utilizando os métodos da classe SingleLinkedListNode<T>:

java
Copy code
import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointerImpl<T> implements CopyListWithRandomPointer<T> {

    // Implementação iterativa
    public SingleLinkedListNode<T> copyRandomListIterative(SingleLinkedListNode<T> head) {
        if (head == null) {
            return null;
        }

        Map<SingleLinkedListNode<T>, SingleLinkedListNode<T>> map = new HashMap<>();

        SingleLinkedListNode<T> curr = head;
        SingleLinkedListNode<T> dummy = new SingleLinkedListNode<>();
        SingleLinkedListNode<T> prev = dummy;

        while (curr != null) {
            SingleLinkedListNode<T> copy = new SingleLinkedListNode<>(curr.getData(), null);
            map.put(curr, copy);
            prev.setNext(copy);
            prev = copy;
            curr = curr.getNext();
        }

        curr = head;
        while (curr != null) {
            SingleLinkedListNode<T> copy = map.get(curr);
            copy.setRandom(map.get(curr.getRandom()));
            curr = curr.getNext();
        }

        return dummy.getNext();
    }

    // Implementação recursiva
    public SingleLinkedListNode<T> copyRandomListRecursive(SingleLinkedListNode<T> head) {
        Map<SingleLinkedListNode<T>, SingleLinkedListNode<T>> map = new HashMap<>();
        return copyRandomListRecursiveHelper(head, map);
    }

    private SingleLinkedListNode<T> copyRandomListRecursiveHelper(SingleLinkedListNode<T> node, Map<SingleLinkedListNode<T>, SingleLinkedListNode<T>> map) {
        if (node == null) {
            return null;
        }

        if (map.containsKey(node)) {
            return map.get(node);
        }

        SingleLinkedListNode<T> copy = new SingleLinkedListNode<>(node.getData(), null);
        map.put(node, copy);

        copy.setNext(copyRandomListRecursiveHelper(node.getNext(), map));
        copy.setRandom(copyRandomListRecursiveHelper(node.getRandom(), map));

        return copy;
    }
}
Explicação:

A classe CopyListWithRandomPointerImpl<T> implementa a interface CopyListWithRandomPointer<T> e fornece implementações para os métodos copyRandomListIterative e copyRandomListRecursive.

A implementação iterativa copyRandomListIterative utiliza um mapa para mapear os nós originais para suas respectivas cópias. O algoritmo percorre a lista original, cria cópias de cada nó e as liga em uma nova lista. Em seguida, percorre novamente a lista original para atualizar os ponteiros aleatórios das cópias. Por fim, retorna o nó inicial da lista copiada.

A implementação recursiva copyRandomListRecursive utiliza um mapa para mapear os nós originais para suas respectivas cópias. O método copyRandomListRecursiveHelper é chamado recursivamente para criar as cópias dos nós e configurar os ponteiros aleatórios. A recursão ocorre até que todos os nós da lista original tenham sido copiados. A função retorna o nó inicial da lista copiada.

Ambas as implementações fazem uso dos métodos da classe SingleLinkedListNode<T> para criar cópias dos nós, configurar os ponteiros next e random e obter os valores dos nós originais e cópias.

Aqui está a classe Main com alguns casos de teste para as implementações da interface CopyListWithRandomPointer<T>:

java
Copy code
public class Main {
    public static void main(String[] args) {
        // Caso de teste 1: Lista vazia
        SingleLinkedListNode<Integer> list1 = new SingleLinkedListNode<>();
        CopyListWithRandomPointer<Integer> copyList1 = new CopyListWithRandomPointerImpl<>();
        SingleLinkedListNode<Integer> copy1Iterative = copyList1.copyRandomListIterative(list1);
        SingleLinkedListNode<Integer> copy1Recursive = copyList1.copyRandomListRecursive(list1);

        System.out.println("Caso de teste 1 - Lista vazia:");
        System.out.println("Lista original: " + list1);
        System.out.println("Cópia iterativa: " + copy1Iterative);
        System.out.println("Cópia recursiva: " + copy1Recursive);
        System.out.println();

        // Caso de teste 2: Lista com 3 elementos e ponteiros aleatórios
        SingleLinkedListNode<Integer> node1 = new SingleLinkedListNode<>(1, null);
        SingleLinkedListNode<Integer> node2 = new SingleLinkedListNode<>(2, null);
        SingleLinkedListNode<Integer> node3 = new SingleLinkedListNode<>(3, null);
        node1.setNext(node2);
        node2.setNext(node3);
        node1.setRandom(node3);
        node2.setRandom(node1);

        SingleLinkedListNode<Integer> list2 = node1;

        CopyListWithRandomPointer<Integer> copyList2 = new CopyListWithRandomPointerImpl<>();
        SingleLinkedListNode<Integer> copy2Iterative = copyList2.copyRandomListIterative(list2);
        SingleLinkedListNode<Integer> copy2Recursive = copyList2.copyRandomListRecursive(list2);

        System.out.println("Caso de teste 2 - Lista com 3 elementos e ponteiros aleatórios:");
        System.out.println("Lista original: " + list2);
        System.out.println("Cópia iterativa: " + copy2Iterative);
        System.out.println("Cópia recursiva: " + copy2Recursive);
        System.out.println();
    }
}
Explicação:

Na classe Main, temos dois casos de teste para demonstrar o funcionamento das implementações da interface CopyListWithRandomPointer<T>.

O primeiro caso de teste cria uma lista vazia e realiza a cópia tanto de forma iterativa quanto recursiva. Em seguida, imprime a lista original e as cópias.

O segundo caso de teste cria uma lista com 3 elementos e configura ponteiros aleatórios entre eles. Realiza a cópia da lista tanto de forma iterativa quanto recursiva e imprime a lista original e as cópias.

Os resultados são impressos no console para verificar se as cópias foram feitas corretamente.

Dessa forma, você pode executar a classe Main para testar as implementações da interface CopyListWithRandomPointer<T> com os casos de teste fornecidos.
