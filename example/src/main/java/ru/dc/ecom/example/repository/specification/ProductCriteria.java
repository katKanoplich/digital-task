package ru.dc.ecom.example.repository.specification;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.query.Criteria;
import ru.dc.ecom.example.model.ProductEntity;
import ru.dc.ecom.example.repository.specification.utils.CriteriaUtils;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductCriteria {

    public static Criteria isIdLike(String id) {
        return CriteriaUtils.isFieldContains(ProductEntity.Fields.id, id);
    }

    public static Criteria isNameLike(String name) {
        return CriteriaUtils.isFieldContains(ProductEntity.Fields.name, name);
    }
}