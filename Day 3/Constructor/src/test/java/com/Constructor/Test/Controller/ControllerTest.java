package com.Constructor.Test.Controller;

import com.Constructor.Controller.Controller;
import com.Constructor.Service.OrderService;
import com.Constructor.Service.UserService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {
    @InjectMocks
    private Controller userController;

    @Mock
    private UserService userService;

    @Mock
    private OrderService orderService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetUserDetails() throws Exception {
        when(userService.getUserDetails()).thenReturn("Prathibha");

        mockMvc.perform(MockMvcRequestBuilders.get("/user-details"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Prathibha"));
    }

    @Test
    public void testGetUserOrders() throws Exception {
        when(userService.getUserOrders()).thenReturn("User orders: [OrderA, OrderB]");

        mockMvc.perform(MockMvcRequestBuilders.get("/user-orders"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("User orders: [OrderA, OrderB]"));
    }

    @Test
    public void testGetOrderUser() throws Exception {
        when(orderService.getOrderUser()).thenReturn("Order user: User: Prathibha");

        mockMvc.perform(MockMvcRequestBuilders.get("/order-user"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Ordered user: Prathibha"));
    }
}
