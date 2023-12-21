package com.inai.cakes.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MakeOrderDto {

    private String firstName;

    private String lastName;

    private String number;

    private int payingSum;

    private String address;

    private String comments;

    private String cakeId;
}
