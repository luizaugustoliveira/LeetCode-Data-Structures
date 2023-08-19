/*
 * Sqrt(x)
 * 
 * Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator.

For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 

Example 1:

Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.
Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
 */

 //Versão Iterativa

 class Solution {
    public int mySqrt(int x) {
      if (x == 0 | x == 1) return x;

      int left = 1;
      int right = x;

      while (left <= right) {
        int mid = left + (right - left) / 2;

        if (mid == x / mid) {
          return mid;
        }
        else if (x / mid < mid) {
          right = mid - 1;
        }
        else {
          left = mid + 1;
        }
      }
    return right;
    }
  }

class Main {
  public static void main(String[] args) {
    Solution solucao = new Solution();
    int x = 16;
    int x2 = 9;
    int x3 = 5;
    int numero = solucao.mySqrt(x);
    int numero2 = solucao.mySqrt(x2);
    int numero3 = solucao.mySqrt(x3);
    System.out.println(numero);
    System.out.println(numero2);
    System.out.println(numero3);
  }
}

 // Versão Recursiva

 class Solution {
    public int mySqrt(int x) {
      if (x == 0 || x == 1){
        return x;
      }
      return raizQuadrada(x, 0, x);
    }
  
    private int raizQuadrada(int x, int left, int right) {
      if (left > right) {
        return right;
      }
      int mid = left + (right - left) / 2;
  
      if (mid == x / mid) {
        return mid;
      }
      else if (x / mid < mid) {
        return raizQuadrada(x, left, mid - 1);
      }
      else {
        return raizQuadrada(x, mid + 1, right);
      }
    }
  }
  
  class Main {
    public static void main(String[] args) {
      Solution solucao = new Solution();
      int x = 16;
      int x2 = 9;
      int x3 = 2;
      int numero = solucao.mySqrt(x);
      int numero2 = solucao.mySqrt(x2);
      int numero3 = solucao.mySqrt(x3);
      System.out.println(numero);
      System.out.println(numero2);
      System.out.println(numero3);
    }
  }

 // Versão Comparable

 class Solution implements Comparable<Solution> {
    public int mySqrt(int x) {
      if (x == 0 || x == 1){
        return x;
      }
      return raizQuadrada(x, 0, x);
    }
  
    private int raizQuadrada(int x, int left, int right) {
      if (left > right) {
        return right;
      }
      int mid = left + (right - left) / 2;
  
      if (mid == x / mid) {
        return mid;
      }
      else if (x / mid < mid) {
        return raizQuadrada(x, left, mid - 1);
      }
      else {
        return raizQuadrada(x, mid + 1, right);
      }
    }
  
    @Override
    public int compareTo(Solution outraSolucao) {
      return this.mySqrt(16) - outraSolucao.mySqrt(16);
    }
  }
  
  class Main {
    public static void main(String[] args) {
      Solution solucao = new Solution();
      Solution solucao2 = new Solution();
      int x = 16;
      int x2 = 9;
      int x3 = 2;
      int numero = solucao.mySqrt(x);
      int numero2 = solucao.mySqrt(x2);
      int numero3 = solucao.mySqrt(x3);
      System.out.println(numero);
      System.out.println(numero2);
      System.out.println(numero3);
  
      // utilizando o compareTo
      int resultadoComparacao = solucao.compareTo(solucao2);
      System.out.println("Resultado da comparação: " + resultadoComparacao);
    }
  }
  