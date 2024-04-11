package com.EventBookingApp.EventBookingApp.services;

import com.EventBookingApp.EventBookingApp.data.models.Event;
import com.EventBookingApp.EventBookingApp.data.models.EventCategory;
import com.EventBookingApp.EventBookingApp.data.models.User;
import com.EventBookingApp.EventBookingApp.data.repositories.EventRepository;
import com.EventBookingApp.EventBookingApp.data.repositories.UserRepository;
import com.EventBookingApp.EventBookingApp.dtos.requests.EventCreationRequest;
import com.EventBookingApp.EventBookingApp.dtos.requests.UserRegistrationRequest;
import com.EventBookingApp.EventBookingApp.dtos.responses.EventCreationResponse;
import com.EventBookingApp.EventBookingApp.dtos.responses.UserRegistrationResponse;
import com.EventBookingApp.EventBookingApp.exceptions.RegistrationException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.EventBookingApp.EventBookingApp.utils.Validation.*;

@Service
@AllArgsConstructor
public class UserAppService implements UserService{

    private final UserRepository userRepository;

    private final EventRepository eventRepository;
    @Override
    public UserRegistrationResponse register(UserRegistrationRequest request) throws RegistrationException {
        boolean isRegistered = userRepository.findByEmail(request.getEmail()) !=null;
        if (isRegistered) throw new RegistrationException("Invalid registration details");
        if (!verifyName(request.getName())) throw new RegistrationException("Invalid name length submitted");
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

    @Override
    public EventCreationResponse createEvent(EventCreationRequest request) throws RegistrationException {
        User user = userRepository.findByEmail(request.getUserEmail());
        if (user== null) throw new RegistrationException("User not found");

        Event newEvent = new Event();
        newEvent.setCategory(EventCategory.valueOf(request.getCategory().toUpperCase()));
        newEvent.setDescription(request.getDescription());
        newEvent.setAvailableAttendees(request.getAvailableAttendees());

        eventRepository.save(newEvent);

        userRepository.save(user);

        EventCreationResponse response = new EventCreationResponse();
        response.setMessage("Event successfully created");

        return response;
    }
}
