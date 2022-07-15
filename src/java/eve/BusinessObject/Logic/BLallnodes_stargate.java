/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 15.11.2021 15:0
 */

package eve.BusinessObject.Logic;

import db.*;
import db.SQLTqueue;
import general.exception.DBException;
import eve.interfaces.logicentity.IAllnodes_stargate;
import eve.logicentity.Allnodes_stargate;
import eve.BusinessObject.table.Ballnodes_stargate;
import eve.conversion.entity.EMallnodes_stargate;
import general.exception.DataException;

/**
 * @author Franky Laseure
 */
public class BLallnodes_stargate extends Ballnodes_stargate {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    public BLallnodes_stargate(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public void reload(SQLTqueue transactionqueue) {
        addStatement(transactionqueue, EMallnodes_stargate.SQLcopyStargates);
    }
    
    public void markdeadends(SQLTqueue transactionqueue) {
        addStatement(transactionqueue, EMallnodes_stargate.SQLmarkdeadends);
    }
    
    public BLallnodes_stargate(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }

}
