package com.projetofaculdade.fasterfood.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.projetofaculdade.fasterfood.entities.Collaborator;
import com.projetofaculdade.fasterfood.entities.Costumer;
import com.projetofaculdade.fasterfood.entities.Order;
import com.projetofaculdade.fasterfood.entities.OrderItem;
import com.projetofaculdade.fasterfood.entities.Product;
import com.projetofaculdade.fasterfood.entities.enums.OrderStatus;
import com.projetofaculdade.fasterfood.entities.enums.UserAccess;
import com.projetofaculdade.fasterfood.repositories.CollaboratorRepository;
import com.projetofaculdade.fasterfood.repositories.CostumerRepository;
import com.projetofaculdade.fasterfood.repositories.OrderItemRepository;
import com.projetofaculdade.fasterfood.repositories.OrderRepository;
import com.projetofaculdade.fasterfood.repositories.ProductRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private CollaboratorRepository collaboratorRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CostumerRepository costumerRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		Collaborator c1 = new Collaborator(null, "alex@gmail.com", "abobrinha123", UserAccess.EMPLOYEE);
		Collaborator c2 = new Collaborator(null, "brenda21@gmail.com", "passarinho12", UserAccess.ADMIN);
		Collaborator c3 = new Collaborator(null, "romulomend12@gmail.com", "abacaxi65", UserAccess.ADMIN);
		Collaborator c4 = new Collaborator(null, "pereira2000@outlook.com", "pessego32", UserAccess.OBSERVER);
		collaboratorRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
		
		Product p1 = new Product(null, "Molho de Tomate", 3.99, "", "Molho de Tomate Quero Tradicional 300G", 30, sdf.parse("08/02/2024"));
		Product p2 = new Product(null, "Suco de fruta", 5.99, "", "Suco natural 200ML", 10, sdf.parse("08/02/2024"));
		Product p3 = new Product(null, "Queijo", 59.99, "", "Queijo Mussarela KG", 15, sdf.parse("08/02/2024"));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Costumer cos1 = new Costumer(null, "João");
		Costumer cos2 = new Costumer(null, "Ana");
		Costumer cos3 = new Costumer(null, "Maria");
		costumerRepository.saveAll(Arrays.asList(cos1, cos2, cos3));
		
		Order o1 = new Order(null, cos1, sdf.parse("08/12/2023"), OrderStatus.RECEIVED);
		Order o2 = new Order(null, cos2, sdf.parse("06/12/2023"), OrderStatus.DELIVERED);
		Order o3 = new Order(null, cos3, sdf.parse("05/12/2023"), OrderStatus.CANCELED);
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		OrderItem oi1 = new OrderItem(o1, p2, 3, p2.getPrice());		
		OrderItem oi2 = new OrderItem(o3, p1, 5, p1.getPrice());		
		OrderItem oi3 = new OrderItem(o2, p3, 3, p3.getPrice());
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3));
	}

}
