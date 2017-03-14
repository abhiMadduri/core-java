package com.java.search;

/*
 * Initialize first=0 and last=sortedArray.length-1
    compute mid and compare  sortedArray[mid]  with element to be searched
    If element to be searched is less than sortedArray[mid] then element lies in left part of the mid, so last=mid
    if element to be searched is greater than sortedArray[mid] then element lies in right part of the mid, so first=mid+1.
    if element to be searched is equal to sortedArray[mid] , then return index
    Repeat above process until first is less than last.
    
    Complexity = log(n)
 */
public class BinarySearch {
    public static int binarySearch(int[] sortedArray, int elementToBeSearched) {
        int first = 0;
        int last = sortedArray.length - 1;

        while (first < last) {

            int mid = (first + last) / 2; // Compute mid point.

            if (elementToBeSearched < sortedArray[mid]) {
                last = mid; // repeat search in first half.
            } else if (elementToBeSearched > sortedArray[mid]) {
                first = mid + 1; // Repeat sortedArray in last half.
            } else {
                return mid; // Found it. return position
            }
        }

        return -1; // Failed to find element
    }

    public static void main(String[] args) {

        int[] sortedArray = { 12, 56, 74, 96, 112, 114, 123, 567 };
        int indexOfElementToBeSearched = binarySearch(sortedArray, 74);
        System.out.println("Index of 74 in array is: " + indexOfElementToBeSearched);

        int indexOfElementToBeSearchedNotFound = binarySearch(sortedArray, 7);
        System.out.println("Index of 7 in array is: " + indexOfElementToBeSearchedNotFound);
    }
}
