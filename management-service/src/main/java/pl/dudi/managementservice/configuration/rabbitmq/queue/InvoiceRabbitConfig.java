package pl.dudi.managementservice.configuration.rabbitmq.queue;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class InvoiceRabbitConfig {

    @Value("${rabbitmq.queue.management.invoice.name}")
    private String managementInvoiceQueue;
    @Value("${rabbitmq.binding.management.invoice.routing.key}")
    private String managementInvoiceRoutingKey;


    @Bean
    public Queue managementInvoiceQueue() {
        return new Queue(managementInvoiceQueue);
    }

    @Bean
    public Binding managementInvoiceBinding(TopicExchange exchange) {
        return BindingBuilder
            .bind(managementInvoiceQueue())
            .to(exchange)
            .with(managementInvoiceRoutingKey);
    }


}
