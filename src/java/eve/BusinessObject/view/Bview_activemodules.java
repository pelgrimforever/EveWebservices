/*
 * Bview_activemodules.java
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
import eve.conversion.entity.EMview_activemodules;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_activemodules;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_activemodules
 *
 * Superclass for manipulating data- and database objects
 * for View View_activemodules and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_activemodules extends BLview {

    /**
     * Constructor, sets View_activemodules as default Entity
     */
    public Bview_activemodules() {
        super(new View_activemodules(), new EMview_activemodules());
    }

    /**
     * get all View_activemodules objects from database
     * @return ArrayList of View_activemodules objects
     * @throws DBException
     */
    public ArrayList<View_activemodules> getView_activemoduless() throws DBException {
        return getEntities(EMview_activemodules.SQLSelectAll);
    }
}
