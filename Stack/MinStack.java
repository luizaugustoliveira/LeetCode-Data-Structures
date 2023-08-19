/*Min Stack
Questão 155: Projetar uma pilha que suporta operações push, pop, top e recuperar o mínimo em tempo constante.

 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

 

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
 */

 //Primeira versão

 class MinStack {

  private Stack<Integer> stack;
  private Stack<Integer> minStack;

  public MinStack() {
      stack = new Stack<>();
      minStack = new Stack<>();
  }
  
  public void push(int x) {
      stack.push(x);
      if (minStack.isEmpty() || x <= minStack.peek()) {
          minStack.push(x);
      }
  }
  
  public void pop() {
      if (stack.peek().equals(minStack.peek())) {
          minStack.pop();
      }
      stack.pop();
  }
  
  public int top() {
      return stack.peek();
  }
  
  public int getMin() {
      return minStack.peek();
  }
}

// Segunda versão
class MinStack {
  private Stack<int[]> stack = new Stack<>();

  public void push(int x) {
      if (stack.isEmpty()) {
          stack.push(new int[]{x, x});
      } else {
          stack.push(new int[]{x, Math.min(x, stack.peek()[1])});
      }
  }

  public void pop() {
      stack.pop();
  }

  public int top() {
      return stack.peek()[0];
  }

  public int getMin() {
      return stack.peek()[1];
  }
}
