package com.mycompany;

import com.mycompany.Model.Optimizer;

public class App {
    public static void main(String[] args) {
        Optimizer o = new Optimizer();
        o.load("./data.json");
        System.out.println(o);
    }
}
