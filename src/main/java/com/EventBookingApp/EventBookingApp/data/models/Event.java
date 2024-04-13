package com.EventBookingApp.EventBookingApp.data.models;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Event {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
    private String eventDate;
    private int numberOfAttendees;
    private String description;
    @Enumerated(EnumType.STRING)
    private EventCategory eventCategory;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

}
