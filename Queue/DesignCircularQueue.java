/*
 * 622. Design Circular Queue

Design your implementation of the circular queue. The circular queue is a linear data structure in which the operations are performed based on FIFO (First In First Out) principle, and the last position is connected back to the first position to make a circle. It is also called "Ring Buffer".

One of the benefits of the circular queue is that we can make use of the spaces in front of the queue. In a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space in front of the queue. But using the circular queue, we can use the space to store new values.

Implement the MyCircularQueue class:

MyCircularQueue(k) Initializes the object with the size of the queue to be k.
int Front() Gets the front item from the queue. If the queue is empty, return -1.
int Rear() Gets the last item from the queue. If the queue is empty, return -1.
boolean enQueue(int value) Inserts an element into the circular queue. Return true if the operation is successful.
boolean deQueue() Deletes an element from the circular queue. Return true if the operation is successful.
boolean isEmpty() Checks whether the circular queue is empty or not.
boolean isFull() Checks whether the circular queue is full or not.
You must solve the problem without using the built-in queue data structure in your programming language. 

 

Example 1:

Input
["MyCircularQueue", "enQueue", "enQueue", "enQueue", "enQueue", "Rear", "isFull", "deQueue", "enQueue", "Rear"]
[[3], [1], [2], [3], [4], [], [], [], [4], []]
Output
[null, true, true, true, false, 3, true, true, true, 4]

Explanation
MyCircularQueue myCircularQueue = new MyCircularQueue(3);
myCircularQueue.enQueue(1); // return True
myCircularQueue.enQueue(2); // return True
myCircularQueue.enQueue(3); // return True
myCircularQueue.enQueue(4); // return False
myCircularQueue.Rear();     // return 3
myCircularQueue.isFull();   // return True
myCircularQueue.deQueue();  // return True
myCircularQueue.enQueue(4); // return True
myCircularQueue.Rear();     // return 4
 */

 class MyCircularQueue {
  private int[] queue;
  private int front; // Índice da frente da fila
  private int rear; // Índice do final da fila
  private int size; // Tamanho atual da fila
  private int capacity; // Capacidade máxima da fila

  public MyCircularQueue(int k) {
      capacity = k;
      queue = new int[capacity];
      front = -1;
      rear = -1;
      size = 0;
  }

  public boolean enQueue(int value) {
      // Verifica se a fila está cheia
      if (isFull())
          return false;

      // Calcula o novo índice do final da fila
      rear = (rear + 1) % capacity;

      // Insere o novo valor no final da fila
      queue[rear] = value;

      // Atualiza o índice da frente se a fila estiver vazia
      if (isEmpty())
          front = rear;

      // Incrementa o tamanho da fila
      size++;

      return true;
  }

  public boolean deQueue() {
      // Verifica se a fila está vazia
      if (isEmpty())
          return false;

      // Remove o elemento da frente da fila
      front = (front + 1) % capacity;

      // Decrementa o tamanho da fila
      size--;

      // Verifica se a fila ficou vazia
      if (isEmpty()) {
          front = -1;
          rear = -1;
      }

      return true;
  }

  public int Front() {
      // Retorna o elemento da frente da fila
      if (isEmpty())
          return -1;

      return queue[front];
  }

  public int Rear() {
      // Retorna o elemento do final da fila
      if (isEmpty())
          return -1;

      return queue[rear];
  }

  public boolean isEmpty() {
      // Verifica se a fila está vazia
      return size == 0;
  }

  public boolean isFull() {
      // Verifica se a fila está cheia
      return size == capacity;
  }
}

public class DesignCircularQueue {
  public static void main(String[] args) {
      // Cria uma instância do objeto MyCircularQueue com capacidade 3
      MyCircularQueue circularQueue = new MyCircularQueue(3);

      // Teste com algumas operações na fila circular
      System.out.println(circularQueue.enQueue(1)); // Deve retornar true
      System.out.println(circularQueue.enQueue(2)); // Deve retornar true
      System.out.println(circularQueue.enQueue(3)); // Deve retornar true
      System.out.println(circularQueue.enQueue(4)); // Deve retornar false (a fila está cheia)
      System.out.println(circularQueue.Rear()); // Deve retornar 3
      System.out.println(circularQueue.isFull()); // Deve retornar true
      System.out.println(circularQueue.deQueue()); // Deve retornar true
      System.out.println(circularQueue.enQueue(4)); // Deve retornar true
      System.out.println(circularQueue.Rear()); // Deve retornar 4
  }
}
