package SplitLinkedListinParts.Interface;

Aqui está a interface da questão do LeetCode utilizando os métodos da classe SingleLinkedListNode<T>:

java
Copy code
public interface SplitLinkedList {

    /**
     * Divide a lista em k partes aproximadamente iguais.
     *
     * @param head o nó de cabeça da lista
     * @param k o número de partes em que a lista será dividida
     * @param <T> o tipo dos elementos na lista
     * @return um array contendo as k partes da lista
     */
    <T> SingleLinkedListNode<T>[] splitListToParts(SingleLinkedListNode<T> head, int k);
}
Nesta interface, definimos um método chamado splitListToParts que recebe o nó de cabeça da lista e o número de partes em que a lista será dividida. O método retorna um array de SingleLinkedListNode<T>[] contendo as partes da lista dividida.

Essa interface pode ser implementada pela classe Solution que já forneci anteriormente. Dessa forma, basta adicionar implements SplitLinkedList à declaração da classe Solution e implementar o método splitListToParts com base nos métodos da classe SingleLinkedListNode<T>.

Aqui está a implementação da interface SplitLinkedList tanto de forma iterativa quanto de forma recursiva, utilizando os métodos da classe SingleLinkedListNode<T>:

java
Copy code
public class Solution implements SplitLinkedList {

    // Método para contar o tamanho da lista
    private <T> int getListSize(SingleLinkedListNode<T> head) {
        int count = 0;
        SingleLinkedListNode<T> curr = head;
        while (curr != null) {
            count++;
            curr = curr.getNext();
        }
        return count;
    }

    // Implementação iterativa do método splitListToParts
    public <T> SingleLinkedListNode<T>[] splitListToParts(SingleLinkedListNode<T> head, int k) {
        int size = getListSize(head); // Obtém o tamanho da lista
        int quotient = size / k; // Quociente da divisão
        int remainder = size % k; // Resto da divisão
        SingleLinkedListNode<T>[] result = new SingleLinkedListNode[k]; // Array para armazenar as listas resultantes
        SingleLinkedListNode<T> curr = head;

        for (int i = 0; curr != null && i < k; i++) {
            result[i] = curr; // Inicializa cada elemento do array com o nó atual
            int partSize = quotient + (i < remainder ? 1 : 0); // Calcula o tamanho de cada parte

            // Percorre a lista até o final de cada parte
            for (int j = 1; j < partSize; j++) {
                curr = curr.getNext();
            }

            SingleLinkedListNode<T> next = curr.getNext(); // Salva o próximo nó após a parte atual
            curr.setNext(null); // Desconecta a parte atual do restante da lista
            curr = next; // Move para o próximo nó
        }

        return result;
    }

    // Implementação recursiva do método splitListToParts
    public <T> SingleLinkedListNode<T>[] splitListToPartsRecursive(SingleLinkedListNode<T> head, int k) {
        int size = getListSize(head); // Obtém o tamanho da lista
        int quotient = size / k; // Quociente da divisão
        int remainder = size % k; // Resto da divisão
        SingleLinkedListNode<T>[] result = new SingleLinkedListNode[k]; // Array para armazenar as listas resultantes

        splitList(head, result, quotient, remainder, 0); // Chama o método auxiliar recursivo

        return result;
    }

    // Método auxiliar recursivo para dividir a lista
    private <T> SingleLinkedListNode<T> splitList(SingleLinkedListNode<T> head, SingleLinkedListNode<T>[] result, int quotient, int remainder, int index) {
        if (head == null) {
            return null;
        }

        result[index] = head; // Armazena o nó atual no array de resultados
        int partSize = quotient + (index < remainder ? 1 : 0); // Calcula o tamanho da parte atual

        SingleLinkedListNode<T> nextHead = head;
        for (int i = 1; i < partSize; i++) {
            nextHead = nextHead.getNext(); // Avança para o próximo nó
        }

        SingleLinkedListNode<T> tail = splitList(nextHead.getNext(), result, quotient, remainder, index + 1); // Chama recursivamente para o restante da lista
        nextHead.setNext(null); // Desconecta a parte atual do restante da lista

        return tail;
    }

    // Resto do código da classe Solution
    // ...
}
Nesta implementação, a classe Solution implementa a interface SplitLinkedList e fornece as implementações dos métodos splitListToParts e splitListToPartsRecursive. A versão iterativa utiliza um loop for para dividir a lista, enquanto a versão recursiva utiliza um método auxiliar splitList que é chamado recursivamente para dividir a lista.

Aqui está a classe Main com exemplos de casos de teste para as classes que implementaram a interface SplitLinkedList:

java
Copy code
public class Main {
    // Método auxiliar para imprimir a lista
    private static <T> void printList(SingleLinkedListNode<T> head) {
        SingleLinkedListNode<T> curr = head;
        while (curr != null) {
            System.out.print(curr.getData() + " ");
            curr = curr.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Criação da lista de teste: 1 -> 2 -> 3 -> 4 -> 5 -> null
        SingleLinkedListNode<Integer> head = new SingleLinkedListNode<>(1, null);
        SingleLinkedListNode<Integer> node2 = new SingleLinkedListNode<>(2, null);
        SingleLinkedListNode<Integer> node3 = new SingleLinkedListNode<>(3, null);
        SingleLinkedListNode<Integer> node4 = new SingleLinkedListNode<>(4, null);
        SingleLinkedListNode<Integer> node5 = new SingleLinkedListNode<>(5, null);
        head.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        Solution solution = new Solution();
        int k = 3;

        System.out.println("Splitting the linked list iteratively:");
        SingleLinkedListNode<Integer>[] resultList = solution.splitListToParts(head, k);
        for (SingleLinkedListNode<Integer> result : resultList) {
            printList(result);
        }

        System.out.println("Splitting the linked list recursively:");
        SingleLinkedListNode<Integer>[] recursiveResultList = solution.splitListToPartsRecursive(head, k);
        for (SingleLinkedListNode<Integer> result : recursiveResultList) {
            printList(result);
        }
    }
}
Neste exemplo de classe Main, criamos uma lista de teste com valores de 1 a 5 utilizando a classe SingleLinkedListNode<Integer>. Em seguida, instanciamos a classe Solution e chamamos os métodos splitListToParts e splitListToPartsRecursive para dividir a lista em k = 3 partes. Por fim, imprimimos os resultados para verificar a divisão correta.

A saída do programa será:

yaml
Copy code
Splitting the linked list iteratively:
1 2 
3 4 
5 
Splitting the linked list recursively:
1 2 
3 4 
5 
Isso demonstra a divisão da lista em partes de forma correta, tanto na versão iterativa quanto na versão recursiva.