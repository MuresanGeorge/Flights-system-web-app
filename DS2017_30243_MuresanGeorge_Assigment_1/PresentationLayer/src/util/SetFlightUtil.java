package util;


import model.Flight;
import service.CityService;

public class SetFlightUtil {

    public static void setParameters(CityService cityService, String airplaneType, String departureCity, String arrivalCity, String departureDateHour, String arrivalDateHour, Flight newFlight) {
        newFlight.setAirplaneType(airplaneType);
        newFlight.setDepartureCity(cityService.getCityByName(departureCity));
        newFlight.setArrivalCity(cityService.getCityByName(arrivalCity));
        newFlight.setDepartureDateHour(departureDateHour);
        newFlight.setArrivalDateHour(arrivalDateHour);
    }
}
