package com.Constructor.Service;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service 
public class UserService {
    private String userName="Prathibha";
    
    private final OrderService orderService;
 
    @Autowired
    public UserService(OrderService service){
        this.orderService=service;
    }
 
    public String getUserDetails() {
        // Simulate fetching user details
        return this.userName;
    }
 
    public String getUserOrders() {
        // return String with user details as User orders: orderService.getOrders()
        return "User orders: " +orderService.getOrders() ;
    }
}
