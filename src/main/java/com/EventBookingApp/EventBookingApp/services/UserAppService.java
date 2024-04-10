package com.EventBookingApp.EventBookingApp.services;

import com.EventBookingApp.EventBookingApp.data.models.User;
import com.EventBookingApp.EventBookingApp.data.repositories.UserRepository;
import com.EventBookingApp.EventBookingApp.dtos.requests.UserRegistrationRequest;
import com.EventBookingApp.EventBookingApp.dtos.responses.UserRegistrationResponse;
import com.EventBookingApp.EventBookingApp.exceptions.RegistrationException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.EventBookingApp.EventBookingApp.utils.Validation.verifyEmail;
import static com.EventBookingApp.EventBookingApp.utils.Validation.verifyPassword;

@Service
@AllArgsConstructor
public class UserAppService implements UserService{

    private final UserRepository userRepository;

    @Override
    public UserRegistrationResponse register(UserRegistrationRequest request) throws RegistrationException {
        boolean isRegistered = userRepository.findByEmail(request.getEmail()) !=null;
        if (isRegistered) throw new RegistrationException("Invalid registration details");
        if (!verifyEmail(request.getEmail())) throw new RegistrationException("Invalid email format");
        if (!verifyPassword(request.getPassword())) throw new RegistrationException("Invalid password format");
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
                userRepository.save(user);
        UserRegistrationResponse response = new UserRegistrationResponse();

        response.setMessage("Registration successful");

        return response;

    }
}
