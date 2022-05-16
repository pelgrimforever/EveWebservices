/*
 * Bview_shipfit.java
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
import eve.conversion.entity.EMview_shipfit;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_shipfit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_shipfit
 *
 * Superclass for manipulating data- and database objects
 * for View View_shipfit and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_shipfit extends BLview {

    /**
     * Constructor, sets View_shipfit as default Entity
     */
    public Bview_shipfit() {
        super(new View_shipfit(), new EMview_shipfit());
    }

    /**
     * get all View_shipfit objects from database
     * @return ArrayList of View_shipfit objects
     * @throws DBException
     */
    public ArrayList<View_shipfit> getView_shipfits() throws DBException {
        return getEntities(EMview_shipfit.SQLSelectAll);
    }
}
