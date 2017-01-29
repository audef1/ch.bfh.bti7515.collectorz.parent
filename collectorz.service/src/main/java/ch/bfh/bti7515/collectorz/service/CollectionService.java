package ch.bfh.bti7515.collectorz.service;

import java.util.Collection;

import ch.bfh.bti7515.collectorz.service.dto.CollectionDTO;

public interface CollectionService {
	
	public CollectionDTO create(CollectionDTO collection);
	public CollectionDTO read(long id);
	public Collection<CollectionDTO> list();
	public CollectionDTO update(CollectionDTO collection);
	public void delete(CollectionDTO collection);

}
