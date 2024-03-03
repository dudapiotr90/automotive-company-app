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

    @RabbitListener(queues = {"${rabbitmq.queue.invoice.file.save}"})
    public void saveInvoice(InvoiceDto invoiceDto) {
        fileService.saveInvoice(invoiceDto);
    }

    @RabbitListener(queues = {"${rabbitmq.queue.invoice.file.update}"})
    public void updateInvoice(InvoiceDto invoiceDto) {
        fileService.updateInvoice(invoiceDto);
    }

}
