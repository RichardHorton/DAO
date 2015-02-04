import java.util.UUID;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Statement;
import com.datastax.driver.core.querybuilder.QueryBuilder;

public class CassandraFNodeChildDAO implements FNodeChildDAO {
		
		FNodeChild fnc = null;
		Session ses = null;
	    ResultSet results = null;
	    Statement cql = null;
	
	public CassandraFNodeChildDAO(Session session){
		this.ses = session;
	}

	public int insertFNodeChild(FNodeChild fnc) {
		//clear statement by setting it to null
		cql = null;
		
		//Prepare insert statement using QueryBuilder
		cql = QueryBuilder.insertInto("clearnda", "fnodechild")
		        .value("parent", fnc.getParent())
		        .value("name", fnc.getName())
		        .value("fnode", fnc.getFnode());
		ses.getState().getSession().execute(cql);
		return 0;
	}

	public boolean deleteFNodeChild(UUID parent, String name) {
		//clear statement by setting it to null
		cql = null;
		
		//Prepare delete statement using QueryBuilder
		cql = QueryBuilder.delete()
		        .from("clearnda", "fnodechild")
		        .where(QueryBuilder.eq("parent", parent))
		        .and(QueryBuilder.eq("name", name));
		ses.getState().getSession().execute(cql);
		return false;
	}

	public boolean updateFNodeChild(UUID parent, String name, String col, UUID value) {
		//clear statement by setting it to null
		cql = null;
		//Prepare update statement using QueryBuilder
		cql = QueryBuilder.update("clearnda", "fnodechild")
		        .with(QueryBuilder.set(col, value))
		        .where(QueryBuilder.eq("parent", parent))
		        .and(QueryBuilder.eq("name", name));
		ses.getState().getSession().execute(cql);
		return false;
	}
	
	public FNodeChild findFNodeChild(UUID parent, String name) {
		//clear statement by setting it to null
		cql = null;
		// Use select to get the full fnodechild record that corresponds with the fnodechild name
		cql = QueryBuilder.select().all().from("clearnda", "fnodechild")
				.where(QueryBuilder.eq("parent", parent))
				.and(QueryBuilder.eq("name", name));
        results = ses.execute(cql);	
		
		//create transfer object
		fnc = new FNodeChild();
		
		//load transfer object from query results
		for (Row row : results) {
			fnc.setParent(row.getUUID("parent"));
			fnc.setName(row.getString("name"));
			fnc.setFnode(row.getUUID("fnode"));
		}
		return fnc;   
	}
	
}
