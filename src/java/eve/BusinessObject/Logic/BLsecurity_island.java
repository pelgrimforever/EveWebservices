/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 24.4.2021 17:5
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import eve.interfaces.logicentity.ISecurity_island;
import eve.logicentity.Security_island;
import db.*;
import db.SQLTqueue;
import eve.BusinessObject.table.Bsecurity_island;
import eve.conversion.entity.EMsecurity_island;
import eve.conversion.entity.EMsystem;
import general.exception.DataException;

/**
 * @author Franky Laseure
 */
public class BLsecurity_island extends Bsecurity_island {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    public BLsecurity_island(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public BLsecurity_island(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }

    public void deleteAll(SQLTqueue transactionqueue) throws DBException, DataException {
        addStatement(transactionqueue, EMsystem.SQLRemoveSecurityIslands);
        addStatement(transactionqueue, EMsecurity_island.SQLDeleteAll);
    }
    
}
