/*
 * Bview_stocktrade_orders.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 24.9.2021 14:40
 *
 */

package eve.BusinessObject.view;

import BusinessObject.BLview;
import db.SQLMapperFactory;
import data.gis.shape.*;
import db.SQLMapper_pgsql;
import eve.conversion.entity.EMview_stocktrade_orders;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_stocktrade_orders;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_stocktrade_orders
 *
 * Superclass for manipulating data- and database objects
 * for View View_stocktrade_orders and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_stocktrade_orders extends BLview {

    /**
     * Constructor, sets View_stocktrade_orders as default Entity
     */
    public Bview_stocktrade_orders() {
        super(new View_stocktrade_orders(), new EMview_stocktrade_orders());
    }

    /**
     * get all View_stocktrade_orders objects from database
     * @return ArrayList of View_stocktrade_orders objects
     * @throws DBException
     */
    public ArrayList<View_stocktrade_orders> getView_stocktrade_orderss() throws DBException {
        return getEntities(EMview_stocktrade_orders.SQLSelectAll);
    }
}
