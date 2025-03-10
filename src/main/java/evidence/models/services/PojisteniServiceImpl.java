package evidence.models.services;

import evidence.data.entities.PojistenecEntity;
import evidence.data.entities.PojisteniEntity;
import evidence.data.repositories.PojisteniRepository;
import evidence.data.repositories.PojistenecRepository;
import evidence.models.dto.PojisteniDTO;
import evidence.models.dto.mappers.PojisteniMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PojisteniServiceImpl implements PojisteniService {

    @Autowired
    private PojisteniRepository pojisteniRepository;

    @Autowired
    private PojistenecRepository pojistenecRepository;

    @Autowired
    private PojisteniMapper pojisteniMapper;

    @Override
    public void create(PojisteniDTO pojisteniDTO) {

        PojisteniEntity newPojisteni = pojisteniMapper.toEntity(pojisteniDTO);

        PojistenecEntity pojistenec = pojistenecRepository.findById(pojisteniDTO.getPojistenecId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid pojistenec ID: " + pojisteniDTO.getPojistenecId()));

        newPojisteni.setPojistenec(pojistenec);

        pojisteniRepository.save(newPojisteni);
    }

    @Override
    public PojisteniDTO getById(long pojisteniId) {
        PojisteniEntity fetchedPojisteni = getPojisteniOrThrow(pojisteniId);

        return pojisteniMapper.toDTO(fetchedPojisteni);
    }

    @Override
    public void edit(PojisteniDTO pojisteni) {
        PojisteniEntity fetchedPojisteni = getPojisteniOrThrow(pojisteni.getPojisteniId());

        pojisteniMapper.updatePojisteniEntity(pojisteni, fetchedPojisteni);
        pojisteniRepository.save(fetchedPojisteni);
    }

    private PojisteniEntity getPojisteniOrThrow(long pojisteniId) {
        return pojisteniRepository
                .findById(pojisteniId)
                .orElseThrow();
    }
    @Override
    public void remove(long pojisteniId) {
        PojisteniEntity fetchedEntity = getPojisteniOrThrow(pojisteniId);
        pojisteniRepository.delete(fetchedEntity);
    }
}