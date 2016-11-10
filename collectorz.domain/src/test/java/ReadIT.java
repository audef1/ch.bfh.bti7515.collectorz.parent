/**
 * 
 */

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Test;

import ch.bfh.bti7515.collectorz.gamecollector.model.*;

/**
 * @author audef1
 * 
 */
public class ReadIT {

	@Test
	public void test() {

		EntityManager em = Persistence.createEntityManagerFactory(
				"ch.bfh.bti7515.collectorz.gamecollector.domain").createEntityManager();

		Query q = em.createQuery("select c from Collector c");
		@SuppressWarnings("unchecked")
		List<Collector> foundCollector = q.getResultList();
		Collector firstCollector = foundCollector.get(0);
		Assert.assertTrue(firstCollector.getFirstname().equals("Florian"));

		List<Collection> foundCollections = firstCollector.getCollections();
		Collection firstCollection = foundCollections.get(0);
		Assert.assertTrue(firstCollection.getName().startsWith("NES"));
	}

}
