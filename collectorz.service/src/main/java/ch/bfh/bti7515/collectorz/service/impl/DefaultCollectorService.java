package ch.bfh.bti7515.collectorz.service.impl;

import java.lang.reflect.Type;
import java.util.Collection;

import javax.inject.Inject;
import javax.inject.Named;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import ch.bfh.bti7515.collectorz.gamecollector.model.Collector;
import ch.bfh.bti7515.collectorz.gamecollector.repository.CollectorRepository;
import ch.bfh.bti7515.collectorz.service.CollectorService;
import ch.bfh.bti7515.collectorz.service.dto.CollectorDTO;

@Named
public class DefaultCollectorService implements CollectorService {

	@Inject
	private CollectorRepository collectorRepository;

	private final ModelMapper mapper = new ModelMapper();

	public CollectorDTO create(CollectorDTO collectorDto) {
		Collector collector = mapper.map(collectorDto, Collector.class);
		Collector persistedCollector = collectorRepository.save(collector);
		return mapper.map(persistedCollector, CollectorDTO.class);
	}

	public CollectorDTO read(long id) {
		Collector collector = collectorRepository.findOne(id);
		if (collector == null) return null;
        return mapper.map(collector, CollectorDTO.class);
	}

	public Collection<CollectorDTO> list() {
		Iterable<Collector> collectors = collectorRepository.findAll();
		Type listType = new TypeToken<Collection<CollectorDTO>>() {
		}.getType();
		return mapper.map(collectors, listType);
	}

	public CollectorDTO update(CollectorDTO collectorDto) {
		Collector collector = mapper.map(collectorDto, Collector.class);
		Collector updatedCollector = collectorRepository.save(collector);
		return mapper.map(updatedCollector, CollectorDTO.class);
	}

	public void delete(CollectorDTO collectorDto) {
		Collector collector = collectorRepository.findOne(collectorDto.getId());
		collectorRepository.delete(collector);
	}

}
