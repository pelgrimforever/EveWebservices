package eve.usecases.custom;

import eve.BusinessObject.service.Multistoproutecalculator;
import eve.logicentity.Systemjumps;
import java.util.ArrayList;

/**
 * @author Franky Laseure
 */
public class Multistoproutecalculator_usecases {

    public Multistoproutecalculator_usecases() {
    }
    
    public ArrayList<eve.logicentity.System> calculateroute(
            eve.logicentity.System startsystem, 
            eve.logicentity.System endsystem, 
            ArrayList<eve.logicentity.System> systemstops, 
            ArrayList<Systemjumps> systemjumps) {
        Multistoproutecalculator multistoproutecalculator = new Multistoproutecalculator();
        return multistoproutecalculator.calculateroute(startsystem, endsystem, systemstops, systemjumps);
    }
    
}
