package pl.dudi.invoiceservice.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import pl.dudi.invoiceservice.infrastructure.dao.InvoiceDao;
import pl.dudi.invoiceservice.infrastructure.entity.InvoiceEntity;
import pl.dudi.invoiceservice.infrastructure.repository.jpa.InvoiceJpaRepository;
import pl.dudi.invoiceservice.mapper.InvoiceMapper;
import pl.dudi.invoiceservice.model.Invoice;

@Repository
@RequiredArgsConstructor
public class InvoiceRepository implements InvoiceDao {

    private final InvoiceJpaRepository invoiceJpaRepository;
    private final InvoiceMapper invoiceMapper;

    @Override
    public InvoiceEntity findLastInvoice(String email) {
        return invoiceJpaRepository.findFirstByCustomerEmailOrderByIssuedAtDesc(email);
    }

    @Override
    public InvoiceEntity saveInvoice(InvoiceEntity invoice) {
        return invoiceJpaRepository.save(invoice);
    }

    @Override
    public Page<Invoice> findInvoices(int customerCode, Pageable pageable) {
        Page<InvoiceEntity> invoices = invoiceJpaRepository.findByCustomerCode(customerCode, pageable);
        return invoices.map(invoiceMapper::mapFromEntity);
    }
}
