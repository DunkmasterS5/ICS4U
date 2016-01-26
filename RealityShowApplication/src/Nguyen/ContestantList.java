package Nguyen;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections; 

/**
 * This class is the main menu where the user can input and manipulate information
 * including: add and clearing contestants, and saving and loading
 */

public class ContestantList {
	static Scanner scan;

	public static void main(String[] args) throws InvalidInputException {
		
		ArrayList<ContestantInformation> C1 = new ArrayList<ContestantInformation>();
		scan = new Scanner(System.in);		
		int menuselection;	
		do {		
			/**
			 * The menu allows the user to select an action
			 */

			System.out.println("1. Add new contestant");
			System.out.println("2. Print Label");
			System.out.println("3. Search");
			System.out.println("4. Remove Contestant");
			System.out.println("5. Clear All Contestants");
			System.out.println("6. Save");
			System.out.println("7. Load");
			System.out.println("8. Sort");
			System.out.println("9. Exit");
			menuselection = scan.nextInt();

			if (menuselection == 1)
				addContestant(C1);
			if (menuselection == 2)
				printContestantLabels (C1);
			if (menuselection == 3)	
				searchTerms (C1);
			if (menuselection == 4)
				remove(C1);
			if (menuselection == 5)
				clearAll(C1);
			if (menuselection == 6)
				saveData(C1);
			if (menuselection == 7)
				loadData(C1);
			if (menuselection == 8)
				sortData(C1);

		} while (menuselection !=9);
	}
/**
 * Contestants input their information then are accepted in after everything is checked and they answer a question
 * @param C1
 */
	
	public static void addContestant (ArrayList<ContestantInformation> C1){
		Scanner scan = new Scanner(System.in);
		boolean flag = false;

		/**
		 * the Contestant inputs values
		 */
		do{
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
						
			String question = "What colour is the sky?";

			flag = false;

			try {	   

				/**
				 * Properly sets (when correct) contestant input values and sets the province value to the enum type Province when found
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
				System.out.println(question);
				String answer=scan.nextLine();
				if (answer.equalsIgnoreCase("blue")){
                    System.out.println("Congrats, Contestant!");
					C1.add(Contestant1);
					Label Label1 = new Label (Contestant1);
					System.out.print (Label1.toString());
				}

			}
			/**
			 * Used to check for errors when setting user values
			 */
			catch (InvalidInputException e){
				System.out.print (e.getMessage());
				flag=true;
			}
		}
		while (flag);
	}

	/**
	 * using the list of contestants the user can print the information of the requested Contestant
	 * @param C1
	 */
	public static void printContestantLabels (ArrayList<ContestantInformation> C1){		
		Label label1;					
		if (C1.size()==0){
			System.out.print ("That person does not exist.");
		}
		else{
			for (int a=0;a<C1.size();a++){
				label1 = new Label (C1.get(a));
				System.out.println (label1.toString()) ;
			}
		}
	}

	/**
	 * using a temporary list the user can search for the required individual based on input information
	 * @param C1
	 * @throws InvalidInputException
	 */
	public static void searchTerms (ArrayList<ContestantInformation> C1) throws InvalidInputException{
		System.out.println("Enter the last name of the person you wish to find.");
		String first = scan.nextLine();
		System.out.println("Enter the first name of the person you wish to find.");
		String last = scan.nextLine();

		ContestantInformation temp=new ContestantInformation();
		temp.setFirstName(first);
		temp.setlastName(last);

		Searches.linearSearch(C1, temp);
		if (Searches.linearSearch(C1, temp)==-1)
			 System.out.print("This person is not in the list.");
		else 
			System.out.print("This person is in the list.");
	}

	/**
	 * The User can remove a existing contestant and their information
	 * @param C1
	 */
	public static void remove (ArrayList<ContestantInformation> C1){
		System.out.println("Enter the number of the contestant you wish to remove.");
		int select = scan.nextInt();
		C1.remove(select);
	}

	/**
	 * The user can remove all existing contestants and their information
	 * @param C1
	 */
	public static void clearAll (ArrayList<ContestantInformation> C1){
		C1.removeAll(C1);
	}

	/**
	 * Saves contestants and their information into a file
	 * @param C1
	 */
	public static void saveData (ArrayList<ContestantInformation> C1) { 	
		FileOutputStream fileOutputStream;
		try {
			fileOutputStream = new FileOutputStream("src\\Nguyen\\contestants.txt");
			PrintStream fps = new PrintStream(fileOutputStream);
			for (int i=0;i<C1.size();i++){
				fps.println(C1.size());
				fps.println(C1.get(i).getFirstName());
				fps.println(C1.get(i).getlastName());
				fps.println(C1.get(i).getstreetAddress());
				fps.println(C1.get(i).getcity());
				fps.println(C1.get(i).getprovince());
				fps.println(C1.get(i).getpostalCode());
				fps.println(C1.get(i).getphoneNum());
				fps.println(C1.get(i).getbirthDate());
			}
			try {
				fileOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}   

		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Loads information from the file
	 * @param C1
	 * @throws InvalidInputException 
	 */
	public static void loadData (ArrayList<ContestantInformation> C1) throws InvalidInputException{
		BufferedReader fbr;
		try {
			fbr = new BufferedReader(new FileReader("src\\Nguyen\\contestants.txt"));
			String load = fbr.readLine();
			int x = Integer.parseInt(load);
			for (int i=0;i<x;i++){
				
				String firstName = fbr.readLine();
				String lastName = fbr.readLine();
				String streetAddress = fbr.readLine();
				String city = fbr.readLine();
				String province = fbr.readLine();
				String postalCode = fbr.readLine();
				String phoneNumber = fbr.readLine();
				String birthDate = fbr.readLine();
				//make new ContestantInformation
				//add ContestantInformation to the ArrayList
				
				
				ContestantInformation loaded = new ContestantInformation();
				C1.add(loaded);
				
				loaded.setFirstName(firstName);
				loaded.setlastName(lastName);
				loaded.setstreetAddress(streetAddress);
				loaded.setcity(city);
				loaded.setprovince(checkProvince(province));
				loaded.setpostalCode(postalCode);
				loaded.setphoneNum(phoneNumber);
				loaded.setbirthDate(birthDate);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();			
		} 
		catch (IOException e) {				
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Similar to the add contestant method when a contestant is loaded the method will check the province and return it in the Province enum type
	 * @param province
	 * @return Province
	 */
	public static Province checkProvince (String province){
		
		if (province.equalsIgnoreCase("Ontario")||province.equalsIgnoreCase("ON"))
			return Province.ON;
		else if (province.equalsIgnoreCase("yukon territories")||province.equalsIgnoreCase("Yukon")||province.equalsIgnoreCase("YT"))
			return Province.YT;
		else if (province.equalsIgnoreCase("Quebec")||province.equalsIgnoreCase("QC"))
			return Province.QC;
		else if (province.equalsIgnoreCase("Saskatchewan")||province.equalsIgnoreCase("SK"))
			return Province.SK;
		else if (province.equalsIgnoreCase("Nova Scotia")||province.equalsIgnoreCase("NS"))
			return (Province.NS);
		else if (province.equalsIgnoreCase("Nunavut")||province.equalsIgnoreCase("NU"))
			return (Province.NU);
		else if (province.equalsIgnoreCase("Northwest territories")||province.equalsIgnoreCase("Northwest")||province.equalsIgnoreCase("NT"))
			return (Province.NT);
		else if (province.equalsIgnoreCase("Manitoba")||province.equalsIgnoreCase("MB"))
			return (Province.MB);
		else if (province.equalsIgnoreCase("British columbia")||province.equalsIgnoreCase("BC"))
			return (Province.BC);
		else if (province.equalsIgnoreCase("Alberta")||province.equalsIgnoreCase("AB"))
			return (Province.AB);
		else if (province.equalsIgnoreCase("Prince Edward Island")||province.equalsIgnoreCase("PEI"))
			return (Province.PEI);
		else if (province.equalsIgnoreCase("Newfoundland and Labrador")||province.equalsIgnoreCase("NL"))
			return (Province.NL);
		else if (province.equalsIgnoreCase("New brunswick")||province.equalsIgnoreCase("NB"))
			return (Province.NB);
		return (Province.ON) ;
	}
	
	
	/**
	 * Sorts the list of contestants
	 * @param C1
	 */
	@SuppressWarnings("unchecked")
	public static void sortData (ArrayList<ContestantInformation> C1){
		Collections.sort(C1);
	}

}