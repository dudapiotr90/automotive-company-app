package pl.dudi.invoiceservice.service.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.dudi.invoiceservice.dto.response.InvoiceFile;
import pl.dudi.invoiceservice.service.FileService;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileServiceSender implements FileService {

    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange.file.name}")
    private String exchange;

    @Value("${rabbitmq.binding.invoice.file.routing.key}")
    private String invoiceFileRoutingKey;


    @Override
    public void sendFileToExternalHosting(InvoiceFile invoiceFile) {
        log.info("invoice send to file service");
        rabbitTemplate.convertAndSend(exchange,invoiceFileRoutingKey, invoiceFile);
    }
}
