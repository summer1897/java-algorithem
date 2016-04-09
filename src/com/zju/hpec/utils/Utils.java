package com.zju.hpec.utils;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * <p>Title: Utils</p>
 * <p>Description: a util class</p>
 * <p>Company: </p>
 * @author summer
 * @date 2016年4月9日 下午7:18:35
 *
 */
public class Utils {

	/**
	 * print the array
	 * @param array
	 */
	public static void print(int[] array){
		System.out.println(Arrays.toString(array));
	}
	
	/**
	 * initiate a array with the specified length
	 * @param length the array length
	 * @param max the element in the array must be less than the max
	 * @return return the array with specified length
	 */
	public static int[] getArray(int length,int max){
		if(length <= 0)
			throw new IllegalArgumentException("the "+length+"can't be negative.");
		int[] array = new int[length];
		ThreadLocalRandom tld = ThreadLocalRandom.current();
		for(int i = 0; i < length; ++i)
			array[i] = tld.nextInt(0, max);
		return array;
	}
	
	/**
	 * @return default return 10 integer number that less than 10
	 */
	public static int[] getArray(){
		return getArray(10,10);
	}
	
	/**
	 * swap two element of the array
	 * @param array
	 * @param i
	 * @param j
	 */
	public static void swap(int[] array,int i,int j){
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
}
