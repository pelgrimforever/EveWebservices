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
import eve.logicentity.Market_group;
import eve.logicview.*;
import general.exception.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Market_group_usecases {

    private boolean loggedin = false;
    private BLmarket_group blmarket_group = new BLmarket_group();
    
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
        return blmarket_group.getEntityExists(market_groupPK);
    }
    
    public Market_group get_market_group_by_primarykey(IMarket_groupPK market_groupPK) throws DBException {
        return blmarket_group.getMarket_group(market_groupPK);
    }

    public ArrayList<Market_group> get_market_group_with_foreignkey_market_groupParent_id(IMarket_groupPK market_groupParent_idPK) throws CustomException {
        return blmarket_group.getMarket_groups4market_groupParent_id(market_groupParent_idPK);
    }
    
    public ArrayList<Market_group> search_market_group(IMarket_groupsearch market_groupsearch) throws ParseException, CustomException {
        return blmarket_group.search(market_groupsearch);
    }
    
    public long search_market_group_count(IMarket_groupsearch market_groupsearch) throws ParseException, CustomException {
        return blmarket_group.searchcount(market_groupsearch);
    }

    public void secureinsertMarket_group(IMarket_group market_group) throws DBException, DataException {
        blmarket_group.secureinsertMarket_group(market_group);
    }

    public void secureupdateMarket_group(IMarket_group market_group) throws DBException, DataException {
        blmarket_group.secureupdateMarket_group(market_group);
    }

    public void securedeleteMarket_group(IMarket_group market_group) throws DBException, DataException {
        blmarket_group.securedeleteMarket_group(market_group);
    }
}

