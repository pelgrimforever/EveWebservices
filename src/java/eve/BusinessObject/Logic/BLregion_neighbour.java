/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 24.4.2021 15:45
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import eve.interfaces.logicentity.IRegion_neighbour;
import eve.logicentity.Region_neighbour;
import db.*;
import db.SQLTqueue;
import eve.BusinessObject.table.Bregion_neighbour;
import eve.conversion.entity.EMregion_neighbour;
import general.exception.DataException;

/**
 * @author Franky Laseure
 */
public class BLregion_neighbour extends Bregion_neighbour {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    public BLregion_neighbour(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public BLregion_neighbour(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }

    public void createneighbours(SQLTqueue transactionqueue) throws DBException, DataException {
        addStatement(transactionqueue, EMregion_neighbour.SQLDeleteAll);
        addStatement(transactionqueue, EMregion_neighbour.SQLcreateneighours);
    }

}
