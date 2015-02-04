import java.util.UUID;



public class EntityTester {
		static UUID entityID = UUID.randomUUID();
		
		final DAO dao = WeldContext.INSTANCE.getBean(DAO.class);

		//create the Cassandra Entity DAO
		EntityDAO entityDao = dao.getEntityDAO();
	
	public void testFindOp(){
		Entity findentity = entityDao.findEntity(entityID);
		System.out.println("Entity: [Name : " + findentity.getShortName()+" ]");
	}
	
	public void testUpdateOp(){
		entityDao.updateEntity(entityID, "shortname", "New Shortname");
	}
	
	public void testInsertOp(){
		Entity insentity = new Entity();
		insentity.setId(entityID);
		insentity.setParent(null);
		insentity.setShortName("ShortName");
		insentity.setLongName(null);
		insentity.setPayload(null);
		insentity.setAttributes(null);
		insentity.setEmails(null);
		insentity.setAuthorizations(null);
		insentity.setGroups(null);
		insentity.setOwnedGroups(null);
		insentity.setFnodes(null);
		insentity.setKey(null);		
		entityDao.insertEntity(insentity);
	}
	
	public void testDeleteOp(){
		entityDao.deleteEntity(entityID);
	}
	
}
