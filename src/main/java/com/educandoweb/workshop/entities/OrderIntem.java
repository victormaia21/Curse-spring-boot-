package com.educandoweb.workshop.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.educandoweb.workshop.entities.pk.OrderIntemPk;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "order_intem")
public class OrderIntem implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private OrderIntemPk id = new OrderIntemPk();
	private Integer quantity;
	private double price;
	
	public OrderIntem() {
	}

	public OrderIntem(Order order,Product product,Integer quantity, double price) {
		super();
		id.setOrder(order);
		id.setProduct(product);
		this.quantity = quantity;
		this.price = price;
	}
	
	public Product getProduct() {
		return id.getProduct();
	}
	
	public void setProduct(Product product) {
		id.setProduct(product);
	}
	
	@JsonIgnore
	public Order getOrder() {
		return id.getOrder();
	}
	
	public void setOrder(Order order) {
		id.setOrder(order);
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
	
	public Double getSubTotal() {
		return quantity * price;
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
