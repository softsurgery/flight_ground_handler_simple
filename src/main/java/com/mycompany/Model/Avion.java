package com.mycompany.Model;

import java.util.HashMap;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
public class Avion{
    private int id;
    private int hde;
    private int hfe;
    private HashMap<Integer, Tache> taches = new HashMap<>();

    public Avion(){
        for(int i=0 ; i<4 ;i++) this.taches.put(i,new Tache());
    }

    public int startingTask(){
        int i = 0;
        while(i < 4){
            if (taches.get(i)!=null) return i;
            else i++;
        } 
        return -1;
    }

}