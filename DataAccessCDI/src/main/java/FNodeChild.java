import java.util.UUID;

public class FNodeChild implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	public UUID parent;
	public String name;
	public UUID fnode;
	
	public UUID getParent() {
		return parent;
	}
	public void setParent(UUID parent) {
		this.parent = parent;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public UUID getFnode() {
		return fnode;
	}
	public void setFnode(UUID fnode) {
		this.fnode = fnode;
	}
		
}
