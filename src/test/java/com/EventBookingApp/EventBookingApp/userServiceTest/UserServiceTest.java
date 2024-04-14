package com.EventBookingApp.EventBookingApp.userServiceTest;


import com.EventBookingApp.EventBookingApp.data.repositories.UserRepository;
import com.EventBookingApp.EventBookingApp.dtos.requests.UserRegistrationRequest;
import com.EventBookingApp.EventBookingApp.dtos.responses.UserRegistrationResponse;
import com.EventBookingApp.EventBookingApp.exceptions.EventAppException;
import com.EventBookingApp.EventBookingApp.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;



    @Test
    public void userRegistrationTest() throws EventAppException {
        UserRegistrationRequest request = new UserRegistrationRequest();
        request.setName("Tobi");
        request.setEmail("tobi4tee@gmail.com");
        request.setPassword("Agboola.");

        UserRegistrationResponse response = userService.register(request);
        assertThat(response).isNotNull();

    }

    @Test
    public void testThatMoreThanOneUserCanRegister() throws EventAppException {
        UserRegistrationRequest request = new UserRegistrationRequest();
        request.setName("Avia");
        request.setEmail("avia@gmail.com");
        request.setPassword("Aviaa04@");

        UserRegistrationResponse response = userService.register(request);
        assertThat(response).isNotNull();
        assertEquals(2,userRepository.count());

    }

    @Test
    public void testThatMoreThanOneUserCanRegister2() throws EventAppException {
        UserRegistrationRequest request = new UserRegistrationRequest();
        request.setName("Charis");
        request.setEmail("charis@gmail.com");
        request.setPassword("Charis04@");

        UserRegistrationResponse response = userService.register(request);
        assertThat(response).isNotNull();
        assertEquals(3,userRepository.count());

    }

    @Test
    public void testThatForUserNameGreaterThan100CharacterExceptionIsThrown(){
        UserRegistrationRequest request = new UserRegistrationRequest();
        request.setName("AgboolaTobyAgboolaTobyAgboolaTobyAgboolaTobyAgboolaTobyAgboolaTobyAgboolaTobyAgboolaTobyAgboolaTobyAgboolaTobyAgboolaTobyAgboolaTobyAgboolaTobyAgboolaTobyAgboolaToby");
        assertThrows(EventAppException.class,()->userService.register(request));
    }

    @Test
    public void testThatIfAAttemptsToRegisterWithExistingEmailAddressExceptionIsThrown(){
        UserRegistrationRequest request = new UserRegistrationRequest();
        request.setName("Toby");
        request.setEmail("tobi4tee@gmail.com");
        request.setPassword("Agboola.");
        assertThrows(EventAppException.class,()->userService.register(request));
    }


    @Test
    public void testThatIfAUserRegistrationPasswordIsLessThan8CharactersExceptionIsThrown(){
        UserRegistrationRequest request = new UserRegistrationRequest();
        request.setName("Toby");
        request.setEmail("tobi09@gmail.com");
        request.setPassword("pass");
        assertThrows(EventAppException.class,()->userService.register(request));
    }


}
