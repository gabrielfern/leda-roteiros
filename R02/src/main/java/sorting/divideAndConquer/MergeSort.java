package sorting.divideAndConquer;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
	        int mid = (leftIndex+rightIndex)/2;
	        sort(array, leftIndex, mid);
	        sort(array, mid+1, rightIndex);
	        merge(array, leftIndex, mid, rightIndex);
		}
	}

	private void merge(T[] array,  int leftIndex, int mid, int rightIndex) {
		T[] aux = Arrays.copyOfRange(array, leftIndex, rightIndex + 1);
	    mid -= leftIndex;
	    rightIndex -= leftIndex;
	    int i = 0; int j = mid + 1; int k = leftIndex;

	    while (i <= mid && j <= rightIndex) {
	        if (aux[i].compareTo(aux[j]) <= 0) {
	            array[k++] = aux[i++];
	        }
	        else {
	            array[k++] = aux[j++];
	        }
	    }

	    while (i <= mid) {
	        array[k++] = aux[i++];
	    }
	    
	    while (j <= rightIndex) {
	        array[k++] = aux[j++];
		}
	}
}