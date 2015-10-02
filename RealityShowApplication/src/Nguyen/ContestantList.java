package Nguyen;

import java.util.Scanner;
import java.util.ArrayList; 

public class ContestantList {


	public ContestantList() {

	}
		
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean flag = false;
		ArrayList<ContestantInformation> Cl = new ArrayList<ContestantInformation>();
				
		do{	
			
			/**
			 * Contestant inputs values
			 */
			
			System.out.print ("Enter first name.");
			String Fname = scan.nextLine();	

			System.out.print ("Enter last name.");
			String Lname = scan.nextLine();

			System.out.print ("Enter your address.");
			String Staddress = scan.nextLine();

			System.out.print ("Enter the city you live in.");
			String Citee = scan.nextLine();

			System.out.print ("Enter the province you live in.");
			String Provincal = scan.nextLine();

			System.out.print ("Enter your postal code.");
			String Postcode = scan.nextLine();

			System.out.print ("Enter your phone number.");
			String Phone = scan.nextLine();

			System.out.print ("Enter your birth date.");
			String Bday = scan.nextLine();
			
			flag = false;

			try {	   
				
				/**
				 * Properly sets contestant input values and sets the province value to the enum type Province
				 */
				ContestantInformation Contestant1 = new ContestantInformation ();

				Contestant1.setFirstName(Fname);
				Contestant1.setlastName(Lname);
				Contestant1.setstreetAddress(Staddress);
				Contestant1.setcity(Citee);

				if (Provincal.equalsIgnoreCase("Ontario")||Provincal.equalsIgnoreCase("ON"))
					Contestant1.setprovince(Province.ON);
				else if (Provincal.equalsIgnoreCase("yukon territories")||Provincal.equalsIgnoreCase("Yukon")||Provincal.equalsIgnoreCase("YT"))
					Contestant1.setprovince(Province.YT);
				else if (Provincal.equalsIgnoreCase("Quebec")||Provincal.equalsIgnoreCase("QC"))
					Contestant1.setprovince(Province.QC);
				else if (Provincal.equalsIgnoreCase("Saskatchewan")||Provincal.equalsIgnoreCase("SK"))
					Contestant1.setprovince(Province.SK);
				else if (Provincal.equalsIgnoreCase("Nova Scotia")||Provincal.equalsIgnoreCase("NS"))
					Contestant1.setprovince(Province.NS);
				else if (Provincal.equalsIgnoreCase("Nunavut")||Provincal.equalsIgnoreCase("NU"))
					Contestant1.setprovince(Province.NU);
				else if (Provincal.equalsIgnoreCase("Northwest territories")||Provincal.equalsIgnoreCase("Northwest")||Provincal.equalsIgnoreCase("NT"))
					Contestant1.setprovince(Province.NT);
				else if (Provincal.equalsIgnoreCase("Manitoba")||Provincal.equalsIgnoreCase("MB"))
					Contestant1.setprovince(Province.MB);
				else if (Provincal.equalsIgnoreCase("British columbia")||Provincal.equalsIgnoreCase("BC"))
					Contestant1.setprovince(Province.BC);
				else if (Provincal.equalsIgnoreCase("Alberta")||Provincal.equalsIgnoreCase("AB"))
					Contestant1.setprovince(Province.AB);
				else if (Provincal.equalsIgnoreCase("Prince Edward Island")||Provincal.equalsIgnoreCase("PEI"))
					Contestant1.setprovince(Province.PEI);
				else if (Provincal.equalsIgnoreCase("Newfoundland and Labrador")||Provincal.equalsIgnoreCase("NL"))
					Contestant1.setprovince(Province.NL);
				else if (Provincal.equalsIgnoreCase("New brunswick")||Provincal.equalsIgnoreCase("NB"))
					Contestant1.setprovince(Province.NB);
				else
				{
					throw new InvalidInputException();
				}

				Contestant1.setpostalCode(Postcode);
				Contestant1.setphoneNum(Phone);
				Contestant1.setbirthDate(Bday);

				/**
				 * Once everything is okay the current contestant will be added to a list and a label will be printed
				 */
				Cl.add(Contestant1);
				Label Label1 = new Label (Contestant1);
				System.out.print (Label1.toString());
				
			}
			/**
			 * Used to check for errors
			 */
			catch (InvalidInputException e){
				System.out.print (e.getMessage());
				flag=true;
			}

		}
		while (flag);
	}
}
