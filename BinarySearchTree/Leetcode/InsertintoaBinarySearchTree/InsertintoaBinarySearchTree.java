package InsertintoaBinarySearchTree;

public class InsertintoaBinarySearchTree {
  
}
/*Aqui está uma maneira de implementar a interface e a função solicitada.

1. Primeiro, atualizamos a interface `BSTSolution` para incluir o método `insertIntoBST`:

```java
public interface BSTSolution extends BT<Integer> {
    BSTNode<Integer> searchBST(BSTNode<Integer> root, Integer val);
    BSTNode<Integer> insertIntoBST(BSTNode<Integer> root, Integer val);
}
```

2. Em seguida, implementamos a interface `BSTSolution` na classe `BSTImpl`:

```java
public class BSTImpl extends BSTNode<Integer> implements BSTSolution {

    // Implementação dos outros métodos de BT<Integer> vai aqui...

    @Override
    public BSTNode<Integer> searchBST(BSTNode<Integer> root, Integer val) {
        // Implementação existente...
    }

    @Override
    public BSTNode<Integer> insertIntoBST(BSTNode<Integer> root, Integer val) {
        if (root == null || root.isEmpty()) {
            BSTNode<Integer> newNode = new BSTNode<>();
            newNode.setData(val);
            return newNode;
        }

        if (val.compareTo(root.getData()) < 0) {
            root.setLeft(insertIntoBST(root.getLeft(), val));
        } else if (val.compareTo(root.getData()) > 0) {
            root.setRight(insertIntoBST(root.getRight(), val));
        }
        
        return root;
    }
}
```

3. Finalmente, em `BSTInteger`, você pode agora usar o método `insertIntoBST`.

```java
public class BSTInteger extends BSTImpl {

    // Implementação existente...
    // ...

    public void insertIntoBST(Integer val) {
        setRoot(insertIntoBST(getRoot(), val));
    }
}
```

O método `insertIntoBST` adiciona um novo nó à árvore binária de busca. Se a raiz for nula ou vazia, cria um novo nó com o valor fornecido e o retorna. Caso contrário, compara o valor com o dado no nó raiz. Se o valor for menor, chama recursivamente o método `insertIntoBST` na subárvore esquerda. Se o valor for maior, chama recursivamente o método `insertIntoBST` na subárvore direita.

A complexidade do tempo para a função `insertIntoBST` é O(N) no pior caso, onde N é o número de nós na árvore. Isso ocorreria se a árvore estiver desbalanceada, e na prática seria mais próximo de O(log N) para uma árvore balanceada. */

/*Claro, aqui está o que cada parte do código está fazendo:

**1. Interface BSTSolution:**

Estamos atualizando a interface `BSTSolution` para incluir um novo método chamado `insertIntoBST`. Este método recebe um `BSTNode<Integer>` chamado `root` e um `Integer` chamado `val` como argumentos. Ele retorna um `BSTNode<Integer>`. Qualquer classe que implementar `BSTSolution` agora precisará implementar este método.

```java
public interface BSTSolution extends BT<Integer> {
    BSTNode<Integer> searchBST(BSTNode<Integer> root, Integer val);
    BSTNode<Integer> insertIntoBST(BSTNode<Integer> root, Integer val);
}
```

**2. Classe BSTImpl:**

Na classe `BSTImpl`, implementamos a interface `BSTSolution`. Esta classe também estende `BSTNode<Integer>`, ou seja, é uma árvore binária de busca que mantém dados do tipo `Integer`.

Estamos implementando o método `insertIntoBST` aqui. Este método insere um novo nó com um valor específico (`val`) na árvore binária de busca.

- Se o nó raiz fornecido (`root`) for nulo ou vazio, criamos um novo nó com o valor `val` e o retornamos.

- Se `val` for menor que o valor no nó raiz, chamamos recursivamente `insertIntoBST` na subárvore esquerda do nó raiz, passando a subárvore esquerda e `val` como argumentos. Definimos a subárvore esquerda do nó raiz como o resultado desta chamada recursiva.

- Se `val` for maior que o valor no nó raiz, fazemos algo semelhante com a subárvore direita do nó raiz.

- No final, retornamos o nó raiz. Se tivermos inserido um novo nó em algum lugar na árvore, a estrutura da árvore abaixo do nó raiz terá sido atualizada apropriadamente devido às chamadas recursivas.

```java
public class BSTImpl extends BSTNode<Integer> implements BSTSolution {
    
    // Outros métodos da interface BT<Integer>...

    @Override
    public BSTNode<Integer> searchBST(BSTNode<Integer> root, Integer val) {
        // Implementação existente...
    }

    @Override
    public BSTNode<Integer> insertIntoBST(BSTNode<Integer> root, Integer val) {
        // Corpo do método...
    }
}
```

**3. Classe BSTInteger:**

Na classe `BSTInteger`, que estende `BSTImpl`, adicionamos um método `insertIntoBST` que aceita apenas um valor e chama o método `insertIntoBST` da superclasse `BSTImpl` com o nó raiz da árvore e o valor fornecido.

```java
public class BSTInteger extends BSTImpl {

    // Outros métodos...

    public void insertIntoBST(Integer val) {
        setRoot(insertIntoBST(getRoot(), val));
    }
}
```

Em suma, este código permite inserir um valor em uma árvore binária de busca. Ele utiliza a recursão e não usa memória extra, atendendo às suas restrições. A complexidade do tempo é O(N) no pior caso, onde N é o número de nós na árvore.
 */