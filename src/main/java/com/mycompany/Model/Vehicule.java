package com.mycompany.Model;

import com.mycompany.Exceptions.TacheException;
import com.mycompany.Model.Types.TacheType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Vehicule {
    private int id;
    private TacheType tacheType = TacheType.UNDEFINED;
    private int tachesCount;
    private int retard;

    static TacheType gTacheType(int index){
         return switch (index) {
            case 0 -> TacheType.DEBARQUEMENT;
            case 1 -> TacheType.CATERING;
            case 2 -> TacheType.REFUELING;
            case 3 -> TacheType.EMBARQUEMENT;
            default -> throw new IllegalArgumentException("Unexpected value: " + index);
        };
    }

    public void setTacheType(int index) throws TacheException{
        if (index >= 0 && index <=3) this.tacheType = gTacheType(index);
        else throw new TacheException();
    }

    public Vehicule clone(){
        return new Vehicule(id,tacheType,tachesCount,retard);
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
