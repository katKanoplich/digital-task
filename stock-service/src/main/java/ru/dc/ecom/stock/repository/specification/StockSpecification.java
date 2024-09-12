package ru.dc.ecom.stock.repository.specification;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import ru.dc.ecom.stock.model.StockEntity;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StockSpecification {

    public static Specification<StockEntity> tagLike(String tag) {
        return (root, query, builder) ->
                builder.like(root.get("tag"), "%" + tag + "%");
    }
    public static Specification<StockEntity> productIdEquals(Long productId) {
        return (root, query, builder) ->
                builder.equal(root.get("productId"), productId);
    }
    public static Specification<StockEntity> amountGreaterThan(Integer amount) {
        return (root, query, builder) ->
                builder.greaterThan(root.get("amount"), amount);
    }

}
