package pl.dudi.managementservice.service.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.dudi.managementservice.dto.InvoiceDto;

@Slf4j
@Service
@RequiredArgsConstructor
public class InvoiceProducer {

    @Value("${rabbitmq.exchange.management.name}")
    private String exchange;

    @Value("${rabbitmq.binding.management.invoice.routing.key}")
    private String managementInvoiceRoutingKey;

    private final RabbitTemplate rabbitTemplate;

    public InvoiceDto generateInvoice(String orderNumber) {

        return null;
    }
}
