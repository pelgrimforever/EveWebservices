/*
 * BLview_systemtrade.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 29.5.2021 13:26
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import data.interfaces.db.View;
import eve.interfaces.logicview.IView_systemtrade;
import eve.logicview.View_systemtrade;
import eve.BusinessObject.view.Bview_systemtrade;
import eve.interfaces.BusinessObject.IBLview_systemtrade;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Business Logic Entity class BLview_systemtrade
 *
 * Class for manipulating data- and database objects
 * for View View_systemtrade and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLview_systemtrade extends Bview_systemtrade implements IBLview_systemtrade {
//ProjectGenerator: NO AUTHOMATIC UPDATE
	
    /**
     * Constructor, sets View_systemtrade as default Entity
     */
    public BLview_systemtrade() {
    }

    @Override
    public void loadExtra(ResultSet dbresult, View view_systemtrade) throws SQLException {
        
    }
    
}
