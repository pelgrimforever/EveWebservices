/*
 * Bview_userbp.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 28.0.2022 15:57
 *
 */

package eve.BusinessObject.view;

import BusinessObject.BLview;
import db.SQLMapperFactory;
import data.gis.shape.*;
import db.SQLMapper_pgsql;
import eve.conversion.entity.EMview_userbp;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_userbp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_userbp
 *
 * Superclass for manipulating data- and database objects
 * for View View_userbp and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_userbp extends BLview {

    /**
     * Constructor, sets View_userbp as default Entity
     */
    public Bview_userbp() {
        super(new View_userbp(), new EMview_userbp());
    }

    /**
     * get all View_userbp objects from database
     * @return ArrayList of View_userbp objects
     * @throws DBException
     */
    public ArrayList<View_userbp> getView_userbps() throws DBException {
        return getEntities(EMview_userbp.SQLSelectAll);
    }
}
