package ru.dc.ecom.example.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.dc.ecom.example.api.dto.ProductDto;
import ru.dc.ecom.example.model.ProductEntity;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductConverter {

    ProductDto convertToDto(ProductEntity entity);
    ProductEntity convertToEntity(ProductDto dto);

    @Mapping(target = "id", ignore = true)
    void updateEntity(@MappingTarget ProductEntity productEntity, ProductDto productDto);
}