package ch.bfh.bti7515.collectorz.service;

import java.util.Collection;

import ch.bfh.bti7515.collectorz.service.dto.DeveloperDTO;

public interface DeveloperService {
	
	public DeveloperDTO create(DeveloperDTO developer);
	public DeveloperDTO read(long id);
	public Collection<DeveloperDTO> list();
	public DeveloperDTO update(DeveloperDTO developer);
	public void delete(DeveloperDTO developer);

}
