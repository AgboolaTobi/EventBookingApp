package com.EventBookingApp.EventBookingApp.eventServiceTest;


import com.EventBookingApp.EventBookingApp.data.models.EventCategory;
import com.EventBookingApp.EventBookingApp.data.repositories.EventRepository;
import com.EventBookingApp.EventBookingApp.dtos.requests.EventCreationRequest;
import com.EventBookingApp.EventBookingApp.dtos.responses.EventCreationResponse;
import com.EventBookingApp.EventBookingApp.exceptions.EventAppException;
import com.EventBookingApp.EventBookingApp.services.EventService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class EventServiceTest {

    @Autowired
    private EventService eventService;

    @Autowired
    private EventRepository eventRepository;

    @Test
    public void EventCreationTest() throws EventAppException {
        EventCreationRequest request = new EventCreationRequest();
        request.setEmail("tobi099@gmail.com");
        request.setName("Hackathon");
        request.setDescription("A tech conference");
        request.setCategory(EventCategory.CONFERENCE);
        request.setNumberOfAttendees(250);
        request.setEventDate("2024,12,16,12,00,00");

        EventCreationResponse response = eventService.createEvent(request);

//        assertThat(response).isNotNull();
        assertEquals(1, eventRepository.count());

    }
}
