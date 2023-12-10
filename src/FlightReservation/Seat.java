//
package FlightReservation;

import java.util.ArrayList;

public class Seat{
    private final int seatNumber;
    private String seatClass;
    private boolean available;
    public Seat(int seatNumber, String seatClass){
        this.seatNumber = seatNumber;
        this.seatClass = seatClass;
        this.available = true;
    }
    // Setters
    public void setSeatClass(String seatClass) {
        this.seatClass = seatClass;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
    // Getters
    public int getSeatNumber(){
        return this.seatNumber;
    }
    public String getSeatClass(){
        return this.seatClass;
    }
    public boolean isAvailable(){
        return this.available;
    }
    public static void createSeats(int number, ArrayList<Seat> seats, String seatClass){
        int size =seats.size();
        for (int i = size; i < number + size; i++) {
            Seat seat = new Seat(i, seatClass);
            seats.add(seat);
        }
    }
    public static String displayAllSeats(ArrayList<Seat> seats){
        int firstClassNumber = 0;
        int businessClassNumber = 0;
        int economyClassNumber = 0;
        for (Seat seat:
             seats) {
            if (seat.getSeatClass().equalsIgnoreCase("first class")){
                firstClassNumber++;
            } else if (seat.getSeatClass().equalsIgnoreCase("business class")) {
                businessClassNumber++;
            }else {
                economyClassNumber++;
            }
        }
        return ("First Class Seats x" + firstClassNumber +"\nBusiness Class Seats x" + businessClassNumber +
                "\nEconomy Class Seats x" + economyClassNumber);
    }
}