package com.mycompany.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import com.mycompany.Exceptions.WarehouseException;
import io.github.cdimascio.dotenv.Dotenv;
import lombok.Getter;


@Getter
public class Aeroport{
    protected static Dotenv dotenv = Dotenv.load();
    private Warehouse[] warehouses = new Warehouse[
        Integer.parseInt(dotenv.get("MAX_WAREHOUSE"))
    ];
    private int warehouseCount = 0;

    public Warehouse search(Avion a){
        Optional<Warehouse> result = Arrays.stream(warehouses)
            .filter(o -> o.getAvion().equals(a)).findFirst();
        return result.isPresent() ? result.get() : null;
    }

    public void addWarehouse(Warehouse warehouse) throws WarehouseException {
        Warehouse w = this.search(warehouse.getAvion());
        if(w==null) this.warehouses[warehouseCount] = w;
        else throw new WarehouseException();
    }

    public Warehouse deletWarehouse(Warehouse warehouse) throws WarehouseException {
        Warehouse w = this.search(warehouse.getAvion());
        if (w!=null) {
            List<Warehouse> list = new ArrayList<>(Arrays.asList(warehouses));
            list.remove(w);
            this.warehouses = list.toArray(new Warehouse[0]);
        }
        return w;
    }
}
