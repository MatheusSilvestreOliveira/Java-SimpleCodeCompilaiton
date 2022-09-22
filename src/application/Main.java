package application;

import java.util.Scanner;
import codes.PrimeNumber;


public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int option = 0;
		

		do {
			try {
				System.out.println("Welcome to the main page!");
				System.out.println("Digit the option of the code you want to execute:\n"
						+ "[1] Prime Numbers code.\n"
						+ "[2] Exit.");
				option = Integer.parseInt(sc.nextLine());
			} catch(NumberFormatException e) {
				System.out.println("***");
				System.out.println("Error: The input must a numeric. Try again.");
				System.out.println("***");
			}
			
			switch (option) {
				case 1:
					PrimeNumber pn = new PrimeNumber();
					pn.execute();
					break;
					
				case 2:
					System.out.println("Thanks for coding with me!");
			}
			
			
		} while ((int)option != 2);
		
		
		sc.close();
		
	}

}
