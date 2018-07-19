package com.del;

public class Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 1 ; i <= 50 ; i++)
		{
			if(i%3==0)
				System.out.print("abc");
			if(i%5==0)
				System.out.print("xyz");
			if((i%3!=0)&&(i%5!=0))
				System.out.print(i);
			System.out.print(" ");
		}
	}

}
