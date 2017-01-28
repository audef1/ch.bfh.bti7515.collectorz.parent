package ch.bfh.bti7515.collectorz.service;

import java.util.Collection;

import ch.bfh.bti7515.collectorz.service.dto.PublisherDTO;

public interface PublisherService {
	
	public PublisherDTO create(PublisherDTO publisher);
	public PublisherDTO read(long id);
	public Collection<PublisherDTO> list();
	public PublisherDTO update(PublisherDTO publisher);
	public void delete(PublisherDTO publisher);

}
