package pl.dudi.invoiceservice.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.dudi.invoiceservice.infrastructure.dao.InvoiceDao;
import pl.dudi.invoiceservice.infrastructure.entity.InvoiceEntity;
import pl.dudi.invoiceservice.infrastructure.repository.jpa.InvoiceJpaRepository;

@Repository
@RequiredArgsConstructor
public class InvoiceRepository implements InvoiceDao {

    private final InvoiceJpaRepository invoiceJpaRepository;

    @Override
    public InvoiceEntity findLastInvoice(String email) {
        return invoiceJpaRepository.findFirstByOrderByIssuedDateTimeDescWhereEmail(email);
    }
}
