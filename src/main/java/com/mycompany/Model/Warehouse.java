package com.mycompany.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.mycompany.Exceptions.VehiculeException;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Warehouse{
    protected static Dotenv dotenv = Dotenv.load();
    private final static int max = Integer.parseInt(dotenv.get("MAX_VEHICULE"));
    private int id;
    private Avion avion = new Avion();
    private Vehicule[] vehicules = new Vehicule[max];
    private int vehicleCount = 0;

    public Warehouse(){
        for(int i=0; i<max; i++) vehicules[i] = new Vehicule();
    }
    public Vehicule search(Vehicule vehicule){
        Optional<Vehicule> result = Arrays.stream(vehicules)
            .filter(o -> o.equals(vehicule)).findFirst();
        return result.isPresent() ? result.get() : null;
    }

    public void addVehicule(Vehicule vehicule) throws VehiculeException {
        Vehicule v = this.search(vehicule);
        if(v==null) this.vehicules[vehicleCount] = vehicule;
        else throw new VehiculeException();
    }

    public Vehicule deletVehicule(Vehicule vehicule) throws VehiculeException {
        Vehicule v = this.search(vehicule);
        if (v!=null) {
            List<Vehicule> list = new ArrayList<>(Arrays.asList(vehicules));
            list.remove(v);
            this.vehicules = list.toArray(new Vehicule[0]);
        }
        return v;
    }
}