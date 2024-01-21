package pl.dudi.accountservice.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dudi.accountservice.infrastructure.database.entity.CustomerEntity;

import java.util.Optional;

@Repository
public interface CustomerJpaRepository extends JpaRepository<CustomerEntity,Long> {
    Optional<CustomerEntity> findByCustomerCode(int customerCode);
}
