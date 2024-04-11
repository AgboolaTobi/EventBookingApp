package com.EventBookingApp.EventBookingApp.services;

import com.EventBookingApp.EventBookingApp.dtos.requests.UserRegistrationRequest;
import com.EventBookingApp.EventBookingApp.dtos.responses.UserRegistrationResponse;
import com.EventBookingApp.EventBookingApp.exceptions.EventAppException;

public interface UserService {
    UserRegistrationResponse register(UserRegistrationRequest request) throws EventAppException;

}
