package pl.dudi.managementservice.service.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailProducer {

    @Value("${rabbitmq.exchange.management.name}")
    private String exchange;

    @Value("${rabbitmq.binding.management.email.routing.key}")
    private String managementEmailRoutingKey;

    private final RabbitTemplate rabbitTemplate;


}
