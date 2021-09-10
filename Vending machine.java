// This code is a vending machine that accepts coins and bills. 
import java.util.Scanner;

public class Main
{
  static Scanner input = new Scanner (System.in);
  static int balance = 0, product, coins, bills, total = 0, change = 0,
    options;

  public static void payment (int opt, int coin, int bill)
  {
    System.out.
      println
      ("\nPlease select the payment method. \n Enter a zero to finish entering");
    do
      {
	// enter money options
	System.out.println ("0. Done entering money");
	System.out.println ("1. Enter coins");
	System.out.println ("2. Enter bills");
	options = opt;



	if (options == 0)
	  {
	    break;
	  }

	else if (options == 1)
	  {			// 1 for coins
	    System.out.println ("Enter coins");
	    System.out.print (coin);
	    do
	      {
		coins = coin;

		switch (coins)
		  {
		  case 0:
		    break;
		  case 1:	// penny
		    total += 1;
		    break;
		  case 5:	// nickle
		    total += 5;
		    break;
		  case 10:	// dime
		    total += 10;
		    break;
		  case 25:	// quarter
		    total += 25;
		    break;
		  default:
		    System.out.println ("Invalid Coins");
		  }
	      }
	    while (coins != 0);
	  }
	else if (options == 2)
	  {
	    System.out.println ("Enter bills");
	    System.out.print (bill);
	    do
	      {
		bills = bill;
		// enter bills
		switch (bills)
		  {
		  case 0:
		    break;
		  case 1:	// 1 dollar
		    total += 100;
		    break;
		  case 5:	// 5 dollar
		    total += 500;
		    break;

		  default:
		    System.out.println ("Invalid Bills");
		  }
	      }
	    while (bills != 0);
	  }
	else
	  {
	    System.out.println ("Invalid Options");
	  }
      }
    while (options != 0);
  }

  public static void payment ()
  {
    System.out.
      println
      ("\nPlease select the payment method. \nEnter a zero to finish entering");
    do
      {

	System.out.println ("0. Done entering money");
	System.out.println ("1. Enter coins");
	System.out.println ("2. Enter bills");
	options = input.nextInt ();
	if (options == 0)
	  {
	    break;
	  }

	else if (options == 1)
	  {
	    System.out.println ("Enter coins");
	    do
	      {
		coins = input.nextInt ();

		switch (coins)
		  {
		  case 0:
		    break;
		  case 1:
		    total += 1;
		    break;
		  case 5:
		    total += 5;
		    break;
		  case 10:
		    total += 10;
		    break;
		  case 25:
		    total += 25;
		    break;
		  default:
		    System.out.println ("Invalid Coins");
		  }
	      }
	    while (coins != 0);
	  }
	else if (options == 2)
	  {
	    System.out.println ("Enter bills");

	    do
	      {
		bills = input.nextInt ();

		switch (bills)
		  {
		  case 0:
		    break;
		  case 1:
		    total += 100;
		    break;
		  case 5:
		    total += 500;
		    break;
		  default:
		    System.out.println ("Invalid Bills");
		  }
	      }
	    while (bills != 0);
	  }
	else
	  {
	    System.out.println ("Invalid Options");
	  }
      }
    while (options != 0);
  }

  public static void buy ()
  {
    //Start the PURCHASE module
    System.out.println ("Please select your product.");

    product = input.nextInt ();

    switch (product)
      {
      case 0:
	balance += 0;
	break;
      case 1:
	balance += 50;
	break;
      case 2:
	balance += 100;
	break;
      case 3:
	balance += 175;
	break;
      case 4:
	balance += 150;
	break;
      case 5:
	balance += 200;
	break;
      default:
	System.out.println ("Invalid Products");
      }
  }

  public static String calculatecoin (int changes)
  {
    String changeString = "";
    int quarters, remQ = 0;
    int dimes, remD = 0;
    int nickles, remN = 0;
    int pennies = 0;

    quarters = change / 25;
    remQ = change % 25;
    changeString += quarters + " quarters\n";

    if (remQ != 0)
      {
	dimes = remQ / 10;
	remD = remQ % 10;
	changeString += dimes + " dimes\n";
      }

    if (remD != 0)
      {
	nickles = remD / 5;
	remN = remD % 5;
	changeString += nickles + " nickles\n";
      }

    if (remN != 0)
      {
	pennies = remN;
	changeString += pennies + " pennies\n";
      }
    return changeString;
  }

  public static String change ()
  {
    String changeDisplay = "";
    if (total > balance)
      {
	change = total - balance;

	changeDisplay = calculatecoin (change);
      }
    else
      {
	changeDisplay = "Enter more money";
      }

    return changeDisplay;
  }

  public static void display ()
  {
    System.out.println ("BALANCE : " + balance);
    System.out.println ("TOTAL MONEY : " + total);
    System.out.println ("CHANGE :\n " + change ());
  }

  public static void main (String[]args)
  {
    System.out.println ("Wellcome to Alcorn Vending!");
    System.out.println ("0. Get money back");
    System.out.println ("1. Gum\t\t$.50");
    System.out.println ("2. Lifesavers\t$1.00");
    System.out.println ("3. Reese\t$1.75");
    System.out.println ("4. Twix\t\t$1.50");
    System.out.println ("5. Doritos\t$2.00");

    payment ();
    buy ();
    change ();
    display ();
  }
}
