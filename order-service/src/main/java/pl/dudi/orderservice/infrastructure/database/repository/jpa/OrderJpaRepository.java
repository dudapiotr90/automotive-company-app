package pl.dudi.orderservice.infrastructure.database.repository.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.dudi.orderservice.infrastructure.database.entity.OrderEntity;
import pl.dudi.orderservice.model.Status;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderJpaRepository extends JpaRepository<OrderEntity,Long> {

    // TODO check if works after inserting data
    Page<OrderEntity> findByCustomerCodeAndStatus(int customerCode, Status status, Pageable pageable);

    Optional<OrderEntity> findByOrderNumber(String orderNumber);

    List<OrderEntity> findByStatus(Status status);

    void deleteByOrderNumber(String orderNumber);

    @Modifying
    @Query("""
        UPDATE OrderEntity oe
        SET status = ?2
        WHERE orderNumber = ?1
        """)
    void changeOrderStatus(String orderNumber, Status status);

    @Modifying
    @Query("""
        UPDATE OrderEntity oe
        SET status = ?2
        WHERE status = ?1
        AND cancelTill < ?3
        """)
    void changeOrdersStatus(Status currentStatus, Status newStatus, OffsetDateTime time);
}
