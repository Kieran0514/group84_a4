import java.util.HashMap;
import java.util.Date;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Person {
    private String personID;
    private String firstName;
    private String lastName;
    private String address;
    private String birthdate;
    private String demeritDate;
    private Integer points;
    private HashMap<Date, Integer> demeritPoints;
    private boolean isSuspended;

    public boolean addPerson(String id, String fname, String lname, String addy, String bdate) {
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

        boolean status = false;
        int i;
        int counter= 0;

        //check id is valid
        if (id.length() == 10) { //check for length of 10, if not return false
            for (i = 0; i < 2; ++i) { //iterate thru first 2 letters of the id
                if (Character.isDigit(id.charAt(i))) { //check that the characters are digits, else break and return false
                    if (Character.getNumericValue(id.charAt(i)) >= 2 && Character.getNumericValue(id.charAt(i)) <= 9) { //check that they're between 2 and 9, else break and return false
                        for (i = 2; i < 8; ++i) { //iterate thru characters 3 and 8
                            if (!Character.isLetterOrDigit(id.charAt(i)) && id.charAt(i) != ' ') { //check if characters are special characters
                                ++counter; //if so, add to the counter
                            }
                        }

                        if (counter >= 2) { //if special character counter is equal or above 2
                            for (i = 8; i < 10; ++i) { //iterate thru the last 2 characters
                                if (Character.isUpperCase(id.charAt(i))) { //if they're uppercase letters, else return false and break
                                    status = true; //return true
                                }
                                else {
                                    status = false;
                                    break;
                                }
                            }
                        }
                        else {
                            status = false;
                        }
                    }
                    else {
                        status = false;
                        break;
                    }
                }
                else {
                    status = false;
                    break;
                }
            }
        }
        else {
            status = false;
        }

        //check address is valid and formatted correctly
        String[] addressParts = addy.split("\\|"); //split the address using | as a delimiter
        if (addressParts.length == 5) { //check there are exactly the 5 required components of the address, else return false
            if(addressParts[3] == "Victoria") { //ensure the state is victoria, else return false
                status = true;
            }
            else {
                status = false;
            }
        }
        else {
            status = false;
        }

        //check date is formatted correctly
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy"); //use dateTimeFormatter to determine required date pattern
        try {
            LocalDate.parse(bdate, dateFormat); //try parse bdate as date in the correct format, if success return true
            status = true;
        } catch (DateTimeParseException e) { //else return false
            status = false;
        }

        if (status) { //all checks passed
            System.out.println("Successfully added user.");
        }
        else { //let the user know the requirements for adding a person if it fails
            System.out.println("Failed to add person. Please ensure the following: ");
            System.out.println("- ID has exactly 10 characters");
            System.out.println("- First 2 characters of ID must be a number between 2 and 9");
            System.out.println("- ID should have at least 2 special characters between characters 3 and 8");
            System.out.println("- Last 2 characters of ID must be uppercase letters");
            System.out.println("- Address should formatted as such: Street Number|Street|City|State|Country");
            System.out.println("- Birthdate should be formatted as such: DD-MM-YYYY");
        }

        return status;
    }

    public boolean updatePersonalDetails(String id, String fname, String lname, String addy, String bdate) {
    // Condition 1: If a person is under 18, their address cannot be changed.

    // Condition 2: If a person's birthday is going to be changed, then no other personal detail 
    // (i.e, person's ID, firstName, lastName, address) can be changed.

    // Condition 3: If the first character/digit of a person's ID is an even number, then their ID cannot be changed.

        return true;
    }

    public String addDemeritPoints(String id, String date, int points) {
    // Condition 1: The format of the date of the offense should follow the following format: 
    // DD-MM-YYYY. Example: 15-11-1990

    // Condition 2: The demerit points must be a whole number between 1-6. 

    // Condition 3: If the person is under 21, the isSuspended variable should be set to true if the total demerit points within two years exceed 6. 
    // If the person is over 21, the isSuspended variable should be set to true if the total demerit points within two years exceed 12.

        return "Success";
    }

    public static void main(String[] args) {
        Person person = new Person(); //create new person object
        Scanner scanner = new Scanner(System.in); //set up scanner to take user input
        int choice; //variable for choosing menu item
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); //format date for user input

        //set up do-while loop to facilitate menu functionality
        //depending on user input, one of the 3 different methods will be called
        do {
            //print menu options
            System.out.println("=== Enter the corresponding key for what you want to do ==="); 
            System.out.println("(1) Add a person to the database");
            System.out.println("(2) Update personal details of a user");
            System.out.println("(3) Add demerit points to a user");
            System.out.println("(4) Quit the program");

            choice = scanner.nextInt(); //take input for menu

            switch (choice) {
                case 1:
                    //set all the variables
                    System.out.println("Enter user ID: ");
                    person.setID(scanner.next());
                    System.out.println("Enter first name: ");
                    person.setFname(scanner.next());
                    System.out.print("Enter last name: ");
                    person.setLname(scanner.next());
                    System.out.println("Enter the address of the user: ");
                    person.setAddress(scanner.next());
                    System.out.println("Enter user's birthdate: ");
                    person.setBirthdate(scanner.next());

                    //call addPerson() to run validation checks
                    person.addPerson(person.getID(), person.getFname(), person.getLname(), person.getAddress(), person.getBirthdate());
                    break;
                case 2:
                    //set all the variables
                    System.out.println("Enter new user ID (leave blank to leave unchanged): ");
                    person.setID(scanner.next());
                    System.out.println("Enter new first name (leave blank to leave unchanged): ");
                    person.setFname(scanner.next());
                    System.out.print("Enter new last name (leave blank to leave unchanged): ");
                    person.setLname(scanner.next());
                    System.out.println("Enter the new address of the user (leave blank to leave unchanged): ");
                    person.setAddress(scanner.next());
                    System.out.println("Enter user's new birthdate (leave blank to leave unchanged): ");
                    person.setBirthdate(scanner.next());

                    //call updatePersonalDetails() to run validation checks
                    person.updatePersonalDetails(person.getID(), person.getFname(), person.getLname(), person.getAddress(), person.getBirthdate());
                    break;
                case 3:
                    //set all the variables
                    System.out.println("Enter user ID: ");
                    person.setID(scanner.next());
                    System.out.println("Enter date of offense: ");
                    person.setDemeritDate(scanner.next());
                    System.out.println("Enter # of demerit points: ");
                    person.setPoints(scanner.nextInt());

                    //call addDemeritPoints() to run validation checks
                    person.addDemeritPoints(person.getID(), person.getDemeritDate(), person.getPoints());

                case 4:
                    System.out.println("Goodbye!"); //end the program
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                } 
            } while (choice != 3);

            scanner.close();
    }

    //setters and getters
    public String getID() {
        return personID;
    }

    public void setID(String id) {
        personID = id;
    }

    public String getFname() {
        return firstName;
    }

    public void setFname(String fname) {
        firstName = fname;
    }

    public String getLname() {
        return lastName;
    }

    public void setLname(String lname) {
        lastName = lname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String addy) {
        address = addy;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String bdate) {
        birthdate = bdate;
    }

    public String getDemeritDate() {
        return demeritDate;
    }

    public void setDemeritDate(String ddate) {
        demeritDate = ddate;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer pts) {
        points = pts;
    }

    public HashMap<Date, Integer> getDemeritPoints() {
        return demeritPoints;
    }

    public boolean getSuspended() {
        return isSuspended;
    }

    public void setSuspended(boolean susp) {
        isSuspended = susp;
    }
}
