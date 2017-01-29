package ch.bfh.bti7515.collectorz.service.impl;

import java.lang.reflect.Type;
import java.util.Collection;

import javax.inject.Inject;
import javax.inject.Named;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import ch.bfh.bti7515.collectorz.gamecollector.model.Developer;
import ch.bfh.bti7515.collectorz.gamecollector.repository.DeveloperRepository;
import ch.bfh.bti7515.collectorz.service.DeveloperService;
import ch.bfh.bti7515.collectorz.service.dto.DeveloperDTO;

@Named
public class DefaultDeveloperService implements DeveloperService {

	@Inject
	private DeveloperRepository developerRepository;

	private final ModelMapper mapper = new ModelMapper();

	public DeveloperDTO create(DeveloperDTO developerDto) {
		Developer developer = mapper.map(developerDto, Developer.class);
		Developer persistedDeveloper = developerRepository.save(developer);
		return mapper.map(persistedDeveloper, DeveloperDTO.class);
	}

	public DeveloperDTO read(long id) {
		Developer developer = developerRepository.findOne(id);
		if (developer == null) return null;
        return mapper.map(developer, DeveloperDTO.class);
	}

	public Collection<DeveloperDTO> list() {
		Iterable<Developer> developers = developerRepository.findAll();
		Type listType = new TypeToken<Collection<DeveloperDTO>>() {
		}.getType();
		return mapper.map(developers, listType);
	}

	public DeveloperDTO update(DeveloperDTO developerDto) {
		Developer developer = mapper.map(developerDto, Developer.class);
		Developer updatedDeveloper = developerRepository.save(developer);
		return mapper.map(updatedDeveloper, DeveloperDTO.class);
	}

	public void delete(DeveloperDTO developerDto) {
		Developer developer = developerRepository.findOne(developerDto.getId());
		developerRepository.delete(developer);
	}

}
