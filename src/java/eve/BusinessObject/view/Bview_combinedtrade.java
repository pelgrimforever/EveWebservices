/*
 * Bview_combinedtrade.java
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
import eve.conversion.entity.EMview_combinedtrade;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_combinedtrade;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_combinedtrade
 *
 * Superclass for manipulating data- and database objects
 * for View View_combinedtrade and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_combinedtrade extends BLview {

    /**
     * Constructor, sets View_combinedtrade as default Entity
     */
    public Bview_combinedtrade() {
        super(new View_combinedtrade(), new EMview_combinedtrade());
    }

    /**
     * get all View_combinedtrade objects from database
     * @return ArrayList of View_combinedtrade objects
     * @throws DBException
     */
    public ArrayList<View_combinedtrade> getView_combinedtrades() throws DBException {
        return getEntities(EMview_combinedtrade.SQLSelectAll);
    }
}
