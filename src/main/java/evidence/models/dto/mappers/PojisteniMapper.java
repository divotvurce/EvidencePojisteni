package evidence.models.dto.mappers;

import evidence.data.entities.PojisteniEntity;
import evidence.data.entities.PojistenecEntity;
import evidence.models.dto.PojistenecDTO;
import evidence.models.dto.PojisteniDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PojisteniMapper {

    PojisteniMapper INSTANCE = Mappers.getMapper(PojisteniMapper.class);

    // Mapping from PojisteniDTO to PojisteniEntity
    @Mapping(source = "pojistenecId", target = "pojistenec", qualifiedByName = "mapPojistenecIdToEntity")
    PojisteniEntity toEntity(PojisteniDTO pojisteniDTO);

    // Mapping from PojisteniEntity to PojisteniDTO
    @Mapping(source = "pojisteniId", target = "pojisteniId")
    @Mapping(source = "pojistenec.pojistenecId", target = "pojistenecId")
    PojisteniDTO toDTO(PojisteniEntity pojisteniEntity);

    // Helper method to map a Pojistenec ID to a PojistenecEntity
    @Named("mapPojistenecIdToEntity")
    default PojistenecEntity mapPojistenecIdToEntity(Long pojistenecId) {
        if (pojistenecId == null) return null;

        PojistenecEntity pojistenecEntity = new PojistenecEntity();
        pojistenecEntity.setPojistenecId(pojistenecId);
        return pojistenecEntity;
    }
    void updatePojisteniDTO(PojisteniDTO source, @MappingTarget PojisteniDTO target);
    void updatePojisteniEntity(PojisteniDTO source, @MappingTarget PojisteniEntity target);
}