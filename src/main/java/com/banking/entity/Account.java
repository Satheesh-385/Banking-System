package com.banking.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "account") // optional but good practice
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String accountHolderName;

    // 🔥 UNIQUE constraint added here
    @Column(unique = true, nullable = false)
    private String accountNumber;

    @Column(nullable = false)
    private double balance;
}