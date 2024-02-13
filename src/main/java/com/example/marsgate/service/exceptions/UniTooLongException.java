package com.example.marsgate.service.exceptions;

import java.sql.SQLDataException;

public class UniTooLongException extends SQLDataException {

    public UniTooLongException() {
        super("The university degree is too long, max. 100 characters allowed. Please return to the previous page!");
    }
}
