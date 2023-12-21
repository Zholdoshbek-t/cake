package com.inai.cakes.repository;

import com.inai.cakes.entity.Cake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CakeRepository extends JpaRepository<Cake, Long> {
    Optional<Cake> findByName(String name);
}
