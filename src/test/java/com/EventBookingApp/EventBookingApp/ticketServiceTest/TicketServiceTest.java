package com.EventBookingApp.EventBookingApp.ticketServiceTest;


import com.EventBookingApp.EventBookingApp.data.models.ReservationStatus;
import com.EventBookingApp.EventBookingApp.dtos.requests.TicketBookingRequest;
import com.EventBookingApp.EventBookingApp.dtos.requests.TicketCancellingRequest;
import com.EventBookingApp.EventBookingApp.dtos.requests.ViewBookEventRequest;
import com.EventBookingApp.EventBookingApp.dtos.responses.TicketBookingResponse;
import com.EventBookingApp.EventBookingApp.dtos.responses.TicketCancellingResponse;
import com.EventBookingApp.EventBookingApp.dtos.responses.ViewBookEventResponse;
import com.EventBookingApp.EventBookingApp.exceptions.EventAppException;
import com.EventBookingApp.EventBookingApp.services.TicketService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class TicketServiceTest {

    @Autowired
    private TicketService ticketService;

    @Test

    public void testThatARegisteredUserCanBookATicketForAnEvent() throws EventAppException {

        TicketBookingRequest request = new TicketBookingRequest();

        request.setEmail("avia@gmail.com");
        request.setNameOnTicket("Toby");
        request.setEventName("The Future of Tech");
        request.setNumberOfTickets(6);
        request.setStatus(ReservationStatus.RESERVED);

        TicketBookingResponse response = ticketService.bookTicket(request);

        assertThat(response).isNotNull();


    }


    @Test

    public void testThatMoreThanOneRegisteredUserCanBookATicketForAnEvent() throws EventAppException {

        TicketBookingRequest request = new TicketBookingRequest();

        request.setEmail("avia@gmail.com");
        request.setNameOnTicket("Samuel");
        request.setEventName("The Future of Tech");
        request.setNumberOfTickets(2);
        request.setStatus(ReservationStatus.RESERVED);

        TicketBookingResponse response = ticketService.bookTicket(request);

        assertThat(response).isNotNull();


    }


    @Test

    public void testThatAUserCanBookForMultipleEvents() throws EventAppException {

        TicketBookingRequest request = new TicketBookingRequest();

        request.setEmail("avia@gmail.com");
        request.setNameOnTicket("Samuel");
        request.setEventName("Worship of God");
        request.setNumberOfTickets(10);
        request.setStatus(ReservationStatus.RESERVED);

        TicketBookingResponse response = ticketService.bookTicket(request);

        assertThat(response).isNotNull();


    }

    @Test

    public void testThatARegisteredUserCannotBookForAnAlreadyBookedEvent(){

        TicketBookingRequest request = new TicketBookingRequest();

        request.setEmail("avia@gmail.com");
        request.setNameOnTicket("Samuel");
        request.setEventName("The Future of Tech");
        request.setNumberOfTickets(2);
        request.setStatus(ReservationStatus.RESERVED);

        assertThrows(Exception.class,()->ticketService.bookTicket(request));


    }


    @Test

    public void testThatAUserCannotBookAnUnlistedEvent(){
        TicketBookingRequest request = new TicketBookingRequest();

        request.setEmail("tobi4tee@gmail.com");
        request.setNameOnTicket("Samuel");
        request.setEventName("Wrestling");
        request.setNumberOfTickets(2);
        request.setStatus(ReservationStatus.RESERVED);

        assertThrows(EventAppException.class,()->ticketService.bookTicket(request));

    }


    @Test

    public void testThatAnUnregisteredUserCannotBookAnEvent(){
        TicketBookingRequest request = new TicketBookingRequest();

        request.setEmail("tobi4@gmail.com");
        request.setNameOnTicket("Samuel");
        request.setEventName("The Future of Tech");
        request.setNumberOfTickets(15);
        request.setStatus(ReservationStatus.RESERVED);

        assertThrows(EventAppException.class,()->ticketService.bookTicket(request));

    }


    @Test
    public void testThatAUserCanCancelABookedEvent() throws EventAppException {

        TicketCancellingRequest request = new TicketCancellingRequest();
        request.setEmail("avia@gmail.com");
        request.setEventName("The Future of Tech");
        request.setStatus(ReservationStatus.CANCELLED);

        TicketCancellingResponse response = ticketService.cancelTicket(request);

        assertThat(response).isNotNull();

    }


    @Test
    public void testThatAUserCannotCancelAnUnbookedEvent(){

        TicketCancellingRequest request = new TicketCancellingRequest();
        request.setEmail("tobi4tee@gmail.com");
        request.setEventName("Future of Tech");
        request.setStatus(ReservationStatus.CANCELLED);
        assertThrows(EventAppException.class,()->ticketService.cancelTicket(request));

    }

    @Test
    public  void viewAllBookedEventTest() throws EventAppException {
        ViewBookEventRequest request = new ViewBookEventRequest();
        request.setEmail("avia@gmail.com");

        ViewBookEventResponse response = ticketService.viewAllTickets(request);

        assertThat(response).isNotNull();
    }



}
