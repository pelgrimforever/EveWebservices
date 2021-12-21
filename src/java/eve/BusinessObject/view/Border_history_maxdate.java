/*
 * Border_history_maxdate.java
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
import eve.conversion.entity.EMorder_history_maxdate;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.Order_history_maxdate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Border_history_maxdate
 *
 * Superclass for manipulating data- and database objects
 * for View Order_history_maxdate and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Border_history_maxdate extends BLview {

    /**
     * Constructor, sets Order_history_maxdate as default Entity
     */
    public Border_history_maxdate() {
        super(new Order_history_maxdate(), new EMorder_history_maxdate());
    }

    /**
     * get all Order_history_maxdate objects from database
     * @return ArrayList of Order_history_maxdate objects
     * @throws DBException
     */
    public ArrayList<Order_history_maxdate> getOrder_history_maxdates() throws DBException {
        return getEntities(EMorder_history_maxdate.SQLSelectAll);
    }
}
