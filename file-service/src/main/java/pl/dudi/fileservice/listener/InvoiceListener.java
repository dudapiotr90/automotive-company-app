package pl.dudi.fileservice.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import pl.dudi.fileservice.dto.InvoiceDto;
import pl.dudi.fileservice.service.FileService;

@Slf4j
@Service
@RequiredArgsConstructor
public class InvoiceListener {

    private final FileService fileService;

    @RabbitListener(queues = {"${rabbitmq.queue.management.invoice.name}"})
    public void consumeInvoices(InvoiceDto invoiceDto) {
        fileService.saveInvoice(invoiceDto);
    }

}
