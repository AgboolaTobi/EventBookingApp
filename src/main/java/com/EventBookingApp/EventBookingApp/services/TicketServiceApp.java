package com.EventBookingApp.EventBookingApp.services;

import com.EventBookingApp.EventBookingApp.data.models.Event;
import com.EventBookingApp.EventBookingApp.data.models.Ticket;
import com.EventBookingApp.EventBookingApp.data.models.User;
import com.EventBookingApp.EventBookingApp.data.repositories.TicketRepository;
import com.EventBookingApp.EventBookingApp.data.repositories.UserRepository;
import com.EventBookingApp.EventBookingApp.dtos.requests.TicketBookingRequest;
import com.EventBookingApp.EventBookingApp.dtos.requests.TicketCancellingRequest;
import com.EventBookingApp.EventBookingApp.dtos.requests.ViewBookEventRequest;
import com.EventBookingApp.EventBookingApp.dtos.responses.TicketBookingResponse;
import com.EventBookingApp.EventBookingApp.dtos.responses.TicketCancellingResponse;
import com.EventBookingApp.EventBookingApp.dtos.responses.ViewBookEventResponse;
import com.EventBookingApp.EventBookingApp.exceptions.EventAppException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.EventBookingApp.EventBookingApp.utils.Validation.UserExist;

@Service
@AllArgsConstructor
public class TicketServiceApp implements TicketService{
    private final UserRepository userRepository;
    private final TicketRepository ticketRepository;
    private final EventService eventService;

    @Override
    public TicketBookingResponse bookTicket(TicketBookingRequest request) throws EventAppException {

        User user = userRepository.findByEmail(request.getEmail());
        UserExist(user);

        Ticket ticket = new Ticket();
        Event availableEvent = eventService.findByName(request.getEventName());

        if (availableEvent==null) throw new EventAppException("Event not listed");
        ticket.setEmail(request.getEmail());

        ticket.setEventName(request.getEventName());

        

        ticket.setNameOnTicket(request.getNameOnTicket());
        ticket.setNumberOfTickets(request.getNumberOfTickets());
        ticket.setStatus(request.getStatus());
        ticket.setUser(user);
        ticketRepository.save(ticket);

        TicketBookingResponse response = new TicketBookingResponse();

        response.setTicketId(ticket.getId());
        response.setMessage("You have successfully booked " + request.getNumberOfTickets() + " for" + request.getNameOnTicket());
        return response;

    }


    @Override
    public TicketCancellingResponse cancelTicket(TicketCancellingRequest request) throws EventAppException {
        User user = userRepository.findByEmail(request.getEmail());
        UserExist(user);
        Ticket ticket = ticketRepository.findByEventName(request.getEventName());
        validateTicket(ticket);

        ticket.setEventName(request.getEventName().toUpperCase());

        ticketRepository.deleteById(ticket.getId());
        userRepository.save(user);

        TicketCancellingResponse response = new TicketCancellingResponse();

        response.setMessage("Dear " + ticket.getNameOnTicket() + " you have successfully cancelled your tickets for " + ticket.getEventName() + " event");
        return response;
    }

    @Override
    public ViewBookEventResponse viewAllTickets(ViewBookEventRequest request) throws EventAppException {
        User user = userRepository.findByEmail(request.getEmail());
        UserExist(user);
        List<Ticket> tickets = ticketRepository.findByUserId(user.getId());
        if (tickets==null) throw new EventAppException("You have no booked ticket(s) for any event at the moment");
        ViewBookEventResponse response = new ViewBookEventResponse();
        response.setMessage("These are your available ticket(s)");
        response.setTickets(tickets);

        return response;
    }

    private static void validateTicket(Ticket ticket) throws EventAppException {
        if (ticket ==null) throw new EventAppException("No ticket found for this event");
    }
}
