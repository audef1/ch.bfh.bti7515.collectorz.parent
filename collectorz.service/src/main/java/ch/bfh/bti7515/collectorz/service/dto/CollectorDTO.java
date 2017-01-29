package ch.bfh.bti7515.collectorz.service.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CollectorDTO implements Serializable {

	private Long id;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private List<CollectionDTO> collections;
    private Date created;
    private Date updated;
    private Boolean enabled;
    
    private static final long serialVersionUID = 1L;

	public CollectorDTO() {
		super();
	}   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String name) {
        this.firstname = name;
    }
    
    public String geLastname() {
        return lastname;
    }

    public void setLastname(String name) {
        this.lastname = name;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getPassword() {
    	return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public List<CollectionDTO> getCollections() {
        return collections;
    }

    public void setCollections(List<CollectionDTO> collections) {
        this.collections = collections;
    }
    
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
