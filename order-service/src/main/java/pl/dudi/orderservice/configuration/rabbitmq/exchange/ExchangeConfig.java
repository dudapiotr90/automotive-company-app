package pl.dudi.orderservice.configuration.rabbitmq.exchange;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExchangeConfig {

    @Value("${rabbitmq.exchange.order.name}")
    private String exchange;


}
