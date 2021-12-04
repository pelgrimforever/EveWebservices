/*
 * Bview_stocktrade_system.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 4.11.2021 14:51
 *
 */

package eve.BusinessObject.view;

import BusinessObject.BLview;
import db.SQLMapperFactory;
import data.gis.shape.*;
import db.SQLMapper_pgsql;
import eve.conversion.entity.EMview_stocktrade_system;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_stocktrade_system;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_stocktrade_system
 *
 * Superclass for manipulating data- and database objects
 * for View View_stocktrade_system and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_stocktrade_system extends BLview {

    /**
     * Constructor, sets View_stocktrade_system as default Entity
     */
    public Bview_stocktrade_system() {
        super(new View_stocktrade_system(), new EMview_stocktrade_system());
    }

    /**
     * get all View_stocktrade_system objects from database
     * @return ArrayList of View_stocktrade_system objects
     * @throws DBException
     */
    public ArrayList<View_stocktrade_system> getView_stocktrade_systems() throws DBException {
        return getEntities(EMview_stocktrade_system.SQLSelectAll);
    }
}
