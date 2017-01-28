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

import ch.bfh.bti7515.collectorz.service.PlatformService;
import ch.bfh.bti7515.collectorz.service.dto.PlatformDTO;

@Controller
@RequestMapping("/platforms")
public class PlatformController {

	@Inject
	private PlatformService platformService;

	/**
	 * Create
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public PlatformDTO createPlatform(@RequestBody PlatformDTO platform) {
		PlatformDTO createdPlatform = platformService.create(platform);
		System.out.println("Platform created with id = " + createdPlatform.getId());
		return createdPlatform;
	}

	/**
	 * ReadAll
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Collection<PlatformDTO> getPlatforms() {
		System.out.println("Collection of Platform requested");
		return platformService.list();
	}

	/**
	 * Read
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public PlatformDTO getPlatform(@PathVariable long id) {
		System.out.println("Platform requested with id = " + id);
		return platformService.read(id);
	}

	/**
	 * Update
	 */
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public PlatformDTO updatePlatform(@RequestBody PlatformDTO platform) {
		PlatformDTO updatedPlatform = platformService.update(platform);
		System.out.println("Platform updated with id = " + updatedPlatform.getId());
		return updatedPlatform;
	}

	/**
	 * Delete
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deletePlatform(@PathVariable long id) {
		PlatformDTO platform = platformService.read(id);
		platformService.delete(platform);
		System.out.println("Delete Platform with id = " + id);
	}
}
