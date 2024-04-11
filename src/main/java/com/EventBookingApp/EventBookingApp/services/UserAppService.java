package com.EventBookingApp.EventBookingApp.services;

import com.EventBookingApp.EventBookingApp.data.models.User;
import com.EventBookingApp.EventBookingApp.data.repositories.EventRepository;
import com.EventBookingApp.EventBookingApp.data.repositories.UserRepository;
import com.EventBookingApp.EventBookingApp.dtos.requests.UserRegistrationRequest;
import com.EventBookingApp.EventBookingApp.dtos.responses.UserRegistrationResponse;
import com.EventBookingApp.EventBookingApp.exceptions.EventAppException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.EventBookingApp.EventBookingApp.utils.Validation.*;

@Service
@AllArgsConstructor
public class UserAppService implements UserService {

    private final UserRepository userRepository;

    private final EventRepository eventRepository;

    @Override
    public UserRegistrationResponse register(UserRegistrationRequest request) throws EventAppException {
        boolean isRegistered = userRepository.findByEmail(request.getEmail()) != null;
        if (isRegistered) throw new EventAppException("Invalid registration details");
        if (!verifyName(request.getName())) throw new EventAppException("Invalid name length submitted");
        if (!verifyEmail(request.getEmail())) throw new EventAppException("Invalid email format");
        if (!verifyPassword(request.getPassword())) throw new EventAppException("Invalid password format");

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
