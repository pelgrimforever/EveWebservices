/*
 * Bview_contractswithprofit.java
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
import eve.conversion.entity.EMview_contractswithprofit;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_contractswithprofit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_contractswithprofit
 *
 * Superclass for manipulating data- and database objects
 * for View View_contractswithprofit and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_contractswithprofit extends BLview {

    /**
     * Constructor, sets View_contractswithprofit as default Entity
     */
    public Bview_contractswithprofit() {
        super(new View_contractswithprofit(), new EMview_contractswithprofit());
    }

    /**
     * get all View_contractswithprofit objects from database
     * @return ArrayList of View_contractswithprofit objects
     * @throws DBException
     */
    public ArrayList<View_contractswithprofit> getView_contractswithprofits() throws DBException {
        return getEntities(EMview_contractswithprofit.SQLSelectAll);
    }
}
