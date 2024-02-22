package pl.dudi.invoiceservice.service.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import pl.dudi.invoiceservice.dto.InvoiceDto;
import pl.dudi.invoiceservice.service.FileService;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileServiceSender implements FileService {

    private final RabbitTemplate rabbitTemplate;


    @Override
    public void sendFileToExternalHosting(InvoiceDto invoiceDto) {
        // TODO send to fileService
    }
}
