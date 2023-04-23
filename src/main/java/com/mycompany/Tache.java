package com.mycompany;
public class Tache {
    private int id;
    private int duree;
    private int hd;
    private TacheType tacheType;

    public Tache(int id, int duree, int hd, TacheType tacheType) {
        this.id = id;
        this.duree = duree;
        this.hd = hd;
        this.tacheType = tacheType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public int getHd() {
        return hd;
    }

    public void setHd(int hd) {
        this.hd = hd;
    }

    public TacheType getTacheType() {
        return tacheType;
    }

    public void setTacheType(int index) throws TacheException {
        if (index == 0) this.tacheType = TacheType.DEBARQUEMENT;
        else if (index == 1) this.tacheType = TacheType.REFUELING;
        else if (index == 2) this.tacheType = TacheType.CATERING;
        else if (index == 3) this.tacheType = TacheType.EMBARQUEMENT;
        else throw new TacheException();
    }
    

    
}
