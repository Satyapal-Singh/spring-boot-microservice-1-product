package com.sha.springbootmicroservice1product.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name="name",length=100, nullable=false)
    private String name;

    @Column(name="price", nullable=false)
    private Double price;
	
	@Column(name="brand", length=100, nullable=true)
	private String brand;
	
	@Column(name="discount", nullable=true)
	private Double discount;
	
	@Column(name="category", length=100, nullable=true)
	private String category;

    @Column(name="create_time",nullable=false)
    private LocalDateTime createTime;
}
