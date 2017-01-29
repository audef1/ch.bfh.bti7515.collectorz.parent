package ch.bfh.bti7515.collectorz.service.impl;

import java.lang.reflect.Type;

import javax.inject.Inject;
import javax.inject.Named;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import ch.bfh.bti7515.collectorz.gamecollector.model.Collection;
import ch.bfh.bti7515.collectorz.gamecollector.repository.CollectionRepository;
import ch.bfh.bti7515.collectorz.service.CollectionService;
import ch.bfh.bti7515.collectorz.service.dto.CollectionDTO;

@Named
public class DefaultCollectionService implements CollectionService {

	@Inject
	private CollectionRepository collectionRepository;

	private final ModelMapper mapper = new ModelMapper();

	public CollectionDTO create(CollectionDTO collectionDto) {
		Collection collection = mapper.map(collectionDto, Collection.class);
		Collection persistedCollection = collectionRepository.save(collection);
		return mapper.map(persistedCollection, CollectionDTO.class);
	}

	public CollectionDTO read(long id) {
		Collection collection = collectionRepository.findOne(id);
		if (collection == null) return null;
        return mapper.map(collection, CollectionDTO.class);
	}

	public java.util.Collection<CollectionDTO> list() {
		Iterable<Collection> collections = collectionRepository.findAll();
		Type listType = new TypeToken<java.util.Collection<CollectionDTO>>() {
		}.getType();
		return mapper.map(collections, listType);
	}

	public CollectionDTO update(CollectionDTO collectionDto) {
		Collection collection = mapper.map(collectionDto, Collection.class);
		Collection updatedCollection = collectionRepository.save(collection);
		return mapper.map(updatedCollection, CollectionDTO.class);
	}

	public void delete(CollectionDTO collectionDto) {
		Collection collection = collectionRepository.findOne(collectionDto.getId());
		collectionRepository.delete(collection);
	}

}
