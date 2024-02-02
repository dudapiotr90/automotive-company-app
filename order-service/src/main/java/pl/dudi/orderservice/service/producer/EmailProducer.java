package pl.dudi.orderservice.service.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.dudi.basedomains.dto.CustomerDto;
import pl.dudi.basedomains.dto.orders.OrderDto;
import pl.dudi.orderservice.model.rabbitmqmessage.CustomerOrderMessage;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailProducer {

    @Value("${rabbitmq.exchange.order.name}")
    private String exchange;

    @Value("${rabbitmq.binding.order.email.routing.key}")
    private String orderEmailRoutingKey;

    private final RabbitTemplate rabbitTemplate;


    public String sendOrderProcessingEmail(CustomerDto customerDto, OrderDto orderDto) {
        CustomerOrderMessage message = new CustomerOrderMessage(customerDto, orderDto);
        Object response = rabbitTemplate.convertSendAndReceive(exchange, orderEmailRoutingKey, message);
        return response.toString();
    }
}
