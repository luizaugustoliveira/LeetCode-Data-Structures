//questão Peak in a Mountain

//Versão Iterativa

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < arr[mid+1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}


class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1
        int[] arr1 = {0, 1, 0};
        int peakIndex1 = sol.peakIndexInMountainArray(arr1);
        System.out.println("Peak Index for Test Case 1: " + peakIndex1);

        // Test Case 2
        int[] arr2 = {0, 2, 1, 0};
        int peakIndex2 = sol.peakIndexInMountainArray(arr2);
        System.out.println("Peak Index for Test Case 2: " + peakIndex2);

        // Test Case 3
        int[] arr3 = {3, 4, 5, 1};
        int peakIndex3 = sol.peakIndexInMountainArray(arr3);
        System.out.println("Peak Index for Test Case 3: " + peakIndex3);
    }
}

// Versão Recursiva

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        return peakIndexInMountainArrayRecursive(arr, 0, arr.length - 1);
    }
    
    private int peakIndexInMountainArrayRecursive(int[] arr, int left, int right) {
        if (left >= right) {
            return left;
        }
        
        int mid = (left + right) / 2;
        if (arr[mid] < arr[mid+1]) {
            return peakIndexInMountainArrayRecursive(arr, mid + 1, right);
        } else {
            return peakIndexInMountainArrayRecursive(arr, left, mid);
        }
    }
}

