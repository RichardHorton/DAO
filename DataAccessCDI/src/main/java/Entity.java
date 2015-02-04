import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class Entity implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	public UUID id;
	public UUID parent;
	public String shortName;
	public String longName;
	public String payload;
	public Map<String, String> attributes;
	public Set<String> emails;
	public Set<UUID> authorizations;
	public Set<UUID> groups;
	public Set<UUID> ownedGroups;
	public Set<UUID> fnodes;
	public String key;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public UUID getParent() {
		return parent;
	}
	public void setParent(UUID parent) {
		this.parent = parent;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getLongName() {
		return longName;
	}
	public void setLongName(String longName) {
		this.longName = longName;
	}
	public String getPayload() {
		return payload;
	}
	public void setPayload(String payload) {
		this.payload = payload;
	}
	public Map<String, String> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}
	public Set<String> getEmails() {
		return emails;
	}
	public void setEmails(Set<String> emails) {
		this.emails = emails;
	}
	public Set<UUID> getAuthorizations() {
		return authorizations;
	}
	public void setAuthorizations(Set<UUID> authorizations) {
		this.authorizations = authorizations;
	}
	public Set<UUID> getGroups() {
		return groups;
	}
	public void setGroups(Set<UUID> groups) {
		this.groups = groups;
	}
	public Set<UUID> getOwnedGroups() {
		return ownedGroups;
	}
	public void setOwnedGroups(Set<UUID> ownedGroups) {
		this.ownedGroups = ownedGroups;
	}
	public Set<UUID> getFnodes() {
		return fnodes;
	}
	public void setFnodes(Set<UUID> fnodes) {
		this.fnodes = fnodes;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	
}
