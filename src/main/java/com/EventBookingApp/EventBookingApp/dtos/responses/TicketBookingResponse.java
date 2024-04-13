package com.EventBookingApp.EventBookingApp.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TicketBookingResponse {
    private Long ticketId;
    private String message;
}
