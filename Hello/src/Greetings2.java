import java.util.Scanner;

/*
 * This program prompts the user to enter his or her first name and last name and displays 
 * a greeting message author:Marialitvin
 */
public class Greetings2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("enter your first name: ");
		String firstName = scan.nextLine();
		System.out.print("enter your last name: ");
		String lastName = scan.nextLine();
		System.out.println ("Hello " + firstName + " " + lastName);
		System.out.println ("Welcome to java!");

	}

}
