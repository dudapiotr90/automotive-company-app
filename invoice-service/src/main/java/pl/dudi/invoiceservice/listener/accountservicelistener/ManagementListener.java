package pl.dudi.invoiceservice.listener.accountservicelistener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import pl.dudi.invoiceservice.dto.InvoiceDto;
import pl.dudi.invoiceservice.model.Invoice;
import pl.dudi.invoiceservice.dto.InvoiceRequestDto;
import pl.dudi.invoiceservice.service.InvoiceService;

@Slf4j
@Service
@RequiredArgsConstructor
public class ManagementListener {

    private final InvoiceService invoiceService;

    @RabbitListener(queues = {"${rabbitmq.queue.management.invoice.name}"})
    public InvoiceDto consumeInvoiceRequest(InvoiceRequestDto request) {
        InvoiceDto invoice = invoiceService.processInvoice(request);
        return invoice;
    }



}
