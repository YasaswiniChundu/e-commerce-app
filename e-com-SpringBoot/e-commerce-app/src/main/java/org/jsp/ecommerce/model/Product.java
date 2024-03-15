package org.jsp.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String name, brand, category, descrp, image_url;

	@Column(nullable = false)
	private double cost;
	@ManyToOne
	@JoinColumn(name="merchant-id")
	@JsonIgnore
	private Merchant merchant;

}