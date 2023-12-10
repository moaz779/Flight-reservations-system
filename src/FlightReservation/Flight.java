//
package FlightReservation;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static FlightReservation.Main.*;

public class Flight {
    private final int flightNumber;
    private Airport departureAirport;
    private Airport arrivalAirport;
    private final Date departureTime;
    private final Date arrivalTime;
    private int availableSeats;
    private ArrayList<Seat> seats;

    public Flight(int flightNumber, Airport departureAirport, Airport arrivalAirport, Date departureTime,
                  Date arrivalTime, int availableSeats,ArrayList<Seat> seats) {
        this.flightNumber = flightNumber;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.availableSeats = availableSeats;
        this.seats = seats;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void displayFlight(){
        System.out.println("Flight number: "+ flightNumber + " Departure Airport: " + departureAirport.getAirportName() +
                " Arrival Airport: " + arrivalAirport.getAirportName() + " Departure Time: "
                + departureTime.returnDate() + " Arrival Time: " + arrivalTime.returnDate() + " Available Seats: "
                + availableSeats + "\nSeats: \n" + Seat.displayAllSeats(seats));
    }
    public void EditSeats(){
        getSeats(EditAvailableSeats(),seats);
    }
    public void EditDepartureAirport(){
        System.out.println("Enter new Departure Airport Code: ");
        this.departureAirport = getAirport();
    }
    public void EditArrivalAirport() {
        System.out.println("Enter new Arrival Airport Code: ");
        this.arrivalAirport = getAirport();
    }
    public void EditTime() {
        Date departureDate = getDate("Departure");
        Date arrivalDate = getDate("Arrival");
        checkDate(departureDate,arrivalDate);
        this.departureTime.editDate(departureDate);
        this.arrivalTime.editDate(arrivalDate);
    }
    public int EditAvailableSeats() {
        int number = getSeatsNumber();
        this.availableSeats = number;
        return number;
    }

}

