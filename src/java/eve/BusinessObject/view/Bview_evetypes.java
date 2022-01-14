/*
 * Bview_evetypes.java
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
import eve.conversion.entity.EMview_evetypes;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_evetypes;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_evetypes
 *
 * Superclass for manipulating data- and database objects
 * for View View_evetypes and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_evetypes extends BLview {

    /**
     * Constructor, sets View_evetypes as default Entity
     */
    public Bview_evetypes() {
        super(new View_evetypes(), new EMview_evetypes());
    }

    /**
     * get all View_evetypes objects from database
     * @return ArrayList of View_evetypes objects
     * @throws DBException
     */
    public ArrayList<View_evetypes> getView_evetypess() throws DBException {
        return getEntities(EMview_evetypes.SQLSelectAll);
    }
}
