package ch.bfh.bti7515.collectorz.gamecollector.repository;

import ch.bfh.bti7515.collectorz.gamecollector.model.Game;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by florianauderset on 10.11.16.
 */
public interface GameRepository extends CrudRepository<Game, Long> {

}
