package GeeksforGeeks.LowestCommonAncestorinaBST;

public class LowestCommonAncestorinaBST {
  
}
/*Neste problema, estamos buscando o ancestral comum mais baixo (Lowest Common Ancestor - LCA) de dois nós em uma Árvore Binária de Busca (BST). A solução para este problema é bastante direta usando a natureza da BST.

Aqui está a interface `BSTSolution` e a implementação `BSTImpl` adaptada ao problema, com as restrições especificadas.

```java
public interface BSTSolution<T extends Comparable<T>> extends BST<T> {
    BTNode<T> LCA(BTNode<T> root, T n1, T n2);
}

public class BSTImpl<T extends Comparable<T>> implements BSTSolution<T> {
    // variáveis de instância existentes...
    BTNode<T> root;

    // métodos existentes...

    @Override
    public BTNode<T> LCA(BTNode<T> node, T n1, T n2) {
        if (node == null) {
            return null;
        }

        if (node.getData().compareTo(n1) > 0 && node.getData().compareTo(n2) > 0) {
            return LCA(node.getLeft(), n1, n2);
        }

        if (node.getData().compareTo(n1) < 0 && node.getData().compareTo(n2) < 0) {
            return LCA(node.getRight(), n1, n2);
        }

        return node;
    }
}
```

Nesse código, `LCA` é um método recursivo que começa a busca a partir da raiz da BST. A busca procede da seguinte forma:

- Se os valores dos dois nós forem menores que o valor do nó atual, a função se chama recursivamente para a subárvore à esquerda.
- Se os valores dos dois nós forem maiores que o valor do nó atual, a função se chama recursivamente para a subárvore à direita.
- Caso contrário, o nó atual é o LCA dos dois nós.

Essa solução é eficiente e opera em tempo O(N) no pior caso, onde N é o número de nós na BST, porque visita cada nó uma vez no máximo. Também não usa memória extra nem converte a BST em um array, atendendo às restrições dadas. */