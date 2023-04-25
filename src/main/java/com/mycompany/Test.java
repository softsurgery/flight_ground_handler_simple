package com.mycompany;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.mycompany.Model.Optimizer;

public class Test {
    public static void main(String[] args) {
        Optimizer o = new Optimizer();
        Gson gson = new Gson();
        String json = gson.toJson(o);
        try {
            FileWriter writer = new FileWriter("./data.json");
            writer.write(json);
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
