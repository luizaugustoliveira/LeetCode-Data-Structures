public class Teste {
    public static void main(String[] args) {
        Integer[] array = (Integer[]) Array.newInstance(Integer.class, 6);
        array[0] = 7;
        array[1] = 10;
        array[2] = 4;
        array[3] = 3;
        array[4] = 20;
        array[5] = 15;
        System.out.println(new quickSelect<Integer>().quickselect(array, 0, array.length - 1, 4));// elemento na posição 4 é 20
        //inicio do array: {7, 10, 4, 3, 20, 15}
        //final do array: {3, 4, 7, 10, 20, 15}
    }

}




//busca binaria

class Solution {
    public int search(int[] nums, int target) {
        int inicio = 0;
        int fim = nums.length - 1;

        return buscaBinaria(nums, target, inicio, fim);
    }

    private static int buscaBinaria(int[] nums, int target, int inicio, int fim) {
        if (inicio <= fim) { //Mudei do  "<" para "<=", assim consigo incluir o caso em que o inicio == fim
            int meio = (inicio + fim) / 2;

            if (nums[meio] == target) {
                return meio;
            }
            if (target < nums[meio]) {
                return buscaBinaria(nums, target, inicio, meio - 1);
            } else {
                return buscaBinaria(nums, target, meio + 1, fim);
            }
        } else {
            return -1;
        }
    }
}

class Solution {
    public int searchInsert(int[] nums, int target) {
        int inicio = 0;
        int fim = nums.length - 1;

        return buscaBinaria(nums, target, inicio, fim);
    }

    private static int buscaBinaria(int[] nums, int target, int inicio, int fim) {
        if (inicio <= fim) { //Mudei do  "<" para "<=", assim consigo incluir o caso em que o inicio == fim
            int meio = (inicio + fim) / 2;

            if (nums[meio] == target) {
                return meio;//caso base 1
            }
            if (target < nums[meio]) {
                return buscaBinaria(nums, target, inicio, meio - 1);
            } else {
                return buscaBinaria(nums, target, meio + 1, fim);
            }
        } else {//caso base 2: O valor não existe no array e precisa pensar no indice que ele estaria se esse número existisse
                return inicio;// suposto meio +1 da penúltima chamada recursiva

                }

            }
        }

		class Solution {
			public int[] searchRange(int[] nums, int target) {
				int inicio = 0;
				int fim = nums.length - 1;
				int[] result = new int[2];
				result[0]=buscaBinariaPrimeiro(nums, target, inicio, fim);
				result[1]=buscaBinariaUltimo(nums, target, inicio, fim);
				return result;
			}
		
			private static int buscaBinariaPrimeiro(int[] nums, int target, int inicio, int fim) {
				int meio = (inicio + fim)/2;
				if(fim < inicio){//caso em que o valor não tá no array
					return -1;
				}
				if(nums[meio] < target){
					return buscaBinariaPrimeiro(nums, target, meio + 1, fim);
				}else if(nums[meio]> target){
					return buscaBinariaPrimeiro(nums, target, inicio, meio - 1);   
				}else{
					if(meio == 0 || nums[meio] != nums[meio -1]){
						return meio;
					}else{
						return buscaBinariaPrimeiro(nums,target,inicio,meio-1);
					}
				}
			}
		
			private static int buscaBinariaUltimo(int[] nums, int target, int inicio, int fim) {
				int meio = (inicio + fim) / 2;
				if(fim < inicio){//caso em que o valor não tá no array
					return -1;
				}
				if(nums[meio]< target){
					return buscaBinariaUltimo(nums, target, meio + 1, fim);
				}else if(nums[meio] > target){
					return buscaBinariaUltimo(nums, target, inicio, meio -1);   
				}else{//(nums[meio] == target)
					if(meio == nums.length -1 || nums[meio] != nums[meio +1]){
						return meio;
					}else{
						return buscaBinariaUltimo(nums,target, meio + 1, fim);
					}
				}   
			}
		
		}

		class Solution {
			public int search(int[] nums, int target) {
				int inicio = 0;
				int fim = nums.length -1;
				return buscaBinaria(nums,inicio,fim, target);
			}
		
			private int buscaBinaria(int[] nums, int inicio, int fim, int target){
		
				if(inicio > fim){
					return -1;
				}
			   int meio = (inicio + fim)/2;
		
				if(target == nums[meio]) {
					return meio;
				}if(nums[inicio] <= nums[meio]) {
					if(target <= nums[meio] && nums[inicio] <= target ){
						return buscaBinaria(nums, inicio, meio -1,target);
					}else{
						return buscaBinaria(nums, meio +1, fim, target);
					}
				}else{
					if(nums[meio] <= target && target <= nums[fim]){
						return buscaBinaria(nums,meio +1,fim, target);
					}else{
						return buscaBinaria(nums,inicio, meio -1,target);
					}
				}
			}
		
		}   
		
public static  int closest(int[]array, int x){
    int left= 0;
    int right=array.length -1;
    int closest=-1;

    while(left<=right){
        int mid=(left+right)/2;

        if(array[mid]==x){
            return array[mid];
        }if(array[mid]>x){
            right=mid-1;
        }else{
            left=mid+1;
        }
        if (closest == -1 || Math.abs(array[mid] - x) < Math.abs(closest - x)) {// Verifica se a diferença entre o elemento atual e x é menor do que a diferença entre o closest atual e x.
            closest = array[mid];
        }
    }return closest;
}

public static void main(String[] args) {
    //int array[]={4,15,25,30,38,84,96};
    int array[]={15,25,28,84};

    System.out.println(closest(array,50));
}
public static int floorBuscaRec(int[] array, int x, int left, int right, int floor) {
    if (left > right) {
        return floor;
    }

    if (x < array[left]) {
        return -1; 
    }

    int mid = (left + right) / 2;

    if (array[mid] == x) {
        return array[mid];
    } else if (array[mid] > x) {
        return floorBuscaRec(array, x, left, mid - 1, floor);
    } else {
        floor = array[mid];
        return floorBuscaRec(array, x, mid + 1, right, floor);
    }
}



public static int ceilBusca(int[]array,int x){
    int left=0;
    int right=array.length -1 ;
    int ceil=-1;

    while (left <=right) {
       int mid =( left + right)/2;

    if(array[mid] == x){
        return array[mid];
    }else if(array[mid]>x){
        right = mid -1;
        ceil=array[mid];
    }else{
        left = mid + 1;
    }
    }return ceil;
}




//quicksort
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= 0 && rightIndex < array.length && leftIndex < rightIndex) {

			int pivotIndex = this.partition(array, leftIndex, rightIndex);

			this.sort(array, leftIndex, pivotIndex - 1);
			this.sort(array, pivotIndex + 1, rightIndex);
		}
	}

	private int partition(T[] array, int leftIndex, int rightIndex) {
		int pivotIndex = leftIndex;
		T pivot = array[leftIndex];

		for (int i = pivotIndex + 1; i <= rightIndex; i++) {
			if (pivot.compareTo(array[i]) > 0) {
				pivotIndex++;
				Util.swap(array, pivotIndex, i);

			}
		}
		Util.swap(array, leftIndex, pivotIndex);

		return pivotIndex;
	}
}

public class QuickSortMedianOfThree<T extends Comparable<T>> extends
		AbstractSorting<T> {

	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= 0 && rightIndex < array.length && leftIndex < rightIndex) {
			int pivotIndex = this.partition(array, leftIndex, rightIndex);
			this.sort(array, leftIndex, pivotIndex -1);
			this.sort(array, pivotIndex+1, rightIndex);	
		}
	}
	
	private int partition(T[] array, int leftIndex, int rightIndex) {
		int middleIndex = (leftIndex + rightIndex) / 2;
		medianOfThree(array, leftIndex, middleIndex, rightIndex);
		
		T pivot = array[middleIndex];
		Util.swap(array, middleIndex, rightIndex -1);
		int pivotIndex = rightIndex -1;
		
		for(int i = pivotIndex -1; i > leftIndex ; i--) {
			if(pivot.compareTo(array[i]) < 0) {
				pivotIndex --;
				Util.swap(array, pivotIndex, i);
			}
		}
		Util.swap(array, rightIndex-1, pivotIndex);
		return pivotIndex;
		
	}
	
	private void medianOfThree(T[] array, int leftIndex,int middleIndex, int rightIndex) {
		if(array[leftIndex].compareTo(array[middleIndex]) > 0) {
			Util.swap(array, leftIndex, middleIndex);
		}
		if(array[leftIndex].compareTo(array[rightIndex]) > 0) {
			Util.swap(array, leftIndex, rightIndex);
		}
		if(array[middleIndex].compareTo(array[rightIndex]) > 0) {
			Util.swap(array, middleIndex, rightIndex);
		}
	}

}


//quickselect
public class quickSelect<T extends Comparable<T>> {
    public T quickselect(T[]array, int inicio, int fim, int k){
        int i = inicio;
        T pivot = array[inicio];
        for(int j=inicio+1;j <= fim;j++){
            if(array[j].compareTo(pivot)<0){
                i++;
                swap(array,i,j);
            }
        }
            swap(array,i,inicio);
            if(k==i+1){
                return pivot;
            }else if(k < i + 1){
                return quickselect(array, inicio, i-1, k);
            }else{
                return quickselect(array, i+1,fim,k);
            }
        }

    private void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

	//Given an array of points where points[i] = [xi, yi] represents a point on the X-Y //plane and an integer k, return the k closest points to the origin (0, 0).

//The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

//You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        return kClosestRec(points, 0, points.length - 1, k);
    }
    
    private int[][] kClosestRec(int[][] points, int left, int right, int k) {
        if (left >= right) {
            return Arrays.copyOfRange(points, 0, k);
        }
        
        int pivotIndex = partition(points, left, right);
        int count = pivotIndex - left + 1;
        
        if (count == k) {
            return Arrays.copyOfRange(points, 0, k);
        } else if (count > k) {
            return kClosestRec(points, left, pivotIndex - 1, k);
        } else {
            int[][] result = kClosestRec(points, left, pivotIndex - 1, count);
            int[][] rightResult = kClosestRec(points, pivotIndex + 1, right, k - count);
            return combine(result, rightResult);
        }
    }
    
    private int partition(int[][] points, int left, int right) {
        int[] pivot = points[right];
        int i = left;
        
        for (int j = left; j < right; j++) {
            if (distance(points[j]) < distance(pivot)) {
                swap(points, i, j);
                i++;
            }
        }
        
        swap(points, i, right);
        return i;
    }
    
    private double distance(int[] point) {
        return Math.sqrt(point[0] * point[0] + point[1] * point[1]);
    }
    
    private void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
    
    private int[][] combine(int[][] arr1, int[][] arr2) {
        int[][] result = new int[arr1.length + arr2.length][2];
        int index = 0;
        
        for (int[] point : arr1) {
            result[index] = point;
            index++;
        }
        
        for (int[] point : arr2) {
            result[index] = point;
            index++;
        }
        
        return result;
    }
}


//Given an integer array nums and an integer k, return the k most frequent elements. You //may return the answer in any order.
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        List<Integer>[] bucket = new List[nums.length + 1];
        
        for (int key : freqMap.keySet()) {
            int freq = freqMap.get(key);
            
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            
            bucket[freq].add(key);
        }
        
        List<Integer> result = new ArrayList<>();
        
        for (int i = bucket.length - 1; i >= 0 && result.size() < k; i--) {
            if (bucket[i] != null) {
                result.addAll(bucket[i]);
            }
        }
        
        int[] output = new int[k];
        
        for (int i = 0; i < k; i++) {
            output[i] = result.get(i);
        }
        
        return output;
    }
}


//merge
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		if (leftIndex >= 0 && rightIndex < array.length && leftIndex < rightIndex) {

			int middleIndex = (leftIndex + rightIndex) / 2;

			this.sort(array, leftIndex, middleIndex);
			this.sort(array, middleIndex + 1, rightIndex);
			this.merge(array, leftIndex, middleIndex, rightIndex);
		}

	}

	private void merge(T[] array, int leftIndex, int middleIndex, int rightIndex) {

		T[] help = (T[]) new Comparable[array.length];

		for (int i = leftIndex; i <= rightIndex; i++) {
			help[i] = array[i];
		}

		int firstIterator = leftIndex;
		int secondIterator = middleIndex + 1;
		int auxIterator = leftIndex;

		while (firstIterator <= middleIndex && secondIterator <= rightIndex) {
			if (help[firstIterator].compareTo(help[secondIterator]) < 0) {
				array[auxIterator] = help[firstIterator];
				firstIterator++;
			} else {
				array[auxIterator] = help[secondIterator];
				secondIterator++;
			}
			auxIterator++;

		}
		while (firstIterator <= middleIndex) {
			array[auxIterator] = help[firstIterator];
			firstIterator++;
			auxIterator++;

		}
		while (secondIterator <= rightIndex) {
			array[auxIterator] = help[secondIterator];
			secondIterator++;
			auxIterator++;

		}

	}
}

//Merge Without Extra Space
void merge(int arr1[], int arr2[], int n, int m) {
    // base case: if one of the arrays is empty, return
    if(n == 0 || m == 0) {
        return;
    }

    // if last element of arr1 is greater than first element of arr2,
    // swap them so that arr1's last element goes to arr2 and arr2's
    // first element goes to arr1
    if(arr1[n-1] > arr2[0]) {
        swap(arr1[n-1], arr2[0]);
    }

    // sort both arrays using recursive call
    sort(arr1, arr1+n);
    sort(arr2, arr2+m);
}


//
public class KLargestOrderStatisticsImpl<T extends Comparable<T>> implements KLargest<T> {

	@Override
	public T[] getKLargest(T[] array, int k) {
		if (k >= 1 && k <= array.length) {
			
			int index = array.length - k;
			orderStatistics(array, index);
			return Arrays.copyOfRange(array, index, array.length);
		}
		return null;
	}

	/**
	 * Metodo que retorna a k-esima estatistica de ordem de um array, usando a ideia
	 * de algum algoritmo de ordenacao visto em sala. Caso nao exista a k-esima
	 * estatistica de ordem, entao retorna null.
	 * 
	 * Obs: o valor de k deve ser entre 1 e N.
	 * 
	 * @param array
	 * @param k
	 * @return
	 */
	public T orderStatistics(T[] array, int k) {
		if (k >= 1 && k <= array.length && array.length > 0) {
			for (int i = 0; i <= array.length - 1; i++) {
				int smaller = i;
				for (int j = i + 1; j <= array.length - 1; j++) {
					if (array[j].compareTo(array[smaller]) < 0) {
						smaller = j;
					}

				}
				Util.swap(array, i, smaller);
				if (k == i + 1) {
					return array[i];
				}
			}
		}
		return null;
	}
}


//selection

public class RecursiveSelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	/**
	 * Implementação recursiva do selection sort. Você deve implementar apenas esse
	 * método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do algoritmo
	 * e depois o caso indutivo, que reduz o problema para uma entrada menor em uma
	 * chamada recursiva. Seu algoritmo deve ter complexidade quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= 0 && rightIndex < array.length) {
			if (leftIndex < rightIndex) {
				int smaller = leftIndex;
				for (int i = leftIndex + 1; i <= rightIndex; i++) {
					if (array[i].compareTo(array[smaller]) < 0) {
						smaller = i;
					}
				}
				Util.swap(array, leftIndex, smaller);
				sort(array, leftIndex + 1, rightIndex);
			}
		}
	}
}
//bubble
public class RecursiveBubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	/**
	 * Implementação recursiva do bubble sort. Você deve implementar apenas esse
	 * método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do algoritmo
	 * e depois o caso indutivo, que reduz o problema para uma entrada menor em uma
	 * chamada recursiva. Seu algoritmo deve ter complexidade quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= 0 && rightIndex < array.length) {
			if (leftIndex < rightIndex) {
				for (int i = leftIndex; i < rightIndex; i++) {
					if (array[i].compareTo(array[i + 1]) > 0) {
						Util.swap(array, i, i + 1);
					}
				}
				sort(array, leftIndex, rightIndex - 1);
			}
		}
	}
}

//insertion

package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= 0 && rightIndex < array.length && leftIndex < rightIndex) {
			sort(array, leftIndex, rightIndex - 1); // recursão para ordenar a subarray esquerda
			
			// inserir o elemento no lugar correto dentro da subarray já ordenada
			T key = array[rightIndex];
			int j = rightIndex - 1;
			while (j >= leftIndex && array[j].compareTo(key) > 0) {
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = key;
		}
	}
}
