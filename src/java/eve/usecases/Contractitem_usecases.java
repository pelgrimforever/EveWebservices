/*
 * Generated on 13.6.2022 11:21
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
import eve.logicentity.Contractitem;
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
public class Contractitem_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLcontractitem blcontractitem = new BLcontractitem(sqlreader);
    
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
        return blcontractitem.getContractitemExists(contractitemPK);
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
    
    public ArrayList<Contractitem> search_contractitem(IContractitemsearch contractitemsearch) throws CustomException {
        return blcontractitem.search(contractitemsearch);
    }
    
    public long search_contractitem_count(IContractitemsearch contractitemsearch) throws CustomException {
        return blcontractitem.searchcount(contractitemsearch);
    }

    public void insertContractitem(IContractitem contractitem) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blcontractitem.insertContractitem(tq, contractitem);
        sqlwriter.Commit2DB(tq);
    }

    public void updateContractitem(IContractitem contractitem) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blcontractitem.updateContractitem(tq, contractitem);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteContractitem(IContractitem contractitem) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blcontractitem.deleteContractitem(tq, contractitem);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Evetype(IEvetypePK evetypePK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blcontractitem.delete4evetype(tq, evetypePK);
        sqlwriter.Commit2DB(tq);
    }
    
    public void delete_all_containing_Contract(IContractPK contractPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blcontractitem.delete4contract(tq, contractPK);
        sqlwriter.Commit2DB(tq);
    }
    
}

