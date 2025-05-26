import java.util.HashMap;
import java.util.Date;
import java.util.Scanner;

public class Person {
    private String personID;
    private String firstName;
    private String lastName;
    private String address;
    private String birthdate;
    private HashMap<Date, Integer> demeritPoints;
    private boolean isSuspended;

    public boolean addPerson(String id, String fname, String lname, String addy, Date bdate) {
    // Condition 1: personID should be exactly 10 characters long;
    // the first two characters should be numbers between 2 and 9,
    // there should be at least two special characters between characters 3 and 8,
    // and the last two characters should be uppercase letters (A-Z). Example: "56s_d%&fAB"

    // Condition 2: The address of the Person should follow the following format:
    // Street Number|Street|City|State|Country.
    // The State should be only Victoria.
    // Example: 32|Highland Street|Melbourne|Victoria|Australia.

    // Condition 3: The format of the birthdate of the person should follow the following format: DD-MM-YYYY. 
    // Example: 15-11-1990

        return true;
    }

    public boolean updatePersonalDetails(String id, String fname, String lname, String addy, Date bdate) {
    // Condition 1: If a person is under 18, their address cannot be changed.

    // Condition 2: If a person's birthday is going to be changed, then no other personal detail 
    // (i.e, person's ID, firstName, lastName, address) can be changed.

    // Condition 3: If the first character/digit of a person's ID is an even number, then their ID cannot be changed.

        return true;
    }

    public String addDemeritPoints(Date date, int points) {
    // Condition 1: The format of the date of the offense should follow the following format: 
    // DD-MM-YYYY. Example: 15-11-1990

    // Condition 2: The demerit points must be a whole number between 1-6. 

    // Condition 3: If the person is under 21, the isSuspended variable should be set to true if the total demerit points within two years exceed 6. 
    // If the person is over 21, the isSuspended variable should be set to true if the total demerit points within two years exceed 12.

        return "Success";
    }

    public static void main(String[] args) {
        //set up scanner to take user input
        Scanner scanner = new Scanner(System.in);
        int choice;

        //set up while loop to facilitate menu functionality
        //depending on user input, different methods will be called
        do {
            //print menu options
            System.out.println("=== Enter the corresponding key for what you want to do ==="); 
            System.out.println("(1) Add a person to the database");
            System.out.println("(2) Update personal details of a user");
            System.out.println("(3) Add demerit points to a user");
            System.out.println("(4) Quit the program");

            //take input for menu
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    //addPerson functionality
                    break;
                case 2:
                    //updatePersonalDetails functionality
                    break;
                case 3:
                    //addDemeritPoints functionality
                case 4:
                    System.out.println("Goodbye!"); //end the program
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                } 
            } while (choice != 3);

            scanner.close();
    }
}
