package codes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeNumber {
	
	public void execute() {
		Object option = 0;		
		do {
			System.out.println("Digit the option you want to execute:\n"
					+ "[1] Show N firsts prime number.\n"
					+ "[2] Show if N is a prime number.\n"
					+ "[3] Show prime numbers between N and M.\n"
					+ "[4] Exit.");
			option = this.CheckIntInput();
			if (option == null) {
				option = 0;
			}
			
			switch ((int)option) {
				case 1:
					System.out.println("How many N prime number do you want to see ?");
					Object n = this.CheckIntInput();
					if(n != null) {
						this.ShowNPrimeNumbers((int)n);
					}
					break;
					
				case 2:
					System.out.println("What number N do you want to know if it is a prime number ?");
					n = this.CheckIntInput();
					if(n != null) {
						this.IsNPrimeNumber((int)n);
					}			
					break;
					
				case 3:
					System.out.println("What is the value of the first number: ");
					n = this.CheckIntInput();
					if(n != null) {
						System.out.println("What is the value of the second number: ");
						Object m = this.CheckIntInput();
						if(m != null) {
							if((int)n > (int)m) {
								Object temp = n;
								n = m;
								m = temp;
							}
							this.PrimeNumbersBetweenNandM((int)n, (int)m);
						}
					}
					break;
					
				case 4:
					System.out.println("Ending prime number section...");
					System.out.println();
			}
		} while ((int)option != 4);
	}
	
	private void ShowNPrimeNumbers(int n) {
		List<Integer> primeNumbers = new ArrayList<>();
		int inc = 0;
		int i = 2;
		
		while (inc != n) {
			for (int j=2; j<=i; j++) {
				if ( i % j == 0 ) {
					if ( i == j ) {
						primeNumbers.add(i);
						inc ++;
					} else {
						break;
					}
				}
			}
			i ++;
		}
		System.out.println();
		System.out.println("Those are the "+ n +" firsts prime numbers: ");
		System.out.println(primeNumbers);
		System.out.println();
	}
	
	private void IsNPrimeNumber(int n) {
		for (int i=2; i<=n ; i++) {
			if (n % i == 0) {
				if (n == i) {
					System.out.println();
					System.out.println("Result:");
					System.out.println(n + " is a prime number!");
					System.out.println();
					break;
				} else {
					System.out.println();
					System.out.println("Result:");
					System.out.println(n + " not a prime number.");
					System.out.println();
					break;
				}
			}
		}
	}
	
	private void PrimeNumbersBetweenNandM(int n, int m) {
		List<Integer> primeNumbers = new ArrayList<>();
		int count = 0;
		for(int i=n; i<=m; i++) {
			for (int j=2; j<=i; j++) {
				if ( i % j == 0 ) {
					if ( i == j ) {
						primeNumbers.add(i);
						count ++;
					} else {
						break;
					}
				}
			}
		}
		System.out.println();
		System.out.println("There are "+ count +" prime numbers between "+ n +" and "+ m +":");
		System.out.println(primeNumbers);
		System.out.println();
	}
	
	private Object CheckIntInput() {
		Scanner sc = new Scanner(System.in);
		try {
			int variable = Integer.parseInt(sc.nextLine());
			return variable;
		} catch (NumberFormatException e) {
			System.out.println("***");
			System.out.println("Error: The input must a numeric. Try again.");
			System.out.println("***");
			return null;
		}
	}
	
}
