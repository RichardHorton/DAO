import java.util.UUID;


public interface EntityDAO {
	public int insertEntity(Entity entity);
	public boolean deleteEntity(UUID id);
	public Entity findEntity(UUID id);
	public boolean updateEntity(UUID id, String col, String value);
}
