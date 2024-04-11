package com.EventBookingApp.EventBookingApp.utils;

public class Validation {
    public static boolean verifyPassword(String password){
        return password.matches("[A-Z][a-zA-Z]{2,}[0-9@!#$%^&():;.*_~`+{}]{1,9}");
    }

    public static boolean verifyName(String name){
        return name.matches("[A-Z][a-zA-Z]{1,99}");
    }

    public static boolean verifyDescription(String name){
        return name.matches("[A-Z][a-zA-Z]{1,499}");
    }

    public static boolean verifyAvailableAttendees(String name){
        return name.matches("[0-9]{1,999}");
    }
    public static boolean verifyEmail(String email){
        return email.matches("[a-zA-Z0-9!#$%^&():;.*_~`+{}]+@[a-z]+[.][a-z]{2,3}");
    }

}
