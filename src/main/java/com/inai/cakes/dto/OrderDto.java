package com.inai.cakes.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String number;

    private String date;

    private int payingSum;

    private int price;

    private String address;

    private String comments;

    private String cakeName;

    private boolean delivered;
}
