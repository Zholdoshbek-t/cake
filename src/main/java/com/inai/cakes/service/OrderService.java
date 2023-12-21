package com.inai.cakes.service;

import com.inai.cakes.dto.MakeOrderDto;
import com.inai.cakes.dto.OrdersDto;

public interface OrderService {

    void makeOrder(MakeOrderDto dto);
    OrdersDto getOrders();
    void deliverOrder(Long id);
    void deleteOrder(Long id);
    void cancelOrder(Long id);
}
