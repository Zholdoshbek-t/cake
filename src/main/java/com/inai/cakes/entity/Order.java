package com.inai.cakes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "`order`")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;

    private String lastName;

    private String number;

    private LocalDate date;

    private int payingSum;

    private int price;

    private String address;

    private String comments;

    private boolean delivered;

    @ManyToOne
    @JoinColumn(
            name = "cake_id",
            referencedColumnName = "id"
    )
    private Cake cake;
}
