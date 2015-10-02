/**
 * 
 */
package Nguyen;

/**
 * @author StevenNguyen
 * @date September 21, 2015
 */
public class ContestantInformation {
	private String firstName ;
	private String lastName ;
	private String streetAddress;
	private String city;
	private Province province;
	private String postalCode;
	private String phoneNum;
	private String birthDate;


	/**
	 * constructor thats holds all user data
	 * @param FN
	 * @param LN
	 * @param SA
	 * @param CY
	 * @param PV
	 * @param PC
	 * @param PN
	 * @param BD
	 * @throws InvalidInputException 
	 */
	public  ContestantInformation (String FN,String LN,String SA,String CY, Province PV , String PC, String PN,String BD) throws InvalidInputException{
		this.setFirstName(FN);
		this.setlastName(LN);
		this.setstreetAddress(SA);
		this.setcity(CY);
		this.setprovince(PV);
		this.setpostalCode(PC);
		this.setphoneNum(PN);
		this.setbirthDate(BD);
	}	
	/**
	 * empty constructor
	 */
	public ContestantInformation() {		
	}

	/**
	 * Set first name
	 * @param FN
	 */	
	public void setFirstName(String FN) throws InvalidInputException{
		for (int i=0;i<FN.length();i++)
			if (!Character.isLetter(FN.charAt(i)))
				throw new InvalidInputException ("First name in letters please!");
		this.firstName=FN;
	}

	/**
	 * set last name
	 * @param LN
	 */
	public void setlastName(String LN) throws InvalidInputException{
		for (int k=0; k<LN.length();k++)
			if (!Character.isLetter(LN.charAt(k)))
				throw new InvalidInputException ("Last name in Letters please!");		    
		this.lastName=LN;
	}

	/**
	 * set street address
	 * @param SA
	 */
	public void setstreetAddress(String SA) throws InvalidInputException{
		this.streetAddress=SA;
	}

	/**
	 * set city
	 * @param CY
	 */
	public void setcity (String CY)throws InvalidInputException{
		for (int r=0;r<CY.length();r++)
			if (!Character.isLetter(CY.charAt(r)))
				throw new InvalidInputException("Please re-enter, no numbers!");  	
		this.city=CY;
	}

	/**
	 * set province
	 * @param PV
	 */
	public void setprovince (Province PV)throws InvalidInputException{
		this.province = (PV);
	}

	/**
	 * set postal code
	 * @param PC
	 * @throws InvalidInputException
	 */
	public void setpostalCode (String PC) throws InvalidInputException{
		if (PC.length()>6){
			throw new InvalidInputException("This code is too long!");
		}
		if (PC.length()<6){
			throw new InvalidInputException("This code is too short!");
		}
		for (int f=0;f<PC.length();f+=2)
			if (!Character.isLetter(PC.charAt(f)))
				throw new InvalidInputException("Incorrect order please re-enter!");  	
		for (int e=1;e<PC.length();e+=2)
			if (!Character.isDigit(PC.charAt(e)))
				throw new InvalidInputException("Incorrect order please re-enter!"); 	
		this.postalCode=PC;
	}

	/**
	 * set phone number
	 * @param PN
	 * @throws InvalidInputException
	 */
	public void setphoneNum (String PN) throws InvalidInputException{
		if (PN.length()>12){
			throw new InvalidInputException("This phone number is too long!");
		}
		if (PN.length()<12){
			throw new InvalidInputException("This phone number is too short!");
		}    	
		if (PN.charAt(3)!='-')
			throw new InvalidInputException("Please include dashes please!");
		if (PN.charAt(7)!='-')
			throw new InvalidInputException("Please include dashes please!");  	
		this.phoneNum=PN;
	}

	/**
	 * set birth date
	 * @param BD
	 */
	public void setbirthDate (String BD) throws InvalidInputException{
		if (BD.length()<9){
			throw new InvalidInputException("Not the correct length");
		}
		if (BD.charAt(2)!='/')
			throw new InvalidInputException ("birth date in number form please dd/mm/year.");
		if (BD.charAt(5)!='/')
			throw new InvalidInputException ("birth date in number form please dd/mm/year.");
		this.birthDate=BD;
	}



	/**
	 * Get first name
	 * @return
	 */    		    
	public String getFirstName(){
		return this.firstName;
	}
	/**
	 *  get last name
	 * @return
	 */
	public String getlastName(){
		return this.lastName;
	}
	/**
	 * get street address
	 * @return
	 */
	public String getstreetAddress(){
		return this.streetAddress;
	}
	/**
	 * get city
	 * @return
	 */
	public String getcity (){
		return this.city;
	}
	/**
	 * get province
	 * @return
	 */
	public Province getprovince (){
		return this.province;
	}
	/**
	 * get postal code	
	 * @return
	 */
	public String getpostalCode (){
		return this.postalCode;
	}
	/**
	 * get phone number
	 * @return
	 */
	public String getphoneNum (){
		return this.phoneNum;
	}
	/**
	 * get birth date
	 * @return
	 */
	public String getbirthDate (){
		return this.birthDate;
	}

	/**
	 * toString method to output all info on one line
	 */
	public String toString(){
		return (firstName + " " + lastName + " " + streetAddress + " " + city + " " + province + " " + postalCode + " " + phoneNum + " " + birthDate);
	}
}
