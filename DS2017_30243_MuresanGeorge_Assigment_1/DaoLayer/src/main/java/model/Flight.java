package model;

import javax.persistence.*;

@Entity
@Table(name = "flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "airplaneType")
    private String airplaneType;

    @ManyToOne
    @JoinColumn(name = "departureCity", referencedColumnName = "city_id")
    private City departureCity;
    //mai multe zboruri in acelasi oras

    @ManyToOne
    @JoinColumn(name = "arrivalCity", referencedColumnName = "city_id")
    private City arrivalCity;

    @Column(name = "departureDateHour")
    private String departureDateHour;

    @Column(name = "arrivalDateHour")
    private String arrivalDateHour;

    public Flight(String airplaneType, City departureCity, City arrivalCity, String departureDateHour, String arrivalDateHour) {
        this.airplaneType = airplaneType;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.departureDateHour = departureDateHour;
        this.arrivalDateHour = arrivalDateHour;
    }

    public Flight (){ }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAirplaneType() {
        return airplaneType;
    }

    public void setAirplaneType(String airplaneType) {
        this.airplaneType = airplaneType;
    }

    public City getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(City departureCity) {
        this.departureCity = departureCity;
    }

    public City getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(City arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public String getDepartureDateHour() {
        return departureDateHour;
    }

    public void setDepartureDateHour(String departureDateHour) {
        this.departureDateHour = departureDateHour;
    }

    public String getArrivalDateHour() {
        return arrivalDateHour;
    }

    public void setArrivalDateHour(String arrivalDateHour) {
        this.arrivalDateHour = arrivalDateHour;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", airplaneType='" + airplaneType + '\'' +
                ", departureCity='" + departureCity + '\'' +
                ", arrivalCity='" + arrivalCity + '\'' +
                ", departureDateHour=" + departureDateHour +
                ", arrivalDateHour=" + arrivalDateHour +
                '}';
    }
}
