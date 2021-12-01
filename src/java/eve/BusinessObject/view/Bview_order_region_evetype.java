/*
 * Bview_order_region_evetype.java
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
import eve.conversion.entity.EMview_order_region_evetype;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_order_region_evetype;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_order_region_evetype
 *
 * Superclass for manipulating data- and database objects
 * for View View_order_region_evetype and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_order_region_evetype extends BLview {

    /**
     * Constructor, sets View_order_region_evetype as default Entity
     */
    public Bview_order_region_evetype() {
        super(new View_order_region_evetype(), new EMview_order_region_evetype());
    }

    /**
     * get all View_order_region_evetype objects from database
     * @return ArrayList of View_order_region_evetype objects
     * @throws DBException
     */
    public ArrayList<View_order_region_evetype> getView_order_region_evetypes() throws DBException {
        return getEntities(EMview_order_region_evetype.SQLSelectAll);
    }
}
