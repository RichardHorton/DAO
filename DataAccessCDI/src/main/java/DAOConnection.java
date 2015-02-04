import com.datastax.driver.core.Session;

public interface DAOConnection {
    public Session createSession();
}
