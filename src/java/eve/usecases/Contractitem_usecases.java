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
import eve.logicentity.Contractitem;
import eve.logicview.*;
import general.exception.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Contractitem_usecases {

    private boolean loggedin = false;
    private BLcontractitem blcontractitem = new BLcontractitem();
    
    public Contractitem_usecases() {
        this(false);
    }
    
    public Contractitem_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blcontractitem.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blcontractitem.count();
    }
    
    public ArrayList<Contractitem> get_all() throws DBException {
        return blcontractitem.getContractitems();
    }
    
    public boolean getContractitemExists(IContractitemPK contractitemPK) throws DBException {
        return blcontractitem.getEntityExists(contractitemPK);
    }
    
    public Contractitem get_contractitem_by_primarykey(IContractitemPK contractitemPK) throws DBException {
        return blcontractitem.getContractitem(contractitemPK);
    }

    public ArrayList<Contractitem> get_contractitem_with_foreignkey_evetype(IEvetypePK evetypePK) throws CustomException {
        return blcontractitem.getContractitems4evetype(evetypePK);
    }
    
    public ArrayList<Contractitem> get_contractitem_with_foreignkey_contract(IContractPK contractPK) throws CustomException {
        return blcontractitem.getContractitems4contract(contractPK);
    }
    
    public ArrayList<Contractitem> search_contractitem(IContractitemsearch contractitemsearch) throws ParseException, CustomException {
        return blcontractitem.search(contractitemsearch);
    }
    
    public long search_contractitem_count(IContractitemsearch contractitemsearch) throws ParseException, CustomException {
        return blcontractitem.searchcount(contractitemsearch);
    }

    public void secureinsertContractitem(IContractitem contractitem) throws DBException, DataException {
        blcontractitem.secureinsertContractitem(contractitem);
    }

    public void secureupdateContractitem(IContractitem contractitem) throws DBException, DataException {
        blcontractitem.secureupdateContractitem(contractitem);
    }

    public void securedeleteContractitem(IContractitem contractitem) throws DBException, DataException {
        blcontractitem.securedeleteContractitem(contractitem);
    }
}

