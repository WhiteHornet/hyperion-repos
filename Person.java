/**
 * 
 */

/**
 * @author LPOTT
 *
 */
import java.util.*;
 public class Person implements customer{
		String Name;
		String Telephone;
		String Email_address;
		String Physical_Address;
;
		

	public Person(String name2, String telephone2, String email_address2, String physical_Address2) {
		// TODO Auto-generated constructor stub
		Name = name2;
		Telephone = telephone2;
		Email_address = email_address2;
		Physical_Address = physical_Address2;

	}

	
	public void setTelephone(String telephone) {
		Telephone = "Telephone: " + telephone;
	}
	
	public String toFile() {
		return "Name:  "+ Name+ ", "+ Telephone + ", "+ Email_address + ", "+ Physical_Address;
	}

	public String getTelephone() {
		return Telephone;
	}
	
	public String getName()
	{
		return Name;
	}


	public void setEmail_address(String email_address) {
		Email_address = email_address;
	}


	public String toString()
	{
		String output = "Name: " + Name;
		output +="\nTelephone: " + Telephone;
		output +="\nEmail Address: " + Email_address;
		output +="\nPhysical Address: " + Physical_Address;
				return output;
	}
	
}
