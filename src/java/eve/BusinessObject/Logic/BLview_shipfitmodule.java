/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 18.11.2021 16:29
 */

package eve.BusinessObject.Logic;

import db.*;
import eve.BusinessObject.view.Bview_shipfitmodule;
import eve.conversion.entity.EMview_shipfitmodule;
import general.exception.DBException;
import java.util.ArrayList;

/**
 * @author Franky Laseure
 */
public class BLview_shipfitmodule extends Bview_shipfitmodule {
//Metacoder: NO AUTHOMATIC UPDATE
	
    public BLview_shipfitmodule(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public ArrayList getview_shipfitmodules(String username, String shipname) throws DBException {
        Object[][] parameters = { { "username", username }, { "shipname", shipname } };
        SQLparameters sqlparameters = new SQLparameters(parameters);
        return viewio.getEntities(EMview_shipfitmodule.SQLSelect4shipfit, sqlparameters);
    }
    
}
