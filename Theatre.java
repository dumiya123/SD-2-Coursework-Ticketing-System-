import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * COPYRIGHT (C) Dumindu Induwara Gamage - 20221168 - W1953846- dumindu.20221168@iit.ac.lk. All Rights Reserved.
 *PART-A:Main Program.
 * SD2 CourseWork L4 Sem2
 * @author Dumindu Induwara Gamage.
 * @version 1 2023-02-18
 */

public class Theatre {


    final private static int[][] seats = new int[3][];                                 //Create 2D array in  program to keep record of the seats that have been sold and the seats that are still available.

    final private static ArrayList<Ticket> tickets = new ArrayList<>();         //Create a arraylist called tickets to store tickets information.
    public static void main(String[] args) {                                   //Define main method in the program.

        System.out.println();

        System.out.println("                        Welcome to the New Theatre.             ");                // Print message to the console.

        seats[0] = new int[12];                                               // 12 seats in row 1

        seats[1] = new int[16];                                              // 16 seats in row 2

        seats[2] = new int[20];                                              // 20 seats in row 3.

        Scanner input = new Scanner(System.in);                           //Create scanner class to get input from users.

        int option = -1;                                                 //Create a integer type variable called option.

        while (option != 0) {

            printMenu();

            try {                                                        //Start try-catch block to handle user exception.

                System.out.print("\nEnter your option:");             //Say user to enter his option as his wish

                option = input.nextInt();                               //Read the input user entered and store it in variable called option.

            } catch (Exception e) {                                     //if Error occurred in the line which we take user's input then

                System.out.println("You can only enter a option 0 to 8 option \t Please enter an integer value.");    //print this message to the user
            }
            //process user input
            switch (option) {
                case 1:
                    System.out.println("option 1: Buy ticket.");                     // If option is 1, execute the following code.

                    buyTicket();                                                    //call buyTicket method to purchase a ticket.

                    break;
                case 2:
                    System.out.println("option 2: Print seating area");             // If option is 2, execute the following code

                    print_seating_area();                                          //cal this method to display updated seat area

                    break;

                case 3:                                                                // If option is 3, execute the following code

                    System.out.println("option 3: Cancel ticket.");                   //call display seats method to display seats status

                    cancel_ticket();

                    break;

                case 4:                                                             // If option is 4, execute the following code
                    System.out.println("option 4: List available seats");

                    show_available();                                               //call display show_available method to display seats status

                    break;

                case 5:                                                             // If option is 5, execute the following code

                    System.out.println("option 5: Save to file");

                    save();                                                      //call  save method to save seats status.

                    break;

                case 6:                                                          // If option is 6, execute the following code.

                    System.out.println("option 6: load from file");

                    load();

                    break;

                case 7:                                                          // If option is 7, execute the following code

                    System.out.println("option 7: Print ticket information and total price.");

                    show_tickets_info();

                    break;

                case 8:                                                         // If option is 8, execute the following code

                    System.out.println("option 8: Sort tickets by price.");

                    Sorting_tickets();

                    break;

                case 0:                                                        // If option is 0, execute the following code.

                    System.out.println("option 0: Quit");

                    break;

                default:                                                       //If user enter any option without above mention options then,

                    System.out.println("Invalid option. Please select again.");   //This message will print to the console.

                    break;
            }


        }
    }

    /**
     * create a method called printMenu.
     *this method will print out a formatted menu of options for a ticketing system.
     *Each option is numbered from 1 to 8, with a 0 option to quit the system.
     * The menu is separated by a horizontal line of dashes for better readability.
     */
    public static void printMenu() {
        System.out.println("""
                ----------------------------------------------------------------------------------
                Please select an option:
                      1)Buy a ticket
                      2)Print seating area
                      3)Cancel ticket
                      4)list available seats
                      5)Save to file
                      6)Load from file
                      7)Print ticket information and total price.
                      8)Sort tickets by price.
                      0)Quit
                                
                ----------------------------------------------------------------------------------
                """);

    }

    /**
     * implement a method called buy_ticket.using this method hope to ask the user to input row number and a seat number.
     * after check that the row and seat are correct and that the seat is available.
     * this method will call when user enter option 4.
     * this method will control whole process of buying ticket.
     */

    public static void buyTicket() {
        try{

        Scanner input = new Scanner(System.in);

        //Asks for user's information.

        System.out.println("Enter name: ");
        String name = input.next();

        System.out.println("Enter surname:");
        String surname = input.next();

        System.out.println("Enter your email:");
        String email = input.next();

        //Create person object

        Person person = new Person(name, surname, email);

        //Asks for ticket information.

        System.out.println("Enter row number:");
        int row = input.nextInt();

        System.out.println("Enter a seat number:");
        int seat = input.nextInt();

        System.out.println("Enter price of ticket:");
        double price = input.nextDouble();

        //Create a new ticket object

        Ticket ticket = new Ticket(row, seat, price, person);

        //Add the ticket to the Array list.

        tickets.add(ticket);

        System.out.println("Ticket bought successfully.");

        // validate the seat number based on the row selected

        if (row < 1 || row > 3) {

            System.out.println("Invalid row number(Select 1-3)");
        }

        System.out.println();

        // validate the seat number based on the row selected

        if (row == 1) {
            if (!(seat >= 1 && seat <= 12))

                System.out.println("Invalid seat number.");

        } else if (row == 2) {

            if (!(seat >= 1 && seat <= 16))

                System.out.println("Invalid seat number.");

        } else if (row == 3) {

            if (!(seat >= 1 && seat <= 20))

                System.out.println("Invalid seat number.");
        }

            // check if the seat has already been sold

        if (seats[row - 1][seat - 1] == 1) {

            System.out.println("Seat already sold.Please try another seat.");

            return;
        }

        //Reserve the seat by updating the seats array

        seats[row - 1][seat - 1] = 1;

        System.out.println("Ticket purchased");
    }
        catch(Exception e){

            // Handle any exceptions that occur during the execution of the code

            System.out.println("Invalid Input (Hint:Input must be an integer).Please try Again.");

        }

    }

        /**
         *Implement a method called print_seating_area.
         * This method prints the seating area for the stage.
         * this method will call when the user selects '2' in the main menu
         *
         */

        private static void print_seating_area () {

            System.out.println("Booked Seats:X  Available Seats:O ");

            System.out.println();

            System.out.println("        ***********      ");

            System.out.println("        *  STAGE  *     ");

            System.out.println("        ***********     ");

            // Loop through each row of the seating area

            for (int row=0; row < 3; row++){

                // Adjust the indentation of the three rows.

                if(row==0) System.out.print("       ");

                if(row==1) System.out.print("     ");

                if(row==2) System.out.print("   ");

                // Loop through each seat in the current row.

                for (int seat = 0; seat < seats[row].length; seat++) {

                    // Add a space in the middle of the row

                    if (seat == seats[row].length/2) {

                        System.out.print(" ");
                    }

                    // Print an "o" if the seat is empty, or an "x" if it is taken

                    if (seats[row][seat] == 0) {

                        System.out.print("o");
                    } else

                    {
                        System.out.print("x");

                    }

                }
                System.out.println();
            }
        }

    /**
     * Declaring a private method named "cancel_ticket"
     * this makes seats available again.
     */

    private static void cancel_ticket()
        {
                try {

                    // Creating a Scanner object to read input from the console

                    Scanner sc = new Scanner(System.in);

                    // Prompting the user to enter a row number

                    System.out.println("Enter a row  number: ");

                    // Reading the user input for the row number

                    int row = sc.nextInt();

                    System.out.println("Enter a seat number:");
                    int seat = sc.nextInt();

                    // Checking if the user input for the row and seat number is within the range of valid values.

                    if (row < 1 || row > 3 || seat < 1 || seat > 20) {

                        System.out.println("Invalid row or seat number.Please enter a valid row number or seat number. ");


                    }

                    // If an exception occurs while reading input from the console, catch the exception and print an error message.

                }catch(Exception e)

                {
                    System.out.println("Please enter an integer value.");
                }

        }

    /**
     * Defines a public method named "show_available()"
     * this method will display the seats are available.
     * this method will call when the user enter option 4
     */
    public static void show_available()
        {
            // Iterates through the "seats" array using a for loop

            for(int k=0;k<seats.length;k++) {

                // Retrieves the "k" th row from the "seats" array.

                int[] row = seats[k];

                //Prints the row number (k+1) add a colon to the console.

                System.out.print("Row "+ (k+1) +" :");

                //Loop through each seat in the row using a for loop.

                for(int i =0; i<row.length; i++)
                {

                    //Prints the seat number to the console,followed by a space

                    System.out.print( i + " ");
                }

                //prints new line character to the console

                System.out.println();
            }

        }

    /**
     *Implement a method called save.
     *Using this method we can save tickets data to the file.
     */

    public static void save()
    {

                try     // Start a try-catch block for handling IOExceptions
                {

                    // Create a new file object with the file name "seats.txt"

                    File file = new File("seats.txt");

                    // Create a new FileWriter object to write to the file

                    FileWriter writer = new FileWriter(file);

                    // Create a new StringBuilder object to store the data that will be written to the file

                    StringBuilder obj1=new StringBuilder();

                    // Iterate  through the rows of the "seats" 2D array

                    for(int i=0;i< seats.length;i++){

                        // Loop through the columns of the current row, except for the last column

                        for(int j=0;j<(seats[i].length-1);j++){

                            // Append the current element followed by a space to the StringBuilder object

                           obj1.append(seats[i][j]+" ");
                        }

                        // Append the last element of the current row followed by a newline character to the StringBuilder object

                        obj1.append(seats[i][seats[i].length-1]);

                        obj1.append("\n");
                    }

                    // Write the contents of the StringBuilder object to the file using the FileWriter object

                    writer.write(obj1.toString());

                    // Close the FileWriter object

                    writer.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();   // Print the stack trace of the exception
                }
    }

    /**
     *Implement a private method called "lood()"
     * this will load the file saved in save() method and restores the 3 arrays with the row's information.
     * this method will call when the user selects 6
     */

    private static void load()
    {
        try{    // Start a try-catch block for handling FileNotFoundException

            // Create a new file object with the file name "seats.txt".
            File object=new File("seats.txt");

            // Create a new Scanner object to read from the file

            Scanner reader=new Scanner(object);

            // Iterate through each line in the file

            while(reader.hasNextLine())

            {

                // Loop through each row of the "seats" 2D array

                for(int j=0;j<seats.length;j++){

                    // Read the next line from the file and store it in a temporary string variable

                    String temp=reader.nextLine();

                    // Split the temporary string into an array of strings using the space character as the delimiter

                    String [] tempArr=temp.split(" ");

                    // Loop through each element in the temporary array of strings

                    for(int i=0;i<tempArr.length;i++){

                        // Convert the current element to an integer and store it in the corresponding element in the "seats" array.

                        seats[j][i]=Integer.parseInt(tempArr[i]);
                    }
                }


            }

            // Close the Scanner object

            reader.close();

         // Catch any FileNotFoundExceptions that occur

       }catch (FileNotFoundException e)

       {

        System.out.println("An error occurred");

        e.printStackTrace(); // Print the stack trace of the exception
        }
    }

    /**
     *Define the method called "show_tickets_info".
     *This will print all the information for all tickets.
     *This  will calculate and show the total price of all tickets after ticket information.
     */

    public static void show_tickets_info()
    {

        // Initialize a variable to store the total price of all tickets

        double total_price=0.0;

        // Iterate over all tickets in the tickets ArrayList

        for(int i=0;i<tickets.size();i++)
        {
            // Get the ticket at the current index of the ArrayList

                tickets.get(i).print();

            // Call the print() method on the current ticket object to print its information.

               total_price+=tickets.get(i).getPrice();

               System.out.println("------------------------------------------------------------");

            // Print the ticket information (movie name, row, seat, and price)


        }

        //Print the total price of all tickets

        System.out.println("Total is: "+total_price);

    }

    /**
     * Define a method called "Sorting_tickets()".
     * This will return new list of  tickets sorted by Tickets price ascending order(cheapest first).
     */



    private static void Sorting_tickets()
    {
        ArrayList<Ticket>  sorted=tickets;  // Create a new ArrayList called "sorted" and initialize it with the same objects as the "tickets" ArrayList.

        for (int i=0;i<sorted.size();i++)  // Use a nested loop to compare each pair of tickets and sort them based on their price.
        {
            for(int j=i+1;j< sorted.size();j++)
            {
                if(sorted.get(i).getPrice()>sorted.get(j).getPrice())
                {
                    Ticket temp=sorted.get(i);

                    sorted.set(i,sorted.get(j));

                    sorted.set(j,temp);
                }
            }
        }
        for (Ticket ticket:sorted) // Loop through the sorted ArrayList and print out each ticket's information
        {

            System.out.println("------------------------------------------------------------");

            ticket.print(); // Call the print() method on the current ticket object to print its information
        }
    }

}







