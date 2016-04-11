package com.zju.hpec.sort;

import com.zju.hpec.utils.Utils;

/**
 *
 * <p>Title: InsertSort</p>
 * <p>Description: insert sort mainly includes direct insert sort 
 * 	  ,binary insert sort and Shel sort</p>
 * <p>Company: </p>
 * @author summer
 * @date 2016年4月11日 上午11:07:28
 *
 */
public class InsertSort {

	
	/**
	 * direct sort
	 * @param array
	 */
	public static void directInsertSort(int[] array){
		for(int i = 1; i < array.length; ++i){
			int tmp = array[i],j = i - 1;
			for(; j >= 0; --j){
				if(array[j] > tmp)
					array[j + 1] = array[j];
				else
					break;
			}
			array[j + 1] = tmp;
		}
	}
	
	/**
	 * binary insert sort
	 * this sort is better than direct sort,because the binary sort
	 * use binary find algorithm to find the insertion position 
	 * @param array
	 */
	public static void binaryInsertSort(int[] array){
		for(int i = 1; i < array.length; ++i){
			int tmp = array[i],left = 0,right = i - 1,mid = right;
			while(left <= right){
				mid = (right + left) / 2;
				if(array[mid] >= tmp){
					right = mid - 1;
				}else{
					left = mid + 1;
				}
			}
			int move = i - 1;
			for(; move >= left; --move)
				array[move + 1] = array[move];
			array[move + 1] = tmp;
		}
	}
	
	/**
	 * shell sort , it may say that direct sort is a special
	 * shell sort ,it's increment is equal to 1
	 * @param array
	 */
	public static void shellSort(int[] array){
		int inc = array.length / 2;
		while(inc >= 1){
			shellSort(array,inc);
			inc /= 2;
		}
	}
	
	private static void shellSort(int[] array,int inc){
		for(int i = inc; i < array.length; ++i){
			int j = i - inc,tmp = array[i];
			for(;j >= 0; j -= inc){
				if(array[j] > tmp)
					array[j + inc] = array[j];
				else
					break;
			}
			array[j + inc] =tmp;
		}
	}
	
	/**
	 * Test
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = Utils.getArray();
//		int[] array = new int[]{2,3,4,10,9,8,7,6,5,1};
		Utils.print(array);
//		directInsertSort(array);
//		binaryInsertSort(array);
		shellSort(array);
		Utils.print(array);
	}
}
