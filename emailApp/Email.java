package emailApp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String alternateEmail;
    private int mailboxCapacity = 1000;
    private String email;
    private int passwordLength = 10;
    private String companySuffix = "Company_Name.com";

    //Constructor to receive first name and last name from user
    public Email(){
        
        System.out.println("Enter first name: ");
        Scanner firstName = new Scanner(System.in);
        this.firstName = firstName.next();

        System.out.println("Enter last name: ");
        Scanner lastName = new Scanner(System.in);
        this.lastName = lastName.next();
         

        
        //call a method asking for department code and return department name
        this.department = setDepartment();
        

        //call a method to generate random password
        this.password = randomPassword(passwordLength);
        System.out.println("Your Password: " + this.password);

        //Combine everything for email generating
        email = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + department+ "." + companySuffix;
        System.out.println("Email:" + email);
    }


    //Ask for department
    private String setDepartment(){
        System.out.print("Enter the department code:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if(depChoice == 1){return "Sales";}
        else if (depChoice == 2){return "Development";}
        else if (depChoice == 3){return "acct";}
        else{return "";}
    }

    //Generate some password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUPWXYZ0123456789!@#$%^&*";
        char[] passwords = new char[length]; // array of character for random password
        //generate an array with random values from passwordSet

        for (int i = 0; i<length; i++ ){
           int rand=  (int) (Math.random() * passwordSet.length()); // generate a number between 0 and array password length
            passwords[i] = passwordSet.charAt(rand); // grab the character accordingly with the random number and pass it into password
            
        }
        return new String (passwords); //convert set of character to a new string
    }


    //Set the mailbox capacity from public API
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    //set alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }

    //Change password
    public void changePassword(String password){
        this.password = password;
     }

     public int getMailboxCapacity() { return mailboxCapacity; }
     public String getAlternateEmail() { return alternateEmail; }
     public String getPassword() { return password; }
     
     public String showInfo(){
         return "Display Name: " + firstName + " " + lastName + 
                "\nCompany Email: " + email +
                "\nMailbox Capacity: " + mailboxCapacity + " mb";
     }

}
  