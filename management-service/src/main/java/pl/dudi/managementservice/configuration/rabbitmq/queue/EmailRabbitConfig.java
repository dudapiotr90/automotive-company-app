package pl.dudi.managementservice.configuration.rabbitmq.queue;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class EmailRabbitConfig {

    @Value("${rabbitmq.queue.management.email.name}")
    private String managementEmailQueue;
    @Value("${rabbitmq.binding.management.email.routing.key}")
    private String managementEmailRoutingKey;


    @Bean
    public Queue managementEmailQueue() {
        return new Queue(managementEmailQueue);
    }

    @Bean
    public Binding managementEmailBinding(TopicExchange exchange) {
        return BindingBuilder
            .bind(managementEmailQueue())
            .to(exchange)
            .with(managementEmailRoutingKey);
    }


}
