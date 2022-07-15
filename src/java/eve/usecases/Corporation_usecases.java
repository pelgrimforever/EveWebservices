/*
 * Generated on 13.6.2022 11:21
 */

package eve.usecases;

import db.*;
import data.conversion.JSONConversion;
import data.interfaces.db.Filedata;
import data.gis.shape.piPoint;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.*;
import eve.interfaces.entity.pk.*;
import eve.logicentity.*;
import eve.logicentity.Corporation;
import eve.logicview.*;
import eve.usecases.custom.*;
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
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLcorporation blcorporation = new BLcorporation(sqlreader);
    
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
        return blcorporation.getCorporationExists(corporationPK);
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

    public void insertCorporation(ICorporation corporation) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blcorporation.insertCorporation(tq, corporation);
        sqlwriter.Commit2DB(tq);
    }

    public void updateCorporation(ICorporation corporation) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blcorporation.updateCorporation(tq, corporation);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteCorporation(ICorporation corporation) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blcorporation.deleteCorporation(tq, corporation);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Station(IStationPK stationPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blcorporation.delete4station(tq, stationPK);
        sqlwriter.Commit2DB(tq);
    }
    
    public void delete_all_containing_Faction(IFactionPK factionPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blcorporation.delete4faction(tq, factionPK);
        sqlwriter.Commit2DB(tq);
    }
    
    public void delete_all_containing_Alliance(IAlliancePK alliancePK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blcorporation.delete4alliance(tq, alliancePK);
        sqlwriter.Commit2DB(tq);
    }
    
}

