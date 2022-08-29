
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import com.opencsv.CSVWriter;

@SuppressWarnings("serial")
class Customer implements Serializable{

	int id;
	String name;
	long contact_no;
	String email_id;
	
	public Customer(int id, String name, long contact_no, String email_id)
	{
		this.id = id;
		this.name = name;
		this.contact_no = contact_no;
		this.email_id = email_id;
	}
	
	public String toString()
	{
		return "\nCustomer Details :" + "\nID: " + this.id + "\nName: " + this.name + "\nContact No: " + this.contact_no + "\nEmail-id: " + this.email_id;
	}
	
}

public class CustomerManagement
{	
	static void display(ArrayList<Customer> al)	{ // Display all customersS
		
		System.out.println("\n--------------Customer List---------------\n");
		System.out.println(String.format("%-10s%-20s%-20s%-10s", "ID","Name","Contact-no","Email-Id"));
		for(Customer e : al)
		{
			System.out.println(String.format("%-10s%-20s%-20s%-10s",e.id,e.name,e.contact_no,e.email_id));
		}
	}

	static void load(String filePath) { // Upload multiple customers
		try {
			FileReader fr = new FileReader(filePath);
			Scanner sc = new Scanner(fr);
			String[] line;
			int i = 0;
				 
			while (sc.hasNextLine()) {
				line = sc.nextLine().split(" |\t|, |,");
				SQLiteJDBC.updateRow(Integer.parseInt(line[0]), line[1], Long.parseLong(line[2]), line[3]);
				i++;
			}

			System.out.printf("Updated %d customers\n", i);
						
		} catch  (FileNotFoundException e){
			e.printStackTrace();
		}
		
	}

	static void generate_csv() {  // Generate a csv report
		ArrayList<Customer> al = SQLiteJDBC.getData();
		File file = new File("customers.csv");
		String [] data = {"A", "B", "C", "D"};
		
		try {
        	FileWriter outputfile = new FileWriter(file);
        	CSVWriter writer = new CSVWriter(outputfile);

			String[] header = { "ID", "Name", "Contact No.", "Email ID" };
            writer.writeNext(header);

			for (Customer e: al) {
				data[0] = Integer.toString(e.id);
				data[1] = e.name;
				data[2] = Long.toString(e.contact_no);
				data[3] = e.email_id;

				writer.writeNext(data);
			}

		}
		catch (Exception e) {
        	e.printStackTrace();
    	}
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		int id;
		String name;
		long contact_no;
		String email_id;
		Customer searchResults;
		ArrayList<Customer> al = new ArrayList<Customer>();
		Scanner sc = new Scanner(System.in);
		
		do
		{
			System.out.println("\n*********Welcome to the Customer Management System**********\n");
			System.out.println("1). Add Customer to the DataBase\n" +
								"2). Search for Customer\n" +
								"3). Edit Customer details\n" +
								"4). Delete Customer Details\n" +
								"5). Display all Customers in the database\n" +
								"6). Upload file\n" +
								"7). EXIT\n");
			System.out.println("Enter your choice : ");
			int ch = sc.nextInt();
			
			switch(ch)
			{
			case 1:System.out.println("\nEnter the following details to ADD list:\n");
				System.out.println("Enter ID :");
				id = sc.nextInt();
				System.out.println("Enter Name :");
				name = sc.next();
				System.out.println("Enter Contact No :");
				contact_no = sc.nextLong();
				System.out.println("Enter Email-ID :");
				email_id = sc.next();
				Customer customer = new Customer(id, name, contact_no, email_id);
				SQLiteJDBC.updateRow(id, name, contact_no, email_id);
				System.out.println(customer);
				break;
				
			case 2: System.out.println("Enter the Cusomer ID to search :");
					id = sc.nextInt();
					searchResults = SQLiteJDBC.search(id);
					if(searchResults != null) {
						System.out.println(searchResults);
						break;
					}
					else {
						System.out.println("\nCustomer Details are not available, Please enter a valid ID!!");
					}
					
					break;
			
			case 3: System.out.println("\nEnter the Customer ID to EDIT the details");

					id = sc.nextInt();
					searchResults = SQLiteJDBC.search(id);

					if (searchResults == null) {
						System.out.println("\nCustomer Details are not available, Please enter a valid ID!!");
						break;
					}
					
					do {
						int ch1 = 0;
						System.out.println("\nEDIT Customer Details :\n" +
											"1). Customer ID\n" +
											"2). Name\n" +
											"3). Contact No.\n" +
											"4). Email-ID\n" +
											"5). GO BACK\n");
						System.out.println("Enter your choice : ");
						ch1 = sc.nextInt();
						switch(ch1) {
							case 1: System.out.println("\nEnter new Customer ID:");
									id =sc.nextInt();
									SQLiteJDBC.update(searchResults.id, id, searchResults.name, searchResults.contact_no, searchResults.email_id);
									break;
							
							case 2: System.out.println("Enter new Customer Name:");
									name =sc.nextLine();
									SQLiteJDBC.update(searchResults.id, searchResults.id, name, searchResults.contact_no, searchResults.email_id);
									break;
																
							case 3: System.out.println("Enter new Customer Contact No. :");
									contact_no =sc.nextLong();
									SQLiteJDBC.update(searchResults.id, searchResults.id, searchResults.name, contact_no, searchResults.email_id);
									break;
									
							case 4: System.out.println("Enter new Customer Email-ID :");
									email_id =sc.next();
									SQLiteJDBC.update(searchResults.id, searchResults.id, searchResults.name, searchResults.contact_no, email_id);
									break;
									
							case 5: break;
									
							default : System.out.println("\nEnter a correct choice from the List :");
										break;
							
						}
					}while(false);
				
					break;
					
			case 4: 
					System.out.println("\nEnter Customer ID to DELETE from the Database :");
					id = sc.nextInt();
					searchResults = SQLiteJDBC.search(id);
					
					SQLiteJDBC.delete(id);
					break;
			
			case 5:
					al = SQLiteJDBC.getData();
					display(al);
					int ch2 = 0;
					System.out.println("\nReports :\n" +
										"1). Generate csv report\n" +
										"2). GO BACK\n");
					System.out.println("Enter your choice : ");
					ch2 = sc.nextInt();

					switch (ch2) {
						case 1:
								generate_csv();
								break;
						
						case 2:	break;
						
						default:
								System.out.println("\nEnter a correct choice from the List :");
								break;

					}
					break;

			case 6:
					System.out.println("\nEnter filename: ");
					String filePath= sc.next();
					load(filePath);
					break;
			
			case 7:
					
					System.out.println("\nYou have chosen EXIT !! Closing the tool...");
					sc.close();
					System.exit(0);
					break;
					
			default : System.out.println("\nEnter a correct choice from the List :");
						break;
			
			}
		}
		while(true);
	}
	
}