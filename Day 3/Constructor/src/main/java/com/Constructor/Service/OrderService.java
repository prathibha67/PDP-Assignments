package com.Constructor.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Lazy;

@Service
public class OrderService {

	private final UserService userService;

	@Autowired
	public OrderService(@Lazy UserService service) {
		this.userService = service;
	}

	public List<String> getOrders() {
		// Simulate fetching orders
		List<String> orderList = new ArrayList<>();
		orderList.add("OrderA");
		orderList.add("OrderB");
		return orderList;
	}

	public String getOrderUser() {
		// return String with user details as Ordered user:
		// userService.getUserDetails();
		return "Ordered user: " + userService.getUserDetails();
	}
}