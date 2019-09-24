package util;

import model.Flight;

import java.util.Iterator;

public class ViewFlightsUtil {

    public static String getString(String tot, Iterator<Flight> it) {
        while(it.hasNext()){
            Flight flight = it.next();
            int id = flight.getId();
            String airplaneType = flight.getAirplaneType();
            String depC = flight.getDepartureCity().getName();
            String arrC = flight.getArrivalCity().getName();
            String depH = flight.getDepartureDateHour();
            String arH = flight.getArrivalDateHour();
            String tableRow =
//                    "<table>"+
//                            "<tr>"+
//                            "<th>"+"Flight Number"+"</th>"+
//                            "<th>"+"Airplane Type"+"</th>"+
//                            "<th>"+"Departure City"+"</th>"+
//                            "<th>"+"Arrival City"+"</th>"+
//                            "<th>"+"Departure Hour"+"</th>"+
//                            "<th>"+"Arrival Hour"+"</th>"+
                            "<tr>"+
                            "<td>"+id+"</td>"+
                            "<td>"+airplaneType+"</td>"+
                            "<td>"+depC+"</td>"+"<td>"+arrC+"</td>"+
                            "<td>"+depH+"</td>"+ "<td>"+arH+"</td>"+
                            "</tr>";

//                                    +
//                            "</table>";
            tot += tableRow;
        }
        return tot;
    }

}
