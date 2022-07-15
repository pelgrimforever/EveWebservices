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
import eve.logicentity.Alliance;
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
public class Alliance_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLalliance blalliance = new BLalliance(sqlreader);
    
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
        return blalliance.getAllianceExists(alliancePK);
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
    
    public ArrayList<Alliance> search_alliance(IAlliancesearch alliancesearch) throws CustomException {
        return blalliance.search(alliancesearch);
    }
    
    public long search_alliance_count(IAlliancesearch alliancesearch) throws CustomException {
        return blalliance.searchcount(alliancesearch);
    }

    public void insertAlliance(IAlliance alliance) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blalliance.insertAlliance(tq, alliance);
        sqlwriter.Commit2DB(tq);
    }

    public void updateAlliance(IAlliance alliance) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blalliance.updateAlliance(tq, alliance);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteAlliance(IAlliance alliance) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blalliance.deleteAlliance(tq, alliance);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Corporationcreator_corporation(ICorporationPK corporationCreator_corporationPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blalliance.delete4corporationCreator_corporation(tq, corporationCreator_corporationPK);
        sqlwriter.Commit2DB(tq);
    }
    
    public void delete_all_containing_Corporationexecutor_corporation(ICorporationPK corporationExecutor_corporationPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blalliance.delete4corporationExecutor_corporation(tq, corporationExecutor_corporationPK);
        sqlwriter.Commit2DB(tq);
    }
    
}

