package com.educandoweb.workshop.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name = "tb_product")
@Entity
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String description;
	private double price;
	private String imgurl;
	
    
    
	
	@JoinTable(name = "tb_product_category"
		    , joinColumns = @JoinColumn(name = "tb_product")
		    , inverseJoinColumns = @JoinColumn(name = "tb_category"))
	
	@ManyToMany
	private Set<Category>category = new HashSet<>();
	
	@OneToMany(mappedBy = "id.product")
	private Set<OrderIntem>items = new HashSet<>();	
	
	public Product() {
	}

	public Product(Integer id, String name, String description, double price, String imgurl) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgurl = imgurl;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	
	

	public Set<Category> getCategory() {
		return category;
	}
	
	@JsonIgnore
	public Set<Order>getOrders(){
		Set<Order>set = new HashSet<>();
		for(OrderIntem x : items) {
			set.add(x.getOrder());
		}
		return set;
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
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}
	
	
}

