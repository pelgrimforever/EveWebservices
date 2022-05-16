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
import eve.logicentity.Alliance;
import eve.logicview.*;
import general.exception.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Alliance_usecases {

    private boolean loggedin = false;
    private BLalliance blalliance = new BLalliance();
    
    public Alliance_usecases() {
        this(false);
    }
    
    public Alliance_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blalliance.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blalliance.count();
    }
    
    public ArrayList<Alliance> get_all() throws DBException {
        return blalliance.getAlliances();
    }
    
    public boolean getAllianceExists(IAlliancePK alliancePK) throws DBException {
        return blalliance.getEntityExists(alliancePK);
    }
    
    public Alliance get_alliance_by_primarykey(IAlliancePK alliancePK) throws DBException {
        return blalliance.getAlliance(alliancePK);
    }

    public ArrayList<Alliance> get_alliance_with_foreignkey_corporationCreator_corporation(ICorporationPK corporationCreator_corporationPK) throws CustomException {
        return blalliance.getAlliances4corporationCreator_corporation(corporationCreator_corporationPK);
    }
    
    public ArrayList<Alliance> get_alliance_with_foreignkey_corporationExecutor_corporation(ICorporationPK corporationExecutor_corporationPK) throws CustomException {
        return blalliance.getAlliances4corporationExecutor_corporation(corporationExecutor_corporationPK);
    }
    
    public ArrayList<Alliance> search_alliance(IAlliancesearch alliancesearch) throws ParseException, CustomException {
        return blalliance.search(alliancesearch);
    }
    
    public long search_alliance_count(IAlliancesearch alliancesearch) throws ParseException, CustomException {
        return blalliance.searchcount(alliancesearch);
    }

    public void secureinsertAlliance(IAlliance alliance) throws DBException, DataException {
        blalliance.secureinsertAlliance(alliance);
    }

    public void secureupdateAlliance(IAlliance alliance) throws DBException, DataException {
        blalliance.secureupdateAlliance(alliance);
    }

    public void securedeleteAlliance(IAlliance alliance) throws DBException, DataException {
        blalliance.securedeleteAlliance(alliance);
    }
}

