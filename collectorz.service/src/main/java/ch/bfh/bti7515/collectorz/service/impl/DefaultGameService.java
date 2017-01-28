package ch.bfh.bti7515.collectorz.service.impl;

import java.lang.reflect.Type;
import java.util.Collection;

import javax.inject.Inject;
import javax.inject.Named;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import ch.bfh.bti7515.collectorz.gamecollector.model.Game;
import ch.bfh.bti7515.collectorz.gamecollector.repository.GameRepository;
import ch.bfh.bti7515.collectorz.service.GameService;
import ch.bfh.bti7515.collectorz.service.dto.GameDTO;

@Named
public class DefaultGameService implements GameService {

	@Inject
	private GameRepository gameRepository;

	private final ModelMapper mapper = new ModelMapper();

	public GameDTO create(GameDTO gameDto) {
		Game game = mapper.map(gameDto, Game.class);
		Game persistedGame = gameRepository.save(game);
		return mapper.map(persistedGame, GameDTO.class);
	}

	public GameDTO read(long id) {
		Game game = gameRepository.findOne(id);
		if (game == null) return null;
        return mapper.map(game, GameDTO.class);
	}

	public Collection<GameDTO> list() {
		Iterable<Game> games = gameRepository.findAll();
		Type listType = new TypeToken<Collection<GameDTO>>() {
		}.getType();
		return mapper.map(games, listType);
	}

	public GameDTO update(GameDTO gameDto) {
		Game game = mapper.map(gameDto, Game.class);
		Game updatedGame = gameRepository.save(game);
		return mapper.map(updatedGame, GameDTO.class);
	}

	public void delete(GameDTO gameDto) {
		Game game = gameRepository.findOne(gameDto.getId());
		gameRepository.delete(game);
	}

}
