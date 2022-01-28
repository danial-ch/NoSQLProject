import com.datastax.driver.core.Session;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        CassandraConnector client = new CassandraConnector();
        client.connect("127.0.0.1", 9042);
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            List<Flight> flights = client.getFlightsBySpecificDate(formatter.parse("2022-05-03"),"economy",new OrderBy("DESC","price"));
//            for (Flight flight : flights) {
//                System.out.println(flight.toString());
//            }
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        client.getMinMaxPrice("Imam airport","Istanbul Airport",null);
        System.out.println(client.getCheapestFlight("Imam airport","Istanbul Airport",100,500,"economy"));
//        List<Flight> flights = client.getFlightsInPriceRange(100,600);

//        Session session = client.getSession();
//        String query = "INSERT INTO FLIGHT (flightid,airlinecompany,capacity,classType,destination,destinationCity,destinationCountry,finishtime,flightduration,origin,origincity,origincountry,price,starttime,stops) values (1,['iran air'],250,'economy','Istanbul Airport','Istanbul','Turkey','2022-05-03 12:20:00',4,'Imam airport','Tehran','Iran',200,'2022-05-03 16:20:00',[]); ";
//        session.execute(query);
    }
}
