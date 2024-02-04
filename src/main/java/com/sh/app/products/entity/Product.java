package com.sh.app.products.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table
@Data
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @CreationTimestamp
    private LocalDateTime createdAt;
}
