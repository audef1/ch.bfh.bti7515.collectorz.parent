package ch.bfh.bti7515.collectorz.service.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CollectionDTO implements Serializable {

	private Long id;
	private String name;
    private Date created;
    private Date updated;
    private Boolean enabled;
    private List<GameDTO> games;
    
    private static final long serialVersionUID = 1L;

	public CollectionDTO() {
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

    public List<GameDTO> getGames() {
        return games;
    }

    public void setGames(List<GameDTO> games) {
        this.games = games;
    }
}
