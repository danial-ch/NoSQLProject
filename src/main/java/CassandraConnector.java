import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CassandraConnector {

    private Cluster cluster;

    private Session session;

    public void connect(String node, Integer port) {
        Cluster.Builder b = Cluster.builder().addContactPoint(node);
        if (port != null) {
            b.withPort(port);
        }
        cluster = b.build();
        session = cluster.connect();
        session.execute("USE Alibaba;");
    }

    public List<Flight> getFlightsBySpecificDate(Date date){
        List<Flight> flights = new LinkedList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateFormatted = formatter.format(date);
        String query = "SELECT * FROM Flight WHERE starttime >= '" + dateFormatted + " 00:00:00' and starttime <= '" + dateFormatted + " 23:59:59"  + "' ALLOW FILTERING; ";
        ResultSet resultSet = session.execute(query);
        for (Row row : resultSet) {
            Flight flight = parseQuery(row);
            flights.add(flight);
        }
        return flights;
    }

    private Flight parseQuery(Row row){
        Flight flight = new Flight();
        flight.setFlightId(row.getInt("flightId"));
        flight.setAirlineCompany(row.getList("airlineCompany",String.class));
        flight.setCapacity(row.getInt("capacity"));
        flight.setClassType(row.getString("classType"));
        flight.setDestination(row.getString("destination"));
        flight.setDestinationCity(row.getString("destinationCity"));
        flight.setDestinationCountry(row.getString("destinationCountry"));
        flight.setFinishTime(row.getTimestamp("finishTime"));
        flight.setDuration(row.getDouble("flightDuration"));
        flight.setOrigin(row.getString("origin"));
        flight.setOriginCity(row.getString("originCity"));
        flight.setOriginCountry(row.getString("originCountry"));
        flight.setPrice(row.getDouble("price"));
        flight.setStartTime(row.getTimestamp("startTime"));
        flight.setStops(row.getList("stops",String.class));
        return flight;
    }

    public Session getSession() {
        return this.session;
    }

    public void close() {
        session.close();
        cluster.close();
    }
}
