package eve.BusinessObject.service;

import eve.logicentity.Systemjumps;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javafx.util.Pair;

/**
 * @author Franky Laseure
 */
public class Multistoproutecalculator {

    public Multistoproutecalculator() {
    }
    
    public ArrayList<eve.logicentity.System> calculateroute(
            eve.logicentity.System startsystem, 
            eve.logicentity.System endsystem, 
            ArrayList<eve.logicentity.System> systemstops, 
            ArrayList<Systemjumps> systemjumps) {
        ArrayList<eve.logicentity.System> calculatedroute = new ArrayList<>();
        HashMap<Pair<Long,Long>, Systemjumps> jumptable = new HashMap<>();
        for(Systemjumps systemjump: systemjumps)
            jumptable.put(new Pair(systemjump.getPrimaryKey().getSystem_start(), systemjump.getPrimaryKey().getSystem_end()), systemjump);
        Systempermutation permutation = new Systempermutation(systemstops, jumptable, startsystem.getPrimaryKey().getId(), endsystem.getPrimaryKey().getId());
        calculatedroute.add(startsystem);
        ArrayList<eve.logicentity.System> route = permutation.findroute();
        if(route!=null)
            calculatedroute.addAll(route);
        calculatedroute.add(endsystem);
        return calculatedroute;
    }

    private class Systempermutation {

        private ArrayList<eve.logicentity.System> usedsystems = null;
        private HashMap<Pair<Long,Long>, Systemjumps> jumptable = null;
        private long startsystem;
        private long endsystem;

        private int totaljumps = Integer.MAX_VALUE;
        private ArrayList<eve.logicentity.System> route = null;

        public Systempermutation(ArrayList<eve.logicentity.System> usedsystems, HashMap<Pair<Long,Long>, Systemjumps> jumptable, long startsystem, long endsystem) {
            this.usedsystems = usedsystems;
            this.jumptable = jumptable;
            this.startsystem = startsystem;
            this.endsystem = endsystem;
        }

        public ArrayList<eve.logicentity.System> findroute() {
            permute(usedsystems, 0);
            return route;
        }

        private void permute(java.util.List<eve.logicentity.System> arr, int k){
            for(int i = k; i < arr.size(); i++){
                java.util.Collections.swap(arr, i, k);
                permute(arr, k+1);
                java.util.Collections.swap(arr, k, i);
            }
            if (k == arr.size() -1){
                //check combination
                Iterator<eve.logicentity.System> systemI = arr.iterator();
                eve.logicentity.System prevsystem = systemI.next();
                eve.logicentity.System system = prevsystem; //initialize for compilation
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
                    for(eve.logicentity.System s: arr) {
                        route.add(s);
                    }
                }
            }
        }

    }
}
