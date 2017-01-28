package ch.bfh.bti7515.collectorz.service.impl;

import java.lang.reflect.Type;
import java.util.Collection;

import javax.inject.Inject;
import javax.inject.Named;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import ch.bfh.bti7515.collectorz.gamecollector.model.Platform;
import ch.bfh.bti7515.collectorz.gamecollector.repository.PlatformRepository;
import ch.bfh.bti7515.collectorz.service.PlatformService;
import ch.bfh.bti7515.collectorz.service.dto.PlatformDTO;

@Named
public class DefaultPlatformService implements PlatformService {

	@Inject
	private PlatformRepository platformRepository;

	private final ModelMapper mapper = new ModelMapper();

	public PlatformDTO create(PlatformDTO platformDto) {
		Platform platform = mapper.map(platformDto, Platform.class);
		Platform persistedPlatform = platformRepository.save(platform);
		return mapper.map(persistedPlatform, PlatformDTO.class);
	}

	public PlatformDTO read(long id) {
		Platform platform = platformRepository.findOne(id);
		if (platform == null) return null;
        return mapper.map(platform, PlatformDTO.class);
	}

	public Collection<PlatformDTO> list() {
		Iterable<Platform> platforms = platformRepository.findAll();
		Type listType = new TypeToken<Collection<PlatformDTO>>() {
		}.getType();
		return mapper.map(platforms, listType);
	}

	public PlatformDTO update(PlatformDTO platformDto) {
		Platform platform = mapper.map(platformDto, Platform.class);
		Platform updatedPlatform = platformRepository.save(platform);
		return mapper.map(updatedPlatform, PlatformDTO.class);
	}

	public void delete(PlatformDTO platformDto) {
		Platform platform = platformRepository.findOne(platformDto.getId());
		platformRepository.delete(platform);
	}

}
