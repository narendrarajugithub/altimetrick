package com.alti.logical.sortandsearch;

import java.time.LocalTime;

public class Sortting {

	public static void main(String[] args) {
		//insertionSort();
		int arr[] = {1, 4};
		sort(arr, 0, arr.length-1);
		
		for(int i:arr) {
			System.out.println(i);
		}
	}

	public static void bubbleSort() {
		int[] arr = { 1, 4, 2, 6, 5, 0, -1 };
		int startTime = LocalTime.now().getNano();
		for (int i = 0; i < arr.length; i++)
			for (int j = i + 1; j < arr.length; j++) {
				int temp = 0;
				if (arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		int completedTime = LocalTime.now().getNano();
		System.out.println(completedTime - startTime);
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i]);
	}

	public static void selectionSort() {
		int[] arr = { 1, 4, 2, 6, 5, 0, -1 };

		int startTime = LocalTime.now().getNano();

		for (int i = 0; i < arr.length; i++) {
			int min_index = i;
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] > arr[min_index]) {
					min_index = j;
				}

				int temp = arr[min_index];
				arr[min_index] = arr[i];
				arr[i] = temp;

			}
		}
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i]);

	}

	public static void insertionSort() {
		int[] arr = { 1, 4, 2, 6, 5, 0, -1 };

		for (int i = 1; i < arr.length; i++) {// 1
			int key = arr[i];
			int j = i - 1; // 0
			while (j >= 0 && arr[j] > key) {// 1>4
				arr[j + 1] = arr[j]; //
				j = j - 1; //
			}
			arr[j + 1] = key; // 4

		}

		for (int k : arr) {
			System.out.print(k);
		}

	}

	public static void sort(int[] arr, int l, int r) {

		if (l < r) {
			int mid = l + (r - 1) / 2;

			sort(arr, l, mid);
			sort(arr, mid + 1, r);

			merge(arr, l, mid, r);

		}

		
	}

	private static void merge(int[] arr, int l, int mid, int r) {
		int n1 = mid - l + 1;
		int n2 = r - mid;

		int L[] = new int[n1];
		int R[] = new int[n2];

		for (int i = 0; i < n1; i++)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; j++)
			R[j] = arr[mid + 1 + j];

		int i = 0, j = 0;

		int k = 1;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		
		while(i<n1) {
			arr[k]=L[i];
			i++;
			k++;
		}
		while(j<n2) {
			arr[k]=R[i];
			j++;
			k++;
		}

	}

}
