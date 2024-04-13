package com.EventBookingApp.EventBookingApp.services;

import com.EventBookingApp.EventBookingApp.data.models.Event;
import com.EventBookingApp.EventBookingApp.data.models.Ticket;
import com.EventBookingApp.EventBookingApp.data.models.User;
import com.EventBookingApp.EventBookingApp.data.repositories.EventRepository;
import com.EventBookingApp.EventBookingApp.data.repositories.TicketRepository;
import com.EventBookingApp.EventBookingApp.data.repositories.UserRepository;
import com.EventBookingApp.EventBookingApp.dtos.requests.TicketBookingRequest;
import com.EventBookingApp.EventBookingApp.dtos.responses.TicketBookingResponse;
import com.EventBookingApp.EventBookingApp.exceptions.EventAppException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
}
