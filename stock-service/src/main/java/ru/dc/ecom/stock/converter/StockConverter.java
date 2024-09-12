package ru.dc.ecom.stock.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.dc.ecom.stock.api.dto.StockDto;
import ru.dc.ecom.stock.model.StockEntity;
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface StockConverter {

    StockDto convertToDto(StockEntity entity);
    StockEntity convertToEntity(StockDto dto);

    @Mapping(target = "id", ignore = true)
    void updateEntity(@MappingTarget StockEntity stockEntity, StockDto stockDto);
}
