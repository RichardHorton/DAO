import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

@Default
public class CassandraConnection implements DAOConnection {

    
    
    Cluster cluster;
	  Session session;
	  
	  
	  public CassandraConnection(){

	  }
	  
	  // method to create Cassandra database connection
	  public Session createSession() {
		 // Connect to the cluster and keyspace "clearnda"
		cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
		session = cluster.connect("clearnda");
		System.out.println("Cassandra session created");
		return session;
	  }

}
