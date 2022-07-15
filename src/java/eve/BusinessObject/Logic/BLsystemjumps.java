/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 3.5.2021 14:39
 */

package eve.BusinessObject.Logic;

import db.*;
import db.*;
import db.SQLTqueue;
import eve.BusinessObject.table.Bsystemjumps;
import eve.conversion.entity.EMsystemjumps;
import eve.interfaces.logicentity.ISystemjumps;
import eve.logicentity.Systemjumps;
import general.exception.DBException;
import general.exception.DataException;
import java.util.ArrayList;

/**
 * @author Franky Laseure
 */
public class BLsystemjumps extends Bsystemjumps {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    public BLsystemjumps(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public BLsystemjumps(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }



    public void createsystemjumps(SQLTqueue transactionqueue) throws DBException {
        addStatement(transactionqueue, EMsystemjumps.SQLDeleteall);
        addStatement(transactionqueue, EMsystemjumps.SQLcreatesystemjumpslowsec);
    }
    
    public void set0jumpsto1(SQLTqueue transactionqueue) throws DBException {
        addStatement(transactionqueue, EMsystemjumps.SQLset0jumpsto1);
    }

    public ArrayList getSystemjumps4shiporderselected(String username, long system1, long system2) throws DBException {
        Object[][] parameteruser = {{ "username", username }};
        SQLparameters sqlparameters = new SQLparameters(parameteruser);
        ArrayList systemjumpspermutations = getEntities(EMsystemjumps.SQLSelect4shipfitorderselectedpermutations, sqlparameters);
        Object[][] parametersystems = {{ "system1", system1 }, { "system2", system2 } };
        sqlparameters = new SQLparameters(parametersystems, parameteruser);
        ArrayList systemjumps = getEntities(EMsystemjumps.SQLSelect4shipfitorderselected, sqlparameters);
        systemjumpspermutations.addAll(systemjumps);
        return systemjumpspermutations;
    }
    
}
