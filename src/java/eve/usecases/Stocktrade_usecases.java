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
import eve.logicentity.Stocktrade;
import general.exception.*;
import java.sql.Date;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Stocktrade_usecases {

    private boolean loggedin = false;
    private BLstocktrade blstocktrade = new BLstocktrade();
    
    public Stocktrade_usecases() {
        this(false);
    }
    
    public Stocktrade_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blstocktrade.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blstocktrade.count();
    }
    
    public ArrayList<Stocktrade> get_all() throws DBException {
        return blstocktrade.getStocktrades();
    }
    
    public boolean getStocktradeExists(IStocktradePK stocktradePK) throws DBException {
        return blstocktrade.getEntityExists(stocktradePK);
    }
    
    public Stocktrade get_stocktrade_by_primarykey(IStocktradePK stocktradePK) throws DBException {
        return blstocktrade.getStocktrade(stocktradePK);
    }

    public ArrayList<Stocktrade> get_stocktrade_with_foreignkey_stock(IStockPK stockPK) throws CustomException {
        return blstocktrade.getStocktrades4stock(stockPK);
    }
    
    public ArrayList<Stocktrade> search_stocktrade(IStocktradesearch stocktradesearch) throws CustomException {
        return blstocktrade.search(stocktradesearch);
    }
    
    public long search_stocktrade_count(IStocktradesearch stocktradesearch) throws CustomException {
        return blstocktrade.searchcount(stocktradesearch);
    }

    public void secureinsertStocktrade(IStocktrade stocktrade) throws DBException, DataException {
        blstocktrade.secureinsertStocktrade(stocktrade);
    }

    public void secureupdateStocktrade(IStocktrade stocktrade) throws DBException, DataException {
        blstocktrade.secureupdateStocktrade(stocktrade);
    }

    public void securedeleteStocktrade(IStocktrade stocktrade) throws DBException, DataException {
        blstocktrade.securedeleteStocktrade(stocktrade);
    }
}

