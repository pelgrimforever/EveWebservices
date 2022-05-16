/*
 * Bview_evetype_order_history_region_month.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 11.4.2022 9:13
 *
 */

package eve.BusinessObject.view;

import BusinessObject.BLview;
import db.SQLMapperFactory;
import data.gis.shape.*;
import db.SQLMapper_pgsql;
import eve.conversion.entity.EMview_evetype_order_history_region_month;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_evetype_order_history_region_month;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_evetype_order_history_region_month
 *
 * Superclass for manipulating data- and database objects
 * for View View_evetype_order_history_region_month and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_evetype_order_history_region_month extends BLview {

    /**
     * Constructor, sets View_evetype_order_history_region_month as default Entity
     */
    public Bview_evetype_order_history_region_month() {
        super(new View_evetype_order_history_region_month(), new EMview_evetype_order_history_region_month());
    }

    /**
     * get all View_evetype_order_history_region_month objects from database
     * @return ArrayList of View_evetype_order_history_region_month objects
     * @throws DBException
     */
    public ArrayList<View_evetype_order_history_region_month> getView_evetype_order_history_region_months() throws DBException {
        return getEntities(EMview_evetype_order_history_region_month.SQLSelectAll);
    }
}
