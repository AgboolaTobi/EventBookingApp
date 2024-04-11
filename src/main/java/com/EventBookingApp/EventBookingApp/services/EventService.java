package com.EventBookingApp.EventBookingApp.services;

import com.EventBookingApp.EventBookingApp.dtos.requests.EventCreationRequest;
import com.EventBookingApp.EventBookingApp.dtos.responses.EventCreationResponse;
import com.EventBookingApp.EventBookingApp.exceptions.EventAppException;

public interface EventService {

    EventCreationResponse createEvent(EventCreationRequest request, Long userId) throws EventAppException;
}