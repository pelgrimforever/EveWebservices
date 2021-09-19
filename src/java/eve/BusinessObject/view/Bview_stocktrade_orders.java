/*
 * Bview_stocktrade_orders.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 18.8.2021 11:31
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
import eve.logicview.View_stocktrade_orders;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_stocktrade_orders
 *
 * Superclass for manipulating data- and database objects
 * for View View_stocktrade_orders and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_stocktrade_orders extends GeneralViewObject implements ProjectConstants {

    /**
     * Constructor, sets View_stocktrade_orders as default Entity
     */
    public Bview_stocktrade_orders() {
        super(new SQLMapper_pgsql(connectionpool, "View_stocktrade_orders"), new View_stocktrade_orders());
    }

    /**
     * Map ResultSet Field values to View_stocktrade_orders
     * @param dbresult: Database ResultSet
     */
    public View_stocktrade_orders mapResultSet2View(ResultSet dbresult) throws SQLException {
        View_stocktrade_orders view_stocktrade_orders = new View_stocktrade_orders();
        if(dbresult!=null) {
            try {
                view_stocktrade_orders.setUsername(dbresult.getString("username"));
                view_stocktrade_orders.setSystem(dbresult.getLong("system"));
                view_stocktrade_orders.setLocationid(dbresult.getLong("locationid"));
                view_stocktrade_orders.setStationname(dbresult.getString("stationname"));
                view_stocktrade_orders.setLocationname(dbresult.getString("locationname"));
                view_stocktrade_orders.setEvetypeid(dbresult.getLong("evetypeid"));
                view_stocktrade_orders.setEvetypename(dbresult.getString("evetypename"));
                view_stocktrade_orders.setPackaged_volume(dbresult.getDouble("packaged_volume"));
                view_stocktrade_orders.setMin_volume(dbresult.getInt("min_volume"));
                view_stocktrade_orders.setSellamount(dbresult.getLong("sellamount"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, view_stocktrade_orders);
        return view_stocktrade_orders;
    }

    /**
     * get all View_stocktrade_orders objects from database
     * @return ArrayList of View_stocktrade_orders objects
     * @throws DBException
     */
    public ArrayList getView_stocktrade_orderss() throws DBException {
        return getMapper().loadViewVector(this, View_stocktrade_orders.SQLSelectAll);
    }
}
