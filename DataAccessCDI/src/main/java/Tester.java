
public class Tester {

	public static void main(String[] args) {
		FnodeTester fnode = new FnodeTester();
		FnodeChildTester fnodechild = new FnodeChildTester();
		EntityTester entity = new EntityTester();
		
		fnode.testInsertOp();
		fnode.testFindOp();		
		fnode.testUpdateOp();
		fnode.testFindOp();
		fnode.testDeleteOp();
		fnode.testFindOp();
		
		fnodechild.testInsertOp();
		fnodechild.testFindOp();		
		fnodechild.testUpdateOp();
		fnodechild.testFindOp();
		fnodechild.testDeleteOp();
		fnodechild.testFindOp();
		
		entity.testInsertOp();
		entity.testFindOp();		
		entity.testUpdateOp();
		entity.testFindOp();
		entity.testDeleteOp();
		entity.testFindOp();
		
	}
}
