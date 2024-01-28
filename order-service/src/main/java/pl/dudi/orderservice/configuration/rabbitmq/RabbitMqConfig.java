package pl.dudi.orderservice.configuration.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMqConfig {

    @Value("${rabbitmq.exchange.order.name}")
    private String exchange;
    @Value("${rabbitmq.queue.order.name}")
    private String orderQueue;
    @Value("${rabbitmq.binding.order.customer.routing.key}")
    private String orderCustomerRoutingKey;


    @Bean
    public Queue emailQueue() {
        return new Queue(orderQueue);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(exchange);
    }

    @Bean
    public Binding orderBinding() {
        return BindingBuilder
            .bind(emailQueue())
            .to(exchange())
            .with(orderCustomerRoutingKey);
    }
    @Bean
    public MessageConverter jsonConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        return new Jackson2JsonMessageConverter(objectMapper);
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonConverter());
        return rabbitTemplate;
    }

}
