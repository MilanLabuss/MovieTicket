//Author: Milan Labus
//Class: CC
//Date: 08/02/2019

//In this Program we will allow to user to select their movie and time
//and then display the cost and give them a choice to input a set discount Code
//Then the user will input their credit card details and we will display a ticket
//showing their order and cost as well as the last 4 digits of their card and the
//seats remaining will get updated

import java.util.Scanner;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class mainClass {

	static Scanner sc = new Scanner(System.in);
	static DecimalFormat CCformat = new DecimalFormat("XXXX-XXXX-XXXX-0000");
	static DecimalFormat moneyFormat = new DecimalFormat("#0.00");
	static String name;
	static String moviechoice;
	static String timeOfShow;
	//these are child and adult tickets set as an Int
	static int adult, child;
	//Here i have set the day price to price1 and Night Price to price 2.
	static double priceadult1 = 6.50, pricechild1 = 4, priceadult2 = 9.90, pricechild2 = 6.50;
	static String discountCode;
	//Here I have set the discount to equal -4
	static double discount = 4;
	static double finalPrice;
	static double cost;
	//Here i have set the seat numbers to 200
	static int seats1 = 200, seats2 = 200, seats3 = 200, seats4 = 200;
	//Total is the total number of tickets for each movie and they are ordered as they appear in the code.
	static int total1, total2, total3, total4;
	static long creditCardNumber;

	public static void main(String[] args) {
	//here i have put the switch statement selecting the movie
		do {
			do {
				getName();
				moviemenu();
				switch (moviechoice) {
				case "1":
					wwOne();
					break;
				case "2":
					badBoys();
					break;
				case "3":
					littlewoman();
					break;
				case "4":
					mercy();
					break;
				case "X":
				case "x":
					System.out.println("\tGoodbye");
					break;
				default:
					System.out.println("\t\nError in input: Choice must be 1, 2, 3, 4  or X");
	
			ticketMenu();			}
			} while (!(moviechoice.equals("1") || moviechoice.equals("2") || moviechoice.equals("3")
					|| moviechoice.equals("4") || moviechoice.equals("X")));
			Cost();
			discounts();
			boolean validCC = true;
			do {
				validCC = getCreditCard();
			} while (!validCC);

			finalTicket();

		} while (!moviechoice.equals("X") && !moviechoice.equals("x"));
	}

	public static void getName() {
		System.out.println("Please Enter your Name: ");
		name = sc.nextLine();
	}

	public static void moviemenu() {
		//This is the movie menu where the user selects which movie they
		//would like 
		System.out.println("\tMovie List:");
		System.out.println("\n\t1: 1917:\t\t" + "        seats remaining= " + seats1);
		System.out.println("\n\t2: Bad Boys for Life:\t\t" + "seats remaining= " + seats2);
		System.out.println("\n\t3: Little Woman:\t\t" + "seats remaining= " + seats3);
		System.out.println("\n\t4: Mercy:\t\t" + "        seats remaining= " + seats4);
		System.out.println("\n\tX: Exit");
		System.out.println("\n\tChoice > ");
		moviechoice = sc.next();
	}

	public static void ticketMenu() {
		//here the user picks the time and time of show becomes either 1 or 2
		System.out.println("\tplease select a time of viewing:");
		System.out.println("\t 1): Day:");
		System.out.println("\t 2): Night");
		System.out.println("\n\tChoice > ");
		timeOfShow = sc.next();
	}

	public static void Cost() {
		//here we will calculate the cost of the order
		if (timeOfShow.equals("1")) {
			cost = adult * priceadult1 + child * pricechild1;
			System.out.println("The Cost is: €" + moneyFormat.format(cost));
		} else {
			cost = adult * priceadult2 + child * pricechild2;
		}
	}

	public static void discounts() {
		//here is an if statement used for calculating a discount code
		System.out.println("please enter discount Code or type in next to continue");
		discountCode = sc.next();
		if (discountCode.toUpperCase().equals("GTTEN") || discountCode.toUpperCase().equals("GTDISC")) {
			finalPrice = cost - discount;
			System.out.println("Discounted cost: €" + moneyFormat.format(finalPrice));
		} else {
			finalPrice = cost;
			System.out.println("The Cost is: €" + moneyFormat.format(finalPrice));
		}
	}

	static boolean getCreditCard() {
		//Here we will get the users credit card information
		System.out.println("Enter your Credit Card number: ");
		creditCardNumber = sc.nextLong();
		if (creditCardNumber < 100000000000000l || creditCardNumber > 9999999999999999l)
			return false;
		else
		    System.out.println("Thank You");
		return true;
	}
	
	public static void drawALine(byte length) {
		//This a line we will add to the ticket
		for (byte i = 1; i <= length; i++)
			System.out.print("\u2500");
		System.out.println();
	}
	
	public static void wwOne() {
		//The code for the Movie 1917
		System.out.println("enter number of Adult tickets:");
		adult = sc.nextInt();
		System.out.println("enter number of Child tickets: ");
		child = sc.nextInt();
		if (adult < 1) {
			System.out.println("This movie is rated R Children must be accompanied by an Adult");
		} else {
			
		}
			total1 = adult + child;
			if (total1 > seats1 ) {
				System.out.println("Sorry this Movie is fully booked");
				moviemenu();
		} else {
				seats1 -= total1;
			
			}
	}
	public static void badBoys() {
		//Here is the code for the movie Bad Boys for Life
		System.out.println("enter number of Adult tickets:");
		adult = sc.nextInt();
		System.out.println("enter number of Child tickets: ");
		child = sc.nextInt();
		if (adult < 1) {
			System.out.println("This movie is rated R Children must be accompanied by an Adult");
		} else {
		}
		total2 = adult + child;
		if (total2 > seats2) {
			System.out.println("Sorry this Movie is fully booked");
			moviemenu();

		} else {
			seats2 -= total2;
		
		}
	}
	
	public static void mercy() {
		//Here is the code for the movie Just Mercy
		System.out.println("enter number of Adult tickets:");
		adult = sc.nextInt();
		System.out.println("enter number of Child tickets: ");
		child = sc.nextInt();
		total3 = adult + child;
		if (total3 > seats3) {
			System.out.println("Sorry this Movie is fully booked");
			moviemenu();  } 
		else {
			
			seats3 -= total3;
			
		}
	}
	
	public static void littlewoman() {
		//Here is the code the movie Little Women 
		System.out.println("enter number of Adult tickets:");
		adult = sc.nextInt();
		System.out.println("enter number of Child tickets: ");
		child = sc.nextInt();
		total4 = adult + child;
		
		if (total4>seats4) {
		System.out.println("Sorry this Movie is fully booked");
			moviemenu();  } 
		else {
		seats4 -= total4;
		}
	}
	
	public static void finalTicket() {
		//This is the code for displaying the final ticket
		drawALine((byte) 80);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println("\t\t\t\t\t\t\t" + dtf.format(now));
		System.out.println("\n\t\t\t     THE GALAXY THEATRE");
		System.out.println("\n\t\t\tTickets for:  " + name);
		System.out.println("\n\t\t\tUnder 18:      " + child);
		System.out.println("\t\t\tAdult:\t       " + adult);
		System.out.println("\t\t\tTicket Cost:   €" + moneyFormat.format(cost));
		double disCountAmount = cost - finalPrice;
		System.out.println("\t\t\tDiscount:      €" + moneyFormat.format(disCountAmount));
		System.out.println("\t\t\ttotal cost:    €" + moneyFormat.format(finalPrice));
		short last4Digits = (short) (creditCardNumber % 10000);
		creditCardNumber = creditCardNumber / 10000;
		System.out.println("\n\t\t\tPaid by Credit Card: " + CCformat.format(last4Digits));
		drawALine((byte) 80);
	}
}
