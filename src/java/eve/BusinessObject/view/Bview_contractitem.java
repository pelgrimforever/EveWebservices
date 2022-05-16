/*
 * Bview_contractitem.java
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
import eve.conversion.entity.EMview_contractitem;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_contractitem;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_contractitem
 *
 * Superclass for manipulating data- and database objects
 * for View View_contractitem and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_contractitem extends BLview {

    /**
     * Constructor, sets View_contractitem as default Entity
     */
    public Bview_contractitem() {
        super(new View_contractitem(), new EMview_contractitem());
    }

    /**
     * get all View_contractitem objects from database
     * @return ArrayList of View_contractitem objects
     * @throws DBException
     */
    public ArrayList<View_contractitem> getView_contractitems() throws DBException {
        return getEntities(EMview_contractitem.SQLSelectAll);
    }
}
