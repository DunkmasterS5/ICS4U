package Nguyen;


/**
 * Outputs Contestant information in a specific format
 * @author StevenNguyen
 *
 */
public class Label {	
	private ContestantInformation ci1;
	private String output = "";

	public Label(ContestantInformation cio) {
		
		this.ci1=cio;
		formatName();
		formatAddress();
		formatNumber();		
	}
	
	/**
	 * Formats first name and last name
	 */
	private void formatName(){
		 output = output + ci1.getlastName();
				 output = output + "," +ci1.getFirstName() + "\n";		
	}
	
	/**
	 * Formats street address city and province
	 */
	private void formatAddress(){
		output = output + ci1.getstreetAddress() + "\n";
		  output = output + ci1.getcity() + "," + ci1.getprovince() + "\n";
		  		   
	}
	
	/**
	 * Formats postal code and phone number
	 */
	private void formatNumber(){
		String phoneTemp=ci1.getphoneNum();
		output = output + ci1.getpostalCode() + "\n";
			output = output + "(" + phoneTemp.substring(0, 3) + ")" + phoneTemp.substring(3,7) + phoneTemp.substring(7,12) ;		
	}
	
	/**
	 * Method to return all formated info
	 */
	public String toString(){
		return (output);
		
	}

}
