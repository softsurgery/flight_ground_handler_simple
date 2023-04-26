package com.mycompany.Model;

import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

import lombok.ToString;

@ToString
public class Optimizer {
    private Aeroport ano;
    private Aeroport awo;
    
    public boolean load(String samplePath){
        Gson gson = new Gson();
        try{
            FileReader reader = new FileReader(samplePath);
            this.ano = gson.fromJson(reader, Aeroport.class);
            awo = ano.copy();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public float optimize(){
        
        return 0.0f;
    }
}
