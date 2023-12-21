package com.inai.cakes.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CakeDetail {

    private Long id;

    private String name;

    private String ingredients;

    private int price;

    private int cookingTime;

    private String imagePath;
}
