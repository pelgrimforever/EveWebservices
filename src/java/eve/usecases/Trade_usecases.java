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
import eve.logicentity.Trade;
import general.exception.*;
import java.sql.Date;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Trade_usecases {

    private boolean loggedin = false;
    private BLtrade bltrade = new BLtrade();
    
    public Trade_usecases() {
        this(false);
    }
    
    public Trade_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        bltrade.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
    public void executetrade(ITradePK tradePK, long volume) throws DBException, DataException {
        bltrade.executetrade(tradePK, volume);
    }
//Custom code, do not change this line   

    public long count() throws DBException {
        return bltrade.count();
    }
    
    public ArrayList<Trade> get_all() throws DBException {
        return bltrade.getTrades();
    }
    
    public boolean getTradeExists(ITradePK tradePK) throws DBException {
        return bltrade.getEntityExists(tradePK);
    }
    
    public Trade get_trade_by_primarykey(ITradePK tradePK) throws DBException {
        return bltrade.getTrade(tradePK);
    }

    public ArrayList<Trade> get_trade_with_foreignkey_ordersSell_order_id(IOrdersPK ordersSell_order_idPK) throws CustomException {
        return bltrade.getTrades4ordersSell_order_id(ordersSell_order_idPK);
    }
    
    public ArrayList<Trade> get_trade_with_foreignkey_ordersBuy_order_id(IOrdersPK ordersBuy_order_idPK) throws CustomException {
        return bltrade.getTrades4ordersBuy_order_id(ordersBuy_order_idPK);
    }
    
    public ArrayList<Trade> search_trade(ITradesearch tradesearch) throws CustomException {
        return bltrade.search(tradesearch);
    }
    
    public long search_trade_count(ITradesearch tradesearch) throws CustomException {
        return bltrade.searchcount(tradesearch);
    }

    public void secureinsertTrade(ITrade trade) throws DBException, DataException {
        bltrade.secureinsertTrade(trade);
    }

    public void secureupdateTrade(ITrade trade) throws DBException, DataException {
        bltrade.secureupdateTrade(trade);
    }

    public void securedeleteTrade(ITrade trade) throws DBException, DataException {
        bltrade.securedeleteTrade(trade);
    }
}

