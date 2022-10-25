package com.hcl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.hcl.request.LaptopRequest;

@Entity
@Table(name = "Gic_laptops")
public class Laptop {
	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "Brand_name")
	private String name;
	@OneToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;
	@Column(name = "Laptop_Price")
	private Double price;

	public Laptop() {
		super();
	}

	public Laptop(LaptopRequest request) {
		this.name = request.getName();
		this.price = request.getPrice();
	}

	public Laptop(Long id, String name, Brand brand, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Laptop [id=" + id + ", name=" + name + ", brand=" + brand + ", price=" + price + "]";
	}

}
