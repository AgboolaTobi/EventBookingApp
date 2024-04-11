package com.EventBookingApp.EventBookingApp.services;

import com.EventBookingApp.EventBookingApp.data.models.Event;
import com.EventBookingApp.EventBookingApp.data.models.User;
import com.EventBookingApp.EventBookingApp.data.repositories.EventRepository;
import com.EventBookingApp.EventBookingApp.data.repositories.UserRepository;
import com.EventBookingApp.EventBookingApp.dtos.requests.EventCreationRequest;
import com.EventBookingApp.EventBookingApp.dtos.responses.EventCreationResponse;
import com.EventBookingApp.EventBookingApp.exceptions.EventAppException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class EventServiceApp implements EventService{

    private final EventService eventService;
    private final UserService userService;
    private final EventRepository eventRepository;
    private final UserRepository userRepository;



    @Override
    public EventCreationResponse createEvent(EventCreationRequest request, Long userId) throws EventAppException {
        User user = userRepository.findByUserId(userId);
        if (user== null) throw new EventAppException("User not found");
        Event newEvent = new Event();
        if (request.getName().isEmpty() || request.getName().length() > 100) throw new EventAppException("Event name cannot be less than 1 nor greater than 100 characters");
        newEvent.setName(request.getName());
        if (request.getDescription().isEmpty() || request.getDescription().length() > 500) throw new EventAppException("Event description cannot be less than 1 character nor greater than 500 character");

        newEvent.setDescription(request.getDescription());
        if (request.getNumberOfAttendees() < 0 || request.getNumberOfAttendees() > 1000) throw new EventAppException("Number of attendees cannot be less 1 nor greater than 1000");
        newEvent.setNumberOfAttendees(request.getNumberOfAttendees());

        newEvent.setEventCategory(request.getCategory());

        LocalDateTime date = LocalDateTime.of(2024,12,16,12,0,0);
        newEvent.setEventDate(LocalDate.from(date));
//        newEvent.setUser(user);
        eventRepository.save(newEvent);
        userRepository.save(user);

        EventCreationResponse response = new EventCreationResponse();
        response.setId(newEvent.getId());

        return response;

    }
}
