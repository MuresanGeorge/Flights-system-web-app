package servlets;

import model.Flight;
import service.impl.FlightsServiceImpl;
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

@WebServlet(name = "servlets.UserServlet")
public class UserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

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
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
