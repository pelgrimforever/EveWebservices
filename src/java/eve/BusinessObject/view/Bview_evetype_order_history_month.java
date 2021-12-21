/*
 * Bview_evetype_order_history_month.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 16.11.2021 15:46
 *
 */

package eve.BusinessObject.view;

import BusinessObject.BLview;
import db.SQLMapperFactory;
import data.gis.shape.*;
import db.SQLMapper_pgsql;
import eve.conversion.entity.EMview_evetype_order_history_month;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_evetype_order_history_month;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_evetype_order_history_month
 *
 * Superclass for manipulating data- and database objects
 * for View View_evetype_order_history_month and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_evetype_order_history_month extends BLview {

    /**
     * Constructor, sets View_evetype_order_history_month as default Entity
     */
    public Bview_evetype_order_history_month() {
        super(new View_evetype_order_history_month(), new EMview_evetype_order_history_month());
    }

    /**
     * get all View_evetype_order_history_month objects from database
     * @return ArrayList of View_evetype_order_history_month objects
     * @throws DBException
     */
    public ArrayList<View_evetype_order_history_month> getView_evetype_order_history_months() throws DBException {
        return getEntities(EMview_evetype_order_history_month.SQLSelectAll);
    }
}
