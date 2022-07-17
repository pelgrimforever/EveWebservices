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
import eve.logicentity.Stocktrade;
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
public class Stocktrade_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLstocktrade blstocktrade = new BLstocktrade(sqlreader);
    
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
        return blstocktrade.getStocktradeExists(stocktradePK);
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

    public void insertStocktrade(IStocktrade stocktrade) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blstocktrade.insertStocktrade(tq, stocktrade);
        sqlwriter.Commit2DB(tq);
    }

    public void updateStocktrade(IStocktrade stocktrade) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blstocktrade.updateStocktrade(tq, stocktrade);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteStocktrade(IStocktrade stocktrade) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blstocktrade.deleteStocktrade(tq, stocktrade);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Stock(IStockPK stockPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blstocktrade.delete4stock(tq, stockPK);
        sqlwriter.Commit2DB(tq);
    }
    
}

