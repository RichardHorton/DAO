import java.util.UUID;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Statement;
import com.datastax.driver.core.querybuilder.QueryBuilder;

public class CassandraFNodeDAO implements FNodeDAO {
		
		FNode fn = null;
		Session ses = null;
	    ResultSet results = null;
	    Statement cql = null;
	
	public CassandraFNodeDAO(Session session){
		this.ses = session;
	}

	public int insertFNode(FNode fnode) {
		//clear statement by setting it to null
		cql = null;
		
		//Prepare insert statement using QueryBuilder
		cql = QueryBuilder.insertInto("clearnda", "fnode")
		        .value("id", fnode.getId())
		        .value("parent", fnode.getParent())
		        .value("name", fnode.getName())
		        .value("type", fnode.getType())
		        .value("created", fnode.getCreated())
		        .value("modified", fnode.getModified())
		        .value("meta", fnode.getMetaMap())
		        .value("userid", fnode.getUserId())
		        .value("groupid", fnode.getGroupId())
		        .value("access", fnode.getAccess())
		        .value("mime", fnode.getMime())
		        .value("size", fnode.getSize())
		        .value("data", fnode.getData());
		ses.getState().getSession().execute(cql);
		return 0;
	}

	public boolean deleteFNode(UUID fnodeId) {
		//clear statement by setting it to null
		cql = null;
		
		//Prepare delete statement using QueryBuilder
		cql = QueryBuilder.delete()
		        .from("clearnda", "fnode")
		        .where(QueryBuilder.eq("id", fnodeId));
		ses.getState().getSession().execute(cql);
		return false;
	}

	public boolean updateFNode(UUID fnodeId, String col, String value) {
		//clear statement by setting it to null
		cql = null;
		//Prepare update statement using QueryBuilder
		cql = QueryBuilder.update("clearnda", "fnode")
		        .with(QueryBuilder.set(col, value))
		        .where(QueryBuilder.eq("id", fnodeId));
		ses.getState().getSession().execute(cql);
		return false;
	}
	
	public FNode findFNode(UUID fnodeId) {
		//clear statement by setting it to null
		cql = null;
		// Use select to get the full fnode record that corresponds with the fnode name
		cql = QueryBuilder.select().all().from("clearnda", "fnode")
				.where(QueryBuilder.eq("id", fnodeId));
        results = ses.execute(cql);	
		
		//create transfer object
		fn = new FNode();
		
		//load transfer object from query results
		for (Row row : results) {
			fn.setParent(row.getUUID("parent"));
			fn.setName(row.getString("name"));
			fn.setType(row.getString("type"));
			fn.setCreated(row.getDate("created"));
			fn.setModified(row.getDate("modified"));
			fn.setMetaMap(row.getMap("meta", String.class, String.class));
			fn.setUserId(row.getUUID("userid"));
			fn.setGroupId(row.getUUID("groupid"));
			fn.setAccess(row.getInt("access"));
			fn.setMime(row.getString("mime"));
			fn.setSize(row.getLong("size"));
			fn.setData(row.getBytes("data"));
		}
		return fn;   
	}
	
}
