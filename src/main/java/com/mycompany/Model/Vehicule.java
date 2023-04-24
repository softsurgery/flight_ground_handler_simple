package com.mycompany.Model;

import com.mycompany.Exceptions.TacheException;
import com.mycompany.Model.Types.TacheType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class Vehicule {
    private int id;
    private TacheType tacheType;
    private int tachesCount;

    public void setTacheType(int index) throws TacheException{
        if (index == 0) this.tacheType = TacheType.DEBARQUEMENT;
        else if (index == 1) this.tacheType = TacheType.REFUELING;
        else if (index == 2) this.tacheType = TacheType.CATERING;
        else if (index == 3) this.tacheType = TacheType.EMBARQUEMENT;
        else throw new TacheException();
    }
}
