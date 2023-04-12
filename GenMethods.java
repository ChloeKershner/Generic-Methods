/* 
 * @author ChloeKershner
 * Program 4
 * March 15, 2022
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
import java.util.Scanner;
import java.util.*;

public class GenMethods {
	public String getIdentificationString() {
		return "Program 4,Chloe Kershner";
	}
	
	// removes all duplicate elements in list and adds them to newList
	public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
		ArrayList<E> newList = new ArrayList<>();
		for (E check : list) {
			if (!(newList.contains(check))) {
				newList.add(check);
			}
		}
		return newList;
		
		
	}
	
	// shuffles the array 30 times
	public static <E> void shuffle(ArrayList<E> list) {
		Random rand = new Random(340L);
		int listSize = list.size();
		E temp;
		for (int i = 0; i < 30; i++) {
			int index1 = rand.nextInt(listSize);
			temp = list.get(index1);
			int index2 = rand.nextInt(listSize);
			list.set(index1, list.get(index2)); 
			list.set(index2, temp);
				
		}
	}
	
	//returns the maximum element using Collections
	public static <E extends Comparable<E>> E max(ArrayList<E> list) {
		E max = Collections.max(list);
		return max;
			
		
	}
	
	// linear seach method to return key, returns -1 if not found
	public static <E extends Comparable<E>> int linearSearch(E[] list, E key) {
		
		 for (int i = 0; i < list.length; i++){
	            if (list[i].compareTo(key) == 0){
	                return i;
	            }
	        }
	        return -1;
	}
	
	// generic method that returns the maximum element in an array
	public static <E extends Comparable<E>> E max(E[] list) {
		E maxElement = list[0];
		for (int i = 0; i < list.length; i++) {
			E check = list[i];
			if (check.compareTo(maxElement) > 0) {
				maxElement = check;
			}
		}
		return maxElement;
	}
	
	// generic method that returns the maximum element in a 2D array
	public static <E extends Comparable<E>> E max(E[][] list) {
		E maxElement = list[0][0];
		for (int i = 1; i < list.length; i++) {
			for (int j = 1; j < list[0].length; j++) {
				E check = list[i][j];
				if (check.compareTo(maxElement) > 0) {
				maxElement = check;
				}
			}
		}
		return maxElement;
	}
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int n = scnr.nextInt();
		int currentAdd;
		Integer[] list = new Integer[n];
		LinkedList<Integer> linked = new LinkedList<Integer>();
		
		
		for (int i = 0; i < n; i++) {
			currentAdd = scnr.nextInt();
			list[i] = currentAdd;
			linked.add(currentAdd);
		}
		
		System.out.println(Arrays.toString(list));
		System.out.println(linked);
		
		int k = scnr.nextInt();
		
		int find = linearSearch(list, k);
		if (find == -1) {
			System.out.println("Key " + k + "was not found");
		}
		else {
			System.out.println("Key " + k + " was found at position " + find);
		}
		
		System.out.println(max(list) + " is the max element");
		
		int m = scnr.nextInt();
		int p = scnr.nextInt();
		
		Integer[][] list2 = new Integer[m][p];
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < p; j++) {
				list2[i][j] = scnr.nextInt();
			}
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < p; j++) {
				System.out.print(list2[i][j] + " ");
			}
			System.out.println();
			
		}
		
		System.out.println(max(list2) + " is the max element");
		
		ArrayList<Integer> alist = new ArrayList<Integer>();
		alist.addAll(linked);
		System.out.println(alist);
		alist = removeDuplicates(alist);
		System.out.println(alist);
		shuffle(alist);
		System.out.println(alist);
		
		System.out.println( max(alist) + " is the max element");
		
	}
	
}
