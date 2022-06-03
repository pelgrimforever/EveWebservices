/*
 * Generated on 20.4.2022 10:3
 */

package eve.usecases;

import data.conversion.JSONConversion;
import data.interfaces.db.Filedata;
import data.gis.shape.piPoint;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.*;
import eve.interfaces.entity.pk.*;
import eve.logicentity.Corporation;
import general.exception.*;
import java.sql.Date;
import java.util.*;
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
    
    public ArrayList<Corporation> search_corporation(ICorporationsearch corporationsearch) throws CustomException {
        return blcorporation.search(corporationsearch);
    }
    
    public long search_corporation_count(ICorporationsearch corporationsearch) throws CustomException {
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

