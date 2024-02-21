package pl.dudi.emailservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dudi.emailservice.model.EmailTemplate;
import pl.dudi.emailservice.service.EmailTemplateService;

@Service
@RequiredArgsConstructor
public class EmailTemplateServiceImpl implements EmailTemplateService {

    @Override
    public EmailTemplate getInvoiceTemplate() {
        return null;
    }
}
