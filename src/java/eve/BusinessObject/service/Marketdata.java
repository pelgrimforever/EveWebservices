/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eve.BusinessObject.service;

import eve.logicentity.Region;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;

/**
 *
 * @author pelgrim
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
