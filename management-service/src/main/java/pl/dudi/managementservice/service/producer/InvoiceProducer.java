package pl.dudi.managementservice.service.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.dudi.managementservice.dto.Invoice;
import pl.dudi.managementservice.dto.InvoiceRequestDto;

@Slf4j
@Service
@RequiredArgsConstructor
public class InvoiceProducer {

    @Value("${rabbitmq.exchange.management.name}")
    private String exchange;

    @Value("${rabbitmq.binding.management.invoice.routing.key}")
    private String managementInvoiceRoutingKey;

    private final RabbitTemplate rabbitTemplate;

    public Invoice generateInvoice(InvoiceRequestDto invoiceRequest) {
        return (Invoice) rabbitTemplate.convertSendAndReceive(exchange, managementInvoiceRoutingKey, invoiceRequest);
    }
}
