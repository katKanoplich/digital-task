package ru.dc.ecom.example.repository.specification;

import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import ru.dc.ecom.example.api.dto.filter.ProductFilter;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductCriteriaBuilder {

    public Criteria build(ProductFilter filter) {
        List<Criteria> criteriaList = new ArrayList<>();

        if (filter != null) {
            if (StringUtils.isNotBlank(filter.getId())) {
                criteriaList.add(ProductCriteria.isIdLike(filter.getId()));
            }

            if (StringUtils.isNotBlank(filter.getName())) {
                criteriaList.add(ProductCriteria.isNameLike(filter.getName()));
            }
        }

        return criteriaList.isEmpty()
                ? new Criteria()
                : new Criteria().andOperator(criteriaList);
    }
}