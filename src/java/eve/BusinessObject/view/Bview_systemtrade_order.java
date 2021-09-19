/*
 * Bview_systemtrade_order.java
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
import eve.logicview.View_systemtrade_order;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_systemtrade_order
 *
 * Superclass for manipulating data- and database objects
 * for View View_systemtrade_order and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_systemtrade_order extends GeneralViewObject implements ProjectConstants {

    /**
     * Constructor, sets View_systemtrade_order as default Entity
     */
    public Bview_systemtrade_order() {
        super(new SQLMapper_pgsql(connectionpool, "View_systemtrade_order"), new View_systemtrade_order());
    }

    /**
     * Map ResultSet Field values to View_systemtrade_order
     * @param dbresult: Database ResultSet
     */
    public View_systemtrade_order mapResultSet2View(ResultSet dbresult) throws SQLException {
        View_systemtrade_order view_systemtrade_order = new View_systemtrade_order();
        if(dbresult!=null) {
            try {
                view_systemtrade_order.setSell_system(dbresult.getLong("sell_system"));
                view_systemtrade_order.setBuy_system(dbresult.getLong("buy_system"));
                view_systemtrade_order.setSell_order(dbresult.getLong("sell_order"));
                view_systemtrade_order.setBuy_order(dbresult.getLong("buy_order"));
                view_systemtrade_order.setAmount(dbresult.getLong("amount"));
                view_systemtrade_order.setSellprice(dbresult.getDouble("sellprice"));
                view_systemtrade_order.setBuyprice(dbresult.getDouble("buyprice"));
                view_systemtrade_order.setProfit(dbresult.getDouble("profit"));
                view_systemtrade_order.setCargovolume(dbresult.getDouble("cargovolume"));
                view_systemtrade_order.setEvetype(dbresult.getLong("evetype"));
                view_systemtrade_order.setEvetypename(dbresult.getString("evetypename"));
                view_systemtrade_order.setSell_volume_remain(dbresult.getLong("sell_volume_remain"));
                view_systemtrade_order.setSell_price(dbresult.getDouble("sell_price"));
                view_systemtrade_order.setSell_station(dbresult.getLong("sell_station"));
                view_systemtrade_order.setSell_stationname(dbresult.getString("sell_stationname"));
                view_systemtrade_order.setBuy_volume_remain(dbresult.getLong("buy_volume_remain"));
                view_systemtrade_order.setBuy_price(dbresult.getDouble("buy_price"));
                view_systemtrade_order.setBuy_station(dbresult.getLong("buy_station"));
                view_systemtrade_order.setBuy_stationname(dbresult.getString("buy_stationname"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, view_systemtrade_order);
        return view_systemtrade_order;
    }

    /**
     * get all View_systemtrade_order objects from database
     * @return ArrayList of View_systemtrade_order objects
     * @throws DBException
     */
    public ArrayList getView_systemtrade_orders() throws DBException {
        return getMapper().loadViewVector(this, View_systemtrade_order.SQLSelectAll);
    }
}
