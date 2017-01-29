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

import ch.bfh.bti7515.collectorz.service.CollectorService;
import ch.bfh.bti7515.collectorz.service.dto.CollectorDTO;

@Controller
@RequestMapping("/collectors")
public class CollectorController {

	@Inject
	private CollectorService collectorService;

	/**
	 * Create
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public CollectorDTO createCollector(@RequestBody CollectorDTO collector) {
		CollectorDTO createdCollector = collectorService.create(collector);
		System.out.println("Collector created with id = " + createdCollector.getId());
		return createdCollector;
	}

	/**
	 * ReadAll
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Collection<CollectorDTO> getCollectors() {
		System.out.println("Collector of Collector requested");
		return collectorService.list();
	}

	/**
	 * Read
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public CollectorDTO getCollector(@PathVariable long id) {
		System.out.println("Collector requested with id = " + id);
		return collectorService.read(id);
	}

	/**
	 * Update
	 */
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public CollectorDTO updateCollector(@RequestBody CollectorDTO collector) {
		CollectorDTO updatedCollector = collectorService.update(collector);
		System.out.println("Collector updated with id = " + updatedCollector.getId());
		return updatedCollector;
	}

	/**
	 * Delete
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteCollector(@PathVariable long id) {
		CollectorDTO collector = collectorService.read(id);
		collectorService.delete(collector);
		System.out.println("Delete Collector with id = " + id);
	}
}
