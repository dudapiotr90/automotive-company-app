package pl.dudi.productionservice.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.dudi.productionservice.infrastructure.database.entity.OpinionEntity;
import pl.dudi.productionservice.model.Opinion;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE,uses = {ProductMapper.class})
public interface OpinionMapper {

    OpinionEntity mapToEntity(Opinion opinion);

    Opinion mapFromEntity(OpinionEntity opinion);
}
