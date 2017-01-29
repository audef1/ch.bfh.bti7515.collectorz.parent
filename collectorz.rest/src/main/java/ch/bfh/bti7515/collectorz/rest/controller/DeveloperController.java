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

import ch.bfh.bti7515.collectorz.service.DeveloperService;
import ch.bfh.bti7515.collectorz.service.dto.DeveloperDTO;

@Controller
@RequestMapping("/developers")
public class DeveloperController {

	@Inject
	private DeveloperService developerService;

	/**
	 * Create
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public DeveloperDTO createDeveloper(@RequestBody DeveloperDTO developer) {
		DeveloperDTO createdDeveloper = developerService.create(developer);
		System.out.println("Developer created with id = " + createdDeveloper.getId());
		return createdDeveloper;
	}

	/**
	 * ReadAll
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Collection<DeveloperDTO> getDevelopers() {
		System.out.println("Developer of Developer requested");
		return developerService.list();
	}

	/**
	 * Read
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public DeveloperDTO getDeveloper(@PathVariable long id) {
		System.out.println("Developer requested with id = " + id);
		return developerService.read(id);
	}

	/**
	 * Update
	 */
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public DeveloperDTO updateDeveloper(@RequestBody DeveloperDTO developer) {
		DeveloperDTO updatedDeveloper = developerService.update(developer);
		System.out.println("Developer updated with id = " + updatedDeveloper.getId());
		return updatedDeveloper;
	}

	/**
	 * Delete
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteDeveloper(@PathVariable long id) {
		DeveloperDTO developer = developerService.read(id);
		developerService.delete(developer);
		System.out.println("Delete Developer with id = " + id);
	}
}
