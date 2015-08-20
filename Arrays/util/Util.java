package util;

import java.util.Random;


public class Util {

	
	public static int[] random(int size, int max){
		Random r = new Random();

		int[] result = new int[size];
		for(int i = 0; i < size; i++){
			result[i] = r.nextInt(max+1);
		}
		return result;
	}
	
	public static int[] random(int size, int min, int max){
		Random r = new Random();

		int[] result = new int[size];
		for(int i = 0; i < size; i++){
			result[i] = r.nextInt(max-min+1)+min;
		}
		return result;
	}
	
	public static int[] random(int size){
		Random r = new Random();

		int[] result = new int[size];
		for(int i = 0; i < size; i++){
			result[i] = r.nextInt(100);
		}
		return result;
	}
	
	public static int[] sorted(int size){
		int[] result = new int[size];
		for(int i = 0; i < size; i++){
			result[i] = i;
		}
		return result;
	}
	
	public static int[] same(int size){
		int[] result = new int[size];
		for(int i = 0; i < size; i++){
			result[i] = 5;
		}
		return result;
	}
	
	public static int[] same(int size, int num){
		int[] result = new int[size];
		for(int i = 0; i < size; i++){
			result[i] = num;
		}
		return result;
	}
	
	public static void print(int[] a){
		System.out.print("[ ");
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + " ");
		}
		System.out.println("]");
	}
	
	public static int[] copy(int[] a){
		int[] result = new int[a.length];
		for(int i = 0; i < a.length; i++){
			result[i] = a[i];
		}
		return result;
	}
	
	public static void copy(int[] a, int[] b){
		for(int i = 0; i < a.length; i++){
			a[i] = b[i];
		}
	}
}
