/*
 * Bview_shipfitorderselected.java
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
import eve.conversion.entity.EMview_shipfitorderselected;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_shipfitorderselected;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_shipfitorderselected
 *
 * Superclass for manipulating data- and database objects
 * for View View_shipfitorderselected and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_shipfitorderselected extends BLview {

    /**
     * Constructor, sets View_shipfitorderselected as default Entity
     */
    public Bview_shipfitorderselected() {
        super(new View_shipfitorderselected(), new EMview_shipfitorderselected());
    }

    /**
     * get all View_shipfitorderselected objects from database
     * @return ArrayList of View_shipfitorderselected objects
     * @throws DBException
     */
    public ArrayList<View_shipfitorderselected> getView_shipfitorderselecteds() throws DBException {
        return getEntities(EMview_shipfitorderselected.SQLSelectAll);
    }
}
