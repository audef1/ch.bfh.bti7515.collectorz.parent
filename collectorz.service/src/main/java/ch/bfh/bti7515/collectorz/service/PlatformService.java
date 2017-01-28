package ch.bfh.bti7515.collectorz.service;

import java.util.Collection;

import ch.bfh.bti7515.collectorz.service.dto.PlatformDTO;

public interface PlatformService {
	
	public PlatformDTO create(PlatformDTO platform);
	public PlatformDTO read(long id);
	public Collection<PlatformDTO> list();
	public PlatformDTO update(PlatformDTO platform);
	public void delete(PlatformDTO platform);

}
