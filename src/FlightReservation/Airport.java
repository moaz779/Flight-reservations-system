//
package FlightReservation;

public class Airport {
    private int airportCode;
    private String airportName;
    private String location;

    // Constructor
    public Airport(int airportCode, String airportName, String location) {
        this.airportCode = airportCode;
        this.airportName = airportName;
        this.location = location;
    }

    // Getter methods
    public int getAirportCode() {
        return airportCode;
    }

    public String getAirportName() {
        return airportName;
    }

    public String getLocation() {
        return location;
    }

    public void setAirportCode(int airportCode) {
        this.airportCode = airportCode;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public void displayAirport(){
        System.out.println("Airport Code: " + airportCode + " Airport Name: " + airportName + " Airport Location: " +
                location);
    }
}
