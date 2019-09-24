package service.impl;

import dao.FlightDaoImpl;
import model.Flight;
import service.FlightsService;

import java.util.List;

public class FlightsServiceImpl implements FlightsService {

    public FlightsServiceImpl() {
        super();
    }

    FlightDaoImpl flightDao = new FlightDaoImpl();

    public void addFlight(Flight flight) {
        flightDao.addFlight(flight);
    }

    public void updateFlight(Flight flight) {
        flightDao.updateFlight(flight);
    }

    public void deleteFlight(int id) {
        flightDao.deleteFlight(id);
    }

    public List<Flight> getAllFlights() {
        return  flightDao.getAllFlights();
    }

    public Flight getFlightById(int id) {
        return flightDao.getFlightById(id);
    }
}
