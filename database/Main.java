package database;
import java.util.Scanner;
//import java.sql.SQLException;
public class Main {
	public static void main(String []args) {
		BankingServices accountService=new BankingServices();
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("\n1.Admin Login\n2.Customer Login\n3.Logout\n4.Exit");
			System.out.println("Choose an option: ");
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			switch(choice) {
				case 1:
					System.out.println("Enter admin Username: ");
					String adminuser=scanner.nextLine();
					System.out.println("Enter admin Password: ");
					String adminPass=scanner.nextLine();
					if(accountService.adminLogin(adminuser, adminPass)) {
						System.out.println("Admin logged Successfull!");
					}
					else {
						System.out.println("Invalid admin credentials.");
					}
					
			}
		}
	}
}
