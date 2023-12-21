package com.inai.cakes.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrdersDto {

    private List<OrderDto> orders = new ArrayList<>();

    private List<OrderDto> deliveredOrders = new ArrayList<>();
}
