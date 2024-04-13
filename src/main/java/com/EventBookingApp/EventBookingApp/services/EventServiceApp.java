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

import static com.EventBookingApp.EventBookingApp.utils.Validation.*;

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

    @Override
    public Event findByName(String name) {


        return eventRepository.findByName(name);
    }


}
