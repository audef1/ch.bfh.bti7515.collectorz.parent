package ch.bfh.bti7515.collectorz.gamecollector.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by florianauderset on 27.10.16.
 */
@Entity
public class Publisher {
    @GeneratedValue
    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
