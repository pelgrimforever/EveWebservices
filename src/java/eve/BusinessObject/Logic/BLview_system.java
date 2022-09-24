/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 30.11.2021 19:35
 * @author Franky Laseure
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import db.*;
import eve.logicview.View_system;
import eve.BusinessObject.view.Bview_system;
import eve.conversion.entity.EMview_system;

public class BLview_system extends Bview_system {
//Metacoder: NO AUTHOMATIC UPDATE
	
    public BLview_system(SQLreader sqlreader) {
        super(sqlreader);
    }
    
    public View_system getView_systems(long systemstart, long systemend) throws DBException {
        Object[][] parameters = {{ "system_start", systemstart }, { "system_end", systemend }};
        SQLparameters sqlparameters = new SQLparameters(parameters);
        return (View_system)viewio.getEntity(EMview_system.SQLSelect4startend, sqlparameters);
    }

}
