package pl.dudi.productionservice.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import pl.dudi.basedomains.dto.products.ProductDto;
import pl.dudi.productionservice.infrastructure.database.entity.ProductEntity;
import pl.dudi.productionservice.model.Photo;
import pl.dudi.productionservice.model.Product;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.Objects;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    @Mapping(target = "photo", ignore = true )
    ProductDto mapToProductDto(Product product);

    @Mapping(target = "photo", ignore = true )
    Product mapToProduct(ProductEntity productEntity);

    @Mapping(target = "photo", ignore = true )
    Product mapToProduct(ProductDto productDto);

    @Mapping(target = "photo", ignore = true )
    ProductEntity mapToProductEntity(Product product);



}
