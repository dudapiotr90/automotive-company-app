package pl.dudi.invoiceservice.configuration.rabbitmq.queue;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class EmailRabbitConfig {

    @Value("${rabbitmq.queue.invoice.file.name}")
    private String invoiceFileQueue;
    @Value("${rabbitmq.binding.invoice.file.routing.key}")
    private String invoiceFileRoutingKey;


    @Bean
    public Queue managementEmailQueue() {
        return new Queue(invoiceFileQueue);
    }

    @Bean
    public Binding managementEmailBinding(TopicExchange exchange) {
        return BindingBuilder
            .bind(managementEmailQueue())
            .to(exchange)
            .with(invoiceFileRoutingKey);
    }


}
