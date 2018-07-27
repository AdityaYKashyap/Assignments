package com.del;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] arr = new int[size];
		for(int i = 0; i<size; i++)
			arr[i] = sc.nextInt();
		boolean value = UserMainCode.checkTripplets(arr);
		System.out.println(String.valueOf(value).toUpperCase());
	}

}

class UserMainCode{
	public static boolean checkTripplets(int[] a) {
		for(int i = 0; i<a.length-1; i++) {
			if((a[i]==a[i+1])&&(a[i+1]==a[i+2]))
				return true;
		}	
		return false;
	}
}
