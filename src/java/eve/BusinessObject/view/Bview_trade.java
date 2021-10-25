/*
 * Bview_trade.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 25.9.2021 15:16
 *
 */

package eve.BusinessObject.view;

import BusinessObject.BLview;
import db.SQLMapperFactory;
import data.gis.shape.*;
import db.SQLMapper_pgsql;
import eve.conversion.entity.EMview_trade;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_trade;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_trade
 *
 * Superclass for manipulating data- and database objects
 * for View View_trade and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_trade extends BLview {

    /**
     * Constructor, sets View_trade as default Entity
     */
    public Bview_trade() {
        super(new View_trade(), new EMview_trade());
    }

    /**
     * get all View_trade objects from database
     * @return ArrayList of View_trade objects
     * @throws DBException
     */
    public ArrayList<View_trade> getView_trades() throws DBException {
        return getEntities(EMview_trade.SQLSelectAll);
    }
}
