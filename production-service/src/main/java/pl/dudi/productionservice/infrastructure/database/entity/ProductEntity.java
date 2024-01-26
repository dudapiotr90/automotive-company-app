package pl.dudi.productionservice.infrastructure.database.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.dudi.productionservice.model.Photo;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class ProductEntity {
    private Long id;
    private String productNumber;
    private BigDecimal price;
    private Boolean available;
    private Boolean inProduction;
    private String description;
    private OffsetDateTime creationDate;
    private Photo photo;
    private String designerCode;
}
