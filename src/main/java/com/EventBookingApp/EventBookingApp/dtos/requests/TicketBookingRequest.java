package com.EventBookingApp.EventBookingApp.dtos.requests;


import com.EventBookingApp.EventBookingApp.data.models.ReservationStatus;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class TicketBookingRequest {
    private String email;
    private String eventName;
    private String nameOnTicket;
    private int numberOfTickets;
    private ReservationStatus status;


}
