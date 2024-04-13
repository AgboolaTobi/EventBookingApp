package com.EventBookingApp.EventBookingApp.utils;

import com.EventBookingApp.EventBookingApp.data.models.User;
import com.EventBookingApp.EventBookingApp.dtos.requests.EventCreationRequest;
import com.EventBookingApp.EventBookingApp.dtos.requests.TicketBookingRequest;
import com.EventBookingApp.EventBookingApp.exceptions.EventAppException;

public class Validation {
    public static boolean verifyPassword(String password){
        return password.matches("[A-Z][a-zA-Z]{2,}[0-9@!#$%^&():;.*_~`+{}]{1,9}");
    }

    public static boolean verifyName(String name){
        return name.matches("[A-Z][a-zA-Z]{1,99}");
    }

//    public static boolean verifyDescription(String name){
//        return name.matches("[A-Z][a-zA-Z]{1,499}");
//    }

//    public static boolean verifyAvailableAttendees(String name){
//        return name.matches("[0-9]{1,999}");
//    }
    public static boolean verifyEmail(String email){
        return email.matches("[a-zA-Z0-9!#$%^&():;.*_~`+{}]+@[a-z]+[.][a-z]{2,3}");
    }

    public static void validateAttendeesNumber(EventCreationRequest request) throws EventAppException {
        if (request.getNumberOfAttendees() < 0 || request.getNumberOfAttendees() > 1000) throw new EventAppException("Number of attendees cannot be less 1 nor greater than 1000");
    }

    public static void validateDescription(EventCreationRequest request) throws EventAppException {
        if (request.getDescription().isEmpty() || request.getDescription().length() > 500) throw new EventAppException("Event description cannot be less than 1 character nor greater than 500 character");
    }

    public static void validateName(EventCreationRequest request) throws EventAppException {
        if (request.getName().isEmpty() || request.getName().length() > 100) throw new EventAppException("Event name cannot be less than 1 nor greater than 100 characters");
    }

    public static void UserExist(User user) throws EventAppException {
        if (user == null) throw new EventAppException("User not found");
    }

}
