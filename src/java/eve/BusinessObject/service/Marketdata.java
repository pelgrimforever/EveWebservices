package eve.BusinessObject.service;

import eve.logicentity.Region;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;

/**
 * @author Franky Laseure
 */
public class Marketdata {
    
    private ArrayList<Region> regions = new ArrayList<>();
    private Iterator<Region> regionsI;
    
    public Marketdata(ArrayList<Region> regions) {
        this.regions = regions;
        initializeRegions();
    }
    
    public void initializeRegions() {
        regionsI = regions.iterator();
    }
    
    public Region getNextregion() {
        if(regionsI.hasNext()) {
            return regionsI.next();
        } else {
            return null;
        }
    }    
}
