package SearchinaBinarySearchTree;

public class SearchinaBinarySearchTree {
  
}

/*Tudo bem, levando em consideração suas solicitações, podemos ter algo assim:

1. Definimos a interface `BSTSolution` que estende a interface `BT<Integer>`. Isto é, qualquer classe que implemente `BSTSolution` também deve implementar os métodos da interface `BT<Integer>`.

```java
public interface BSTSolution extends BT<Integer> {
    BSTNode<Integer> searchBST(BSTNode<Integer> root, Integer val);
}
```

2. Implementamos a interface `BSTSolution` na classe `BSTImpl`.

```java
public class BSTImpl extends BSTNode<Integer> implements BSTSolution {

    // Implementação dos outros métodos de BT<Integer> vai aqui...

    @Override
    public BSTNode<Integer> searchBST(BSTNode<Integer> root, Integer val) {
        if (root == null || root.isEmpty()) {
            return new BSTNode<>();
        }

        int cmp = val.compareTo(root.getData());

        if (cmp == 0) {
            return root;
        } else if (cmp < 0) {
            return searchBST(root.getLeft(), val);
        } else {
            return searchBST(root.getRight(), val);
        }
    }
}
```

3. Em `BSTInteger`, você pode agora usar o método `searchBST`.

```java
public class BSTInteger extends BSTImpl {

    // Implementação existente...
    // ...

    public BSTNode<Integer> searchBST(Integer val) {
        return searchBST(getRoot(), val);
    }
}
```

Note que com essa configuração, a árvore binária é restrita a conter apenas `Integer`. Isso ocorre porque a interface `BSTSolution` estende `BT<Integer>`, e `BSTInteger` estende `BSTImpl`, que implementa `BSTSolution`. Como tal, `BSTInteger` e `BSTImpl` estão limitados a trabalhar com `Integer`.

A complexidade do tempo para a função `searchBST` é O(N) no pior caso, onde N é o número de nós na árvore. Isso ocorreria se a árvore estiver desbalanceada, e na prática seria mais próximo de O(log N) para uma árvore balanceada. */


/*Claro, vamos revisar o que está acontecendo em cada parte desse código.

**1. Interface BSTSolution:**

Aqui, estamos criando uma nova interface chamada `BSTSolution`. Esta interface estende `BT<Integer>`, o que significa que qualquer classe que implementar `BSTSolution` também deve implementar os métodos definidos em `BT<Integer>`. Além disso, estamos declarando um método `searchBST` que espera um `BSTNode<Integer>` e um valor `Integer` como argumentos.

```java
public interface BSTSolution extends BT<Integer> {
    BSTNode<Integer> searchBST(BSTNode<Integer> root, Integer val);
}
```

**2. Classe BSTImpl:**

Na classe `BSTImpl`, implementamos a interface `BSTSolution`. Esta classe também estende `BSTNode<Integer>`, ou seja, é uma árvore binária de busca que mantém dados do tipo `Integer`. Em particular, estamos implementando o método `searchBST`, que é definido na interface `BSTSolution`.

O método `searchBST` procura um valor na árvore binária de busca. Se o nó atual é nulo ou vazio, retorna um novo nó vazio. Caso contrário, compara o valor com o dado no nó atual. Se eles são iguais, retorna o nó atual. Se o valor é menor, procura recursivamente na subárvore esquerda. Se o valor é maior, procura recursivamente na subárvore direita.

```java
public class BSTImpl extends BSTNode<Integer> implements BSTSolution {
    
    // Outros métodos da interface BT<Integer>...

    @Override
    public BSTNode<Integer> searchBST(BSTNode<Integer> root, Integer val) {
        // Corpo do método...
    }
}
```

**3. Classe BSTInteger:**

A classe `BSTInteger` estende `BSTImpl`, o que significa que herda todos os métodos de `BSTImpl`, incluindo `searchBST`. Aqui, adicionamos um método `searchBST` que aceita apenas um valor e chama o método `searchBST` da superclasse `BSTImpl` com o nó raiz da árvore e o valor fornecido.

```java
public class BSTInteger extends BSTImpl {

    // Outros métodos...

    public BSTNode<Integer> searchBST(Integer val) {
        return searchBST(getRoot(), val);
    }
}
```

No geral, este código define uma interface e duas classes que permitem criar uma árvore binária de busca contendo inteiros e buscar um valor específico nessa árvore. A busca é realizada recursivamente e não usa nenhuma memória extra, cumprindo as restrições que você forneceu.
 */