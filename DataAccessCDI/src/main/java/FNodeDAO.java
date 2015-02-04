import java.util.UUID;


public interface FNodeDAO {
	public int insertFNode(FNode fnode);
	public boolean deleteFNode(UUID fnodeId);
	public FNode findFNode(UUID fnodeId);
	public boolean updateFNode(UUID fnodeId, String col, String value);
}
