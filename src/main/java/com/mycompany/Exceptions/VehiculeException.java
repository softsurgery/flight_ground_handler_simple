package com.mycompany.Exceptions;

import io.github.cdimascio.dotenv.Dotenv;

public class VehiculeException extends Exception {
    protected static Dotenv dotenv = Dotenv.load();
    static String msg = dotenv.get("V_EXCEPTION");
    public VehiculeException() {
        super(msg);
    }
}
