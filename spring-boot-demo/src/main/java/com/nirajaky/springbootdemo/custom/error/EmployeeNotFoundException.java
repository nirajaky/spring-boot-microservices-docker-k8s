package com.nirajaky.springbootdemo.custom.error;

public class EmployeeNotFoundException extends RuntimeException {

    /*
        This is a custom exception
        1. To create a custom exception class we need to extend that class with RuntimeException and
           pass the message to parent constructor using super keyword.
        2. We make custom exception providing meaningful name to our Exceptions.
    */
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
