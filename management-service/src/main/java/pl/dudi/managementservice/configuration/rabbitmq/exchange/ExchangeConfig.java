package pl.dudi.managementservice.configuration.rabbitmq.exchange;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExchangeConfig {

    @Value("${rabbitmq.exchange.management.name}")
    private String exchange;


    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(exchange);
    }


}
