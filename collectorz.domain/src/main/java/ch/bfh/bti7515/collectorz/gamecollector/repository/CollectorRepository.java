package ch.bfh.bti7515.collectorz.gamecollector.repository;

import ch.bfh.bti7515.collectorz.gamecollector.model.Collector;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by florianauderset on 10.11.16.
 */
public interface CollectorRepository extends CrudRepository<Collector, Long> {

}