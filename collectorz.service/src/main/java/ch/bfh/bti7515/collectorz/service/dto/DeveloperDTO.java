package ch.bfh.bti7515.collectorz.service.dto;

import java.io.Serializable;
import java.util.Date;

public class DeveloperDTO implements Serializable {

	private Long id;
	private String name;
    private String description;
    private String logo;
    private Date created;
    private Date updated;
    private Boolean enabled;
    
    private static final long serialVersionUID = 1L;

	public DeveloperDTO() {
		super();
	}   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

}
