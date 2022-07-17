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
import eve.logicentity.Tradecombined_sell;
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
public class Tradecombined_sell_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLtradecombined_sell bltradecombined_sell = new BLtradecombined_sell(sqlreader);
    
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
        return bltradecombined_sell.getTradecombined_sellExists(tradecombined_sellPK);
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
    
    public ArrayList<Tradecombined_sell> search_tradecombined_sell(ITradecombined_sellsearch tradecombined_sellsearch) throws CustomException {
        return bltradecombined_sell.search(tradecombined_sellsearch);
    }
    
    public long search_tradecombined_sell_count(ITradecombined_sellsearch tradecombined_sellsearch) throws CustomException {
        return bltradecombined_sell.searchcount(tradecombined_sellsearch);
    }

    public void insertTradecombined_sell(ITradecombined_sell tradecombined_sell) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        bltradecombined_sell.insertTradecombined_sell(tq, tradecombined_sell);
        sqlwriter.Commit2DB(tq);
    }

    public void updateTradecombined_sell(ITradecombined_sell tradecombined_sell) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        bltradecombined_sell.updateTradecombined_sell(tq, tradecombined_sell);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteTradecombined_sell(ITradecombined_sell tradecombined_sell) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        bltradecombined_sell.deleteTradecombined_sell(tq, tradecombined_sell);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Ordersbuy_order_id(IOrdersPK ordersBuy_order_idPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        bltradecombined_sell.delete4ordersBuy_order_id(tq, ordersBuy_order_idPK);
        sqlwriter.Commit2DB(tq);
    }
    
    public void delete_all_containing_Orderssell_order_id(IOrdersPK ordersSell_order_idPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        bltradecombined_sell.delete4ordersSell_order_id(tq, ordersSell_order_idPK);
        sqlwriter.Commit2DB(tq);
    }
    
    public void delete_all_containing_Tradecombined(ITradecombinedPK tradecombinedPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        bltradecombined_sell.delete4tradecombined(tq, tradecombinedPK);
        sqlwriter.Commit2DB(tq);
    }
    
}

