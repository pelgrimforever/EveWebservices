/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 24.4.2021 15:45
 * @author Franky Laseure
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import eve.interfaces.logicentity.IConstellation_neighbour;
import eve.logicentity.Constellation_neighbour;
import db.*;
import db.SQLTqueue;
import eve.BusinessObject.table.Bconstellation_neighbour;
import eve.conversion.entity.EMconstellation_neighbour;
import general.exception.DataException;

public class BLconstellation_neighbour extends Bconstellation_neighbour {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    public BLconstellation_neighbour(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public BLconstellation_neighbour(TableBusinessrules businessrules) {
        super(businessrules);
        setLogginrequired(isprivatetable);
    }

    public void createneighbours(SQLTqueue transactionqueue) throws DBException, DataException {
        tableio.addStatement(transactionqueue, EMconstellation_neighbour.SQLDeleteAll);
        tableio.addStatement(transactionqueue, EMconstellation_neighbour.SQLcreateneighours);
    }

}
