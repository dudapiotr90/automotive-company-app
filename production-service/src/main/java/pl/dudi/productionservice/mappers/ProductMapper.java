package pl.dudi.productionservice.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.dudi.basedomains.dto.products.ProductDto;
import pl.dudi.productionservice.infrastructure.database.entity.ProductEntity;
import pl.dudi.productionservice.model.Product;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {
    ProductDto mapToProductDto(Product product);

    Product mapToProduct(ProductEntity productEntity);

    Product mapToProduct(ProductDto productDto);

    ProductEntity mapToProductEntity(Product product);
}
