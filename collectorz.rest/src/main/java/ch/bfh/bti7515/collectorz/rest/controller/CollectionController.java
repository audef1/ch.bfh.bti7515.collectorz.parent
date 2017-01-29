package ch.bfh.bti7515.collectorz.rest.controller;

import java.util.Collection;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import ch.bfh.bti7515.collectorz.service.CollectionService;
import ch.bfh.bti7515.collectorz.service.dto.CollectionDTO;

@Controller
@RequestMapping("/collections")
public class CollectionController {

	@Inject
	private CollectionService collectionService;

	/**
	 * Create
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public CollectionDTO createCollection(@RequestBody CollectionDTO collection) {
		CollectionDTO createdCollection = collectionService.create(collection);
		System.out.println("Collection created with id = " + createdCollection.getId());
		return createdCollection;
	}

	/**
	 * ReadAll
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Collection<CollectionDTO> getCollections() {
		System.out.println("Collection of Collection requested");
		return collectionService.list();
	}

	/**
	 * Read
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public CollectionDTO getCollection(@PathVariable long id) {
		System.out.println("Collection requested with id = " + id);
		return collectionService.read(id);
	}

	/**
	 * Update
	 */
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public CollectionDTO updateCollection(@RequestBody CollectionDTO collection) {
		CollectionDTO updatedCollection = collectionService.update(collection);
		System.out.println("Collection updated with id = " + updatedCollection.getId());
		return updatedCollection;
	}

	/**
	 * Delete
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteCollection(@PathVariable long id) {
		CollectionDTO collection = collectionService.read(id);
		collectionService.delete(collection);
		System.out.println("Delete Collection with id = " + id);
	}
}
