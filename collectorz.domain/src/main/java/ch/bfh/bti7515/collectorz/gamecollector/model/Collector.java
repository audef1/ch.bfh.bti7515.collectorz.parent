package ch.bfh.bti7515.collectorz.gamecollector.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by florianauderset on 27.10.16.
 */
@Entity
public class Collector {

    @GeneratedValue
    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    private String firstname;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        firstname = firstname;
    }

    @Basic
    private String lastname;

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        lastname = lastname;
    }

    @Basic
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        username = username;
    }

    @Basic
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        password = password;
    }

    @OneToMany
    private List<Collection> collections;

    public List<Collection> getCollections() {
        return collections;
    }

    public void setCollections(List<Collection> collections) {
        this.collections = collections;
    }

    @Basic
    private Date created;

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Basic
    private Date updated;

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @Basic
    private Boolean enabled;

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

}
