import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;

import com.datastax.driver.core.Session;

@Alternative
public class MysqlConnection implements DAOConnection {

    public void communicateWithDB(String table) {
        System.out.println("communicating with db via mysql connection");
             
    }

	public Session createSession() {
		// TODO Auto-generated method stub
		return null;
	}

}