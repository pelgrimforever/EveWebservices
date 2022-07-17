/*
 * Generated on 17.6.2022 13:4
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
import eve.logicentity.Tradecombined;
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
public class Tradecombined_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLtradecombined bltradecombined = new BLtradecombined(sqlreader);
    
    public Tradecombined_usecases() {
        this(false);
    }
    
    public Tradecombined_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        bltradecombined.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return bltradecombined.count();
    }
    
    public ArrayList<Tradecombined> get_all() throws DBException {
        return bltradecombined.getTradecombineds();
    }
    
    public boolean getTradecombinedExists(ITradecombinedPK tradecombinedPK) throws DBException {
        return bltradecombined.getTradecombinedExists(tradecombinedPK);
    }
    
    public Tradecombined get_tradecombined_by_primarykey(ITradecombinedPK tradecombinedPK) throws DBException {
        return bltradecombined.getTradecombined(tradecombinedPK);
    }

    public ArrayList<Tradecombined> get_tradecombined_with_foreignkey_evetype(IEvetypePK evetypePK) throws CustomException {
        return bltradecombined.getTradecombineds4evetype(evetypePK);
    }
    
    public ArrayList<Tradecombined> get_tradecombined_with_foreignkey_systemBuy_system(ISystemPK systemBuy_systemPK) throws CustomException {
        return bltradecombined.getTradecombineds4systemBuy_system(systemBuy_systemPK);
    }
    
    public ArrayList<Tradecombined> get_tradecombined_with_foreignkey_systemSell_system(ISystemPK systemSell_systemPK) throws CustomException {
        return bltradecombined.getTradecombineds4systemSell_system(systemSell_systemPK);
    }
    
    public Tradecombined get_tradecombined_with_externalforeignkey_tradecombined_sell(ITradecombined_sellPK tradecombined_sellPK) throws CustomException {
        return bltradecombined.getTradecombined_sell(tradecombined_sellPK);
    }
    
    public ArrayList<Tradecombined> search_tradecombined(ITradecombinedsearch tradecombinedsearch) throws CustomException {
        return bltradecombined.search(tradecombinedsearch);
    }
    
    public long search_tradecombined_count(ITradecombinedsearch tradecombinedsearch) throws CustomException {
        return bltradecombined.searchcount(tradecombinedsearch);
    }

    public void insertTradecombined(ITradecombined tradecombined) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        bltradecombined.insertTradecombined(tq, tradecombined);
        sqlwriter.Commit2DB(tq);
    }

    public void updateTradecombined(ITradecombined tradecombined) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        bltradecombined.updateTradecombined(tq, tradecombined);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteTradecombined(ITradecombined tradecombined) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        bltradecombined.deleteTradecombined(tq, tradecombined);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Evetype(IEvetypePK evetypePK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        bltradecombined.delete4evetype(tq, evetypePK);
        sqlwriter.Commit2DB(tq);
    }
    
    public void delete_all_containing_Systembuy_system(ISystemPK systemBuy_systemPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        bltradecombined.delete4systemBuy_system(tq, systemBuy_systemPK);
        sqlwriter.Commit2DB(tq);
    }
    
    public void delete_all_containing_Systemsell_system(ISystemPK systemSell_systemPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        bltradecombined.delete4systemSell_system(tq, systemSell_systemPK);
        sqlwriter.Commit2DB(tq);
    }
    
}

