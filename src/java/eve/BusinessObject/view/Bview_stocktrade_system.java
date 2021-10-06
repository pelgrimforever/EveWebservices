/*
 * Bview_stocktrade_system.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 6.9.2021 16:29
 *
 */

package eve.BusinessObject.view;

import BusinessObject.GeneralViewObject;
import data.gis.shape.*;
import db.SQLMapper_pgsql;
import eve.data.ProjectConstants;
import db.ArchiveViewMapper;
import db.ViewMapper;
import db.ViewMapperInterface;
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
public abstract class Bview_stocktrade_system extends GeneralViewObject implements ProjectConstants {

    /**
     * Constructor, sets View_stocktrade_system as default Entity
     */
    public Bview_stocktrade_system() {
        super(new SQLMapper_pgsql(connectionpool, "View_stocktrade_system"), new View_stocktrade_system());
    }

    /**
     * Map ResultSet Field values to View_stocktrade_system
     * @param dbresult: Database ResultSet
     */
    public View_stocktrade_system mapResultSet2View(ResultSet dbresult) throws SQLException {
        View_stocktrade_system view_stocktrade_system = new View_stocktrade_system();
        if(dbresult!=null) {
            try {
                view_stocktrade_system.setUsername(dbresult.getString("username"));
                view_stocktrade_system.setId(dbresult.getLong("id"));
                view_stocktrade_system.setName(dbresult.getString("name"));
                view_stocktrade_system.setSellprice(dbresult.getDouble("sellprice"));
                view_stocktrade_system.setTotalvolume(dbresult.getDouble("totalvolume"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, view_stocktrade_system);
        return view_stocktrade_system;
    }

    /**
     * get all View_stocktrade_system objects from database
     * @return ArrayList of View_stocktrade_system objects
     * @throws DBException
     */
    public ArrayList getView_stocktrade_systems() throws DBException {
        return getMapper().loadViewVector(this, View_stocktrade_system.SQLSelectAll);
    }
}
