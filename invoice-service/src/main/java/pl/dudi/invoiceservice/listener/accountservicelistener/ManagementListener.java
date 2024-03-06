package pl.dudi.invoiceservice.listener.accountservicelistener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import pl.dudi.invoiceservice.dto.request.InvoiceRequestDto;
import pl.dudi.invoiceservice.dto.response.InvoiceFile;
import pl.dudi.invoiceservice.model.Invoice;
import pl.dudi.invoiceservice.model.PdfFile;
import pl.dudi.invoiceservice.service.DocumentTransformer;
import pl.dudi.invoiceservice.service.FileService;
import pl.dudi.invoiceservice.service.InvoiceGenerator;
import pl.dudi.invoiceservice.service.InvoiceService;

@Slf4j
@Service
@RequiredArgsConstructor
public class ManagementListener {

    private final InvoiceService invoiceService;
    private final InvoiceGenerator invoiceGenerator;
    private final DocumentTransformer documentTransformer;
    private final FileService fileService;

    @RabbitListener(queues = {"${rabbitmq.queue.management.invoice.name}"})
    public InvoiceFile consumeInvoiceRequest(InvoiceRequestDto request) {
        Invoice invoice = invoiceService.issueInvoice(request);
        PdfFile pdf = invoiceGenerator.generateInvoice(request, invoice);

        InvoiceFile invoiceFile = documentTransformer.prepareInvoiceDto(pdf, invoice);
        fileService.sendFileToExternalHosting(invoiceFile);
        return invoiceFile;

    }
}
