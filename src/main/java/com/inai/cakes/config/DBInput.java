package com.inai.cakes.config;

import com.inai.cakes.entity.Cake;
import com.inai.cakes.entity.Order;
import com.inai.cakes.repository.CakeRepository;
import com.inai.cakes.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class DBInput {

    private final CakeRepository cakeRepository;
    private final OrderRepository orderRepository;

    @Bean
    @Transactional
    public void insert() {
        String directory = "/images/cakes/";
        String[] names = {"Шоколадно-ореховый торт", "Фруктовый чизкейк", "Медовый торт", "Клубничный лаймовый тарт",
                "Карамельно-соленый торт", "Морковный торт с крем-чизом", "Ванильно-мятный шоколадный торт", "Кокосово-манговый раффл торт"};
        String[] peopleNames = {"Tilek", "Asan", "Uson", "Alex", "Azamat", "Bermet", "Asel", "Samat"};
        int[] prices = {300, 499, 299, 500, 799, 699, 399, 400};
        String ing = "Печеные основы из печенья, крем-сыр, фруктовая начинка (например, клубника, манго, и киви), желе.";
        List<Cake> cakes = new ArrayList<>();
        for (int i = 1; i < 9; i++) {
            Optional<Cake> optionalSushi = cakeRepository.findByName(names[i - 1]);

            if (optionalSushi.isEmpty()) {
                Cake cake = Cake.builder()
                        .name(names[i - 1])
                        .price(prices[i - 1])
                        .ingredients(ing)
                        .cookingTime(20)
                        .imagePath(directory + i + ".png")
                        .build();

                cakeRepository.save(cake);

                cakes.add(cake);
            }
        }

        for (int i = 0; i < 8; i++) {
            Order order = Order.builder()
                    .firstName(peopleNames[i]).lastName(peopleNames[i]).date(LocalDate.now())
                    .delivered(false).address("Lev Tolstoy 22").comments("Call me when you will come")
                    .payingSum(1000).price(prices[i]).cake(cakes.get(i)).number("+996777777777")
                    .build();

            orderRepository.save(order);
        }
    }
}
