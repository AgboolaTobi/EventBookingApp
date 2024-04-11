package com.EventBookingApp.EventBookingApp.data.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.IDENTITY;

@Setter
@Getter
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
    @JsonIgnore
    private LocalDate eventDate;
    private int numberOfAttendees;
    private String description;
    @Enumerated(EnumType.STRING)
    private EventCategory eventCategory;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", dateTime=" + eventDate +
                ", attendees=" + numberOfAttendees +
                ", description='" + description + '\'' +
                ", category=" + eventCategory +
                '}';
    }

}
