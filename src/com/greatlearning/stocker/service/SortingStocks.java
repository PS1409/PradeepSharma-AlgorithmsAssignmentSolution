package com.greatlearning.stocker.service;

import com.greatlearning.stocker.objects.CompanyStock;


public class SortingStocks {
	
	// Main function that merges array[left...right] in descending order
	
	void mergeDescending(CompanyStock arr[], int left, int mid, int right) {
		// Find sizes of two sub arrays to be merged
		int n1 = mid - left + 1;
		int n2 = right - mid;

		/* Create temporary arrays */
		CompanyStock leftArray[] = new CompanyStock[n1];
		CompanyStock rightArray[] = new CompanyStock[n2];

		/* Copy data to temporary arrays */
		for (int i = 0; i < n1; ++i)
			leftArray[i] = arr[left + i];
		for (int j = 0; j < n2; ++j)
			rightArray[j] = arr[mid + 1 + j];

		/* Merge the temporary arrays */

		// Initial indexes of first and second sub-arrays
		int i = 0, j = 0;

		// Initial index of merged sub-array array
		int k = left;
		while (i < n1 && j < n2) {
			if (leftArray[i].stockPrice >= rightArray[j].stockPrice) {
				arr[k] = leftArray[i];
				i++;
			} else {
				arr[k] = rightArray[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k] = leftArray[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr[k] = rightArray[j];
			j++;
			k++;
		}
	}
	
	// Main function that merges array[left...right] in ascending order 
	void mergeAscending(CompanyStock arr[], int left, int mid, int right) {
	
		// Find sizes of two sub arrays to be merged
		int n1 = mid - left + 1;
		int n2 = right - mid;

		/* Create temporary arrays */
		CompanyStock leftArray[] = new CompanyStock[n1];
		CompanyStock rightArray[] = new CompanyStock[n2];

		/* Copy data to temporary arrays */
		for (int i = 0; i < n1; ++i)
			leftArray[i] = arr[left + i];
		for (int j = 0; j < n2; ++j)
			rightArray[j] = arr[mid + 1 + j];

		/* Merge the temporary arrays */

		// Initial indexes of first and second sub-arrays
		int i = 0, j = 0;

		// Initial index of merged sub-array array
		int k = left;
		while (i < n1 && j < n2) {
			if (leftArray[i].stockPrice <= rightArray[j].stockPrice) {
				arr[k] = leftArray[i];
				i++;
			} else {
				arr[k] = rightArray[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k] = leftArray[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr[k] = rightArray[j];
			j++;
			k++;
		}
	}
	
	// Main function that sorts array[left...right] using mergeDescending()	
	public void sortDescending(CompanyStock[] stocks, int left, int right) {
		if (left < right) {
			// Find the middle point
			int mid = (left + right) / 2;

			// Sort first and second halves
			sortDescending(stocks, left, mid);
			sortDescending(stocks, mid + 1, right);

			// Merge the sorted halves
			mergeDescending(stocks, left, mid, right);
		}
	}
	
	// Main function that sorts array[left...right] using mergeDescending()
	public void sortAscending(CompanyStock[] stocks, int left, int right) {
		if (left < right) {
			// Find the middle point
			int mid = (left + right) / 2;

			// Sort first and second halves
			sortAscending(stocks, left, mid);
			sortAscending(stocks, mid + 1, right);

			// Merge the sorted halves
			mergeAscending(stocks, left, mid, right);
		}
	}
}
