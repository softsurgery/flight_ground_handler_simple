package com.mycompany.Exceptions;

import io.github.cdimascio.dotenv.Dotenv;

public class TacheException extends Exception {
    protected static Dotenv dotenv = Dotenv.load();
    static String msg = dotenv.get("T_EXCEPTION");
    public TacheException() {
        super(msg);
    }
}
