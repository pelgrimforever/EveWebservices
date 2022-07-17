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
import eve.logicentity.Market_group;
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
public class Market_group_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLmarket_group blmarket_group = new BLmarket_group(sqlreader);
    
    public Market_group_usecases() {
        this(false);
    }
    
    public Market_group_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blmarket_group.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blmarket_group.count();
    }
    
    public ArrayList<Market_group> get_all() throws DBException {
        return blmarket_group.getMarket_groups();
    }
    
    public boolean getMarket_groupExists(IMarket_groupPK market_groupPK) throws DBException {
        return blmarket_group.getMarket_groupExists(market_groupPK);
    }
    
    public Market_group get_market_group_by_primarykey(IMarket_groupPK market_groupPK) throws DBException {
        return blmarket_group.getMarket_group(market_groupPK);
    }

    public ArrayList<Market_group> get_market_group_with_foreignkey_market_groupParent_id(IMarket_groupPK market_groupParent_idPK) throws CustomException {
        return blmarket_group.getMarket_groups4market_groupParent_id(market_groupParent_idPK);
    }
    
    public ArrayList<Market_group> search_market_group(IMarket_groupsearch market_groupsearch) throws CustomException {
        return blmarket_group.search(market_groupsearch);
    }
    
    public long search_market_group_count(IMarket_groupsearch market_groupsearch) throws CustomException {
        return blmarket_group.searchcount(market_groupsearch);
    }

    public void insertMarket_group(IMarket_group market_group) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blmarket_group.insertMarket_group(tq, market_group);
        sqlwriter.Commit2DB(tq);
    }

    public void updateMarket_group(IMarket_group market_group) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blmarket_group.updateMarket_group(tq, market_group);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteMarket_group(IMarket_group market_group) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blmarket_group.deleteMarket_group(tq, market_group);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Market_groupparent_id(IMarket_groupPK market_groupParent_idPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blmarket_group.delete4market_groupParent_id(tq, market_groupParent_idPK);
        sqlwriter.Commit2DB(tq);
    }
    
}

