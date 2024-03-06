package pl.dudi.invoiceservice.infrastructure.repository.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dudi.invoiceservice.infrastructure.entity.InvoiceEntity;

@Repository
public interface InvoiceJpaRepository extends JpaRepository<InvoiceEntity,Long> {
    InvoiceEntity findFirstByCustomerEmailOrderByIssuedAtDesc(String email);

    Page<InvoiceEntity> findByCustomerCode(int customerCode, Pageable pageable);
}
