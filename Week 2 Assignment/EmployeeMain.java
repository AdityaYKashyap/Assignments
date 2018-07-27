package com.del;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class EmployeeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int no_of_employees = sc.nextInt();
		EmployeeVo[] emp = new EmployeeVo[no_of_employees];
		for(int i = 0; i<no_of_employees; i++) {
			int id = sc.nextInt();
			String name = sc.next();
			double income = sc.nextDouble();
			EmployeeBo eb = new EmployeeBo(income);
			emp[i] = new EmployeeVo(id, name, income);
			eb.calincomeTax(emp[i]);
		}
		for(int i = 0; i<no_of_employees; i++) {
			System.out.println(emp[i]);
		}
		Arrays.sort(emp, new Employeesort());
		for(int i = 0; i<no_of_employees; i++) {
			System.out.println(emp[i]);
		}
	}

}

class EmployeeVo{
	private int id;
	private String name;
	private double annualincome;
	private double incometax;
	
	public EmployeeVo(int id, String name, double annualincome) {
		super();
		this.id = id;
		this.name = name;
		this.annualincome = annualincome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAnnualincome() {
		return annualincome;
	}
	public void setAnnualincome(double annualincome) {
		this.annualincome = annualincome;
	}
	public double getIncometax() {
		return incometax;
	}
	public void setIncometax(double incometax) {
		this.incometax = incometax;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		EmployeeVo e = (EmployeeVo) obj;
		return (id==e.id);
	}
	@Override
	public String toString() {
		return "\nEmp [ id: " + id + " ,name: "+name+" ,annual income: "
				+annualincome+" ,income tax: "+incometax+"]";
	}	
}

class EmployeeBo{
	
	double rate;
	double income;
	
	public EmployeeBo(double income) {
		this.income = income;
	}


	public void calincomeTax(EmployeeVo e) {
		income = e.getAnnualincome();
		if(income<10000)
			rate = 10;
		else if((income>=10000)&&(income<40000))
			rate = 15;
		else if((income>=40000)&&(income<100000))
			rate = 25;
		else
			rate = 30;
		e.setIncometax((rate*income/100)); 
	}
}

class Employeesort implements Comparator<EmployeeVo>{

	@Override
	public int compare(EmployeeVo o1, EmployeeVo o2) {
		// TODO Auto-generated method stub
		return (int) (o2.getIncometax()-o1.getIncometax());
	}

	
}