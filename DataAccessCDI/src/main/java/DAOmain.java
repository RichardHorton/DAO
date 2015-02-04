import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class DAOmain {
	public static void main(String[] args) {
		   
		   //Weld weld = new Weld();
		   //WeldContainer container = weld.initialize();
		   //container.instance().select(DAOmain.class).get();
		   //weld.shutdown();
		
		final DAO dao = WeldContext.INSTANCE.getBean(DAO.class);
	    System.out.println("finished connecting to db");
		}
}
