package com.EventBookingApp.EventBookingApp.dtos.responses;


import com.EventBookingApp.EventBookingApp.data.models.Ticket;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ViewBookEventResponse {
    private List<Ticket> tickets;
    private String message;
}
