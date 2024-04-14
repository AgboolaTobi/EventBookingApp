package com.EventBookingApp.EventBookingApp.data.repositories;

import com.EventBookingApp.EventBookingApp.data.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Long> {

    Ticket findByEventName(String eventName);

    List<Ticket> findByUserId(Long id);
}
