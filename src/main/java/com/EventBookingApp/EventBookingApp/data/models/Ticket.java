package com.EventBookingApp.EventBookingApp.data.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String eventName;
    private String nameOnTicket;
    private int numberOfTickets;
    @Enumerated(EnumType.STRING)
    private ReservationStatus status;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
}
