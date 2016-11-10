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
public class UpdateIT {

	@Test
	public void test() {

		EntityManager em = Persistence.createEntityManagerFactory(
				"ch.bfh.bti7515.collectorz.gamecollector.domain").createEntityManager();

		Query q = em.createQuery("select c from Collector c");
		@SuppressWarnings("unchecked")
		List<Collector> foundCollectors = q.getResultList();
		Collector firstCollector = foundCollectors.get(0);

		// Write access needs a transaction
		em.getTransaction().begin();
		firstCollector.setLastname("Meier");
		em.getTransaction().commit();
		// Entity is persisted automatically after commit because it is managed
		// by jpa.

		Assert.assertTrue(firstCollector.getLastname().equals("Meier"));
	}

}
