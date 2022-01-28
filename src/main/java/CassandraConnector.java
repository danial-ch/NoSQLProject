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
            String origin = row.getString("origin");
            System.out.println(origin);
        }
        return flights;
    }

    public Session getSession() {
        return this.session;
    }

    public void close() {
        session.close();
        cluster.close();
    }
}
