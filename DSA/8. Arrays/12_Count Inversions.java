/*
    Problem: https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1

    Given an array of integers arr[]. You have to find the Inversion Count of the array. 
    Note : Inversion count is the number of pairs of elements (i, j) such that i < j and arr[i] > arr[j].

    ---------------------------------
    
    Example 1:
        Input: arr[] = [2, 4, 1, 3, 5]
        Output: 3
        Explanation: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).

    Example 2:
        Input: arr[] = [2, 3, 4, 5, 6]
        Output: 0
        Explanation: As the sequence is already sorted so there is no inversion count.

    Example 3:
        Input: arr[] = [10, 10, 10]
        Output: 0
        Explanation: As all the elements of array are same, so there is no inversion count.

    ---------------------------------

    Constraints:
        1 ≤ arr.size() ≤ 105
        1 ≤ arr[i] ≤ 104
*/

class Solution {
    static int cnt = 0;
    
    static void merge(int l, int h, int[] arr) {
        int[] temp = new int[h-l+1];
        
        int mid = l+(h-l)/2;
        int i = l, j = mid+1, index = 0;
        
        while(i<=mid && j<=h) {
            if(arr[i] > arr[j]) {
                temp[index++] = arr[j++];
                cnt += mid-i+1;
            } else {
                temp[index++] = arr[i++];
            }
        }
        
        while(i<=mid) {
            temp[index++] = arr[i++];
        }
        
        while(j<=h) {
            temp[index++] = arr[j++];
        }
        
        for(int k=0; k<h-l+1; k++) {
            arr[l+k] = temp[k];
        }
    }
    
    static void mergeSort(int l, int h, int[] arr) {
        if(l >= h)    return;
        
        int mid = l+(h-l)/2;
        mergeSort(l,mid,arr);
        mergeSort(mid+1,h,arr);
        merge(l,h,arr);
    }
    
    static int inversionCount(int arr[]) {
        int n = arr.length;
        cnt = 0;
        mergeSort(0,n-1,arr);
        return cnt;
    }
}