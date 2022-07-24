package com.educandoweb.workshop.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.educandoweb.workshop.entities.enums.OrderStatus;

@Table(name = "tb_order")
@Entity
public class Order implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Instant moment;
	private Integer orderstatus;
	
	@JoinColumn(name = "client_id")
	@ManyToOne
	private User client;
	
	@OneToMany(mappedBy = "id.order")
	private List<OrderIntem>orderintem = new ArrayList<>();
	
	
	@OneToOne(mappedBy = "order",cascade = CascadeType.ALL)
	private Payment payment;
	
	public Order() {
	}
	
	public Order(Integer id, Instant moment, User client,OrderStatus ordestatus) {
		this.id = id;
		this.moment = moment;
		this.client = client;
		setOrderstatus(ordestatus);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}
	
	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public List<OrderIntem> getOrderintem() {
		return orderintem;
	}

	public OrderStatus getOrderstatus() {
		return OrderStatus.valueof(orderstatus);
	}

	public void setOrderstatus(OrderStatus orderstatus) {
		this.orderstatus = orderstatus.getcode();
	}
	
    public double getTotal() {
    	Double sum = 0.0;
    	for(OrderIntem x : orderintem) {
    		sum = sum + x.getSubTotal();
    	}
    	return sum;
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
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
