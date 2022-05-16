/*
 * Bview_order.java
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
import eve.conversion.entity.EMview_order;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_order;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_order
 *
 * Superclass for manipulating data- and database objects
 * for View View_order and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_order extends BLview {

    /**
     * Constructor, sets View_order as default Entity
     */
    public Bview_order() {
        super(new View_order(), new EMview_order());
    }

    /**
     * get all View_order objects from database
     * @return ArrayList of View_order objects
     * @throws DBException
     */
    public ArrayList<View_order> getView_orders() throws DBException {
        return getEntities(EMview_order.SQLSelectAll);
    }
}
