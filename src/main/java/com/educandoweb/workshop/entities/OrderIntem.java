package com.educandoweb.workshop.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.educandoweb.workshop.entities.pk.OrderIntemPK;

@Entity
@Table(name = "")
public class OrderIntem implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private OrderIntemPK id;
	private Integer quantity;
	private double price;
	
	public OrderIntem() {
	}

	public OrderIntem(Product product, Order order, Integer quantity, double price) {
		id.setProduct(product);
		id.setOrder(order);
		this.quantity = quantity;
		this.price = price;
	}

	public Product GetProduct() {
		return id.getProduct();
	}
	
	public void SetProduct(Product product) {
		id.setProduct(product);
	}
	
	public Order GetOrder() {
		return id.getOrder();
	}
	
	public void SetOrder(Order order) {
		this.SetOrder(order);
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderIntem other = (OrderIntem) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
