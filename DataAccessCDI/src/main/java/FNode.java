import java.nio.ByteBuffer;
import java.util.Date;
import java.util.Map;
import java.util.UUID;



public class FNode implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	public UUID id;
	public UUID parent;
	public String name;
	public String type;
	public Date created;
	public Date modified;
	public Map<String, String> metaMap;
	public UUID userId;
	public UUID groupId;
	public int access;
	public String mime;
	public long size;
	public ByteBuffer data;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID uuid) {
		this.id = uuid;
	}
	public UUID getParent() {
		return parent;
	}
	public void setParent(UUID uuid) {
		this.parent = uuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date date) {
		this.created = date;
	}
	public Date getModified() {
		return modified;
	}
	public void setModified(Date date) {
		this.modified = date;
	}
	public Map<String, String> getMetaMap() {
		return metaMap;
	}
	public void setMetaMap(Map<String, String> map) {
		this.metaMap = map;
	}
	public UUID getUserId() {
		return userId;
	}
	public void setUserId(UUID uuid) {
		this.userId = uuid;
	}
	public UUID getGroupId() {
		return groupId;
	}
	public void setGroupId(UUID uuid) {
		this.groupId = uuid;
	}
	public int getAccess() {
		return access;
	}
	public void setAccess(int i) {
		this.access = i;
	}
	public String getMime() {
		return mime;
	}
	public void setMime(String mime) {
		this.mime = mime;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long l) {
		this.size = l;
	}
	public ByteBuffer getData() {
		return data;
	}
	public void setData(ByteBuffer byteBuffer) {
		this.data = byteBuffer;
	}
	
}
