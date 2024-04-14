package com.EventBookingApp.EventBookingApp.dtos.requests;

import com.EventBookingApp.EventBookingApp.data.models.ReservationStatus;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TicketCancellingRequest {
    private String email;
    private String eventName;
    private Long eventId;
    private ReservationStatus status;
}
