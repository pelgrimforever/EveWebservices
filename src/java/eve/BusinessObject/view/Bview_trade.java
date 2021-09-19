/*
 * Bview_trade.java
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
public abstract class Bview_trade extends GeneralViewObject implements ProjectConstants {

    /**
     * Constructor, sets View_trade as default Entity
     */
    public Bview_trade() {
        super(new SQLMapper_pgsql(connectionpool, "View_trade"), new View_trade());
    }

    /**
     * Map ResultSet Field values to View_trade
     * @param dbresult: Database ResultSet
     */
    public View_trade mapResultSet2View(ResultSet dbresult) throws SQLException {
        View_trade view_trade = new View_trade();
        if(dbresult!=null) {
            try {
                view_trade.setSell_regionid(dbresult.getLong("sell_regionid"));
                view_trade.setSell_regionname(dbresult.getString("sell_regionname"));
                view_trade.setSell_systemid(dbresult.getLong("sell_systemid"));
                view_trade.setSell_systemname(dbresult.getString("sell_systemname"));
                view_trade.setSell_locationid(dbresult.getLong("sell_locationid"));
                view_trade.setSell_stationname(dbresult.getString("sell_stationname"));
                view_trade.setEvetype_id(dbresult.getLong("evetype_id"));
                view_trade.setEvetype_name(dbresult.getString("evetype_name"));
                view_trade.setPackaged_volume(dbresult.getDouble("packaged_volume"));
                view_trade.setSell_id(dbresult.getLong("sell_id"));
                view_trade.setBuy_id(dbresult.getLong("buy_id"));
                view_trade.setSell_volume_remain(dbresult.getLong("sell_volume_remain"));
                view_trade.setSell_price(dbresult.getDouble("sell_price"));
                view_trade.setBuy_price(dbresult.getDouble("buy_price"));
                view_trade.setBuy_systemid(dbresult.getLong("buy_systemid"));
                view_trade.setBuy_systemname(dbresult.getString("buy_systemname"));
                view_trade.setBuy_locationid(dbresult.getLong("buy_locationid"));
                view_trade.setBuy_stationname(dbresult.getString("buy_stationname"));
                view_trade.setBuy_volume_remain(dbresult.getLong("buy_volume_remain"));
                view_trade.setTotal_volume(dbresult.getDouble("total_volume"));
                view_trade.setSell_total(dbresult.getDouble("sell_total"));
                view_trade.setBuy_total(dbresult.getDouble("buy_total"));
                view_trade.setTrade_profit(dbresult.getDouble("trade_profit"));
                view_trade.setTrade_jumps(dbresult.getInt("trade_jumps"));
                view_trade.setTrade_profit_per_jump(dbresult.getDouble("trade_profit_per_jump"));
                view_trade.setTrade_runs(dbresult.getInt("trade_runs"));
                view_trade.setTrade_total_jumps(dbresult.getInt("trade_total_jumps"));
                view_trade.setTrade_singlerunprofit(dbresult.getDouble("trade_singlerunprofit"));
                view_trade.setTrade_maxunits_per_run(dbresult.getInt("trade_maxunits_per_run"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, view_trade);
        return view_trade;
    }

    /**
     * get all View_trade objects from database
     * @return ArrayList of View_trade objects
     * @throws DBException
     */
    public ArrayList getView_trades() throws DBException {
        return getMapper().loadViewVector(this, View_trade.SQLSelectAll);
    }
}
