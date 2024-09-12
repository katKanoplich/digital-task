package ru.dc.ecom.example.repository.specification.utils;

import org.springframework.data.mongodb.core.query.Criteria;

public class CriteriaUtils {
    public static Criteria isFieldContains(String fieldName, String value) {
        return Criteria.where(fieldName).regex(value, "i");
    }

}