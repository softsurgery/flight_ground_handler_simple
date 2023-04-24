package com.mycompany.Model;

import java.util.HashMap;

public class Avion{
    private int id;
    private int hde;
    private int hfe;
    private HashMap<Integer, Tache> taches = new HashMap<>();

    public Avion(int id, int hde, int hfe, HashMap<Integer, Tache> taches) {
        this.id = id;
        this.hde = hde;
        this.hfe = hfe;
        this.taches = taches;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHde() {
        return hde;
    }

    public void setHde(int hde) {
        this.hde = hde;
    }

    public int getHfe() {
        return hfe;
    }

    public void setHfe(int hfe) {
        this.hfe = hfe;
    }

    public HashMap<Integer, Tache> getTaches() {
        return taches;
    }

    public void setTaches(HashMap<Integer, Tache> taches) {
        this.taches = taches;
    }
    
    
}