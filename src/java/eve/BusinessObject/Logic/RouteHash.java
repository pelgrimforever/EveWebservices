/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eve.BusinessObject.Logic;

import eve.entity.pk.RoutePK;
import eve.entity.pk.RoutetypePK;
import eve.entity.pk.SystemPK;
import eve.logicentity.Route;
import general.exception.DBException;
import java.util.HashMap;

/**
 *
 * @author pelgrim
 */
public class RouteHash {
    
    private RoutetypePK routetypePK;
    private HashMap<Long, Routefinder> routehash = new HashMap<>();
    private BLroute blroute = new BLroute();
    
    public RouteHash(RoutetypePK routetypePK) {
        this.routetypePK = routetypePK;
    }
    
    /**
     * find route in hash
     * if not found, load from database
     * @param systemPK
     * @return
     * @throws DBException 
     */
    public Routefinder getRoutefinder(SystemPK systemPK) throws DBException {
        Routefinder routefinder = routehash.get(systemPK.getId());
        if(routefinder==null) {
            routefinder = new Routefinder(blroute.getRoute(new RoutePK(routetypePK.getId(), systemPK.getId())));
            routehash.put(systemPK.getId(), routefinder);
        }
        return routefinder;
    }
    
}
