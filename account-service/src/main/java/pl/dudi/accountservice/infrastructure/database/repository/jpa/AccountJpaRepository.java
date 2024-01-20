package pl.dudi.accountservice.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dudi.accountservice.infrastructure.database.entity.AccountEntity;

import java.util.Optional;

@Repository
public interface AccountJpaRepository extends JpaRepository<AccountEntity, Long> {

    Optional<AccountEntity> findByEmail(String email);
}
