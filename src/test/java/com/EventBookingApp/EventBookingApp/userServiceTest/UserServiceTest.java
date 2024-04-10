package com.EventBookingApp.EventBookingApp.userServiceTest;


import com.EventBookingApp.EventBookingApp.data.repositories.UserRepository;
import com.EventBookingApp.EventBookingApp.dtos.requests.UserRegistrationRequest;
import com.EventBookingApp.EventBookingApp.dtos.responses.UserRegistrationResponse;
import com.EventBookingApp.EventBookingApp.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;



    @Test
    public void userRegistrationTest(){
        UserRegistrationRequest request = new UserRegistrationRequest();
        request.setName("Tobi");
        request.setEmail("tobi4tee@gmail.com");
        request.setPassword("1212");

        UserRegistrationResponse response = userService.register(request);
        assertThat(response).isNotNull();

    }

    @Test
    public void userRegistrationTest2(){
        UserRegistrationRequest request = new UserRegistrationRequest();
        request.setName("Tobi");
        request.setEmail("tobi4tee@gmail.com");
        request.setPassword("1212");

        UserRegistrationResponse response = userService.register(request);
        assertEquals(2,userRepository.count());

    }

}
