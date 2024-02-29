package pl.dudi.fileservice.infrastructure.database.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class InvoiceDataDocument {

    @Id
    private String id;
    private String key;

    @Indexed(unique = true)
    private String name;
    private String link;
    private OffsetDateTime expires;
}
