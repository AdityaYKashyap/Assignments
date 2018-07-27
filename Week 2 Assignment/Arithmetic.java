package com.del;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Arithmetic {

	private double num1,num2,num3;
	
	protected Arithmetic(double num1, double num2) {
		this.num1 = num1;
		this.num2 = num2;
	}

	public double getNum1() {
		return num1;
	}

	public void setNum1(double num1) {
		this.num1 = num1;
	}

	public double getNum2() {
		return num2;
	}

	public void setNum2(double num2) {
		this.num2 = num2;
	}

	public double getNum3() {
		return num3;
	}

	public void setNum3(double num3) {
		this.num3 = num3;
	}

	public abstract double calculate();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc  = new Scanner(System.in);
		try{
			System.out.println("Enter num1: ");
		double num1 = sc.nextDouble();
		System.out.println("Enter num2: ");
		double num2 = sc.nextDouble();
		
		System.out.println("Select Choice for Calculator");
		System.out.println();
		System.out.println("1.Addition");
		System.out.println("2.Subtraction");
		System.out.println("3.Multiplication");
		System.out.println("4.Division");
		
		
		int choice = sc.nextInt();
		
		Arithmetic[] objects; 
		objects = new Arithmetic[]{new Addition(num1,num2), new Subtraction(num1,num2), 
				new Multiplication(num1,num2), new Division(num1,num2)};
		double result = objects[choice-1].calculate();
		System.out.println("Result: "+result);
		}catch(Exception e) {
			System.err.println("Error");
		}
	}
}

class Addition extends Arithmetic{

	public Addition(double num1, double num2) {
		super(num1, num2);
	}

	@Override
	public double calculate() {
		setNum3(getNum1() + getNum2());
		return (getNum3());
	}
	
}

class Subtraction extends Arithmetic{
	public Subtraction(double num1, double num2) {
		super(num1, num2);
	}

	@Override
	public double calculate() {
		setNum3(getNum1() - getNum2());
		return (getNum3());
	}
	
}

class Multiplication extends Arithmetic{

	public Multiplication(double num1, double num2) {
		super(num1, num2);
	}

	@Override
	public double calculate() {
		setNum3(getNum1() * getNum2());
		return getNum3();
	}
	
}

class Division extends Arithmetic{

	public Division(double num1, double num2) {
		super(num1, num2);
	}

	@Override
	public double calculate() {
		setNum3(getNum1() / getNum2());
		return (getNum3());
	}
	
}
