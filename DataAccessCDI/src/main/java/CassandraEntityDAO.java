import java.util.UUID;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Statement;
import com.datastax.driver.core.querybuilder.QueryBuilder;

public class CassandraEntityDAO implements EntityDAO {
		
		Entity enty = null;
		Session ses = null;
	    ResultSet results = null;
	    Statement cql = null;
	
	public CassandraEntityDAO(Session session){
		this.ses = session;
	}

	public int insertEntity(Entity ent) {
		//clear statement by setting it to null
		cql = null;
		
		//Prepare insert statement using QueryBuilder
		cql = QueryBuilder.insertInto("clearnda", "entity")
		        .value("id", ent.getId())
		        .value("parent", ent.getParent())
		        .value("shortname", ent.getShortName())
		        .value("longname", ent.getLongName())
		        .value("payload", ent.getPayload())
		        .value("attributes", ent.getAttributes())
		        .value("emails", ent.getEmails())
		        .value("authorizations", ent.getAuthorizations())
		        .value("groups", ent.getGroups())
		        .value("ownedgroups", ent.getOwnedGroups())
		        .value("fnodes", ent.getFnodes())
		        .value("key", ent.getKey());
		ses.getState().getSession().execute(cql);
		return 0;
	}

	public boolean deleteEntity(UUID entityId) {
		//clear statement by setting it to null
		cql = null;
		
		//Prepare delete statement using QueryBuilder
		cql = QueryBuilder.delete()
		        .from("clearnda", "entity")
		        .where(QueryBuilder.eq("id", entityId));
		ses.getState().getSession().execute(cql);
		return false;
	}

	public boolean updateEntity(UUID entityId, String col, String value) {
		//clear statement by setting it to null
		cql = null;
		//Prepare update statement using QueryBuilder
		cql = QueryBuilder.update("clearnda", "entity")
		        .with(QueryBuilder.set(col, value))
		        .where(QueryBuilder.eq("id", entityId));
		ses.getState().getSession().execute(cql);
		return false;
	}
	
	public Entity findEntity(UUID entityId) {
		//clear statement by setting it to null
		cql = null;
		// Use select to get the full entity record that corresponds with the entity id
		cql = QueryBuilder.select().all().from("clearnda", "entity")
				.where(QueryBuilder.eq("id", entityId));
        results = ses.execute(cql);	
		
		//create transfer object
		enty = new Entity();
		
		//load transfer object from query results
		for (Row row : results) {
			enty.setParent(row.getUUID("parent"));
			enty.setShortName(row.getString("shortname"));
			enty.setLongName(row.getString("longname"));
			enty.setPayload(row.getString("payload"));
			enty.setAttributes(row.getMap("attributes", String.class, String.class));
			enty.setEmails(row.getSet("emails", String.class));
			enty.setAuthorizations(row.getSet("authorizations", UUID.class));
			enty.setGroups(row.getSet("groups", UUID.class));
			enty.setOwnedGroups(row.getSet("ownedgroups", UUID.class));
			enty.setFnodes(row.getSet("fnodes", UUID.class));
			enty.setKey(row.getString("key"));
		}
		return enty;   
	}
	
}
