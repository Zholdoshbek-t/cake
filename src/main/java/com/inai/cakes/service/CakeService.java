package com.inai.cakes.service;

import com.inai.cakes.dto.CakeDetail;
import com.inai.cakes.dto.CakeMenu;
import com.inai.cakes.entity.Cake;

import java.util.List;

public interface CakeService {

    List<CakeMenu> getCakes();
    CakeDetail getCake(Long id);
    Cake createCake(Cake cake);
}
