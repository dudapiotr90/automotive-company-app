package pl.dudi.productionservice.configuration.servicebean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.dudi.basedomains.utils.PageableService;

@Configuration
public class ParentService {

    @Bean
    public PageableService pageableService() {
        return new PageableService();
    }
}
