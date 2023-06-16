package com.nirbi.springboot.orderserviceapplication;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orderService")
@SpringBootApplication
public class OrderServiceApplication {

	@Autowired
	private OrderInventory orderInventory;

	@GetMapping(path = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Order>> retrieveOrders() {
		List<Order> orderList = orderInventory.getOrders().stream()
				.sorted(Comparator.comparing(Order::getName).reversed()).collect(Collectors.toList());
		return new ResponseEntity<>(orderList, HttpStatus.OK);
	}

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

}
