package com.EventBookingApp.EventBookingApp.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter

public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private  Long id;
    private String name;
    private String email;
    private String password;
    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Event> events = new ArrayList<>();



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", events=" + events +
                '}';
    }
}
