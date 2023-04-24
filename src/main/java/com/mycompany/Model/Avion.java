package com.mycompany.Model;

import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Avion{
    private int id;
    private int hde;
    private int hfe;
    private HashMap<Integer, Tache> taches = new HashMap<>();
}