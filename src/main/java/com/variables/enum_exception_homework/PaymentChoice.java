package com.variables.enum_exception_homework;
//Часть 2. Enum PaymentChoice
public enum PaymentChoice {
    CARD (true),
    CASH (false),
    SBP (true);

    private final boolean online;

    PaymentChoice(boolean online) {
        this.online = online;
    }

    public boolean isOnline() {
        return online;
    }
}
