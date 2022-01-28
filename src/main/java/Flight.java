import java.util.Date;
import java.util.List;

public class Flight {

    private int flightId;
    private String origin;
    private String originCity;
    private String originCountry;
    private String destination;
    private String destinationCity;
    private String destinationCountry;
    private String classType;
    private Date startTime;
    private Date finishTime;
    private double duration;
    private int capacity;
    private double price;
    private List<String> airlineCompany;
    private List<String> stops;

    public Flight() {
    }

    public Flight(int flightId, String origin, String originCity, String originCountry, String destination, String destinationCity, String destinationCountry, String classType, Date startTime, Date finishTime, double duration, int capacity, List<String> airlineCompany, List<String> stops, double price) {
        this.flightId = flightId;
        this.origin = origin;
        this.originCity = originCity;
        this.originCountry = originCountry;
        this.destination = destination;
        this.destinationCity = destinationCity;
        this.destinationCountry = destinationCountry;
        this.classType = classType;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.duration = duration;
        this.capacity = capacity;
        this.airlineCompany = airlineCompany;
        this.stops = stops;
        this.price = price;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getOriginCity() {
        return originCity;
    }

    public void setOriginCity(String originCity) {
        this.originCity = originCity;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<String> getAirlineCompany() {
        return airlineCompany;
    }

    public void setAirlineCompany(List<String> airlineCompany) {
        this.airlineCompany = airlineCompany;
    }

    public List<String> getStops() {
        return stops;
    }

    public void setStops(List<String> stops) {
        this.stops = stops;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightId=" + flightId +
                ", origin='" + origin + '\'' +
                ", originCity='" + originCity + '\'' +
                ", originCountry='" + originCountry + '\'' +
                ", destination='" + destination + '\'' +
                ", destinationCity='" + destinationCity + '\'' +
                ", destinationCountry='" + destinationCountry + '\'' +
                ", classType='" + classType + '\'' +
                ", startTime=" + startTime +
                ", finishTime=" + finishTime +
                ", duration=" + duration +
                ", capacity=" + capacity +
                ", price=" + price +
                ", airlineCompany=" + airlineCompany +
                ", stops=" + stops +
                '}';
    }
}
