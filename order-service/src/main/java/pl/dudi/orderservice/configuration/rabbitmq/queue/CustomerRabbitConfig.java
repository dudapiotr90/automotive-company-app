package pl.dudi.orderservice.configuration.rabbitmq.queue;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CustomerRabbitConfig {

    @Value("${rabbitmq.queue.order.customer.name}")
    private String orderCustomerQueue;
    @Value("${rabbitmq.binding.order.customer.routing.key}")
    private String orderCustomerRoutingKey;


    @Bean
    public Queue orderCustomerQueue() {
        return new Queue(orderCustomerQueue);
    }

    @Bean
    public Binding orderCustomerBinding(TopicExchange exchange) {
        return BindingBuilder
            .bind(orderCustomerQueue())
            .to(exchange)
            .with(orderCustomerRoutingKey);
    }


}
