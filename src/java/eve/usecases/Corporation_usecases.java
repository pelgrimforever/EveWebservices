/*
 * Generated on 13.4.2022 19:13
 */

package eve.usecases;

import data.conversion.JSONConversion;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.*;
import eve.interfaces.entity.pk.*;
import eve.logicentity.Corporation;
import eve.logicview.*;
import general.exception.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Corporation_usecases {

    private boolean loggedin = false;
    private BLcorporation blcorporation = new BLcorporation();
    
    public Corporation_usecases() {
        this(false);
    }
    
    public Corporation_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blcorporation.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blcorporation.count();
    }
    
    public ArrayList<Corporation> get_all() throws DBException {
        return blcorporation.getCorporations();
    }
    
    public boolean getCorporationExists(ICorporationPK corporationPK) throws DBException {
        return blcorporation.getEntityExists(corporationPK);
    }
    
    public Corporation get_corporation_by_primarykey(ICorporationPK corporationPK) throws DBException {
        return blcorporation.getCorporation(corporationPK);
    }

    public ArrayList<Corporation> get_corporation_with_foreignkey_station(IStationPK stationPK) throws CustomException {
        return blcorporation.getCorporations4station(stationPK);
    }
    
    public ArrayList<Corporation> get_corporation_with_foreignkey_faction(IFactionPK factionPK) throws CustomException {
        return blcorporation.getCorporations4faction(factionPK);
    }
    
    public ArrayList<Corporation> get_corporation_with_foreignkey_alliance(IAlliancePK alliancePK) throws CustomException {
        return blcorporation.getCorporations4alliance(alliancePK);
    }
    
    public ArrayList<Corporation> search_corporation(ICorporationsearch corporationsearch) throws ParseException, CustomException {
        return blcorporation.search(corporationsearch);
    }
    
    public long search_corporation_count(ICorporationsearch corporationsearch) throws ParseException, CustomException {
        return blcorporation.searchcount(corporationsearch);
    }

    public void secureinsertCorporation(ICorporation corporation) throws DBException, DataException {
        blcorporation.secureinsertCorporation(corporation);
    }

    public void secureupdateCorporation(ICorporation corporation) throws DBException, DataException {
        blcorporation.secureupdateCorporation(corporation);
    }

    public void securedeleteCorporation(ICorporation corporation) throws DBException, DataException {
        blcorporation.securedeleteCorporation(corporation);
    }
}

