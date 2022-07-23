package com.educandoweb.workshop.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.workshop.entities.Category;
import com.educandoweb.workshop.entities.Order;
import com.educandoweb.workshop.entities.OrderIntem;
import com.educandoweb.workshop.entities.Payment;
import com.educandoweb.workshop.entities.Product;
import com.educandoweb.workshop.entities.User;
import com.educandoweb.workshop.entities.enums.OrderStatus;
import com.educandoweb.workshop.repository.CategoryRepository;
import com.educandoweb.workshop.repository.OrderIntemRepository;
import com.educandoweb.workshop.repository.OrderRepository;
import com.educandoweb.workshop.repository.ProductRepository;
import com.educandoweb.workshop.repository.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userrep;
	
	@Autowired
	private OrderRepository ordrep;
	
	@Autowired
	private CategoryRepository catrep;
	
	@Autowired
	private ProductRepository prorep;
	
	@Autowired
	private OrderIntemRepository oir;
	
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Eletronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		catrep.saveAll(Arrays.asList(cat1,cat2,cat3));
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		prorep.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		p1.getCategory().add(cat2);
		p2.getCategory().add(cat1);
		p2.getCategory().add(cat3);
		p3.getCategory().add(cat3);
		p4.getCategory().add(cat2);
		
		prorep.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		userrep.saveAll(Arrays.asList(u1, u2));
		
	
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),u1, OrderStatus.PAID);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2,OrderStatus.CANCELED);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1,OrderStatus.WAITING_PAYMENT);
		ordrep.saveAll(Arrays.asList(o1,o2,o3));
		
		OrderIntem oi1 = new OrderIntem(o1,p1, 2, p1.getPrice());
		OrderIntem oi2 = new OrderIntem(o1,p3, 1, p3.getPrice());
		OrderIntem oi3 = new OrderIntem(o2,p3, 2, p3.getPrice());
		OrderIntem oi4 = new OrderIntem(o3,p5, 2, p5.getPrice());
		
		oir.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
		
		Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
		o1.setPayment(pay1);
		
		ordrep.saveAll(Arrays.asList(o1));
		
		
		
		
	}

}
