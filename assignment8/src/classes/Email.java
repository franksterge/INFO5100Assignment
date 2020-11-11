package classes;
import java.util.Scanner;
import java.util.Random;

public class Email {
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private char[] passwordChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%".toCharArray();
    private String companySuffix = "aeycompany.com";
    private String firstName;
    private String lastName;
    private String department;
    private String password;
    private Scanner console;

    // Constructor to receive the first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.console = new Scanner(System.in);
        System.out.println("New Worker: " + firstName + " " + lastName);
        System.out.println("Department Codes: ");
        System.out.println("1 for Sales\n2 for Development \n3 for Accounting \n0 for none");
        this.department = setDepartment();
        this.password = randomPassword(this.defaultPasswordLength);
    }

    // Ask for the department
    private String setDepartment() {
        System.out.println("Enter department code: ");
        String consoleLine = console.nextLine();
        String[] departments = {"none", "Sales", "Development", "Accounting"};
        try {
            int departmentCode = Integer.parseInt(consoleLine);
            return departments[departmentCode];
        }
        catch (Exception e) {
            System.out.println("Invalid code. Please try again.");
            setDepartment();
        }
        return "none";
    }

    // Generate a random password
    private String randomPassword(int length) {
        char[] pw = new char[length];
        for (int i = 0; i < length; i++) {
            pw[i] = this.passwordChars[new Random().nextInt(this.passwordChars.length)];
        }
        return new String(pw);
    }

    public String showInfo() {
        return "DISPLAY NAME: " + this.firstName + " " + this.lastName + "\n" +
                "DEPARTMENT: " + this.department + "\n" +
                "COMPANY EMAIL: " + generageCompanyEmail() + "\n" +
                "PASSWORD: " + this.password + "\n" +
                "MAILBOX CAPACITY: " + this.mailboxCapacity + "mb";
    }

    private String generageCompanyEmail() {
        return firstName.toLowerCase() + "." + lastName.toLowerCase() + "@"
                + this.department.toLowerCase() + "." + this.companySuffix;
    }
}
