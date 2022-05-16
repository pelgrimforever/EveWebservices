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
import eve.logicentity.Tradecombined_sell;
import eve.logicview.*;
import general.exception.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Tradecombined_sell_usecases {

    private boolean loggedin = false;
    private BLtradecombined_sell bltradecombined_sell = new BLtradecombined_sell();
    
    public Tradecombined_sell_usecases() {
        this(false);
    }
    
    public Tradecombined_sell_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        bltradecombined_sell.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return bltradecombined_sell.count();
    }
    
    public ArrayList<Tradecombined_sell> get_all() throws DBException {
        return bltradecombined_sell.getTradecombined_sells();
    }
    
    public boolean getTradecombined_sellExists(ITradecombined_sellPK tradecombined_sellPK) throws DBException {
        return bltradecombined_sell.getEntityExists(tradecombined_sellPK);
    }
    
    public Tradecombined_sell get_tradecombined_sell_by_primarykey(ITradecombined_sellPK tradecombined_sellPK) throws DBException {
        return bltradecombined_sell.getTradecombined_sell(tradecombined_sellPK);
    }

    public ArrayList<Tradecombined_sell> get_tradecombined_sell_with_foreignkey_ordersBuy_order_id(IOrdersPK ordersBuy_order_idPK) throws CustomException {
        return bltradecombined_sell.getTradecombined_sells4ordersBuy_order_id(ordersBuy_order_idPK);
    }
    
    public ArrayList<Tradecombined_sell> get_tradecombined_sell_with_foreignkey_ordersSell_order_id(IOrdersPK ordersSell_order_idPK) throws CustomException {
        return bltradecombined_sell.getTradecombined_sells4ordersSell_order_id(ordersSell_order_idPK);
    }
    
    public ArrayList<Tradecombined_sell> get_tradecombined_sell_with_foreignkey_tradecombined(ITradecombinedPK tradecombinedPK) throws CustomException {
        return bltradecombined_sell.getTradecombined_sells4tradecombined(tradecombinedPK);
    }
    
    public ArrayList<Tradecombined_sell> search_tradecombined_sell(ITradecombined_sellsearch tradecombined_sellsearch) throws ParseException, CustomException {
        return bltradecombined_sell.search(tradecombined_sellsearch);
    }
    
    public long search_tradecombined_sell_count(ITradecombined_sellsearch tradecombined_sellsearch) throws ParseException, CustomException {
        return bltradecombined_sell.searchcount(tradecombined_sellsearch);
    }

    public void secureinsertTradecombined_sell(ITradecombined_sell tradecombined_sell) throws DBException, DataException {
        bltradecombined_sell.secureinsertTradecombined_sell(tradecombined_sell);
    }

    public void secureupdateTradecombined_sell(ITradecombined_sell tradecombined_sell) throws DBException, DataException {
        bltradecombined_sell.secureupdateTradecombined_sell(tradecombined_sell);
    }

    public void securedeleteTradecombined_sell(ITradecombined_sell tradecombined_sell) throws DBException, DataException {
        bltradecombined_sell.securedeleteTradecombined_sell(tradecombined_sell);
    }
}

