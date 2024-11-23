package evidence.models.services;

import evidence.data.entities.PojistenecEntity;
import evidence.data.repositories.PojistenecRepository;
import evidence.models.dto.PojistenecDTO;
import evidence.models.dto.mappers.PojistenecMapper;
import evidence.models.exceptions.PojistenecNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class PojistenecServiceImpl implements PojistenecService {

    @Autowired
    private PojistenecRepository pojistenecRepository;

    @Autowired
    private PojistenecMapper pojistenecMapper;

    @Override
    public void create(PojistenecDTO pojistenec) {

        PojistenecEntity newPojistenec = pojistenecMapper.toEntity(pojistenec);

        pojistenecRepository.save(newPojistenec);
    }

    @Override
    public List<PojistenecDTO> getAll() {
        return StreamSupport.stream(pojistenecRepository.findAll().spliterator(), false)
                .map(i -> pojistenecMapper.toDTO(i))
                .toList();
    }

    @Override
    public PojistenecDTO getById(long pojistenecId) {
        PojistenecEntity fetchedPojistenec = getPojistenecOrThrow(pojistenecId);

        return pojistenecMapper.toDTO(fetchedPojistenec);
    }

    @Override
    public void edit(PojistenecDTO pojistenec) {
        PojistenecEntity fetchedPojistenec = getPojistenecOrThrow(pojistenec.getPojistenecId());

        pojistenecMapper.updatePojistenecEntity(pojistenec, fetchedPojistenec);
        pojistenecRepository.save(fetchedPojistenec);
    }

    private PojistenecEntity getPojistenecOrThrow(long pojistenecId) {
        return pojistenecRepository
                .findById(pojistenecId)
                .orElseThrow(PojistenecNotFoundException::new);
    }

    @Override
    public void remove(long pojistenecId) {
        PojistenecEntity fetchedEntity = getPojistenecOrThrow(pojistenecId);
        pojistenecRepository.delete(fetchedEntity);
    }
}