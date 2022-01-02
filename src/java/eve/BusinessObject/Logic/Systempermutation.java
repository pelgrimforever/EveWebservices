/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eve.BusinessObject.Logic;

import eve.logicentity.Systemjumps;
import eve.logicentity.System;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javafx.util.Pair;

/**
 *
 * @author pelgrim
 */
public class Systempermutation {
    
    private ArrayList<System> usedsystems = null;
    private HashMap<Pair<Long,Long>, Systemjumps> jumptable = null;
    private long startsystem;
    private long endsystem;
    
    private int totaljumps = Integer.MAX_VALUE;
    private ArrayList<System> route = null;
    
    public Systempermutation(ArrayList<System> usedsystems, HashMap<Pair<Long,Long>, Systemjumps> jumptable, long startsystem, long endsystem) {
        this.usedsystems = usedsystems;
        this.jumptable = jumptable;
        this.startsystem = startsystem;
        this.endsystem = endsystem;
    }

    public ArrayList<System> findroute() {
        permute(usedsystems, 0);
        return route;
    }
    
    private void permute(java.util.List<System> arr, int k){
        for(int i = k; i < arr.size(); i++){
            java.util.Collections.swap(arr, i, k);
            permute(arr, k+1);
            java.util.Collections.swap(arr, k, i);
        }
        if (k == arr.size() -1){
            //check combination
            Iterator<System> systemI = arr.iterator();
            System prevsystem = systemI.next();
            System system = prevsystem; //initialize for compilation
            //add jumps from starting point to first system
            int jumps = jumptable.get(new Pair(startsystem, prevsystem.getPrimaryKey().getId())).getJumpssafe();
            while(systemI.hasNext()) {
                system = systemI.next();
                jumps += jumptable.get(new Pair(prevsystem.getPrimaryKey().getId(), system.getPrimaryKey().getId())).getJumpssafe();
                prevsystem = system;
            }
            //add jumps from end point to last system
            jumps += jumptable.get(new Pair(endsystem, system.getPrimaryKey().getId())).getJumpssafe();
            if(totaljumps>jumps) {
                totaljumps = jumps;
                route = new ArrayList<>();
                for(System s: arr) {
                    route.add(s);
                }
            }
        }
    }
    
}
