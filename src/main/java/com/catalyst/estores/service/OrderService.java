package com.catalyst.estores.service;

import com.catalyst.estores.model.Order;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface OrderService {

    List<Order> getAllOrders();
    Order getOrderById(Long id);
    Order placeOrder(Order order);
    Order updateOrder(Long id, Order order);
    void deleteOrder(Long id);
}
