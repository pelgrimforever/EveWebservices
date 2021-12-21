/*
 * Bview_shipfitmodule.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 18.11.2021 16:29
 *
 */

package eve.BusinessObject.view;

import BusinessObject.BLview;
import db.SQLMapperFactory;
import data.gis.shape.*;
import db.SQLMapper_pgsql;
import eve.conversion.entity.EMview_shipfitmodule;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_shipfitmodule;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_shipfitmodule
 *
 * Superclass for manipulating data- and database objects
 * for View View_shipfitmodule and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_shipfitmodule extends BLview {

    /**
     * Constructor, sets View_shipfitmodule as default Entity
     */
    public Bview_shipfitmodule() {
        super(new View_shipfitmodule(), new EMview_shipfitmodule());
    }

    /**
     * get all View_shipfitmodule objects from database
     * @return ArrayList of View_shipfitmodule objects
     * @throws DBException
     */
    public ArrayList<View_shipfitmodule> getView_shipfitmodules() throws DBException {
        return getEntities(EMview_shipfitmodule.SQLSelectAll);
    }
}
