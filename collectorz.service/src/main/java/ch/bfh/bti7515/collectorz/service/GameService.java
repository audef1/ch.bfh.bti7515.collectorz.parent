package ch.bfh.bti7515.collectorz.service;

import java.util.Collection;

import ch.bfh.bti7515.collectorz.service.dto.GameDTO;

public interface GameService {
	
	public GameDTO create(GameDTO game);
	public GameDTO read(long id);
	public Collection<GameDTO> list();
	public GameDTO update(GameDTO game);
	public void delete(GameDTO game);

}
