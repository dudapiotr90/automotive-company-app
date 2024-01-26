package pl.dudi.basedomains.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    String productNumber;
    BigDecimal price;
    Boolean available;
    Boolean inProduction;
    String description;
    OffsetDateTime creationDate;
    // TODO for thymeleaf <img th:src="|data:image/png;base64,${productDto.photo}|" width="100" height="100"/>
    // TODO possible change for js/react in the future
    String photo;
    String designerCode;
}
