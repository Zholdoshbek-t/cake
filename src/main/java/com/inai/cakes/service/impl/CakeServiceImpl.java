package com.inai.cakes.service.impl;

import com.inai.cakes.dto.CakeDetail;
import com.inai.cakes.dto.CakeMenu;
import com.inai.cakes.entity.Cake;
import com.inai.cakes.repository.CakeRepository;
import com.inai.cakes.service.CakeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CakeServiceImpl implements CakeService {
    private final CakeRepository cakeRepository;


    @Override
    public List<CakeMenu> getCakes() {
        return cakeRepository.findAll().stream()
                .map(cake -> CakeMenu.builder()
                        .id(cake.getId())
                        .name(cake.getName())
                        .imagePath(cake.getImagePath())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public CakeDetail getCake(Long id) {
        Optional<Cake> cake = cakeRepository.findById(id);

        return cake.map(value -> CakeDetail.builder()
                .id(value.getId())
                .name(value.getName())
                .price(value.getPrice())
                .ingredients(value.getIngredients())
                .imagePath(value.getImagePath())
                .cookingTime(value.getCookingTime())
                .build()).orElse(null);
    }

    @Override
    public Cake createCake(Cake cake) {
        return cakeRepository.save(cake);
    }
}
