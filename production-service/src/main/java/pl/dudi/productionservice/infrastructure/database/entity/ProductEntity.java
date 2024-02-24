package pl.dudi.productionservice.infrastructure.database.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.dudi.productionservice.model.Photo;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private String productCode;
    private BigDecimal price;
    private Boolean available;
    private Boolean inProduction;
    private String description;
    private OffsetDateTime creationDate;
    private String designerCode;
    private int averageOpinion;

    @OneToMany(mappedBy = "product")
    private Set<OpinionEntity> opinions;

}
