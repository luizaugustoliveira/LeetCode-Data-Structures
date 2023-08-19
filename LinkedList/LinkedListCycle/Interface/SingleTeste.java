package LinkedListCycle.Interface;

Aqui está a interface para a questão do LeetCode que utiliza os métodos da classe SingleLinkedListNode<T>:

java
Copy code
public interface LinkedListCycle<T> {
    /**
     * Verifica se a lista vinculada possui um ciclo.
     *
     * @param head O nó de início da lista vinculada
     * @return true se houver um ciclo, false caso contrário
     */
    boolean hasCycle(SingleLinkedListNode<T> head);
}
A interface LinkedListCycle<T> define um método hasCycle que recebe um nó de início (head) da lista vinculada e retorna um valor booleano indicando se a lista possui um ciclo.

Essa interface pode ser implementada por qualquer classe que deseje resolver o problema "Linked List Cycle" usando a estratégia que melhor se adequar às suas necessidades.

Claro! Aqui está a implementação da interface LinkedListCycle<T> de forma iterativa e recursiva:

Implementação iterativa:

java
Copy code
import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleIterative<T> implements LinkedListCycle<T> {

    @Override
    public boolean hasCycle(SingleLinkedListNode<T> head) {
        Set<SingleLinkedListNode<T>> visitedNodes = new HashSet<>();
        SingleLinkedListNode<T> currentNode = head;

        while (currentNode != null) {
            if (visitedNodes.contains(currentNode)) {
                return true;  // Encontrou um ciclo
            }
            visitedNodes.add(currentNode);
            currentNode = currentNode.getNext();
        }

        return false;  // Não encontrou ciclo
    }
}
Implementação recursiva:

java
Copy code
import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleRecursive<T> implements LinkedListCycle<T> {

    @Override
    public boolean hasCycle(SingleLinkedListNode<T> head) {
        Set<SingleLinkedListNode<T>> visitedNodes = new HashSet<>();
        return hasCycleRecursive(head, visitedNodes);
    }

    private boolean hasCycleRecursive(SingleLinkedListNode<T> node, Set<SingleLinkedListNode<T>> visitedNodes) {
        if (node == null) {
            return false;  // Alcançou o final da lista sem encontrar ciclo
        }

        if (visitedNodes.contains(node)) {
            return true;  // Encontrou um ciclo
        }

        visitedNodes.add(node);
        return hasCycleRecursive(node.getNext(), visitedNodes);
    }
}
Nas implementações acima, a classe LinkedListCycleIterative representa a solução iterativa, enquanto a classe LinkedListCycleRecursive representa a solução recursiva. Ambas as classes implementam a interface LinkedListCycle<T> e definem o método hasCycle conforme especificado na interface.

Agora você pode utilizar as implementações da seguinte forma:

java
Copy code
SingleLinkedListNode<Integer> node1 = new SingleLinkedListNode<>(1, null);
SingleLinkedListNode<Integer> node2 = new SingleLinkedListNode<>(2, null);
SingleLinkedListNode<Integer> node3 = new SingleLinkedListNode<>(3, null);
SingleLinkedListNode<Integer> node4 = new SingleLinkedListNode<>(4, null);

// Criando uma lista vinculada sem ciclo
node1.setNext(node2);
node2.setNext(node3);
node3.setNext(node4);

LinkedListCycle<Integer> iterativeSolution = new LinkedListCycleIterative<>();
System.out.println(iterativeSolution.hasCycle(node1));  // Deve imprimir: false

LinkedListCycle<Integer> recursiveSolution = new LinkedListCycleRecursive<>();
System.out.println(recursiveSolution.hasCycle(node1));  // Deve imprimir: false
Você pode criar mais casos de teste, adicionando nós e definindo os apontadores de forma apropriada para criar ciclos ou listas vinculadas sem ciclos.

Aqui está a classe Main com exemplos de casos de teste para as implementações LinkedListCycleIterative e LinkedListCycleRecursive:

java
Copy code
public class Main {
    public static void main(String[] args) {
        // Criando uma lista vinculada sem ciclo
        SingleLinkedListNode<Integer> node1 = new SingleLinkedListNode<>(1, null);
        SingleLinkedListNode<Integer> node2 = new SingleLinkedListNode<>(2, null);
        SingleLinkedListNode<Integer> node3 = new SingleLinkedListNode<>(3, null);
        SingleLinkedListNode<Integer> node4 = new SingleLinkedListNode<>(4, null);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);

        LinkedListCycle<Integer> iterativeSolution = new LinkedListCycleIterative<>();
        System.out.println("Iterative Solution:");
        System.out.println("Has cycle? " + iterativeSolution.hasCycle(node1)); // Deve imprimir: false

        LinkedListCycle<Integer> recursiveSolution = new LinkedListCycleRecursive<>();
        System.out.println("\nRecursive Solution:");
        System.out.println("Has cycle? " + recursiveSolution.hasCycle(node1)); // Deve imprimir: false

        // Criando uma lista vinculada com ciclo
        SingleLinkedListNode<Integer> node5 = new SingleLinkedListNode<>(5, null);
        SingleLinkedListNode<Integer> node6 = new SingleLinkedListNode<>(6, null);
        SingleLinkedListNode<Integer> node7 = new SingleLinkedListNode<>(7, null);
        SingleLinkedListNode<Integer> node8 = new SingleLinkedListNode<>(8, null);

        node5.setNext(node6);
        node6.setNext(node7);
        node7.setNext(node8);
        node8.setNext(node5); // Cria o ciclo

        System.out.println("\nIterative Solution:");
        System.out.println("Has cycle? " + iterativeSolution.hasCycle(node5)); // Deve imprimir: true

        System.out.println("\nRecursive Solution:");
        System.out.println("Has cycle? " + recursiveSolution.hasCycle(node5)); // Deve imprimir: true
    }
}
Neste exemplo, a classe Main cria duas listas vinculadas: uma sem ciclo (node1 a node4) e outra com ciclo (node5 a node8). Em seguida, ela utiliza as implementações LinkedListCycleIterative e LinkedListCycleRecursive para verificar se há ciclos nessas listas e imprime o resultado correspondente.

Você pode adicionar mais casos de teste para validar as implementações. Certifique-se de criar listas vinculadas com ciclos e sem ciclos para verificar o comportamento correto das implementações.
