package com.EventBookingApp.EventBookingApp.dtos.requests;

import com.EventBookingApp.EventBookingApp.data.models.EventCategory;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class EventCreationRequest {
    public String email;
    private String name;
    private String eventDate;
    private int numberOfAttendees;
    private String description;
    private EventCategory category;
}
