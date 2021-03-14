import java.util.Formatter;
import java.time.format.DateTimeFormatter;

/**
 * 
 */

/**
 * @author LPOTT
 *
 */
public class project_object implements customer{
	String Date;
	String New_Project_name; //Done
	String Project_number;//Done
	String Building_Design;//Done
	String due_date;//Done
	double amount_paid;//Done
	double ERF_number;
    double total_amount;//Done
    String Physical_address;//Done
    private String values;
    String Completed;
	//String Project_finilizing;
	
	Person contractor;
	Person customer;
	Person architecture;
	//information holding
	project_object(String pname, String duedate, double ampaid,String BuildSeign,double ERFnumb,String projnumb, double tot_amount, String physicalAdrss,String comp){
		New_Project_name = pname;//check
		total_amount = tot_amount;//check
		Project_number = projnumb;
		ERF_number = ERFnumb;//check
		Building_Design = BuildSeign;//check
		amount_paid = ampaid;//check
		due_date = duedate;//check
		Physical_address = physicalAdrss;//check
		Completed = comp;//check
	}
	
	
	
public String getNew_Project_name() {
		return New_Project_name;
	}



	//to call information to file write method in class and call into to main
	public String toString() {
		String output = "Project name: " + New_Project_name; 
		output +="\nProject number: " + Project_number;
		output +="\nERF number: " + ERF_number;
		output +="\nBuilding Design: " + Building_Design;
		output +="\nDue Date: " + due_date;
		output +="\nPhysical Address: " + Physical_address;
		output +="\namount Paid: " + amount_paid;
		output += "\nTotal amount: " + total_amount;
		output += "\ncompleted: " + Completed;
		
		return output;
	}
	public void calc(double amount)
	{
		total_amount = amount_paid - total_amount;
	}
	
	public void Complete(String cPd)
	{
		if(cPd == "yes")
		{
			System.out.println("task completed");
		}
		else
		{
			System.out.println("task incompleted");
		}
		
	}
	
	/*public static String time(String format)
	{
		Date date = new Date();
		SimpleDateFormat sdf =  new SimpleDateFormat("MMM-dd-yyyy");
	}*/
	public String toFile() {
		return "project name: "+ New_Project_name+ "\nDue Date:  "+ due_date +"\nTotal amount:  "+ total_amount +
				"\nProject Number:  "+ Project_number + "\nERF Number:  "+ ERF_number+
				"\nBuilding Design: " + Building_Design+ "\nAmount Paid:  "+ amount_paid + "\nPhysical Address:  "+
				Physical_address + "\nCompletedL:  " + Completed;
	}

	/*	public void constructor(String Name,String Telephone,String Email_address,String Physical_Address)
	{
		Person constructor = new Person(Name,Telephone,Email_address, Physical_Address);
		Person customer = new Person(Name,Telephone,Email_address, Physical_Address);
		Person architecture = new Person(Name,Telephone,Email_address, Physical_Address);
	}
	*/
	public void update(double total_amount_paid)
	{
		amount_paid += total_amount_paid;
		
	}
	public void changeupdate(String dd) {
		due_date = dd;//replaces information
	}
	
	public void changeName(String Pn)
	{
		New_Project_name = Pn;
	}
	
	public void changedes(String bd)
	{
		Building_Design = bd;
	}
	
	public double getTotal_amount()
	{
		return total_amount;
	}
	public double getAmount_paid()
	{
		return amount_paid;
	}
	public void addContractor(String Name,String Telephone,String Email_address,String Physical_Address) {
		contractor = new Person(Name,Telephone, Email_address,Physical_Address);//calls the information from person class
	}
	
	public void addCustomer(String Name,String Telephone,String Email_address,String Physical_Address)
	{
		customer = new Person(Name,Telephone, Email_address,Physical_Address);
	}
	
	public void addArchitecture(String Name,String Telephone,String Email_address,String Physical_Address)
	{
		architecture = new Person(Name,Telephone, Email_address,Physical_Address);
	}
	public Person getContractor()
	{
		return contractor;
	}
	
	public Person getCustomer()
	{
		return customer;
	}
	
	public Person getArchitecture()
	{
		return architecture;
	}
	
	public void setValues(String v) {
		values = v;
	}

}
