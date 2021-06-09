/*
 * BLview_order_region_evetype.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 22.4.2021 16:36
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import data.interfaces.db.View;
import eve.interfaces.logicview.IView_order_region_evetype;
import eve.logicview.View_order_region_evetype;
import eve.BusinessObject.view.Bview_order_region_evetype;
import eve.interfaces.BusinessObject.IBLview_order_region_evetype;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Business Logic Entity class BLview_order_region_evetype
 *
 * Class for manipulating data- and database objects
 * for View View_order_region_evetype and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLview_order_region_evetype extends Bview_order_region_evetype implements IBLview_order_region_evetype {
//ProjectGenerator: NO AUTHOMATIC UPDATE
	
    /**
     * Constructor, sets View_order_region_evetype as default Entity
     */
    public BLview_order_region_evetype() {
    }

    @Override
    public void loadExtra(ResultSet dbresult, View view_order_region_evetype) throws SQLException {
        
    }
    
}
