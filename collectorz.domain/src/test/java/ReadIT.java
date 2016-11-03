/**
 * 
 */

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author rovi
 * 
 */
public class ReadIT {

	@Test
	public void test() {

		EntityManager em = Persistence.createEntityManagerFactory(
				"ch.bfh.swos.bookapp.domain").createEntityManager();

		Query q = em.createQuery("select a from Author a");
		@SuppressWarnings("unchecked")
		List<Author> foundAuthors = q.getResultList();
		Author firstAuthor = foundAuthors.get(0);
		Assert.assertTrue(firstAuthor.getLastname().equals("Tolkien"));

		List<Book> foundBooks = firstAuthor.getBooks();
		Book firstBook = foundBooks.get(0);
		Assert.assertTrue(firstBook.getTitle().startsWith("Der Herr der Ringe"));
	}

}
