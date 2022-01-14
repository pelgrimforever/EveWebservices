/*
 * Bview_stock.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 14.0.2022 16:56
 *
 */

package eve.BusinessObject.view;

import BusinessObject.BLview;
import db.SQLMapperFactory;
import data.gis.shape.*;
import db.SQLMapper_pgsql;
import eve.conversion.entity.EMview_stock;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_stock;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_stock
 *
 * Superclass for manipulating data- and database objects
 * for View View_stock and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_stock extends BLview {

    /**
     * Constructor, sets View_stock as default Entity
     */
    public Bview_stock() {
        super(new View_stock(), new EMview_stock());
    }

    /**
     * get all View_stock objects from database
     * @return ArrayList of View_stock objects
     * @throws DBException
     */
    public ArrayList<View_stock> getView_stocks() throws DBException {
        return getEntities(EMview_stock.SQLSelectAll);
    }
}
