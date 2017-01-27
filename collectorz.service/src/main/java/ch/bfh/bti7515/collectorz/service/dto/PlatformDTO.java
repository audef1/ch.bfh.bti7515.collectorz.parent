package ch.bfh.bti7515.collectorz.service.dto;

import java.io.Serializable;
import java.util.Date;

public class PlatformDTO implements Serializable {

	private Long id;
	private String name;
    private Date releaseyear;
    private Boolean enabled;
    private Date created;
    private Date updated;
    private String image;
    
    private static final long serialVersionUID = 1L;

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

    public Date getReleaseyear() {
        return releaseyear;
    }

    public void setReleaseyear(Date releaseyear) {
        this.releaseyear = releaseyear;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
	
}
