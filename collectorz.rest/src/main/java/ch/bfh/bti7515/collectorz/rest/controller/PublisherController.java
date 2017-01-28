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

import ch.bfh.bti7515.collectorz.service.PublisherService;
import ch.bfh.bti7515.collectorz.service.dto.PublisherDTO;

@Controller
@RequestMapping("/publishers")
public class PublisherController {

	@Inject
	private PublisherService publisherService;

	/**
	 * Create
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public PublisherDTO createPublisher(@RequestBody PublisherDTO publisher) {
		PublisherDTO createdPublisher = publisherService.create(publisher);
		System.out.println("Publisher created with id = " + createdPublisher.getId());
		return createdPublisher;
	}

	/**
	 * ReadAll
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Collection<PublisherDTO> getPublishers() {
		System.out.println("Collection of Publisher requested");
		return publisherService.list();
	}

	/**
	 * Read
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public PublisherDTO getPublisher(@PathVariable long id) {
		System.out.println("Publisher requested with id = " + id);
		return publisherService.read(id);
	}

	/**
	 * Update
	 */
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public PublisherDTO updatePublisher(@RequestBody PublisherDTO publisher) {
		PublisherDTO updatedPublisher = publisherService.update(publisher);
		System.out.println("Publisher updated with id = " + updatedPublisher.getId());
		return updatedPublisher;
	}

	/**
	 * Delete
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deletePublisher(@PathVariable long id) {
		PublisherDTO publisher = publisherService.read(id);
		publisherService.delete(publisher);
		System.out.println("Delete Publisher with id = " + id);
	}
}
