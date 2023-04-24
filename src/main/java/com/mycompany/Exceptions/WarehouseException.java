package com.mycompany.Exceptions;

import io.github.cdimascio.dotenv.Dotenv;

public class WarehouseException extends Exception {
    protected static Dotenv dotenv = Dotenv.load();
    static String msg = dotenv.get("W_EXCEPTION");
    public WarehouseException() {
        super(msg);
    }
}
