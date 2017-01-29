package ch.bfh.bti7515.collectorz.service;

import java.util.Collection;

import ch.bfh.bti7515.collectorz.service.dto.CollectorDTO;

public interface CollectorService {
	
	public CollectorDTO create(CollectorDTO collector);
	public CollectorDTO read(long id);
	public Collection<CollectorDTO> list();
	public CollectorDTO update(CollectorDTO collector);
	public void delete(CollectorDTO collector);

}
