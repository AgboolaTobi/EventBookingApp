package com.EventBookingApp.EventBookingApp.dtos.requests;

import com.EventBookingApp.EventBookingApp.data.models.EventCategory;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
public class EventCreationRequest {
    private String name;
    private int numberOfAttendees;
    private String description;
    private EventCategory category;
    private LocalDateTime eventDate;
}
