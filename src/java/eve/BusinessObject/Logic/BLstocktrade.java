/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 24.7.2021 17:21
 * @author Franky Laseure
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import eve.interfaces.logicentity.IStocktrade;
import eve.logicentity.Stocktrade;
import db.*;
import db.*;
import db.SQLTqueue;
import eve.BusinessObject.table.Bstocktrade;
import eve.conversion.entity.EMstocktrade;
import general.exception.DataException;
import java.util.ArrayList;

public class BLstocktrade extends Bstocktrade {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    public BLstocktrade(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public BLstocktrade(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }



    public ArrayList get4System(String username, long systemid) throws DBException {
        Object[][] parameters = {{ "username", username }, { "system", systemid }};
        SQLparameters sqlparameters = new SQLparameters(parameters);
        return getEntities(EMstocktrade.SQL4usersystem, sqlparameters);
    }
    
    public void deletestocktrade(SQLTqueue transactionqueue, String username) throws DBException, DataException {
        Object[][] parameters = {{ "username", username }};
        SQLparameters sqlparameters = new SQLparameters(parameters);
        addStatement(transactionqueue, EMstocktrade.SQLdelete4user, sqlparameters);
    }

    public void deletestocktrade(SQLTqueue transactionqueue) throws DBException, DataException {
        addStatement(transactionqueue, EMstocktrade.SQLdeleteall);
    }
    
}
