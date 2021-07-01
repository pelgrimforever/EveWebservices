/*
 * BLview_systemtradeorders.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 27.5.2021 17:5
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import data.interfaces.db.View;
import db.AbstractSQLMapper;
import eve.logicview.View_systemtradeorders;
import eve.BusinessObject.view.Bview_systemtradeorders;
import eve.entity.pk.Security_islandPK;
import eve.interfaces.BusinessObject.IBLview_systemtradeorders;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLview_systemtradeorders
 *
 * Class for manipulating data- and database objects
 * for View View_systemtradeorders and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLview_systemtradeorders extends Bview_systemtradeorders implements IBLview_systemtradeorders {
//ProjectGenerator: NO AUTHOMATIC UPDATE
	
    /**
     * Constructor, sets View_systemtradeorders as default Entity
     */
    public BLview_systemtradeorders() {
    }

    @Override
    public void loadExtra(ResultSet dbresult, View view_systemtradeorders) throws SQLException {
        
    }
}
