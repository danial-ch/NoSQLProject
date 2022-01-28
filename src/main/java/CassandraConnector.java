import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

import java.text.SimpleDateFormat;
import java.util.*;

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

    public List<Flight> getFlightsBySpecificDate(Date date, String classType, OrderBy orderBy){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateFormatted = formatter.format(date);
        StringBuilder query = new StringBuilder("SELECT * FROM Flight WHERE starttime >= '" + dateFormatted + " 00:00:00' and starttime <= '" + dateFormatted + " 23:59:59"  + "'");
        if(classType != null){
            query.append(" and classType = '").append(classType).append("'");
        }
        query.append(" ALLOW FILTERING; ");
        List<Flight> flights = getFlightsByQuery(query.toString());
        if(orderBy != null){
            orderFlights(flights,orderBy);
//            query.append(" order by ").append(orderBy.getOrderBy()).append(" ").append(orderBy.getType());
        }
        return flights;
    }

    public List<Flight> getFlightsInPriceRange(double minPrice, double maxPrice, String classType, OrderBy orderBy){
        StringBuilder query = new StringBuilder("SELECT * FROM Flight WHERE price >= " + minPrice + " and price <= " + maxPrice);
        if(classType != null){
            query.append(" and classType = '").append(classType).append("'");
        }
        List<Flight> flights = getFlightsByQuery(query.toString());
        if(orderBy != null){
            orderFlights(flights,orderBy);
        }
        return getFlightsByQuery(query.toString());
    }

    private List<Flight> getFlightsByQuery(String query){
        List<Flight> flights = new LinkedList<>();
        ResultSet resultSet = session.execute(query);
        for (Row row : resultSet) {
            Flight flight = parseQuery(row);
            flights.add(flight);
        }
        return flights;
    }

    private void orderFlights(List<Flight> initialList, OrderBy orderBy){
        if(orderBy.getOrderBy().equals("Price")){
            initialList.sort(Comparator.comparing(Flight::getPrice));
        }
        else {
            initialList.sort(Comparator.comparing(Flight::getStartTime));
        }
        if(orderBy.getType().equals("DESC")){
            initialList.sort(Collections.reverseOrder());
        }
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
