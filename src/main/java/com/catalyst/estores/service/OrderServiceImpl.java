package com.catalyst.estores.service;

import com.catalyst.estores.annotations.ExecutionTime;
import com.catalyst.estores.exceptions.OrderNotFoundException;
import com.catalyst.estores.model.Order;
import com.catalyst.estores.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @ExecutionTime
    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();

    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + id));
    }

    @Override
    public Order placeOrder(Order order) {
        return orderRepository.save(order);

    }

    @Override
    public Order updateOrder(Long id, Order order) {
        Order existingOrder = getOrderById(id);
        existingOrder.setQuantity(order.getQuantity());
        existingOrder.setProduct(order.getProduct());
        return orderRepository.save(existingOrder);
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);

    }
}
