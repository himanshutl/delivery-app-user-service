package com.deliveryapp.userservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "restaurant_generator", sequenceName = "user_seq", allocationSize = 1)
    private long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String userPassword;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String city;
}
