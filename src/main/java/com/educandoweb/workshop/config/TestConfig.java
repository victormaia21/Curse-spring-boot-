package com.educandoweb.workshop.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.workshop.entities.Category;
import com.educandoweb.workshop.entities.Order;
import com.educandoweb.workshop.entities.User;
import com.educandoweb.workshop.entities.enums.OrderStatus;
import com.educandoweb.workshop.repository.CategoryRepository;
import com.educandoweb.workshop.repository.OrderRepository;
import com.educandoweb.workshop.repository.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	UserRepository userrep;
	
	@Autowired
	OrderRepository ordrep;
	
	@Autowired
	CategoryRepository catrep;
	
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Eletronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		catrep.saveAll(Arrays.asList(cat1,cat2,cat3));
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		userrep.saveAll(Arrays.asList(u1, u2));
		
	
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),u1, OrderStatus.PAID);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2,OrderStatus.CANCELED);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1,OrderStatus.WAITING_PAYMENT);
		ordrep.saveAll(Arrays.asList(o1,o2,o3));
		
		
	}

}
