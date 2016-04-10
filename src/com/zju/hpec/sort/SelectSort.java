package com.zju.hpec.sort;

import com.zju.hpec.utils.Utils;

/**
 *
 * @Title: Select Sort
 * @Description: the select sort mainly includes directly sort and heap sort
 * @Company: 
 * @author summer
 * 2016年4月10日
 *
 */
public class SelectSort {

	/**
	 * directly sort 
	 * 1. Firstly,select the index of the minimum or the maximum element in the disordered array
	 * 2. Secondly,swap the first or last element in the disordered array and 
	 * the selected minimum or maximum element
	 * @param array
	 */
	public static void directSelectSort(int[] array){
		int len = array.length;
		for(int i = 0; i < len; ++i){
			//record the index of the minimum element in the disordered array
			int min = i;
			for(int j = i + 1; j < len; ++j){
				if(array[min] > array[j])
					min = j;
			}
			
			//if the index of the minimum element is not equal to the i
			//swap the two element corresponding to the i and min,respectively
			if(i != min)
				Utils.swap(array, i, min);
		}
	}
	
	/**
	 * heap sort
	 * @param array
	 */
	public static void heapSort(int[] array){
		int len = array.length;
		for(int i = 0; i < array.length; ++i){
			buildMaxHeap(array,len - i - 1);
			//the maximum element of the array will be set to the first position
			//of the array after building the maximum heap
			Utils.swap(array, 0, len - i - 1);
		}
//		
//		for(int i = 0; i < len; ++i){
		//the minimum element of the array will be set to the first position
		//of the array after building the minimum heap
//			buildMinHeap(array,len - i -1);
//			Utils.swap(array, 0, len - i -1);
//		}
	}
	
	/**
	 * build max heap
	 * @param array
	 * @param last the last position of the array will be used to build heap
	 */
	private static void buildMaxHeap(int[] array,int last){
		for(int i = (last - 1) / 2; i >= 0; --i){
			int k = i;
			while(k * 2 + 1 < last){
				int maxIndex = k * 2 + 1;
				
				//find the maximum value between the two children nodes of the current node
				//and set the index to the maxIndex variable
				if(maxIndex < last){
					if(array[maxIndex] < array[maxIndex + 1])
						++maxIndex;
				}
				
				//judge if the parent node is less than the child node
				//swap the parent and the child node if the judge statement is true
				//and then set the maxIndex value to the k variable,recursively
				//continue that operation above,or break and return directly
				if(array[maxIndex] > array[k]){
					Utils.swap(array, k, maxIndex);
					k = maxIndex;
				}else{
					break;
				}
			}
		}
	}
	
	/**
	 * build minimum heap
	 * @param array
	 * @param last
	 */
	@SuppressWarnings("unused")
	private static void buildMinHeap(int[] array,int last){
		for(int i = (last - 1) / 2; i >= 0; --i){
			int k = i;
			while(k * 2 + 1 < last){
				int minIndex = k * 2 + 1;
				//find the minimum value between the two children nodes of the current node
				//and set the index to the maxIndex variable
				if(minIndex < last){
					if(array[minIndex] > array[minIndex + 1])
						++minIndex;
				}
				
				//judge if the parent node is great than the child node
				//swap the parent and the child node if the judge statement is true
				//and then set the maxIndex value to the k variable,recursively
				//continue that operation above,or break and return directly
				if(array[minIndex] < array[k]){
					Utils.swap(array, minIndex, k);
					k = minIndex;
				}else{
					break;
				}
			}
		}
	}
	
	
	/**
	 * Test
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = Utils.getArray();
		Utils.print(array);
//		directSelectSort(array);
		heapSort(array);
		Utils.print(array);
	}
}
