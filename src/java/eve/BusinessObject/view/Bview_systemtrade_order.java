/*
 * Bview_systemtrade_order.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 30.10.2021 10:3
 *
 */

package eve.BusinessObject.view;

import BusinessObject.BLview;
import db.SQLMapperFactory;
import data.gis.shape.*;
import db.SQLMapper_pgsql;
import eve.conversion.entity.EMview_systemtrade_order;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_systemtrade_order;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_systemtrade_order
 *
 * Superclass for manipulating data- and database objects
 * for View View_systemtrade_order and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_systemtrade_order extends BLview {

    /**
     * Constructor, sets View_systemtrade_order as default Entity
     */
    public Bview_systemtrade_order() {
        super(new View_systemtrade_order(), new EMview_systemtrade_order());
    }

    /**
     * get all View_systemtrade_order objects from database
     * @return ArrayList of View_systemtrade_order objects
     * @throws DBException
     */
    public ArrayList<View_systemtrade_order> getView_systemtrade_orders() throws DBException {
        return getEntities(EMview_systemtrade_order.SQLSelectAll);
    }
}
