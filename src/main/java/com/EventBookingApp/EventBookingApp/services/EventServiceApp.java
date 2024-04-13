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

@Service
@AllArgsConstructor
public class EventServiceApp implements EventService{


    private final EventRepository eventRepository;
    private final UserRepository userRepository;



    @Override
    public EventCreationResponse createEvent(EventCreationRequest request) throws EventAppException {

        User user = userRepository.findByEmail(request.getEmail());
        UserExist(user);
        Event event = new Event();
        validateName(request);
        event.setName(request.getName());
        validateDescription(request);
        event.setDescription(request.getDescription());
        validateAttendeesNumber(request);
        event.setNumberOfAttendees(request.getNumberOfAttendees());

        event.setEventCategory(request.getCategory());
        event.setEventDate(request.getEventDate());
        event.setUser(user);

        Event saveEvent = eventRepository.save(event);
//        userRepository.save(user);
        eventRepository.save(saveEvent);


        EventCreationResponse response = new EventCreationResponse();
        response.setMessage("Event successfully created");

        return response;

    }

    private static void validateAttendeesNumber(EventCreationRequest request) throws EventAppException {
        if (request.getNumberOfAttendees() < 0 || request.getNumberOfAttendees() > 1000) throw new EventAppException("Number of attendees cannot be less 1 nor greater than 1000");
    }

    private static void validateDescription(EventCreationRequest request) throws EventAppException {
        if (request.getDescription().isEmpty() || request.getDescription().length() > 500) throw new EventAppException("Event description cannot be less than 1 character nor greater than 500 character");
    }

    private static void validateName(EventCreationRequest request) throws EventAppException {
        if (request.getName().isEmpty() || request.getName().length() > 100) throw new EventAppException("Event name cannot be less than 1 nor greater than 100 characters");
    }

    private static void UserExist(User user) throws EventAppException {
        if (user == null) throw new EventAppException("User not found");
    }
}
