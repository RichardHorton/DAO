import java.util.UUID;



public class FnodeChildTester {
		static UUID parent = UUID.fromString("5748c607-64e1-4ec9-bbfb-69b5218edee0");
		static String name = "parent";
		
		
		final DAO dao = WeldContext.INSTANCE.getBean(DAO.class);

		//create the Cassandra FNodeChild DAO
		FNodeChildDAO fnodeChildDao = dao.getFNodeChildDAO();
	
	public void testFindOp(){
		FNodeChild findFNodeChild = fnodeChildDao.findFNodeChild(parent, name);
		System.out.println("FNodeChild: [FNode : " + findFNodeChild.getFnode()+" ]");
	}
	
	public void testUpdateOp(){
		fnodeChildDao.updateFNodeChild(parent, name, "fnode", UUID.randomUUID());
	}
	
	public void testInsertOp(){
		FNodeChild insfnodeChild = new FNodeChild();
		insfnodeChild.setParent(parent);
		insfnodeChild.setName(name);
		insfnodeChild.setFnode(UUID.randomUUID());
		fnodeChildDao.insertFNodeChild(insfnodeChild);
	}
	
	public void testDeleteOp(){
		fnodeChildDao.deleteFNodeChild(parent, name);
	}
	
}
