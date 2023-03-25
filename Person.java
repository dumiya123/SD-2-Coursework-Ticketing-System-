/**
 * Define a public class named Person.
 */
public class Person {

        //Define a private instance variable for name,surname, and email.
        private String name;
        private String surname;
        private String email;


        // Define a public constructor with three parameters: name, surname, and email.
        public Person(String name,String surname,String email){

            // Initialize the private instance variables with the values of the constructor parameters.

            this.name=name;
            this.surname=surname;
            this.email=email;
        }

    // getter and setter methods for the name,surname,and email variables

    /**
     * Define a public method called "getName" that returns the value of the private instance variable "name".
     * @return value of the private instance variable "name"
     */

    public String getName() {
        return name;
    }

    /**
     * Define a public method called "setName" that takes a string parameter "name" and sets the value of the private instance variable "name" to it
     * @param name sets the value of the private instance variable "name" to it.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Define a public method called "getSurname" that returns the value of the private instance variable "surname".
     * @return  the value of the private instance variable "surname"
     */

    public String getSurname() {
        return surname;
    }

    /**
     * Define a public method called "setSurname" that takes a string parameter "surname" and sets the value of the private instance variable "surname" to it
     * @param surname sets the value of the name
     */

    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     *Define a public method called "getEmail" that returns the value of the private instance variable "email".
     * @return the value of the private instance variable "email"
     */

    public String getEmail() {
        return email;
    }

    /**
     * Define a public method called "setEmail" that takes a string parameter "email" and sets the value of the private instance variable "email" to it
     * @param email sets the value of the "email"
     */

    public void setEmail(String email) {
        this.email = email;
    }
}

