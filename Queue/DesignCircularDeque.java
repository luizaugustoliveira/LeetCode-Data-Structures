/*
 * 
 * 
 * 641. Design Circular Deque

Design your implementation of the circular double-ended queue (deque).

Implement the MyCircularDeque class:

MyCircularDeque(int k) Initializes the deque with a maximum size of k.
boolean insertFront() Adds an item at the front of Deque. Returns true if the operation is successful, or false otherwise.
boolean insertLast() Adds an item at the rear of Deque. Returns true if the operation is successful, or false otherwise.
boolean deleteFront() Deletes an item from the front of Deque. Returns true if the operation is successful, or false otherwise.
boolean deleteLast() Deletes an item from the rear of Deque. Returns true if the operation is successful, or false otherwise.
int getFront() Returns the front item from the Deque. Returns -1 if the deque is empty.
int getRear() Returns the last item from Deque. Returns -1 if the deque is empty.
boolean isEmpty() Returns true if the deque is empty, or false otherwise.
boolean isFull() Returns true if the deque is full, or false otherwise.
 

Example 1:

Input
["MyCircularDeque", "insertLast", "insertLast", "insertFront", "insertFront", "getRear", "isFull", "deleteLast", "insertFront", "getFront"]
[[3], [1], [2], [3], [4], [], [], [], [4], []]
Output
[null, true, true, true, false, 2, true, true, true, 4]

Explanation
MyCircularDeque myCircularDeque = new MyCircularDeque(3);
myCircularDeque.insertLast(1);  // return True
myCircularDeque.insertLast(2);  // return True
myCircularDeque.insertFront(3); // return True
myCircularDeque.insertFront(4); // return False, the queue is full.
myCircularDeque.getRear();      // return 2
myCircularDeque.isFull();       // return True
myCircularDeque.deleteLast();   // return True
myCircularDeque.insertFront(4); // return True
myCircularDeque.getFront();     // return 4
 */

 class MyCircularDeque {
  private int[] deque;
  private int front; // Índice da frente do deque
  private int rear; // Índice do final do deque
  private int size; // Tamanho atual do deque
  private int capacity; // Capacidade máxima do deque

  public MyCircularDeque(int k) {
      capacity = k + 1; // Adiciona 1 ao tamanho para diferenciar entre deque vazio e cheio
      deque = new int[capacity];
      front = 0;
      rear = 0;
      size = 0;
  }

  public boolean insertFront(int value) {
      // Verifica se o deque está cheio
      if (isFull())
          return false;

      // Calcula o novo índice da frente do deque
      front = (front - 1 + capacity) % capacity;

      // Insere o novo valor na frente do deque
      deque[front] = value;

      // Incrementa o tamanho do deque
      size++;

      return true;
  }

  public boolean insertLast(int value) {
      // Verifica se o deque está cheio
      if (isFull())
          return false;

      // Insere o novo valor no final do deque
      deque[rear] = value;

      // Calcula o novo índice do final do deque
      rear = (rear + 1) % capacity;

      // Incrementa o tamanho do deque
      size++;

      return true;
  }

  public boolean deleteFront() {
      // Verifica se o deque está vazio
      if (isEmpty())
          return false;

      // Calcula o novo índice da frente do deque
      front = (front + 1) % capacity;

      // Decrementa o tamanho do deque
      size--;

      return true;
  }

  public boolean deleteLast() {
      // Verifica se o deque está vazio
      if (isEmpty())
          return false;

      // Calcula o novo índice do final do deque
      rear = (rear - 1 + capacity) % capacity;

      // Decrementa o tamanho do deque
      size--;

      return true;
  }

  public int getFront() {
      // Retorna o elemento da frente do deque
      if (isEmpty())
          return -1;

      return deque[front];
  }

  public int getRear() {
      // Retorna o elemento do final do deque
      if (isEmpty())
          return -1;

      return deque[(rear - 1 + capacity) % capacity];
  }

  public boolean isEmpty() {
      // Verifica se o deque está vazio
      return size == 0;
  }

  public boolean isFull() {
      // Verifica se o deque está cheio
      return size == capacity - 1;
  }
}

public class DesignCircularDeque {
  public static void main(String[] args) {
      // Cria uma instância do objeto MyCircularDeque com capacidade 3
      MyCircularDeque circularDeque = new MyCircularDeque(3);

      // Teste com algumas operações no deque circular
      System.out.println(circularDeque.insertLast(1)); // Deve retornar true
      System.out.println(circularDeque.insertLast(2)); // Deve retornar true
      System.out.println(circularDeque.insertFront(3)); // Deve retornar true
      System.out.println(circularDeque.insertFront(4)); //
  }
}