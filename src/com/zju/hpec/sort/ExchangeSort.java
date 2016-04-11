package com.zju.hpec.sort;

import com.zju.hpec.utils.Utils;

/**
 *
 * <p>
 * Title: ExchangeSort
 * </p>
 * <p>
 * Description: exchange sort mainly includes bubble sort and quick sort
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author summer
 * @date 2016年4月9日 下午7:17:17
 *
 */
public class ExchangeSort {

	/**
	 * the general bubble sort
	 * 
	 * @param array
	 */
	public static void bubbleSort(int[] array) {
		int len = array.length;
		for (int i = 0; i < len - 1; ++i) {
			for (int j = 0; j < len - i - 1; ++j) {
				if (array[j] > array[j + 1]) {
					Utils.swap(array, j, j + 1);
				}
			}
		}
	}

	/**
	 * the improved bubble sort will end just when there exists a situation
	 * where all the element in the array aren't swap
	 * 
	 * @param array
	 */
	public static void improveBubbleSort(int[] array) {
		int len = array.length;
		for (int i = 0; i < len - 1; ++i) {
			boolean isSwap = false;
			for (int j = 0; j < len - i - 1; ++j) {
				if (array[j] > array[j + 1]) {
					isSwap = true;
					Utils.swap(array, j, j + 1);
				}
			}
			// if there is no comparison in this time, directly end the cycle
			if (!isSwap)
				break;
		}
	}

	/**
	 * quick sort can't sort the array in which there are more than two same
	 * element
	 * 
	 * @param array
	 * @param left
	 * @param right
	 */
	public static void quickSort(int[] array, int left, int right) {
		if (left < right) {
			int pivot = partition(array, left, right);
			quickSort(array, left, pivot - 1);
			quickSort(array, pivot + 1, right);
		}
	}

	/**
	 * find the index position of the pivot element
	 * 
	 * @param array
	 * @param left
	 * @param right
	 * @return
	 */
	private static int partition(int[] array, int left, int right) {
		// default select the left element of the array as the pivot element
		int pivot = array[left];
		// ++left;
		while (left < right) {

			// find the first element which less than the pivot in the right
			// side
			// of the array
			while (left < right && array[right] > pivot)
				--right;

			// find the first element which great than the pivot in the left
			// side
			// of the array
			while (left < right && array[left] < pivot)
				++left;

			if (left < right) {
				Utils.swap(array, left, right);
			}
		}
		// Utils.print(array);
		pivot = left;
		return pivot;
	}

	/**
	 * test
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = Utils.getArray();
		// int[] array = new int[]{2,1,3,9,10,8,7,6,4,5};
		Utils.print(array);
		// bubbleSort(array);
		// improveBubbleSort(array);
		quickSort(array, 0, array.length - 1);
		Utils.print(array);
	}

}
