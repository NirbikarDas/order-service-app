package com.nirbi.springboot.orderserviceapplication;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

@Repository
public class OrderInventory {
	public List<Order> getOrders() {
		return Stream.of(new Order(101L, "Mobile", 2, 60000.0D), new Order(401L, "Laptop", 1, 40000.0D),
				new Order(701L, "Tablet", 4, 50000.0D)).collect(Collectors.toList());
	}
}
