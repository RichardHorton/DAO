import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.inject.Named;

import com.datastax.driver.core.Session;

@Named("dao")
public class DAOImpl implements DAO {
        
    private Session session;
    FNodeDAO fNodeDAO = null;
    FNodeChildDAO fNodeChildDAO = null;
    EntityDAO entityDAO = null;
    
    //get the correct connection
    @Inject
    public void setConnection(DAOConnection conn) {
        this.session = conn.createSession();
    }

	
    
    //get the correct DAO
    public FNodeDAO getFNodeDAO() {
		  if(this.fNodeDAO == null){
			  this.fNodeDAO = new CassandraFNodeDAO(session);
		    }
		  return this.fNodeDAO; 
	  }
    
    public FNodeChildDAO getFNodeChildDAO() {
		  if(this.fNodeChildDAO == null){
			  this.fNodeChildDAO = new CassandraFNodeChildDAO(session);
		    }
		  return this.fNodeChildDAO; 
	  }
    
    public EntityDAO getEntityDAO() {
		  if(this.entityDAO == null){
			  this.entityDAO = new CassandraEntityDAO(session);
		    }
		  return this.entityDAO; 
	  }
	  

}