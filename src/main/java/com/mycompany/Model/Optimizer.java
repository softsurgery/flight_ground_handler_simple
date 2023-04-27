package com.mycompany.Model;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import com.google.gson.Gson;
import com.mycompany.Exceptions.WarehouseException;
import com.mycompany.Model.Types.TacheType;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.ToString;

@ToString
public class Optimizer {
    protected static Dotenv dotenv = Dotenv.load();
    private final static int mpu = Integer.parseInt(dotenv.get("MINUTES_PER_UNIT"));
    private Aeroport ano;
    private Aeroport awo;
    private boolean[] optimized;

    public Optimizer(String samplePath) {
        this.load(samplePath);
        this.optimized = new boolean[awo.getWarehouseCount()];
        for (int i = 0; i < awo.getWarehouseCount(); i++)
            optimized[i] = false;
    }

    public boolean load(String samplePath) {
        Gson gson = new Gson();
        try {
            FileReader reader = new FileReader(samplePath);
            this.ano = gson.fromJson(reader, Aeroport.class);
            awo = ano.copy();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public Warehouse findOut() {
        int current = 0;
        Warehouse[] warehouses = awo.getWarehouses();
        while(current < awo.getWarehouseCount() && optimized[current]!=false) current++;

        for (int i = current ; i < awo.getWarehouseCount() ; i++)
            if (warehouses[i].getAvion().getHfe() < warehouses[current].getAvion().getHfe())
                current = i;
        return warehouses[current];
    }

    public HashMap<TacheType,Vehicule> missingVehicules(Warehouse warehouse) 
    throws WarehouseException {
        HashMap<Integer, Tache> taches = warehouse.getAvion().getTaches();
        HashMap<TacheType,Vehicule> needed = new HashMap<TacheType, Vehicule>();
        Aeroport clone = awo.copy();
        clone.deletWarehouse(warehouse);
        for (int i = 0; i < 4; i++)
            if (taches.get(i).getTacheType() != TacheType.UNDEFINED
                    && warehouse.search(taches.get(i).getTacheType()) == null)
                needed.put(Vehicule.gTacheType(i), null);
            
        Set<TacheType> keys = needed.keySet();
        Vehicule v;
        int retard = 0;
        for (TacheType t : keys){
            for (Warehouse w :clone.getWarehouses()){
                v = w.search(t).clone();
                if (v!=null){
                    retard = Math.abs(w.getLocationUnit()-warehouse.getLocationUnit())*mpu;
                    v.setRetard(retard);
                    if (needed.get(t)!=null){
                        if (retard<needed.get(t).getRetard()){
                            needed.put(t, v);
                        }
                    } else {
                        needed.put(t, v);
                    }
                } 
            }
        }
        return needed;
    }

    public void optimize(Warehouse warehouse) throws WarehouseException{
        HashMap<TacheType,Vehicule> needed = this.missingVehicules(warehouse);
        if (needed.keySet().contains(Vehicule.gTacheType(warehouse.getAvion().startingTask()))){
            
        }
        
    }
}
