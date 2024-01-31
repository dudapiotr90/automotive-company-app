package pl.dudi.orderservice.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import pl.dudi.orderservice.infrastructure.database.dao.OrderDao;
import pl.dudi.orderservice.infrastructure.database.repository.jpa.OrderJpaRepository;
import pl.dudi.orderservice.mapper.OrderMapper;
import pl.dudi.orderservice.model.Order;

@Slf4j
@Repository
@AllArgsConstructor
public class OrderRepository implements OrderDao {

    private final OrderJpaRepository orderJpaRepository;
    private final OrderMapper orderMapper;


    @Override
    public Page<Order> findOrders(int customerCode, Pageable pageRequestDto) {
        return orderJpaRepository.findByCustomerCodeAndRealized(customerCode,pageRequestDto,true)
            .map(orderMapper::mapToOrder);
    }
}
