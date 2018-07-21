package mobilePayment.client;

import java.util.InputMismatchException;
import java.util.Scanner;

import mobilePayment.exception.PaymentException;
import mobilePayment.service.PaymentService;
import mobilePayment.service.PaymentServiceImp1;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Client();
	}
	
	private PaymentService pService;
	
	public Client() {
		// TODO Auto-generated constructor stub
		pService = new PaymentServiceImp1();
		String choice = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("\tMobile Payment System");
		System.out.print("Enter Mobile Number: ");
		String mob = sc.nextLine();
		System.out.println();
		System.out.print("Enter password: ");
		String pass = sc.nextLine();
		System.out.println();
		boolean status = pService.authenticate(mob,pass);
		if(status) {
			pService.setAmount();
			while(true) {
				choice = getChoice(sc,mob);
				if(choice.toLowerCase().equals("yes")) {
					System.out.print("Pay Amount: ");
					double amount = 0;
					try {
						amount = sc.nextDouble();
						System.out.println();
						pService.payAmount(amount);
						System.out.println();
						System.out.println("Mobile Number: " + mob);
						System.out.println("Payment Made: " + amount);
						System.out.println("Pending Payment: " + pService.paymentStatus());
						sc.nextLine();
					} catch(PaymentException e) {
						System.err.println(e.getMessage());
						sc.nextLine();
					}catch(InputMismatchException e) {
						System.err.println("Enter number only");
						sc.nextLine();
					}
				}
				else if (choice.toLowerCase().equals("no")) {
					System.out.println("Transaction Complete. Exiting. ");
					System.exit(0);
				}
				else {
					System.err.println("Please enter 'yes' or 'no' only");
				}
			}
		}
		else {
			System.err.println("Incorrect mobile number or password.");
		}
	}
	
	private String getChoice(Scanner sc, String mob) {
		String choice = null;
		System.out.println();
		System.out.println("Payment Details");
		System.out.print("Mobile Number: " + mob);
		System.out.println();
		System.out.print("Pending Amount: Rs" + pService.getAmount());
		System.out.println();
		System.out.print("Ready to pay? (yes/no): ");
		try {
			choice = sc.nextLine();
		} catch(InputMismatchException e) {
			System.err.println("wrong input");
			sc.nextLine();
		}
		return choice;
	}
}
