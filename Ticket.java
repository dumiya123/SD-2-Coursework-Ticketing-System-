public class Ticket { //Define a new class file  called Ticket.

    //Define a private instance variable for row,seat,price and person.
    private int row;
    private int seat;
    final private double price;
    private Person person;

    /**
     * Constructor method for creating a new ticket object with the given row ,seat,price,and person parameters.
     * @param row-an integer representing the row number of the ticket.
     * @param seat-an integer representing the seat number of the ticket.
     * @param price-a double representing the price of the ticket.
     * @param person-a 'Person' object representing the person who bought the ticket.
     */
    public Ticket(int row, int seat, double price,Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;

    }

    /**
     * Method to print out the information of a ticket object.
     */

    public void print() {
        System.out.println("Name   : " + person.getName());
        System.out.println("Surname: " + person.getSurname());
        System.out.println("Email  :" + person.getEmail());
        System.out.println("Row    : " + row);
        System.out.println("Seat   : " + seat);
        System.out.println("Price  :$ " + price);

    }

    // getter and setter methods for the row,seat ,price,and person variables.

    /**
     *this getter method will return the row number of a 'Ticket' object.
     * @return row number of a 'Ticket' object
     */

    public int getRow() {
        return row;

    }

    /**
     * This is a setter method that sets the row  number of a 'Ticket' object.
     * @param row set the value of the row.
     */

   public void setRow(int row) {
        this.row = row;
    }

    /**
     * This is a setter method that sets the seat number of a 'Ticket' object.
     * @param seat-sets the seat number of a 'Ticket' object
     */

    public void setSeat(int seat) {
        this.seat = seat;
    }

    /**
     * This is getter method  that returns the price of  a 'Ticket' object.
     * @return price of  a 'Ticket' object.
     */

    public double getPrice() {
        return price;

    }

    /**
     * This is a setter method that returns the Person object associated with a 'Ticket' object.
     * @param price-takes double value as a parameter called price
     * @return Person object.
     */

    public Person setPrice(double price) {
        return this.person;

    }

    /**
     * This is getter method that returns the Person object associated with a Ticket object.
     * @return Person object
     */

    public Person getperson() {
        return this.person;

    }

    /**
     * This is setter method that a setter method that sets the Person object associated with a Ticket object.
     * @param person Person object.
     */

    public void setPerson(Person person) {
        this.person = person;

    }

}
