//
package InputOutput;


import FlightReservation.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Input {
    // Initializing constants to be used as file names
    static final String USERS_FILE = "Users.txt";
    static final String FLIGHTS_FILE = "Flights.txt";
    static final String BOOKINGS_FILE = "Bookings.txt";

    // Initializing global arrays
    public static ArrayList<User> users = new ArrayList<User>();
    public static ArrayList<Flight> flights = new ArrayList<Flight>();


    public static void loadALL() throws IOException { // Calls the load method for each file
        load(USERS_FILE, users);
        load(FLIGHTS_FILE, flights);

    }
    private static void load(String fileName, ArrayList objects) throws IOException {
        try {
            ObjectInputStream objectReader = new ObjectInputStream(new FileInputStream(fileName));
            Object obj; // Field takes in a temporary object to put in the array
            while ((obj = objectReader.readObject()) != null /*Reads 1 object then puts in the obj field then checks if its null */) {
                objects.add(obj);// Puts temporary object into the array;
            }
        } catch (IOException e ) {// Catches if there are no files
            Output.saveALL(); // Calls save all function to make files
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
            throw new RuntimeException(e);
        }
    }
}