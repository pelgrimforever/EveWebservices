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
import eve.logicentity.Tradecombined;
import eve.logicview.*;
import general.exception.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Tradecombined_usecases {

    private boolean loggedin = false;
    private BLtradecombined bltradecombined = new BLtradecombined();
    
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
        return bltradecombined.getEntityExists(tradecombinedPK);
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
    
    public ArrayList<Tradecombined> search_tradecombined(ITradecombinedsearch tradecombinedsearch) throws ParseException, CustomException {
        return bltradecombined.search(tradecombinedsearch);
    }
    
    public long search_tradecombined_count(ITradecombinedsearch tradecombinedsearch) throws ParseException, CustomException {
        return bltradecombined.searchcount(tradecombinedsearch);
    }

    public void secureinsertTradecombined(ITradecombined tradecombined) throws DBException, DataException {
        bltradecombined.secureinsertTradecombined(tradecombined);
    }

    public void secureupdateTradecombined(ITradecombined tradecombined) throws DBException, DataException {
        bltradecombined.secureupdateTradecombined(tradecombined);
    }

    public void securedeleteTradecombined(ITradecombined tradecombined) throws DBException, DataException {
        bltradecombined.securedeleteTradecombined(tradecombined);
    }
}

