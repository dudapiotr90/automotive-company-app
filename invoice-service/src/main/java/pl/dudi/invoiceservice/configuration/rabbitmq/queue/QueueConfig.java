package pl.dudi.invoiceservice.configuration.rabbitmq.queue;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class QueueConfig {

    @Value("${rabbitmq.queue.invoice.file.save}")
    private String invoiceFileQueueSave;
    @Value("${rabbitmq.queue.invoice.file.update}")
    private String invoiceFileQueueUpdate;
    @Value("${rabbitmq.binding.invoice.file.routing.key_save}")
    private String invoiceFileRoutingKeySave;
    @Value("${rabbitmq.binding.invoice.file.routing.key_update}")
    private String invoiceFileRoutingKeyUpdate;


    @Bean
    public Queue managementEmailQueueSave() {
        return new Queue(invoiceFileQueueSave);
    }
    @Bean
    public Queue managementEmailQueueUpdate() {
        return new Queue(invoiceFileQueueUpdate);
    }

    @Bean
    public Binding managementEmailBindingSave(TopicExchange exchange) {
        return BindingBuilder
            .bind(managementEmailQueueSave())
            .to(exchange)
            .with(invoiceFileRoutingKeySave);
    }

    @Bean
    public Binding managementEmailBindingUpdate(TopicExchange exchange) {
        return BindingBuilder
            .bind(managementEmailQueueUpdate())
            .to(exchange)
            .with(invoiceFileRoutingKeyUpdate);
    }


}
