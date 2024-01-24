package com.Constructor.Test.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.Constructor.Service.OrderService;
import com.Constructor.Service.UserService;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserServiceTest {
    @InjectMocks
    private UserService userService;

    @Mock
    private OrderService orderService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetUserDetails() {
        // Test the UserService
        String userDetails = userService.getUserDetails();
        assertEquals("Prathibha", userDetails);
    }

    @Test
    public void testGetUserOrders() {
        // Mock the behavior of the OrderService
        when(orderService.getOrders()).thenReturn(Collections.singletonList("OrderA, OrderB"));
        // Test the UserService
        String userOrders = userService.getUserOrders();
        assertEquals("User orders: [OrderA, OrderB]", userOrders);
    }
}
