package com.EventBookingApp.EventBookingApp.data.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private  Long id;
    private String name;
    private String email;
    private String password;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private List<Event> events = new ArrayList<>();
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    private List<Ticket> tickets;

}
