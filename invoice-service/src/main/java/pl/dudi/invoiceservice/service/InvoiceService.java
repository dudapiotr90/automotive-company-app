package pl.dudi.invoiceservice.service;

import org.springframework.data.domain.Page;
import pl.dudi.basedomains.dto.PageRequestDto;
import pl.dudi.invoiceservice.dto.request.InvoiceRequestDto;
import pl.dudi.invoiceservice.dto.response.InvoiceDetails;
import pl.dudi.invoiceservice.model.Invoice;

public interface InvoiceService {

    PageRequestDto DEFAULT_INVOICE_HISTORY_REQUEST = new PageRequestDto(1, 10, "desc", "completedDateTime");
    Invoice issueInvoice(InvoiceRequestDto request);

    Page<InvoiceDetails> findInvoices(int customerCode, PageRequestDto pageRequestDto);
}
