package evidence.models.dto.mappers;

import evidence.data.entities.PojistenecEntity;
import evidence.data.entities.PojisteniEntity;
import evidence.models.dto.PojistenecDTO;
import evidence.models.dto.PojisteniDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PojistenecMapper {

    PojistenecEntity toEntity(PojistenecDTO source);
    PojistenecDTO toDTO(PojistenecEntity source);

    void updatePojistenecDTO(PojistenecDTO source, @MappingTarget PojistenecDTO target);

    default void updatePojistenecEntity(PojistenecDTO source, PojistenecEntity target) {
        target.setJmeno(source.getJmeno());
        target.setPrijmeni(source.getPrijmeni());
        target.setEmail(source.getEmail());
        target.setTelefon(source.getTelefon());
        target.setUlice(source.getUlice());
        target.setMesto(source.getMesto());
        target.setPsc(source.getPsc());

        if (source.getPojisteni() != null) {
            target.getPojisteni().clear();
            target.getPojisteni().addAll(pojisteniDTOToPojisteni(source.getPojisteni()));
        }
    }

    List<PojisteniDTO> pojisteniToPojisteniDTO(List<PojisteniEntity> pojisteni);
    List<PojisteniEntity> pojisteniDTOToPojisteni(List<PojisteniDTO> pojisteniDTO);
}
