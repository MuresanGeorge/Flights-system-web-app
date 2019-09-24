package dao;

import model.City;
import model.Flight;

import java.util.List;

public interface FlightDao {


    void addFlight(Flight flight);
    void updateFlight(Flight flight);
    void deleteFlight(int id);
    List<Flight> getAllFlights();
    Flight getFlightById(int id);


}
