/*
 * Bview_systemtrade.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 24.9.2021 14:40
 *
 */

package eve.BusinessObject.view;

import BusinessObject.BLview;
import db.SQLMapperFactory;
import data.gis.shape.*;
import db.SQLMapper_pgsql;
import eve.conversion.entity.EMview_systemtrade;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_systemtrade;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_systemtrade
 *
 * Superclass for manipulating data- and database objects
 * for View View_systemtrade and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_systemtrade extends BLview {

    /**
     * Constructor, sets View_systemtrade as default Entity
     */
    public Bview_systemtrade() {
        super(new View_systemtrade(), new EMview_systemtrade());
    }

    /**
     * get all View_systemtrade objects from database
     * @return ArrayList of View_systemtrade objects
     * @throws DBException
     */
    public ArrayList<View_systemtrade> getView_systemtrades() throws DBException {
        return getEntities(EMview_systemtrade.SQLSelectAll);
    }
}
