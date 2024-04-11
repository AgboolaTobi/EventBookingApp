package com.EventBookingApp.EventBookingApp.services;

import com.EventBookingApp.EventBookingApp.dtos.requests.EventCreationRequest;
import com.EventBookingApp.EventBookingApp.dtos.requests.UserRegistrationRequest;
import com.EventBookingApp.EventBookingApp.dtos.responses.EventCreationResponse;
import com.EventBookingApp.EventBookingApp.dtos.responses.UserRegistrationResponse;
import com.EventBookingApp.EventBookingApp.exceptions.RegistrationException;

public interface UserService {
    UserRegistrationResponse register(UserRegistrationRequest request) throws RegistrationException;

    EventCreationResponse createEvent(EventCreationRequest request) throws RegistrationException;
}
