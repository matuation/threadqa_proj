package com.variables.enum_exception_homework;
//Часть 3. Исключение OrderValidationException
public class OrderValidationException extends RuntimeException {
    public OrderValidationException(String message) {
        super("OrderValidation: " + message);
    }
}
