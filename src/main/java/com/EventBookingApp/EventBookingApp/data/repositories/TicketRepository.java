package com.EventBookingApp.EventBookingApp.data.repositories;

import com.EventBookingApp.EventBookingApp.data.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Long> {

    Ticket findByEventName(String eventName);
}
