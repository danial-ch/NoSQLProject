import com.datastax.driver.core.Session;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        CassandraConnector client = new CassandraConnector();
        client.connect("127.0.0.1", 9042);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            client.getFlightsBySpecificDate(formatter.parse("2022-05-03"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
//        Session session = client.getSession();
//        String query = "INSERT INTO FLIGHT (flightid,airlinecompany,capacity,classType,destination,destinationCity,destinationCountry,finishtime,flightduration,origin,origincity,origincountry,price,starttime,stops) values (1,['iran air'],250,'economy','Istanbul Airport','Istanbul','Turkey','2022-05-03 12:20:00',4,'Imam airport','Tehran','Iran',200,'2022-05-03 16:20:00',[]); ";
//        session.execute(query);
    }
}
