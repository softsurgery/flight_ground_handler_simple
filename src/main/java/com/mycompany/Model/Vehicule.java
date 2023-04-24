package com.mycompany.Model;

import com.mycompany.Exceptions.TacheException;
import com.mycompany.Model.Types.TacheType;

public class Vehicule {
    private int id;
    private TacheType tacheType;
    private int tachesCount;

    public Vehicule(int id, TacheType tacheType, int tachesCount) {
        this.id = id;
        this.tacheType = tacheType;
        this.tachesCount = tachesCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TacheType getTacheType() {
        return tacheType;
    }

    public void setTacheType(int index) throws TacheException{
        if (index == 0) this.tacheType = TacheType.DEBARQUEMENT;
        else if (index == 1) this.tacheType = TacheType.REFUELING;
        else if (index == 2) this.tacheType = TacheType.CATERING;
        else if (index == 3) this.tacheType = TacheType.EMBARQUEMENT;
        else throw new TacheException();
    }

    public int getTachesCount() {
        return tachesCount;
    }

    public void setTachesCount(int tachesCount) {
        this.tachesCount = tachesCount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vehicule other = (Vehicule) obj;
        if (id != other.id)
            return false;
        if (tacheType != other.tacheType)
            return false;
        if (tachesCount != other.tachesCount)
            return false;
        return true;
    }
    
    
}
