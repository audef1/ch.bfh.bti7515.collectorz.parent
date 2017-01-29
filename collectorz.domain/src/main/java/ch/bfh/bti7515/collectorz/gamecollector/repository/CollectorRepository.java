package ch.bfh.bti7515.collectorz.gamecollector.repository; 
 
import org.springframework.data.repository.CrudRepository; 
import ch.bfh.bti7515.collectorz.gamecollector.model.Collector; 
 
public interface CollectorRepository extends CrudRepository<Collector, Long> { 
 
} 