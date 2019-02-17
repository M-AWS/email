package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email; 
	private int mailboxCapacity=1000;
	private int defaultPasswordLength=10;
	private String alternateEmail;
	private String companySuffix = "developerfun.com";

	// Constructor to receive the first name and last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
		
		// Call a method asking for the department - return the department 
		this.department = setDepartment();
	
		// Call a method that returns a random password
		this.password = randomPassword (defaultPasswordLength);
		System.out.println("Your password is: " + this.password);
		
		// Combine elements to generate email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
}
	
	// Ask for the department
	private String setDepartment() {
		System.out.print("New employee: " + firstName + ". Department Codes:\n1 for Executive Leadership\n2 for Software Development\n3 for Business Management\n0 for none\nEnter department code: ");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		if (depChoice == 1) { return "eleader"; }
		else if (depChoice == 2) { return "dev"; }
		else if (depChoice == 3) { return "mgmt"; }
		else { return ""; }
		
	}

	// Generate a random password
	private String randomPassword(int length) {
		 String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		    char[] randomPassword = new char[length];
		    for(int i=0; i<length;i++) {
		        randomPassword[i] = passwordSet.charAt((int)(Math.random() * passwordSet.length()));
		    }
		    return new String(randomPassword);
	}

	// Set the mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	// Set the alternate email
	public void setAlternateEmail (String altEmail) {
		this.alternateEmail = altEmail;
	}

	// Change the password
	public void changePassword(String password) {
		this.password = password;
	}
	
	public int getMailboxCapacity() { return mailboxCapacity; }
	public String getAlternateEmail() { return alternateEmail;} 
	public String getPassword() { return password; }
	
	public String showInfo() {
		return "DISPLAY NAME: " + firstName + " " + lastName +
				"\nCOMPANY EMAIL: " + email +
				"\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
}
}