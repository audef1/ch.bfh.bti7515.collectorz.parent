package ch.bfh.bti7515.collectorz.service.impl;

import java.lang.reflect.Type;
import java.util.Collection;

import javax.inject.Inject;
import javax.inject.Named;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import ch.bfh.bti7515.collectorz.gamecollector.model.Publisher;
import ch.bfh.bti7515.collectorz.gamecollector.repository.PublisherRepository;
import ch.bfh.bti7515.collectorz.service.PublisherService;
import ch.bfh.bti7515.collectorz.service.dto.PublisherDTO;

@Named
public class DefaultPublisherService implements PublisherService {

	@Inject
	private PublisherRepository publisherRepository;

	private final ModelMapper mapper = new ModelMapper();

	public PublisherDTO create(PublisherDTO publisherDto) {
		Publisher publisher = mapper.map(publisherDto, Publisher.class);
		Publisher persistedPublisher = publisherRepository.save(publisher);
		return mapper.map(persistedPublisher, PublisherDTO.class);
	}

	public PublisherDTO read(long id) {
		Publisher publisher = publisherRepository.findOne(id);
		if (publisher == null) return null;
        return mapper.map(publisher, PublisherDTO.class);
	}

	public Collection<PublisherDTO> list() {
		Iterable<Publisher> publishers = publisherRepository.findAll();
		Type listType = new TypeToken<Collection<PublisherDTO>>() {
		}.getType();
		return mapper.map(publishers, listType);
	}

	public PublisherDTO update(PublisherDTO publisherDto) {
		Publisher publisher = mapper.map(publisherDto, Publisher.class);
		Publisher updatedPublisher = publisherRepository.save(publisher);
		return mapper.map(updatedPublisher, PublisherDTO.class);
	}

	public void delete(PublisherDTO publisherDto) {
		Publisher publisher = publisherRepository.findOne(publisherDto.getId());
		publisherRepository.delete(publisher);
	}

}
