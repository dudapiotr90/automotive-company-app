package pl.dudi.accountservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import pl.dudi.accountservice.infrastructure.database.entity.AccountEntity;
import pl.dudi.accountservice.model.Account;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountMapper {

    AccountEntity mapToEntity(Account account);

    @Named("mapFromEntity")
    Account mapFromEntity(AccountEntity account);

}
