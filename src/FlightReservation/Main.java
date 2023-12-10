//
package FlightReservation;
import java.time.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import static InputOutput.Input.flights;


public class Main {
    public static Airport[] airports = new Airport[5];
    public static void EditFlight(Flight flight){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter What You Want to Edit(1-Departure Airport 2-Arrival Airport 3-Departure and arrival" +
                " Time" +
                " 4-Seats 5-Go Back): ");
        int choice = input.nextInt();
        switch(choice){
            case 1:
                flight.EditDepartureAirport();
                break;
            case 2:
                flight.EditArrivalAirport();
                break;
            case 3:
                flight.EditTime();
                break;
            case 4:
                flight.EditSeats();
                break;
            case 5:
                return; //Exits From the Function
            default:
                System.out.println("Invalid Input!");
        }
        EditFlight(flight);
    }
    public static void searchFlight(Flight[] flights){
        System.out.println("Enter Departure City: ");
        Scanner input = new Scanner(System.in);
        String departureCity = input.next();
        System.out.println("Enter Arrival City: ");
        String arrivalCity = input.next();
        boolean existFlights = false;
        try {
            for (Flight flight :flights) {
                if(departureCity.equalsIgnoreCase(flight.getDepartureAirport().getLocation()) &&
                        arrivalCity.equalsIgnoreCase(flight.getArrivalAirport().getLocation())){
                    flight.displayFlight();
                    existFlights = true;
                }
            }
        }
        catch (NullPointerException ignored){
        }
        finally {
            if (!existFlights){
                System.out.println("No Available Flights Make Sure You Type the Cities Right Or Wait for Admins to Add" +
                        " Flights.");
            }
        }
    }
    public static void AddFlight(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Flight Number: ");
        int flightNumber = input.nextInt();
        displayAirports();
        System.out.println("Enter The Departure Airport Code: ");
        Airport departureAirport = getAirport();
        System.out.println("Enter new Arrival Airport Code: ");
        Airport arrivalAirport = getAirport();
        while (arrivalAirport == departureAirport){
            System.out.println("You can't Travel to The same Airport");
            arrivalAirport = getAirport();
        }
        Date departureDate = getDate("Departure");
        Date arrivalDate = getDate("Arrival");
        checkDate(departureDate,arrivalDate);
        int seatsNumber = getSeatsNumber();
        ArrayList<Seat> seats = new ArrayList<Seat>();
        getSeats(seatsNumber, seats);
        Flight flight = new Flight(flightNumber,departureAirport,arrivalAirport,departureDate,arrivalDate,seatsNumber, seats);
        flights.add(flight);
    }//When user inputs wrong input
    public static Airport getAirport(){
        Scanner input = new Scanner(System.in);
        boolean failure = true;
        while (failure){
            try {
                int airportCode = input.nextInt();
                for (Airport airports : airports) {
                    if (airports.getAirportCode() == airportCode) {
                        return airports;
                    }
                }
            }catch (NullPointerException | InputMismatchException exp){
                System.out.println("Error Airport Does not Exist Enter the Code Again: ");
            }
        }
        return null;
    }
    public static void displayAirports(){
        try {
            for (Airport airport : airports) {
                airport.displayAirport();
            }
        }catch (NullPointerException ignored){}
    }
    public static int getSeatsNumber(){
        System.out.println("Enter The Number of Seats: ");
        Scanner input = new Scanner(System.in);
        boolean failed = true;
        while (failed) {
            try {
                int seats = input.nextInt();
                if(seats < 0 || seats > 200){
                    throw new InputMismatchException();
                }
                return seats;
            } catch (InputMismatchException exp) {
                System.out.println("Error Invalid Year Enter the Number of Seats Again: ");
            }
        }
        return 0;
    }
    public static void getSeats(int seatNumber, ArrayList<Seat> seats){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter How Many First class Seats: ");
        int firstClass = input.nextInt();
        System.out.println("Enter How Many Business class Seats: ");
        int businessClass = input.nextInt();
        System.out.println("Enter How Many Economy class Seats: ");
        int economyClass = input.nextInt();
        if (firstClass + economyClass + businessClass != seatNumber){
            System.out.println("Error the Total Number of Seats Doesn't match Try Again!");
            getSeats(seatNumber, seats);
        }
        seats.clear();
        Seat.createSeats(firstClass, seats, "First Class");
        Seat.createSeats(businessClass, seats, "Business Class");
        Seat.createSeats(economyClass, seats, "Economy Class");
    }
    public static int getYear(String type){
        System.out.println("Enter The " + type +" Year: ");
        Scanner input = new Scanner(System.in);
        boolean failed = true;
        while (failed) {
            try {
                int year = input.nextInt();
                if(year < Year.now().getValue()){
                    throw new InputMismatchException();
                }
                return year;
            } catch (InputMismatchException exp) {
                System.out.println("Error Invalid Year Enter the Year Again: ");
            }
        }
        return 0;
    }
    public static int getMonth(String type){
        System.out.println("Enter The " + type +" Month(1 to 12): ");
        Scanner input = new Scanner(System.in);
        boolean failed = true;
        while (failed){
            try {
                int month = input.nextInt();
                if (month < 1 || month > 12){
                    throw new InputMismatchException();
                }
                return month;
            }catch (InputMismatchException exp){
                System.out.println("Error Invalid Month Enter the Month Again: ");
            }
        }
        return 0;
    }
    public static int getDay(String type){
        System.out.println("Enter The " + type +" Day(1 to 31): ");
        Scanner input = new Scanner(System.in);
        boolean failed = true;
        while (failed){
            try {
                int day = input.nextInt();
                if (day < 1 || day > 31){
                    throw new InputMismatchException();
                }
                return day;
            }catch (InputMismatchException exp){
                System.out.println("Error Invalid Month Enter the Day Again: ");
            }
        }
        return 0;
    }
    public static int getHour(String type){
        System.out.println("Enter The " + type +" Hour(0 to 24): ");
        Scanner input = new Scanner(System.in);
        boolean failed = true;
        while (failed){
            try {
                int hour = input.nextInt();
                if (hour < 0 || hour > 24){
                    throw new InputMismatchException();
                }
                return hour;
            }catch (InputMismatchException exp){
                System.out.println("Error Invalid Month Enter the Hour Again: ");
            }
        }
        return 0;
    }
    public static int getMinute(String type){
        System.out.println("Enter The " + type +" Minute(0 to 59): ");
        Scanner input = new Scanner(System.in);
        boolean failed = true;
        while (failed){
            try {
                int minute = input.nextInt();
                if (minute < 0 || minute > 59){
                    throw new InputMismatchException();
                }
                return minute;
            }catch (InputMismatchException exp){
                System.out.println("Error Invalid Month Enter the Minute Again: ");
            }
        }
        return 0;
    }
    public static Date getDate(String type){
        return new Date(getYear(type),getMonth(type),getDay(type),getHour(type),getMinute(type));
    }
    public static void checkDate(Date departureDate, Date arrivalDate){
        while (departureDate.getYear() > arrivalDate.getYear()){
            System.out.println("Error in Date Please Try Again");
            departureDate = getDate("Departure");
            arrivalDate = getDate("Arrival");
        }if (departureDate.getYear() == arrivalDate.getYear()){
            while (departureDate.getMonth() > arrivalDate.getMonth()){
                System.out.println("Error in Date Please Try Again");
                departureDate = getDate("Departure");
                arrivalDate = getDate("Arrival");
            }
            if (departureDate.getMonth() == arrivalDate.getMonth() ){
                while (arrivalDate.getDay() <= departureDate.getDay()){
                    System.out.println("Error in Date Please Try Again");
                    departureDate = getDate("Departure");
                    arrivalDate = getDate("Arrival");
                }
            }
        }
    }
    public static void ShowSchedule(ArrayList<Flight> flights){
        boolean existFlights = false;
        try {
            for (Flight flight :flights) {
                flight.displayFlight();
                existFlights = true;
            }
        }
        catch (NullPointerException ignored){}
        finally {
            if (!existFlights){
                System.out.println("No Available Flights!");
            }
        }
    }
    public static void main(String[] args) {
        airports[0] = new Airport(1314,"CairoAirport","Cairo");
        airports[1] = new Airport(1414,"AlexAirport","Alex");
        airports[2] = new Airport(1214,"TokyoAirport","Tokyo");
        ShowSchedule(flights);
        AddFlight();
        flights.get(0).displayFlight();
        EditFlight(flights.get(0));
        flights.get(0).displayFlight();
        AddFlight();
        flights.get(1).displayFlight();
        ShowSchedule(flights);
    }
}