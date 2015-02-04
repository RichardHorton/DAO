


public interface DAO {
	// List of methods that create database entity objects
	public abstract FNodeDAO getFNodeDAO();
	public abstract FNodeChildDAO getFNodeChildDAO();
	public abstract EntityDAO getEntityDAO();
	
    public void setConnection(DAOConnection conn);

}