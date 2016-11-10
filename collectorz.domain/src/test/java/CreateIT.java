import java.util.ArrayList;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.Test;

import ch.bfh.bti7515.collectorz.gamecollector.model.*;

/**
 * @author audef1
 * 
 */
public class CreateIT {

	@Test
	public void test() {
		Collector collector = new Collector();
		collector.setFirstname("Florian");
		collector.setLastname("Auderset");
		collector.setUsername("FLOW");
		collector.setPassword("123456");
		collector.setCreated(new Date());
		collector.setUpdated(new Date());
		collector.setEnabled(true);

		Collection collection = new Collection();
		collection.setName("NES Sammlung");
		collection.setCreated(new Date());
		collection.setUpdated(new Date());
		collection.setEnabled(true);

		Game game1 = new Game();
		game1.setName("Contra");
		game1.setDescription("Ein tolles Spiel.");
		game1.setReleasedate(new Date());
        game1.setRating(5);
		game1.setCreated(new Date());
		game1.setUpdated(new Date());
		game1.setEnabled(true);

        Game game2 = new Game();
        game2.setName("Super Mario 3");
        game2.setDescription("Ein Klassiker!");
        game2.setReleasedate(new Date());
        game2.setRating(10);
        game2.setCreated(new Date());
        game2.setUpdated(new Date());
        game2.setEnabled(true);

		ArrayList<Game> games = new ArrayList<Game>();
		games.add(game1);
		games.add(game2);

		collection.setGames(games);

        ArrayList<Collection> collections = new ArrayList<Collection>();
        collections.add(collection);

        collector.setCollections(collections);

		EntityManager em = Persistence.createEntityManagerFactory(
				"ch.bfh.bti7515.collectorz.gamecollector.domain").createEntityManager();

		em.getTransaction().begin();
		em.persist(collector);
		em.getTransaction().commit();
	}
}
