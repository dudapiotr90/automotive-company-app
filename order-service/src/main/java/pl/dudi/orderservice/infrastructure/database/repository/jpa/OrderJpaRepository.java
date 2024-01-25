package pl.dudi.orderservice.infrastructure.database.repository.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dudi.orderservice.infrastructure.database.entity.OrderEntity;
import pl.dudi.orderservice.model.Order;

@Repository
public interface OrderJpaRepository extends JpaRepository<OrderEntity,Long> {

    // TODO check if works after inserting data
    Page<OrderEntity> findByCustomerCodeAndRealized(int customerCode, Pageable pageable, boolean realized);
}
