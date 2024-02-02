package pl.dudi.basedomains.dto.products;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductsDto {

    private Set<ProductDto> products;
}
