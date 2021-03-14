/**
 * 
 */

/**
 * @author LPOTT
 *
 */
import java.util.*;
import java.util.Arrays;
import java.io.IOException;
import java.io.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
public class Project{
	public static project_object capturProject() {
		//when writing to file use while loop 
		//but when reading no loop needed
			Scanner prInput = new Scanner(System.in);//project type
			System.out.print("Project name: ");
			String pname = prInput.nextLine();
			
			prInput = new Scanner(System.in);
			System.out.print("Project due date: ");
			String duedate = prInput.nextLine();
			
			prInput = new Scanner(System.in);
			System.out.println("buidling deisgn: ");
			String BuildSeign = prInput.nextLine();
			
			prInput = new Scanner(System.in);
			System.out.print("Project total Amount: ");
			double tot_amount = prInput.nextDouble();
			
			prInput = new Scanner(System.in);
			System.out.print("Project TEl: ");
			double ERFnumb = prInput.nextDouble();
			
			prInput = new Scanner(System.in);
			System.out.print("Project total amount paid: ");
			double ampaid = prInput.nextDouble();

			prInput = new Scanner(System.in);
			System.out.print("Project number: ");
			String projnumb = prInput.nextLine();
			
			prInput = new Scanner(System.in);
			System.out.print("Project physical address: ");
			String physicalAdrss = prInput.nextLine();
			
			prInput = new Scanner(System.in);
			System.out.println("Is the project completed");
			String comp = prInput.nextLine();
			return new project_object(pname,duedate, ampaid,BuildSeign,ERFnumb,projnumb,tot_amount, physicalAdrss,comp);
	}
		
	
	public static project_object  new_details(String p, project_object pj)
	{//questions asked for all personal
		Scanner Contr = new Scanner(System.in);
		System.out.println("What is a "+ p +" name: ");
		String name2 = Contr.nextLine();
		
		Contr = new Scanner(System.in);
		System.out.println("What is your"+ p + "number?");
		String telephone2 = Contr.nextLine();
		
		Contr = new Scanner(System.in);
		System.out.println("What is your"+ p +" email address: ");
		String email_address2 = Contr.nextLine();
		
		Contr = new Scanner(System.in);
		System.out.println("What is your"+ p + "physical address:");
		String physical_address2 = Contr.nextLine();
		
		if(p.equalsIgnoreCase("Contractor"))//calls the add methods to main
			pj.addContractor(name2, telephone2, email_address2, physical_address2);
		else if(p.equalsIgnoreCase("customer")) {
			pj.addCustomer(name2, telephone2, email_address2, physical_address2);
		}
		
		return pj;
			
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<project_object> projectlist = new ArrayList();
		String input = "07/01/2015";
		int count = 0;
		DateTimeFormatter f = DateTimeFormatter.ofPattern("DD/MM/YYYY");

		
		//projectlist.add(new p)
		
		// TODO Auto-generated method stub
		//reading to the file from here
		try {
			File name = new File("workDocument.txt");
			Scanner read = new Scanner(name);
			while(read.hasNext()) {
				String data = read.nextLine();
				String dataarray [] = data.split(", "); 
				//split
			
				//create the object
				project_object prjfile = new project_object(dataarray[0], dataarray[1], Double.parseDouble(dataarray[2]), dataarray[3],
						Double.parseDouble(dataarray[4]), dataarray[5], Double.parseDouble(dataarray[6]),dataarray[7],dataarray[8]);
				prjfile.addArchitecture(dataarray[9], dataarray[10], dataarray[11], dataarray[12]);
				prjfile.addCustomer(dataarray[13], dataarray[14], dataarray[15], dataarray[16]);
				prjfile.addContractor(dataarray[17], dataarray[18], dataarray[19], dataarray[20]);
				//(String pname, String duedate, double ampaid,String BuildSeign,double ERFnumb,String projnumb, double tot_amount, String physicalAdrss,String comp
				//add into the list
				projectlist.add(prjfile);
				//System.out.println(Arrays.toString(dataarray));
			}

		//pr.addContractor("nathan","+227546214","hypercrs@google.com", "5 jonson str");
		//pr.addArchitecture("carl", "+227584617", "crowsfeet@google.co.za","21 foget av");
		//pr.addCustomer("kevin","+22754135","constute@google.com","1 number str");
		}catch(Exception e) {
			System.out.println("reading data from project file has failed");
		}
		int choiceEntry;
		do {
		System.out.println(" Enter one of the following commands");
		System.out.println("1 - Select project");
		System.out.println("2 - view project details");
		System.out.println("3 - Add a new project");
		System.out.println("4 - Exit");

		//System.out.println("8 - Exit");
		Scanner scanChoice = new Scanner(System.in);//takes in response
		System.out.println();
		System.out.println("Please enter either number from 1 to 4");
		//String data = scanChoice.nextLine();
		choiceEntry = scanChoice.nextInt();
		
		System.out.println(choiceEntry);
			switch(choiceEntry){
	        case 1:
	        	
	        	System.out.println("Please select from the list below");
	        	//int count = 1;//gets project name
	        	for(project_object p:projectlist) {
	        		
	        		System.out.println(count+ ": " + p.getNew_Project_name());
	        		count++;
	        	}
	        	Scanner in = new Scanner(System.in);
	        	int choice = in.nextInt();
	        	//update project deatils//project options
	        	project_object pr = projectlist.get(0);//!only works when there are 3 projects 
	        	//within the list in order to access menu options
	        	pr = projectlist.get(choice);
	        	//pr = projectlist.get(2);//select from the list
	        	int newChoice;
	        	do {
	        	Scanner newMenu = new Scanner(System.in);
	        	System.out.println("Enter a number between 1 to 6");
	        	System.out.println("1 - update project deatils");
	    		System.out.println("2 - Total Amount of Fee Paid to Date");
	    		System.out.println("3 - Update Contractors Contact Details");
	    		System.out.println("4 - print information");
	    		System.out.println("5 - Finalise project");
	    		System.out.println("6 - Exit");//need to return to menu or quit menu to return to original menu
	    		newChoice = newMenu.nextInt();
	    		switch(newChoice)//not going back to menu
	    		{
	    		case 1:
	    			//replaces information
		        	System.out.println("update your project details");
		        	System.out.println("update date");
		        	Scanner datechange = new Scanner(System.in);
		        	String newDueda = datechange.nextLine();
		        	pr.changeupdate(newDueda);
		        	System.out.println("update project name");
		        	Scanner namechange = new Scanner(System.in);
		        	String newName = namechange.nextLine();
		        	pr.changeName(newName);
		        	System.out.println("update project design");
		        	Scanner buildChange = new Scanner(System.in);
		        	String newDesign = buildChange.nextLine();
		        	pr.changedes(newDesign);
		        	System.out.println("updated");
	    			break;
	    		case 2://not displaying the right amount
	    			//shows how much has been paid
		        	System.out.println("update payment");
		        	Scanner payed = new Scanner(System.in);
		        	Double leftover = payed.nextDouble();
		        	pr.update(leftover);
		        	
	    			break;
	    		case 3://not changing the information
	    			System.out.println("update your contact details");
	 	           //replaces contact information
	 	        	System.out.println("update phone number");
	 	        	//makes scanner input
	 	        	Scanner info = new Scanner(System.in);
	 	        	String updatecontact = info.nextLine();
	 	        	//update email
	 	        	pr.getContractor().setTelephone(updatecontact);
	 	        	//prints update email
	 	        	System.out.println("update email");
	 	        	//Scanner
	 	        	Scanner em = new Scanner(System.in);
	 	        	//object created
	 	        	String updateemail = em.nextLine();
	 	        	//replaces the original data
	 	        	pr.getContractor().setEmail_address(updateemail);
	 	        	
	 	        	System.out.println("updated");
	    			break;
	    		case 4:
	    			//update information about the 
		        	//pr.toString();
		        	//pr.getCustomer();
		        	System.out.println(pr);
		        	System.out.println(pr.getCustomer());
		        	System.out.println(pr.getContractor());
	    			break;
	    		case 5:
	    			//print information about the projects
		        	double amount = pr.getTotal_amount() - pr.getAmount_paid();//amount that is leftover
		        	if(pr.getTotal_amount() != pr.amount_paid)
		        	{
		        		System.out.println("Customer name: " + pr.getCustomer().getName());//gets name from getcustomer
			        	System.out.println("Telephone number: "+pr.getCustomer().getTelephone());
			        	System.out.println("Amount left: "+ amount);
			        	System.out.println(pr);
		        	}else if(pr.getTotal_amount() == pr.amount_paid)//checks if the amount paid is the equal the total amount needed
		        	{
		        	System.out.println("amount up to date no invoice needed");
		        	}
	    			break;
	    		}
	    		}while(newChoice !=6);
	        	
	           break;
	        case 3:
	    		project_object pjr = capturProject();
	    		pr = new_details("Contractor", pjr);//calls the project class methods
	    		pr = new_details("Customer", pjr);
	    		projectlist.add(pjr);
	        	break;
	        case 2:
	        	for(project_object p:projectlist)
	        		System.out.println(p);//displays project info
	        	
	           break;
	        	default:
	        		System.out.print("Wrong number input\n please try again");
		}

			//write to the file from here
			try {
				//Formatter out = new Formatter("workDocument.txt");
				
				String datafile = "";
				for(project_object pjr : projectlist)
				{
					datafile += pjr.toFile() + "\n";
				}
				System.out.println(datafile);
				//out.format("%s", datafile);
				//out.close();
			}catch(Exception e) {
				System.out.println("File not Found");
			}
		}while(choiceEntry != 4);
		}
}
