package ch.bfh.bti7515.collectorz.gamecollector.repository; 
 
import org.springframework.data.repository.CrudRepository; 
import ch.bfh.bti7515.collectorz.gamecollector.model.Collection; 
 
public interface CollectionRepository extends CrudRepository<Collection, Long> { 
 
} 
