package com.example.marsgate.service.exceptions;

import java.sql.SQLDataException;

public class EssayTooLongException extends SQLDataException {

    public EssayTooLongException() {
        super("The essay is too long, max. 1000 characters allowed. Please return to the previous page!");
    }
}
