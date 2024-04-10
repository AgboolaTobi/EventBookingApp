package com.EventBookingApp.EventBookingApp.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Event {

    @Id
    private Long id;
    private LocalDateTime date = LocalDateTime.now();
    private int availableAttendees;

}
