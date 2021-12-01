/*
 * Bview_systemtradeorders.java
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
import eve.conversion.entity.EMview_systemtradeorders;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_systemtradeorders;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_systemtradeorders
 *
 * Superclass for manipulating data- and database objects
 * for View View_systemtradeorders and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_systemtradeorders extends BLview {

    /**
     * Constructor, sets View_systemtradeorders as default Entity
     */
    public Bview_systemtradeorders() {
        super(new View_systemtradeorders(), new EMview_systemtradeorders());
    }

    /**
     * get all View_systemtradeorders objects from database
     * @return ArrayList of View_systemtradeorders objects
     * @throws DBException
     */
    public ArrayList<View_systemtradeorders> getView_systemtradeorderss() throws DBException {
        return getEntities(EMview_systemtradeorders.SQLSelectAll);
    }
}
