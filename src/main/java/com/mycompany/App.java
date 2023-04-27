package com.mycompany;

import com.mycompany.Exceptions.WarehouseException;
import com.mycompany.Model.Optimizer;

public class App {
    public static void main(String[] args) throws WarehouseException {
        Optimizer o = new Optimizer("./data.json");
        System.out.println(o.missingVehicules(o.findOut()));
    }
}
