/*
 * Bview_order.java
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
import eve.logicview.View_order;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_order
 *
 * Superclass for manipulating data- and database objects
 * for View View_order and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_order extends GeneralViewObject implements ProjectConstants {

    /**
     * Constructor, sets View_order as default Entity
     */
    public Bview_order() {
        super(new SQLMapper_pgsql(connectionpool, "View_order"), new View_order());
    }

    /**
     * Map ResultSet Field values to View_order
     * @param dbresult: Database ResultSet
     */
    public View_order mapResultSet2View(ResultSet dbresult) throws SQLException {
        View_order view_order = new View_order();
        if(dbresult!=null) {
            try {
                view_order.setId(dbresult.getLong("id"));
                view_order.setIsopen(dbresult.getBoolean("isopen"));
                view_order.setSystem(dbresult.getLong("system"));
                view_order.setEvetype(dbresult.getLong("evetype"));
                view_order.setVolume_total(dbresult.getLong("volume_total"));
                view_order.setVolume_remain(dbresult.getLong("volume_remain"));
                view_order.setRange(dbresult.getString("range"));
                view_order.setRange_number(dbresult.getInt("range_number"));
                view_order.setPrice(dbresult.getDouble("price"));
                view_order.setMin_volume(dbresult.getInt("min_volume"));
                view_order.setLocation(dbresult.getLong("location"));
                view_order.setIs_buy_order(dbresult.getBoolean("is_buy_order"));
                view_order.setIssued(dbresult.getTimestamp("issued"));
                view_order.setDuration(dbresult.getInt("duration"));
                view_order.setPage(dbresult.getInt("page"));
                view_order.setStationid(dbresult.getLong("stationid"));
                view_order.setStationname(dbresult.getString("stationname"));
                view_order.setLocationid(dbresult.getLong("locationid"));
                view_order.setLocationname(dbresult.getString("locationname"));
                view_order.setSystemname(dbresult.getString("systemname"));
                view_order.setConstellation(dbresult.getLong("constellation"));
                view_order.setConstellationname(dbresult.getString("constellationname"));
                view_order.setRegion(dbresult.getLong("region"));
                view_order.setRegionname(dbresult.getString("regionname"));
                view_order.setEvetypename(dbresult.getString("evetypename"));
                view_order.setPackaged_volume(dbresult.getDouble("packaged_volume"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, view_order);
        return view_order;
    }

    /**
     * get all View_order objects from database
     * @return ArrayList of View_order objects
     * @throws DBException
     */
    public ArrayList getView_orders() throws DBException {
        return getMapper().loadViewVector(this, View_order.SQLSelectAll);
    }
}
