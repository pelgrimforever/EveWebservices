/*
 * Bview_tradeorders.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 8.10.2021 7:21
 *
 */

package eve.BusinessObject.view;

import BusinessObject.BLview;
import db.SQLMapperFactory;
import data.gis.shape.*;
import db.SQLMapper_pgsql;
import eve.conversion.entity.EMview_tradeorders;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_tradeorders;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_tradeorders
 *
 * Superclass for manipulating data- and database objects
 * for View View_tradeorders and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_tradeorders extends BLview {

    /**
     * Constructor, sets View_tradeorders as default Entity
     */
    public Bview_tradeorders() {
        super(new View_tradeorders(), new EMview_tradeorders());
    }

    /**
     * get all View_tradeorders objects from database
     * @return ArrayList of View_tradeorders objects
     * @throws DBException
     */
    public ArrayList<View_tradeorders> getView_tradeorderss() throws DBException {
        return getEntities(EMview_tradeorders.SQLSelectAll);
    }
}
