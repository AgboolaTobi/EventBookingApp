package com.EventBookingApp.EventBookingApp.services;

import com.EventBookingApp.EventBookingApp.dtos.requests.TicketBookingRequest;
import com.EventBookingApp.EventBookingApp.dtos.responses.TicketBookingResponse;
import com.EventBookingApp.EventBookingApp.exceptions.EventAppException;

public interface TicketService {
    TicketBookingResponse bookTicket(TicketBookingRequest request) throws EventAppException;
}
