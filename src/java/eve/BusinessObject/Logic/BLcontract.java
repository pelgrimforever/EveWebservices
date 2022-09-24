/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 2.0.2022 18:23
 * @author Franky Laseure
 */

package eve.BusinessObject.Logic;

import db.*;
import db.*;
import db.SQLTqueue;
import general.exception.DBException;
import eve.interfaces.logicentity.IContract;
import eve.logicentity.Contract;
import eve.BusinessObject.table.Bcontract;
import eve.conversion.entity.EMcontract;
import eve.conversion.entity.EMcontractitem;
import eve.entity.pk.RegionPK;
import general.exception.DataException;
import java.util.ArrayList;

public class BLcontract extends Bcontract {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    public BLcontract(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public BLcontract(TableBusinessrules businessrules) {
        super(businessrules);
        setLogginrequired(isprivatetable);
    }

    public ArrayList getContracts_for_region(RegionPK regionPK) throws DBException {
        return getEntities(EMcontract.SQLSelect4Region, regionPK.getSQLprimarykey());
    }
    
    public ArrayList getItem_exchanges() throws DBException {
        Object[][] parameters = {{ "type", "item_exchange" }};
        SQLparameters sqlparameters = new SQLparameters(parameters);
        return getEntities(EMcontract.SQLcontracts4type, sqlparameters);
    }
    
    public void deletecontracts(SQLTqueue transactionqueue) throws DBException {
        addStatement(transactionqueue, EMcontract.SQLtruncate);
    }
    
    public void deactivatecontracts(SQLTqueue transactionqueue) throws DBException {
        addStatement(transactionqueue, EMcontract.SQLdeactivate);
    }
    
    public void deletedeactivatedcontracts(SQLTqueue transactionqueue) throws DBException {
        addStatement(transactionqueue, EMcontractitem.SQLdeletedeactivateditems);
        addStatement(transactionqueue, EMcontract.SQLdeletedeactivatedcontacts);
    }
    
}
