package com.zju.hpec.sort;

import com.zju.hpec.utils.Utils;

/**
 *
 * <p>Title: ExchangeSort</p>
 * <p>Description: exchange sort mainly includes bubble sort and quick sort</p>
 * <p>Company: </p>
 * @author summer
 * @date 2016年4月9日 下午7:17:17
 *
 */
public class ExchangeSort {

	/**
	 * the general bubble sort
	 * @param array
	 */
	public static void bubbleSort(int[] array){
		int len = array.length;
		for(int i = 0; i < len - 1;++i){
			for(int j = 0; j < len - i - 1;++j){
				if(array[j] > array[j + 1]){
					Utils.swap(array, j, j + 1);
				}
			}
		}
	}
	
	/**
	 * the improved bubble sort will end just when there exists a situation where all the element
	 * in the array aren't swap
	 * @param array
	 */
	public static void improveBubbleSort(int[] array){
		int len = array.length;
		for(int i = 0; i < len - 1; ++i){
			boolean isSwap =false;
			for(int j = 0; j < len - i -1; ++j){
				if(array[j] > array[j + 1]){
					isSwap = true;
					Utils.swap(array, j, j + 1);
				}
			}
			//if there is no comparison in this time, directly end the cycle 
			if(!isSwap)
				break;
		}
	}
	
	/**
	 * test
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = Utils.getArray();
		Utils.print(array);
//		bubbleSort(array);
		improveBubbleSort(array);
		Utils.print(array);
	}
	
}
