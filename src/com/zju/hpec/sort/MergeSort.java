package com.zju.hpec.sort;

import com.zju.hpec.utils.Utils;

/**
 *
 * @Title: merge sort
 * @Description: 
 * @Company: 
 * @author summer
 * 2016年4月10日
 *
 */
public class MergeSort {

	/**
	 * merge sort
	 * @param array
	 * @param left
	 * @param right
	 */
	public static void mergeSort(int[] array,int left,int right){
		if(left < right){
			int mid = (left + right) / 2;
			mergeSort(array,left,mid);
			mergeSort(array,mid + 1,right);
			//combine the left sides of the array and the right side of the array
			merge(array,left,mid,right);
		}
	}
	
	/**
	 * merge operation
	 * @param array
	 * @param left
	 * @param mid
	 * @param right
	 */
	private static void merge(int[] array,int left ,int mid,int right){
		int i = left,j = mid + 1,k = 0;
		int[] tmp = new int[right - left + 1];
		
		while(i <= mid && j <= right){
			if(array[i] < array[j]){
				tmp[k++] = array[i++];
			}else{
				tmp[k++] = array[j++];
			}
		}
		
		//append the rest element of the array in the left side to the tmp array
		while(i <= mid)
			tmp[k++] = array[i++];
		
		//append the rest element of the array in the right side to the tmp array
		while(j <= right)
			tmp[k++] = array[j++];
		
		//fill the original array with the elements of the tmp array
		for(int m = 0; m < tmp.length; ++m)
			array[left + m] = tmp[m];
	}
	
	/**
	 * Test
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = Utils.getArray();
		Utils.print(array);
		mergeSort(array,0,array.length - 1);
		Utils.print(array);
	}
}
