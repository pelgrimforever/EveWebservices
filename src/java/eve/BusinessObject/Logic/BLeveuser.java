/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 13.1.2022 17:48
 */

package eve.BusinessObject.Logic;

import db.SQLTqueue;
import db.*;
import general.exception.DBException;
import eve.interfaces.logicentity.IEveuser;
import eve.logicentity.Eveuser;
import eve.BusinessObject.table.Beveuser;
import general.exception.DataException;
import java.sql.Date;

/**
 * @author Franky Laseure
 */
public class BLeveuser extends Beveuser {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = true; //set this to true if only a loggin account has access to this data
	
    public BLeveuser(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public BLeveuser(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }

    @Override
    public void insertEveuser(SQLTqueue transactionqueue, IEveuser eveuser) throws DBException, DataException {
        eveuser.setCreatedat(new Date(System.currentTimeMillis()));
        tableio.insertEntity(transactionqueue, eveuser);
    }
}
