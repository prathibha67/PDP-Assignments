package com.Constructor.Test.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.Constructor.Service.OrderService;
import com.Constructor.Service.UserService;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderServiceTest {
    @InjectMocks
    private OrderService orderService;

    @Mock
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetOrders() {
        // Mock the behavior of the UserService
        when(userService.getUserDetails()).thenReturn("Prathibha");
        // Test the OrderService
        String orders = orderService.getOrders().toString();
        assertEquals("[OrderA, OrderB]", orders);
    }

    @Test
    public void testGetOrderUser() {
        // Mock the behavior of the UserService
        when(userService.getUserDetails()).thenReturn("Prathibha");
        // Test the OrderService
        String orderUser = orderService.getOrderUser();
        assertEquals("Ordered user: Prathibha", orderUser);
    }
}