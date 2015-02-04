import java.util.UUID;


public interface FNodeChildDAO {
	public int insertFNodeChild(FNodeChild fnc);
	public boolean deleteFNodeChild(UUID parent, String name);
	public FNodeChild findFNodeChild(UUID parent, String name);
	public boolean updateFNodeChild(UUID parent, String name, String col, UUID value);
}
