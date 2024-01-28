package pl.dudi.orderservice.service.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderProducer {


    @Value("${rabbitmq.exchange.order.name}")
    private String exchange;
    @Value("${rabbitmq.binding.order.customer.routing.key}")
    private String orderCustomerRoutingKey;

    private final RabbitTemplate rabbitTemplate;

    public String sendOrderRequestToManagement() {
        return "We received your. We will send an email with all the details";
    }
}
