package com.EventBookingApp.EventBookingApp.eventServiceTest;


import com.EventBookingApp.EventBookingApp.data.models.EventCategory;
import com.EventBookingApp.EventBookingApp.dtos.requests.EventCreationRequest;
import com.EventBookingApp.EventBookingApp.dtos.responses.EventCreationResponse;
import com.EventBookingApp.EventBookingApp.exceptions.EventAppException;
import com.EventBookingApp.EventBookingApp.services.EventService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class EventServiceTest {

    @Autowired
    private EventService eventService;

    @Test
    public void EventCreationTest() throws EventAppException {
        EventCreationRequest request = new EventCreationRequest();
        request.setName("Hackathon");
        request.setDescription("A tech conference");
        request.setCategory(EventCategory.CONFERENCE);
        request.setNumberOfAttendees(250);
        LocalDateTime date = LocalDateTime.of(2024,5,15,12,0,0);
        request.setEventDate(date);

        EventCreationResponse response = eventService.createEvent(request, 1L);

        assertThat(response).isNotNull();

    }
}
