package com.example.marsgate.service.exceptions;

import java.sql.SQLDataException;

public class TelTooLongException extends SQLDataException {

    public TelTooLongException() {
        super("The telephone number is too long, max. 25 characters allowed. Please return to the previous page!");
    }
}
