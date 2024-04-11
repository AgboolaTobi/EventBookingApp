package com.EventBookingApp.EventBookingApp.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EventCreationRequest {
    private String userEmail;
    private int availableAttendees;
    private String description;
    private String category;
}
