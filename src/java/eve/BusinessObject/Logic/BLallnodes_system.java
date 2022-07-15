/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 15.11.2021 15:0
 */

package eve.BusinessObject.Logic;

import db.*;
import db.SQLTqueue;
import general.exception.DBException;
import eve.interfaces.logicentity.IAllnodes_system;
import eve.logicentity.Allnodes_system;
import eve.BusinessObject.table.Ballnodes_system;
import eve.conversion.entity.EMallnodes_system;
import general.exception.DataException;

/**
 * @author Franky Laseure
 */
public class BLallnodes_system extends Ballnodes_system {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    public BLallnodes_system(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public void reload(SQLTqueue transactionqueue) {
        addStatement(transactionqueue, EMallnodes_system.SQLdeleteAll);
        addStatement(transactionqueue, EMallnodes_system.SQLcopySystems);
    }
    
    public void markdeadends(SQLTqueue transactionqueue) {
        addStatement(transactionqueue, EMallnodes_system.SQLmarkdeadends);
    }
    
    public long getDeadendscount() throws DBException {
        return count(EMallnodes_system.SQLgetdeadends, null);
    }
    
    public BLallnodes_system(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }

}
