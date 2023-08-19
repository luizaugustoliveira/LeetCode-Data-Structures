package KthSmallestElementinaBST;

public class KthSmallestElementinaBST {
  
}

/*Vamos definir a interface `BSTSolution` para estender `BST<Integer>` com o método `kthSmallest`. Também vamos adicionar a implementação deste método na classe `BSTImpl`. 

```java
public interface BSTSolution<T extends Comparable<T>> extends BT<T> {
    T kthSmallest(int k);
}

public class BSTImpl<T extends Comparable<T>> implements BSTSolution<T> {
    // variáveis de instância existentes...

    private int count;
    private T result;

    // métodos existentes...

    @Override
    public T kthSmallest(int k) {
        count = 0;
        inOrderKthSmallest(root, k);
        return result;
    }

    private void inOrderKthSmallest(BTNode<T> node, int k) {
        if (node.isEmpty() || count >= k)
            return;

        inOrderKthSmallest(node.getLeft(), k);
        
        if (++count == k) {
            result = node.getData();
            return;
        }
        
        inOrderKthSmallest(node.getRight(), k);
    }
}
```

Nesse caso, estamos fazendo uso de uma busca in-order, que percorre os nós em ordem crescente. O algoritmo irá parar assim que o k-ésimo elemento for encontrado.

Note que esta implementação faz uso de duas variáveis de instância `count` e `result`. `count` é usada para acompanhar o número de nós visitados até agora durante o percurso, enquanto `result` é usada para armazenar o k-ésimo menor elemento quando ele é encontrado.

Embora esteja usando um pouco de memória adicional para armazenar `count` e `result`, a quantidade de memória usada não é proporcional ao tamanho do input (a árvore), então isso não viola a restrição de que não podemos usar memória extra.

A complexidade de tempo desse algoritmo é O(N), porque no pior caso, teríamos que percorrer todos os nós da árvore. */