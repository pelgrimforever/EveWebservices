/*
 * Bview_bp_profitperregion.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 22.1.2022 8:34
 *
 */

package eve.BusinessObject.view;

import BusinessObject.BLview;
import db.SQLMapperFactory;
import data.gis.shape.*;
import db.SQLMapper_pgsql;
import eve.conversion.entity.EMview_bp_profitperregion;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_bp_profitperregion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_bp_profitperregion
 *
 * Superclass for manipulating data- and database objects
 * for View View_bp_profitperregion and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_bp_profitperregion extends BLview {

    /**
     * Constructor, sets View_bp_profitperregion as default Entity
     */
    public Bview_bp_profitperregion() {
        super(new View_bp_profitperregion(), new EMview_bp_profitperregion());
    }

    /**
     * get all View_bp_profitperregion objects from database
     * @return ArrayList of View_bp_profitperregion objects
     * @throws DBException
     */
    public ArrayList<View_bp_profitperregion> getView_bp_profitperregions() throws DBException {
        return getEntities(EMview_bp_profitperregion.SQLSelectAll);
    }
}
