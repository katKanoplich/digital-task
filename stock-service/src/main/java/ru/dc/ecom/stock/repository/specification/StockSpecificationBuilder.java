package ru.dc.ecom.stock.repository.specification;

import io.micrometer.common.util.StringUtils;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import ru.dc.ecom.stock.api.dto.filter.StockFilter;
import ru.dc.ecom.stock.model.StockEntity;

@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class StockSpecificationBuilder {
    public static Specification<StockEntity> buildStcokSpecification(StockFilter filter) {
        Specification<StockEntity> spec = Specification.where(null);

        if (filter != null) {
            if (StringUtils.isNotEmpty(filter.getTag())) {
                spec = spec.and(StockSpecification.tagLike(filter.getTag()));
            }
        }
        return spec;
    }

}
