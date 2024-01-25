package pl.dudi.basedomains.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    String orderNumber;
    OffsetDateTime issuedDateTime;
    OffsetDateTime realizedDateTime;
    String comment;
    Boolean realized;
    Boolean inProgress;
    OffsetDateTime cancelTill;
    Set<String> productsCode;
}
