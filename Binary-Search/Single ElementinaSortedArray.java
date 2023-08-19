/*
Single Element in a Sorted Array

You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.

 

Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: nums = [3,3,7,7,10,11,11]
Output: 10
*/

// versão iterativa

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (mid % 2 == 1) {
                mid--; // garante que mid é sempre um índice par
            }
            
            if (nums[mid] != nums[mid+1]) {
                right = mid;
            } else {
                left = mid + 2;
            }
        }
        
        return nums[left];
    }
}

/* if (mid % 2 == 1) {
    mid--; 
Essa parte do código é responsável por garantir que o índice mid seja sempre um número par. Isso é necessário porque o problema garante que o array tem apenas um elemento que não se repete e que este elemento está sempre em um índice par.

O trecho mid % 2 == 1 verifica se o índice mid é ímpar. Se for, isso significa que mid + 1 é um índice par, que é o índice do próximo elemento no array que deve ser comparado com nums[mid].

Se mid for ímpar, a linha seguinte mid--; decrementa mid em 1, garantindo que mid seja sempre um índice par. Dessa forma, o elemento em mid e o elemento em mid+1 serão sempre comparados corretamente, e o algoritmo conseguirá encontrar o elemento que não se repete no array.

Note que a expressão mid % 2 == 1 poderia ser reescrita como mid % 2 != 0, que verifica se mid não é par. De qualquer forma, o objetivo é o mesmo: garantir que mid seja sempre um índice par.



if (nums[mid] != nums[mid+1]) {
    right = mid;
} else {
    left = mid + 2;
}


Esta é a linha mais importante do algoritmo. Aqui é feita a comparação entre nums[mid] e nums[mid+1]. Se os valores forem diferentes, isso significa que o elemento que não se repete está à esquerda de mid, então right é atualizado para mid. Se os valores forem iguais, isso significa que o elemento que não se repete está à direita de mid, então left é atualizado para mid + 2. Isso é necessário porque mid é um índice par, e mid + 1 é o índice do próximo elemento, que deve ser comparado com nums[mid].


    */


// Versão Recursiva

class Solution {
    public int singleNonDuplicate(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }
    
    private int search(int[] nums, int left, int right) {
        if (left >= right) {
            return nums[left];
        }
        
        int mid = left + (right - left) / 2;
        
        if (mid % 2 == 1) {
            mid--; // garante que mid é sempre um índice par
        }
        
        if (nums[mid] != nums[mid+1]) {
            return search(nums, left, mid);
        } else {
            return search(nums, mid + 2, right);
        }
    }
}


// Versão Recursiva com Comparable

class Solution implements Comparable<Solution> {
    private int[] nums;

    public int singleNonDuplicate(int[] nums) {
        this.nums = nums;
        return search(0, nums.length - 1);
    }
    
    private int search(int left, int right) {
        if (left >= right) {
            return nums[left];
        }
        
        int mid = left + (right - left) / 2;
        
        if (mid % 2 == 1) {
            mid--; // garante que mid é sempre um índice par
        }
        
        if (nums[mid] != nums[mid+1]) {
            return search(left, mid);
        } else {
            return search(mid + 2, right);
        }
    }
    
    public int compareTo(Solution other) {
        return this.singleNonDuplicate(this.nums) - other.singleNonDuplicate(other.nums);
    }
}

