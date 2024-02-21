package pl.dudi.orderservice.infrastructure.database.repository.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dudi.orderservice.infrastructure.database.entity.OrderEntity;
import pl.dudi.orderservice.model.Status;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderJpaRepository extends JpaRepository<OrderEntity,Long> {

    // TODO check if works after inserting data
    Page<OrderEntity> findByCustomerCodeAndStatus(int customerCode, Status status, Pageable pageable);

    Optional<OrderEntity> findByOrderNumber(String orderNumber);

    List<OrderEntity> findByStatus(Status status);

}
