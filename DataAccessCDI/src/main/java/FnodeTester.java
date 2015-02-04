import java.util.UUID;



public class FnodeTester {
		static UUID fnodeID = UUID.randomUUID();
		
		final DAO dao = WeldContext.INSTANCE.getBean(DAO.class);

		//create the Cassandra FNode DAO
		FNodeDAO fnodeDao = dao.getFNodeDAO();
	
	public void testFindOp(){
		FNode findfnode = fnodeDao.findFNode(fnodeID);
		System.out.println("FNode: [Name : " + findfnode.getName()+" ]");
	}
	
	public void testUpdateOp(){
		fnodeDao.updateFNode(fnodeID, "name", "Department");
	}
	
	public void testInsertOp(){
		FNode insfnode = new FNode();
		insfnode.setId(fnodeID);
		insfnode.setParent(null);
		insfnode.setName("Division");
		insfnode.setType(null);
		insfnode.setCreated(null);
		insfnode.setModified(null);
		insfnode.setMetaMap(null);
		insfnode.setUserId(null);
		insfnode.setGroupId(null);
		insfnode.setAccess(0);
		insfnode.setMime(null);
		insfnode.setSize(0);
		insfnode.setData(null);		
		fnodeDao.insertFNode(insfnode);
	}
	
	public void testDeleteOp(){
		fnodeDao.deleteFNode(fnodeID);
	}
	
}
