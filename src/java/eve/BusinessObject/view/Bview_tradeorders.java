/*
 * Bview_tradeorders.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 18.6.2021 14:35
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
public abstract class Bview_tradeorders extends GeneralViewObject implements ProjectConstants {

    /**
     * Constructor, sets View_tradeorders as default Entity
     */
    public Bview_tradeorders() {
        super(new SQLMapper_pgsql(connectionpool, "View_tradeorders"), new View_tradeorders());
    }

    /**
     * Map ResultSet Field values to View_tradeorders
     * @param dbresult: Database ResultSet
     */
    public View_tradeorders mapResultSet2View(ResultSet dbresult) throws SQLException {
        View_tradeorders view_tradeorders = new View_tradeorders();
        if(dbresult!=null) {
            try {
                view_tradeorders.setTradevolume(dbresult.getLong("tradevolume"));
                view_tradeorders.setBuy_totalprice(dbresult.getDouble("buy_totalprice"));
                view_tradeorders.setSell_totalprice(dbresult.getDouble("sell_totalprice"));
                view_tradeorders.setCargo_volume(dbresult.getDouble("cargo_volume"));
                view_tradeorders.setSell_id(dbresult.getLong("sell_id"));
                view_tradeorders.setSell_system(dbresult.getLong("sell_system"));
                view_tradeorders.setSell_location(dbresult.getLong("sell_location"));
                view_tradeorders.setSell_evetype(dbresult.getLong("sell_evetype"));
                view_tradeorders.setSell_packaged_volume(dbresult.getDouble("sell_packaged_volume"));
                view_tradeorders.setSell_volume_remain(dbresult.getLong("sell_volume_remain"));
                view_tradeorders.setSell_price(dbresult.getDouble("sell_price"));
                view_tradeorders.setSecurity_island(dbresult.getLong("security_island"));
                view_tradeorders.setBuy_id(dbresult.getLong("buy_id"));
                view_tradeorders.setBuy_system(dbresult.getLong("buy_system"));
                view_tradeorders.setBuy_location(dbresult.getLong("buy_location"));
                view_tradeorders.setBuy_volume_remain(dbresult.getLong("buy_volume_remain"));
                view_tradeorders.setBuy_price(dbresult.getDouble("buy_price"));
                view_tradeorders.setJumps(dbresult.getInt("jumps"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, view_tradeorders);
        return view_tradeorders;
    }

    /**
     * get all View_tradeorders objects from database
     * @return ArrayList of View_tradeorders objects
     * @throws DBException
     */
    public ArrayList getView_tradeorderss() throws DBException {
        return getMapper().loadViewVector(this, View_tradeorders.SQLSelectAll);
    }
}
