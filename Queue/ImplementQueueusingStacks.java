/*
 * 232. Implement Queue using Stacks
Easy
6K
354
Companies
Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

Implement the MyQueue class:

void push(int x) Pushes element x to the back of the queue.
int pop() Removes the element from the front of the queue and returns it.
int peek() Returns the element at the front of the queue.
boolean empty() Returns true if the queue is empty, false otherwise.
Notes:

You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.
 

Example 1:

Input
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 1, 1, false]

Explanation
MyQueue myQueue = new MyQueue();
myQueue.push(1); // queue is: [1]
myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
myQueue.peek(); // return 1
myQueue.pop(); // return 1, queue is [2]
myQueue.empty(); // return false
 */

 import java.util.Stack;

class MyQueue {
    private Stack<Integer> inputStack;
    private Stack<Integer> outputStack;

    public MyQueue() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    public void push(int x) {
        // Empilha o elemento no stack de entrada
        inputStack.push(x);
    }

    public int pop() {
        // Verifica se o stack de saída está vazio
        // Se estiver vazio, transfere os elementos do stack de entrada para o stack de saída
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        // Remove o elemento do stack de saída (que agora é o elemento mais antigo)
        return outputStack.pop();
    }

    public int peek() {
        // Verifica se o stack de saída está vazio
        // Se estiver vazio, transfere os elementos do stack de entrada para o stack de saída
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        // Retorna o elemento do stack de saída (que é o elemento mais antigo sem removê-lo)
        return outputStack.peek();
    }

    public boolean empty() {
        // Verifica se ambos os stacks estão vazios
        return inputStack.isEmpty() && outputStack.isEmpty();
    }
}

public class ImplementQueueusingStacks {
    public static void main(String[] args) {
        // Cria uma instância do objeto MyQueue
        MyQueue queue = new MyQueue();

        // Teste com algumas operações de fila
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());  // Deve retornar 1
        System.out.println(queue.pop());   // Deve retornar 1
        System.out.println(queue.empty()); // Deve retornar false
    }
}

/*
 * Neste código, a classe MyQueue é responsável por implementar uma fila usando duas pilhas (Stack). A pilha inputStack é usada para adicionar elementos à fila, enquanto a pilha outputStack é usada para remover elementos da fila.

O construtor MyQueue() inicializa as duas pilhas vazias.

O método push(int x) adiciona um elemento x à fila, empilhando-o no inputStack.

O método pop() remove e retorna o elemento mais antigo da fila. Antes de fazer isso, verifica-se se o outputStack está vazio. Se estiver vazio, todos os elementos do inputStack são transferidos para o outputStack na ordem inversa, para que o elemento mais antigo fique no topo do outputStack. Em seguida, o elemento é removido do outputStack.

O método peek() retorna o elemento mais antigo da fila sem removê-lo. Novamente, verifica-se se o outputStack está vazio e, se estiver, transfere os elementos do inputStack para o outputStack. Em seguida, retorna-se o elemento do topo do outputStack sem removê-lo.

O método empty() verifica se ambas as pilhas (inputStack e outputStack) estão vazias e retorna true se estiverem vaz
 */