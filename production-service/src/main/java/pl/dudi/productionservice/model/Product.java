package pl.dudi.productionservice.model;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Value
@Builder
public class Product {

    Long id;
    String productName;
    String productNumber;
    BigDecimal price;
    Boolean available;
    Boolean inProduction;
    String description;
    OffsetDateTime creationDate;
    Photo photo;
    String designerCode;
    int averageOpinion;

}
