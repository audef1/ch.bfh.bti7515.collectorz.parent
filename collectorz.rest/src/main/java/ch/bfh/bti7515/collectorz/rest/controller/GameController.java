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

import ch.bfh.bti7515.collectorz.service.GameService;
import ch.bfh.bti7515.collectorz.service.dto.GameDTO;

@Controller
@RequestMapping("/games")
public class GameController {

	@Inject
	private GameService gameService;

	/**
	 * Create
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public GameDTO createGame(@RequestBody GameDTO game) {
		GameDTO createdGame = gameService.create(game);
		System.out.println("Game created with id = " + createdGame.getId());
		return createdGame;
	}

	/**
	 * ReadAll
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Collection<GameDTO> getGames() {
		System.out.println("Collection of Game requested");
		return gameService.list();
	}

	/**
	 * Read
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public GameDTO getGame(@PathVariable long id) {
		System.out.println("Game requested with id = " + id);
		return gameService.read(id);
	}

	/**
	 * Update
	 */
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public GameDTO updateGame(@RequestBody GameDTO game) {
		GameDTO updatedGame = gameService.update(game);
		System.out.println("Game updated with id = " + updatedGame.getId());
		return updatedGame;
	}

	/**
	 * Delete
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteGame(@PathVariable long id) {
		GameDTO game = gameService.read(id);
		gameService.delete(game);
		System.out.println("Delete Game with id = " + id);
	}
}
