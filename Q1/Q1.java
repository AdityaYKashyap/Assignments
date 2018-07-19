package com.del;

import java.util.Scanner;

public class Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Enter number of lines: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int line = 0;
		while(line<=n+1)
		{
			for(int j = 0 ; j <= n - line ; j++)
			{
				System.out.print(" ");
			}
			for(int j = 0 ; j < line ; j++)
				System.out.print("* ");
			System.out.println();
			if(line<n/2)
				line++;
			else
				line+=2;
		}
	}

}
