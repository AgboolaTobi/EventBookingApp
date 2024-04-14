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
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class EventServiceTest {

    @Autowired
    private EventService eventService;

    @Autowired
    private EventRepository eventRepository;

    @Test
    public void EventCreationTest() throws EventAppException {
        EventCreationRequest request = new EventCreationRequest();
        request.setEmail("tobi4tee@gmail.com");
        request.setName("The Future of Tech");
        request.setDescription("A tech conference...");
        request.setCategory(EventCategory.CONFERENCE);
        request.setNumberOfAttendees(250);
        request.setEventDate("2024/12/16/12");

        EventCreationResponse response = eventService.createEvent(request);

        assertThat(response).isNotNull();
//        assertEquals(1, eventRepository.count());

    }


    @Test
    public void userCreatingMultipleEvents() throws EventAppException {
        EventCreationRequest request = new EventCreationRequest();
        request.setEmail("tobi4tee@gmail.com");
        request.setName("Worship of God");
        request.setDescription("A christian meeting. Teaching of the word in the spirit");
        request.setCategory(EventCategory.CONCERT);
        request.setNumberOfAttendees(700);
        request.setEventDate("20/08/2024");

        EventCreationResponse response = eventService.createEvent(request);

        assertThat(response).isNotNull();
//        assertEquals(1, eventRepository.count());

    }

    @Test
    public void testThatIfANonUserAttemptsToCreateAnEventExceptionIsThrown(){
        EventCreationRequest request = new EventCreationRequest();
        request.setEmail("avy@gmail.com");
        request.setName("SportBar");
        request.setDescription("A game for kids...");
        request.setCategory(EventCategory.GAME);
        request.setNumberOfAttendees(500);
        request.setEventDate("2024/08/20/12");
        assertThrows(EventAppException.class,()->eventService.createEvent(request));

    }


    @Test
    public void testThatIfEventNameIsMoreThan100CharactersExceptionIsThrown(){
        EventCreationRequest request = new EventCreationRequest();
        request.setEmail("avy@gmail.com");
        request.setName("SportBarSportBarSportBarSportBarSportBarSportBarSportBarSportBarSportBarSportBarSportBarSportBarSportBarSportBarSportBarSportBarSportBarSportBarSportBarSportBarSportBar");
        request.setDescription("A game for kids...");
        request.setCategory(EventCategory.GAME);
        request.setNumberOfAttendees(500);
        request.setEventDate("2024/08/20/12");
        assertThrows(EventAppException.class,()->eventService.createEvent(request));

    }


    @Test
    public void testThatIfEventDescriptionIsMoreThan1000CharactersExceptionIsThrown(){
        EventCreationRequest request = new EventCreationRequest();
        request.setEmail("avy@gmail.com");
        request.setName("SportBarSportBarSportBarSportBarSportBarSportBarSportBarSportBarSportBarSportBarSportBarSportBarSportBarSportBarSportBarSportBarSportBarSportBarSportBarSportBarSportBar");
        request.setDescription("In today's fast-paced world, the convenience of booking systems has become an essential aspect of daily life. From booking tickets for a concert or reserving a spot at a conference, these systems are used widely by individuals and businesses alike.\n" +
                "In today's fast-paced world, the convenience of booking systems has become an essential aspect of daily life. From booking tickets for a concert or reserving a spot at a conference, these systems are used widely by individuals and businesses alike.\n" +
                "In today's fast-paced world, the convenience of booking systems has become an essential aspect of daily life. From booking tickets for a concert or reserving a spot at a conference, these systems are used widely by individuals and businesses alike.\n" +
                "In today's fast-paced world, the convenience of booking systems has become an essential aspect of daily life. From booking tickets for a concert or reserving a spot at a conference, these systems are used widely by individuals and businesses alike.\n");
        request.setCategory(EventCategory.GAME);
        request.setNumberOfAttendees(500);
        request.setEventDate("2024/08/20/12");
        assertThrows(EventAppException.class,()->eventService.createEvent(request));

    }

    @Test
    public void testThatIfEventDescriptionIsBlankExceptionIsThrown(){
        EventCreationRequest request = new EventCreationRequest();
        request.setEmail("avy@gmail.com");
        request.setName("SportBar");
        request.setDescription("");
        request.setCategory(EventCategory.GAME);
        request.setNumberOfAttendees(500);
        request.setEventDate("2024/08/20/12");
        assertThrows(EventAppException.class,()->eventService.createEvent(request));

    }

    @Test
    public void testThatIfEventNameIsBlankExceptionIsThrown(){
        EventCreationRequest request = new EventCreationRequest();
        request.setEmail("avy@gmail.com");
        request.setName("");
        request.setDescription("A game for kids...");
        request.setCategory(EventCategory.GAME);
        request.setNumberOfAttendees(500);
        request.setEventDate("2024/08/20/12");
        assertThrows(EventAppException.class,()->eventService.createEvent(request));

    }


    @Test
    public void testThatIfEventAttendeesIsMoreThan1000ExceptionIsThrown(){
        EventCreationRequest request = new EventCreationRequest();
        request.setEmail("avy@gmail.com");
        request.setName("Bingo Game");
        request.setDescription("A game for kids...");
        request.setCategory(EventCategory.GAME);
        request.setNumberOfAttendees(1500);
        request.setEventDate("2024/08/20/12");
        assertThrows(EventAppException.class,()->eventService.createEvent(request));

    }


    @Test
    public void testThatIfNumberOfAvailableEventAttendeesIsLessThan1ExceptionIsThrown(){
        EventCreationRequest request = new EventCreationRequest();
        request.setEmail("avy@gmail.com");
        request.setName("Bingo Game");
        request.setDescription("A game for kids...");
        request.setCategory(EventCategory.GAME);
        request.setNumberOfAttendees(0);
        request.setEventDate("2024/08/20/12");
        assertThrows(EventAppException.class,()->eventService.createEvent(request));

    }


}
