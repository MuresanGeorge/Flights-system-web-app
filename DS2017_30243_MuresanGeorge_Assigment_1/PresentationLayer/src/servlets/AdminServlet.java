package servlets;

import model.City;
import model.Flight;
import service.CityService;
import service.FlightsService;
import service.impl.CityServiceImpl;
import service.impl.FlightsServiceImpl;
import util.SetFlightUtil;
import util.ViewFlightsUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import static util.SetFlightUtil.setParameters;

@WebServlet(name = "servlets.AdminServlet")
public class AdminServlet extends HttpServlet {

    private String message;

    public void init(){
        message = "George";
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Set response content type
        response.setContentType("text/html");

        FlightsService flightsService = new FlightsServiceImpl();
        CityService cityService = new CityServiceImpl();
        String airplaneType = request.getParameter("airplaneType");
        String departureCity = request.getParameter("departureCity");
        String arrivalCity = request.getParameter("arrivalCity");
        String departureDateHour = request.getParameter("departureDateHour");
        String arrivalDateHour = request.getParameter("arrivalDateHour");
        String flightIdU = request.getParameter("flightIdU");
        String flightIdD = request.getParameter("flightIdD");

        Flight newFlight = new Flight();
        SetFlightUtil.setParameters(cityService, airplaneType, departureCity, arrivalCity, departureDateHour, arrivalDateHour, newFlight);

        if(( flightIdU == null) && flightIdD == null){
            flightsService.addFlight(newFlight);
        }else if(flightIdU == null){
            //flightsService.deleteFlight(Integer.parseInt(flightIdD));
            doDelete(request, response);
        }else if(flightIdD == null){
            Flight newUpdateFlight = flightsService.getFlightById(Integer.parseInt(flightIdU));
            SetFlightUtil.setParameters(cityService, airplaneType, departureCity, arrivalCity, departureDateHour, arrivalDateHour, newUpdateFlight);
            System.out.println(newUpdateFlight);
            doPut(request, response);
            //flightsService.updateFlight(newUpdateFlight);
        }
    }

//    private void setParameters(CityService cityService, String airplaneType, String departureCity, String arrivalCity, String departureDateHour, String arrivalDateHour, Flight newFlight) {
//        newFlight.setAirplaneType(airplaneType);
//        newFlight.setDepartureCity(cityService.getCityByName(departureCity));
//        newFlight.setArrivalCity(cityService.getCityByName(arrivalCity));
//        newFlight.setDepartureDateHour(departureDateHour);
//        newFlight.setArrivalDateHour(arrivalDateHour);
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Set response content type
        response.setContentType("text/html");

        // Actual logic goes here.
        PrintWriter out = response.getWriter();

        String title = "All flights";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 5.0 " + "transitional//en\">\n";
        String tot = docType + "<html>\n" + "<head><title>" + title + "</title></head>\n" + "<body bgcolor = \"#f0f0f0\">\n" +
                "<h1 align = \"center\">" + title + "</h1>\n" +
                "<ul>\n";
        tot += "<table border =\"1\">"+
                "<tr>"+
                "<th>"+"Flight Number"+"</th>"+
                "<th>"+"Airplane Type"+"</th>"+
                "<th>"+"Departure City"+"</th>"+
                "<th>"+"Arrival City"+"</th>"+
                "<th>"+"Departure Hour"+"</th>"+
                "<th>"+"Arrival Hour"+"</th>";
//        "</table>";
        FlightsServiceImpl flightsService = new FlightsServiceImpl();
        List<Flight> flightList = flightsService.getAllFlights();
        Iterator <Flight> it = flightList.iterator();
        tot = ViewFlightsUtil.getString(tot, it);
        tot += "</table>";
        tot += "</body></html>";
        out.println(tot);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String flightIdU = req.getParameter("flightIdU");
        String airplaneType = req.getParameter("airplaneType");
        String departureCity = req.getParameter("departureCity");
        String arrivalCity = req.getParameter("arrivalCity");
        String departureDateHour = req.getParameter("departureDateHour");
        String arrivalDateHour = req.getParameter("arrivalDateHour");

        FlightsService flightsService = new FlightsServiceImpl();
        CityService cityService = new CityServiceImpl();


        Flight newUpdateFlight = flightsService.getFlightById(Integer.parseInt(flightIdU));
        SetFlightUtil.setParameters(cityService, airplaneType, departureCity, arrivalCity, departureDateHour, arrivalDateHour, newUpdateFlight);
        System.out.println(newUpdateFlight);
        flightsService.updateFlight(newUpdateFlight);

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String flightIdD = req.getParameter("flightIdD");
        FlightsService flightsService = new FlightsServiceImpl();

        flightsService.deleteFlight(Integer.parseInt(flightIdD));
    }
}
