package com.EventBookingApp.EventBookingApp.ticketServiceTest;


import com.EventBookingApp.EventBookingApp.data.models.ReservationStatus;
import com.EventBookingApp.EventBookingApp.dtos.requests.TicketBookingRequest;
import com.EventBookingApp.EventBookingApp.dtos.responses.TicketBookingResponse;
import com.EventBookingApp.EventBookingApp.exceptions.EventAppException;
import com.EventBookingApp.EventBookingApp.services.TicketService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TicketServiceTest {

    @Autowired
    private TicketService ticketService;

    @Test

    public void testThatARegisteredUserCanBookATicketForAnEvent() throws EventAppException {

        TicketBookingRequest request = new TicketBookingRequest();

        request.setEmail("tobi099@gmail.com");
        request.setNameOnTicket("Sola");
        request.setEventName("The Future of Tech");
        request.setNumberOfTickets(5);
        request.setStatus(ReservationStatus.RESERVED);

        TicketBookingResponse response = ticketService.bookTicket(request);

        assertThat(response).isNotNull();


    }


    @Test

    public void testThatMoreThanOneRegisteredUserCanBookATicketForAnEvent() throws EventAppException {

        TicketBookingRequest request = new TicketBookingRequest();

        request.setEmail("tobi4tee2@gmail.com");
        request.setNameOnTicket("Samuel");
        request.setEventName("The Future of Tech");
        request.setNumberOfTickets(2);
        request.setStatus(ReservationStatus.RESERVED);

        TicketBookingResponse response = ticketService.bookTicket(request);

        assertThat(response).isNotNull();


    }
}
