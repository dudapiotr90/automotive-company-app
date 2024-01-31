package pl.dudi.orderservice.configuration.rabbitmq.queue;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class EmailRabbitConfig {

    @Value("${rabbitmq.queue.order.email.name}")
    private String orderEmailQueue;
    @Value("${rabbitmq.binding.order.email.routing.key}")
    private String orderEmailRoutingKey;


    @Bean
    public Queue orderEmailQueue() {
        return new Queue(orderEmailQueue);
    }

    @Bean
    public Binding orderEmailBinding(TopicExchange exchange) {
        return BindingBuilder
            .bind(orderEmailQueue())
            .to(exchange)
            .with(orderEmailRoutingKey);
    }


}
