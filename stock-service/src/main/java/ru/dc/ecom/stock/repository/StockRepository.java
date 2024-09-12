package ru.dc.ecom.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.dc.ecom.stock.model.StockEntity;

@Repository
public interface StockRepository extends JpaRepository<StockEntity, Long>, JpaSpecificationExecutor<StockEntity> {
}
